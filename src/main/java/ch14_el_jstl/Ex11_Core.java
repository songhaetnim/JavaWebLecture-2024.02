package ch14_el_jstl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ch14/jstl1")
public class Ex11_Core extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Address a1 = new Address(12345, "수원", "한국");
		Address a2 = new Address(34567, "용인", "한국");
		Member m1 = new Member(101, "제임스", a1);
		Member m2 = new Member(102, "마리아", a2);
		Member m3 = new Member(103, "브라이언", new Address(45678, "뉴욕", "미국"));
		Member m4 = new Member(104, "사라", new Address(56789, "시카고", "미국"));
		Member m5 = new Member(105, "다니엘", new Address(67890, "런던", "영국"));
		
		Member[] members = {m1, m2, m3, m4, m5};
		request.setAttribute("members", members);
		
		RequestDispatcher rd = request.getRequestDispatcher("/ch14/ex11_core.jsp");
		rd.forward(request, response);
	}

}

