package ch06_basic;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/ch06/register")
public class Ex04_RegisterMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//form 을 제공해주는 역활
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/ch06/registerFormBootstrap.jsp");
		rd.forward(request, response);
	}

	// 입력 폼을 처리해주는 역활
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		String pwd2 = request.getParameter("pwd2");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		//uid 중복 확인
		//pwd 와 pwd2가 일치하는지 확인
		//입력된 값으로 User 객체를 만든다
		//UserService의 registerMember를 호출(DB에 등록)
		//환영 메세지와 함께 로그인 창으로 보냄
		
		User user = new User(uid, pwd, name, email, LocalDate.now(), 0);
		RequestDispatcher rd = request.getRequestDispatcher("/ch06/registerResult.jsp");
		request.setAttribute("user",user);
		rd.forward(request, response);
		
	
	}

}
