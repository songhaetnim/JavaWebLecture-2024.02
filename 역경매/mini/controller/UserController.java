package mini.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mini.entity.User;
import mini.service.UserServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

@WebServlet({"/auctiondb/user/list", "/auctiondb/user/signup", "/auctiondb/user/update", 
			 "/auctiondb/user/delete", "/auctiondb/user/login", "/auctiondb/user/logout"})
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserServiceImpl uSvc = new UserServiceImpl();
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] uri = request.getRequestURI().split("/");
		String action = uri[uri.length - 1];
		String method = request.getMethod();
		HttpSession session = request.getSession();
		RequestDispatcher rd = null;
		String user_id = "", password = "", password2 = "", uname = "", email = "", hashedpassword = "", phone_number = "" ;
		String msg = "", url = "";
		User user = null;
		
		switch (action) {
		
		case "list":
			String page_ = request.getParameter("page");
			int page = (page_ == null || page_.equals("")) ? 1 : Integer.parseInt(page_);
			session.setAttribute("currentUserPage", page);
			List<User> userlist = uSvc.getUserList(page);
			request.setAttribute("userList", userlist);
			
			// for pagination
			int totaluser = uSvc.getUserCount();
			int totalPages = (int)Math.ceil(totaluser * 1.0 / uSvc.COUNT_PER_PAGE);
			List<String> pageList = new ArrayList<String>();	
			for (int i = 1; i <= totalPages; i++) 
				pageList.add(String.valueOf(i));
			request.setAttribute("pageList", pageList);
			
			rd = request.getRequestDispatcher("/WEB-INF/miniview/user/list.jsp");
			rd.forward(request, response);
			break;
		
		case "login":
			if (method.equals("GET")) {
				rd = request.getRequestDispatcher("/WEB-INF/miniview/user/login.jsp");
				rd.forward(request, response);
			} else {
				user_id = request.getParameter("user_id");
				password = request.getParameter("password");
				int result = uSvc.login(user_id, password);
				if (result == uSvc.CORRECT_LOGIN) {
					user = uSvc.getUserById(user_id);
					session.setAttribute("sessuser_id", user_id);
					session.setAttribute("sessUname", user.getUsername());
					msg = user.getUsername() + "님 환영합니다.";
					url = request.getContextPath() + "/auctiondb/user/list?page=1";
				} else if (result == uSvc.WRONG_PASSWORD) {
					msg = "패스워드가 틀립니다.";
					url = request.getContextPath() + "/auctiondb/user/login";
				} else {
					msg = "아이디 입력이 잘못되었습니다.";
					url = request.getContextPath() + "/auctiondb/user/login";
				}
				rd = request.getRequestDispatcher("/WEB-INF/miniview/common/alertMsg.jsp");
				request.setAttribute("msg", msg);
				request.setAttribute("url", url);
				rd.forward(request, response);
			}
			break;
		
		case "logout":
			session.invalidate();
			response.sendRedirect("/jw/auctiondb/user/login");
			break;
			
		case "signup":
			if (method.equals("GET")) {
				session.invalidate();;
				rd = request.getRequestDispatcher("/WEB-INF/miniview/user/signup.jsp");
				rd.forward(request, response);
			} else {
				user_id = request.getParameter("user_id");
				password = request.getParameter("password");
				password2 = request.getParameter("password2");
				uname = request.getParameter("uname");
				email = request.getParameter("email");
				phone_number = request.getParameter("phone_number");
				
				if (uSvc.getUserById(user_id) != null) {
					rd = request.getRequestDispatcher("/WEB-INF/miniview/common/alertMsg.jsp");
					request.setAttribute("msg", "아이디가 중복입니다.");
					request.setAttribute("url", "/jw/auctiondb/user/signup");
					rd.forward(request, response); 
					
				} else if (password.equals(password2)) {
					user = new User(user_id, password, uname, email, phone_number);
					uSvc.registerUser(user);
					response.sendRedirect("/jw/auctiondb/user/list?page=1");
				} else {
					rd = request.getRequestDispatcher("/WEB-INF/miniview/common/alertMsg.jsp");
					request.setAttribute("msg", "패스워드 입력이 잘못되었습니다.");
					request.setAttribute("url", "/jw/auctiondb/user/signup");
					rd.forward(request, response);
				}
			}
			break;
		
		case "update":
			if (method.equals("GET")) {
				user_id = request.getParameter("user_id");
				user = uSvc.getUserById(user_id);
				rd = request.getRequestDispatcher("/WEB-INF/miniview/user/update.jsp");
				request.setAttribute("user", user);
				rd.forward(request, response);
			} else {
				user_id = request.getParameter("user_id");
				password = request.getParameter("password");
				password2 = request.getParameter("password2");
				hashedpassword = request.getParameter("hashedpassword");
				uname = request.getParameter("uname");
				email = request.getParameter("email");
				phone_number = request.getParameter("phone_number");
				
				if (password != null && password.equals(password2)) {
					hashedpassword = BCrypt.hashpw(password, BCrypt.gensalt());
				}
				
				user = new User(user_id, hashedpassword, uname, email, phone_number);
				uSvc.updateUser(user);
				response.sendRedirect("/jw/auctiondb/user/list?page=1");
			}
			break;
			
		case "delete":
			user_id = request.getParameter("user_id");
			uSvc.deleteUser(user_id);
			String sessuser_id = (String) session.getAttribute("sessuser_id");
		    if (sessuser_id != null && !sessuser_id.equals("admin")) {
		        session.invalidate();
		    }

		    response.sendRedirect("/jw/auctiondb/user/list?page=1");
		    break;
		}
	}

}
