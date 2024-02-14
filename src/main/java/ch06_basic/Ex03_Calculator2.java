package ch06_basic;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ch06/calc2")
public class Ex03_Calculator2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// 시작할 때에는 loca;host:8080/jw/ch06/calc2
   // loca;host:8080/jw/ch06/calc2?num1=3&op=+&num2=6
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num1_ = request.getParameter("num1");
		String num2_ = request.getParameter("num2");
		String result_ = request.getParameter("result");
		int num1 = (num1_ == null) ? 0 : Integer.parseInt(num1_);
		int num2 = (num2_ == null) ? 0 : Integer.parseInt(num2_);
		int result = (result_ == null) ? 0 : Integer.parseInt(result_);
      
      RequestDispatcher rd = request.getRequestDispatcher("/ch06/calc.jsp");
      request.setAttribute("num1", num1);
      request.setAttribute("num2", num2);
      request.setAttribute("result", result);
      rd.forward(request, response);
	}
	//<form action="/jw/ch06/calc2" method="post">
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num1_ =request.getParameter("num1");
		String op  =request.getParameter("op");
		String num2_ =request.getParameter("num2");
		int num1 =(num1_.equals("" )) ? 0 : Integer.parseInt(num1_);
		int num2 =(num2_.equals("" )) ? 0 : Integer.parseInt(num2_);
		int result = 0;
		switch(op) {
		case "+":
			result = num1 + num2; break;
		case "-":
			result = num1 + num2; break;
		case "*":
			result = num1 + num2; break;
		case "/":
			result = num1 + num2; break;
		default: 
			result=-1;
		}
		
//		PrintWriter out = response.getWriter();
//		out.print(num1 + " " + op + " " + num2 + " = " + result);
		// calc.jsp(Servlet)을 직접 호출
//		RequestDispatcher rd = request.getRequestDispatcher("/ch06/calc.jsp");
//		request.setAttribute("num1",num1);
//		request.setAttribute("num2",num2);
//		request.setAttribute("result",result);
//		rd.forward(request, response);

		//리디렉션 이용
		String url = "/jw/ch06/calc2?num1=" + num1 + "&num2=" + num2 +"&result=" + result;
		System.out.println(url);
		response.sendRedirect(url);
		
	}

}
