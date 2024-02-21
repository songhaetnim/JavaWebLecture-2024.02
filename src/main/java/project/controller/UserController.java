package project.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import project.entilty.User;
import project.service.UserService;
import project.service.UserServiceImpl;

import java.io.IOException;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

@WebServlet({"/bbs/user/list", "/bbs/user/register", "/bbs/user/update", 
			 "/bbs/user/delete", "/bbs/user/login", "/bbs/user/logout"})
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService uSvc = new UserServiceImpl();
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] uri = request.getRequestURI().split("/");
		String action = uri[uri.length - 1];
		String method = request.getMethod();
		HttpSession session = request.getSession();
		RequestDispatcher rd = null;
		String uid = "", pwd = "", pwd2 = "", uname = "", email = "", hashedPwd = "";
		String msg = "", url = "";
		User user = null;
		
		switch (action) {
		case "list":                 //page -> HTML에서 name="page"일때 불러와라 or
									//http://localhost:8080/jw/ch09/user/list?page=1 <- 주소로 입력받아 실행가능하다.
			String page_ = request.getParameter("page");   //getParameter ==> 값을 가져온다.
			int page = (page_ == null || page_.equals("")) ? 1 : Integer.parseInt(page_);
			// == 는 int(정수용) ,equals 는 String(문자열용)    ^강제로 인트값으로 변환해라.
			//("")) <== 빈값일때 ? <== 참이다.  , : <== 거짓일때 표현
			// int page = (page_ == null || page_.equals("")) ? 1 : Integer.parseInt(page_); <== if (저 한줄이 조건문이다)
			List<User> list = uSvc.getUserList(page);
			//ServiceIMPL에서 getUserList <- 로 보내서 LIST 값을 불러온다.
			request.setAttribute("list", list);  // <- List 값을  HTML로 보낸다.
//			rd = request.getRequestDispatcher("/ch09/user/list.jsp");
			rd = request.getRequestDispatcher("/WEB-INF/view/user/list.jsp");
			//  위에거가 다 실행이 되고 "/ch09/user/listBS.jsp" <- 여기로 보내진다 (웹)
			rd.forward(request, response);
			break;
			
		case "login":
			if (method.equals("GET")) {
//				rd = request.getRequestDispatcher("/ch09/user/login.jsp");
				rd = request.getRequestDispatcher("/WEB-INF/view/user/login.jsp");
				rd.forward(request, response);
			} else {
				uid = request.getParameter("uid");
				pwd = request.getParameter("pwd");
				int result = uSvc.login(uid, pwd);
				if (result == uSvc.CORRECT_LOGIN) {
					user = uSvc.getUserByUid(uid);
					session.setAttribute("sessUid", uid);
					session.setAttribute("sessUname", user.getUname());
					msg = user.getUname() + "님 환영합니다.";
					url = "/jw/bbs/user/list?page=1";
				} else if (result == uSvc.WRONG_PASSWORD) {
					msg = "패스워드가 틀립니다.";
					url = "/jw/bbs/user/login";
				} else {
					msg = "아이디 입력이 잘못되었습니다.";
					url = "/jw/bbs/user/login";
				}
				rd = request.getRequestDispatcher("/WEB-INF/view/common/alertMsg.jsp");
				request.setAttribute("msg", msg);
				request.setAttribute("url", url);
				rd.forward(request, response);
			}
			break;
		
		case "logout":
			session.invalidate();
			response.sendRedirect("/jw/bbs/user/list?page=1");
			break;
			
		case "register":
			if (method.equals("GET")) {
				session.invalidate();
//				rd = request.getRequestDispatcher("/ch09/user/register.jsp");
				rd = request.getRequestDispatcher("/WEB-INF/view/user/register.jsp");
				rd.forward(request, response);
			} else {
				uid = request.getParameter("uid");
				pwd = request.getParameter("pwd");
				pwd2 = request.getParameter("pwd2");
				uname = request.getParameter("uname");
				email = request.getParameter("email");
				if (uSvc.getUserByUid(uid) != null) {
					rd = request.getRequestDispatcher("/WEB-INF/view/common/alertMsg.jsp");
					request.setAttribute("msg", "아이디가 중복입니다.");
					request.setAttribute("url", "/jw/bbs/user/register");
					rd.forward(request, response); 
				} else if (pwd.equals(pwd2)) {
					user = new User(uid, pwd, uname, email);
					uSvc.registerUser(user);
					response.sendRedirect("/jw/bbs/user/list?page=1");
				} else {
					rd = request.getRequestDispatcher("/WEB-INF/view/common/alertMsg.jsp");
					request.setAttribute("msg", "패스워드 입력이 잘못되었습니다.");
					request.setAttribute("url", "/jw/bbs/user/register");
					rd.forward(request, response);
				}
			}
			break;
		
		case "update":
			if (method.equals("GET")) {
				uid = request.getParameter("uid");
				user = uSvc.getUserByUid(uid);
//				rd = request.getRequestDispatcher("/ch09/user/update.jsp");
				rd = request.getRequestDispatcher("/WEB-INF/view/user/update.jsp");
				request.setAttribute("user", user);
				rd.forward(request, response);
			} else {
				uid = request.getParameter("uid");
				pwd = request.getParameter("pwd");
				pwd2 = request.getParameter("pwd2");
				hashedPwd = request.getParameter("hashedPwd");
				uname = request.getParameter("uname");
				email = request.getParameter("email");
				if (pwd != null && pwd.equals(pwd2))
					hashedPwd = BCrypt.hashpw(pwd, BCrypt.gensalt());
				user = new User(uid, hashedPwd, uname, email);
				uSvc.updateUser(user);
				response.sendRedirect("/jw/bbs/user/list?page=1");
			}
			break;
			
		case "delete":
			uid = request.getParameter("uid");
			uSvc.deleteUser(uid);
			String sessUid = (String) session.getAttribute("sessUid");
			if (!sessUid.equals("admin"))
				session.invalidate();
			response.sendRedirect("/jw/bbs/user/list?page=1");
			break;
		}
	}

}