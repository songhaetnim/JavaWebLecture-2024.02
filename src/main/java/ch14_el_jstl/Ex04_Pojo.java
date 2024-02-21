package ch14_el_jstl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ch14/el4")
public class Ex04_Pojo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Address a1 = new Address(12345, "수원", "한국");
		Address a2 = new Address(34567, "용인", "한국");
		Member m1 = new Member(101, "제임스", a1);
		Member m2 = new Member(102, "마리아", a2);
		
		request.setAttribute("m1", m1);
		request.setAttribute("m2", m2);
		
		Member[] members = {m1, m2};
		request.setAttribute("members", members);
		
		RequestDispatcher rd = request.getRequestDispatcher("/ch14/ex04_pojo.jsp");
		rd.forward(request, response);
	}

}