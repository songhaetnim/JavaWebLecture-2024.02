package ch09_cookie_session;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ch09/setSession")
public class Ex01_SetSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();
		 
//		 PrintWriter out = response.getWriter();
//		 response.setContentType("text/html; charset=utf-8");
//		 out.print("<h1>isNew: " + session.isNew());
		 
		 session.setAttribute("price", 12500);
		 session.setAttribute("uid", "janes");
		 String[]  fruits = {"apple","banana","cherry"};
		 session.setAttribute("fruits", fruits);
		 
		 session.setMaxInactiveInterval(24 * 60 *60);       //24시간
		 
//		 session.getAttribute();        // 셋팅값 초기화
		
		 RequestDispatcher rd = request.getRequestDispatcher("/ch09/session.jsp");
		 rd.forward(request, response);

	}
}