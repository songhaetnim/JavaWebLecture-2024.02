package ch14_el_jstl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/ch14/el2")
public class Ex02_BuiltinObject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext ctx = request.getServletContext();	// Application context
		HttpSession session = request.getSession();
		
		ctx.setAttribute("aName", "어플리케이션 스코프");
		session.setAttribute("sName", "세션 스코프");
		request.setAttribute("rName", "리퀘스트 스코프");
		request.setAttribute("name", "리퀘스트 변수");
		
		RequestDispatcher rd = request.getRequestDispatcher("/ch14/ex02_builtin_object.jsp");
		rd.forward(request, response);
	}

}