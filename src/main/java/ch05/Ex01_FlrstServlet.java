package ch05;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// 웹 브라우저 주소창에  localhost:8080/jw/hello 을 입력했을 경우 처리하는 코드
@WebServlet({"/hello", "/ch05/hello"})
public class Ex01_FlrstServlet extends HttpServlet {
	// Get 방식의 요청이 왔을때 처리해주는 코드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String html = "<!DOCTYPE html>\r\n"
				+ "<html>"
				+ "<head>"
				+ "<meta charset=\"UTF-8\">"
				+ "<title>첫번째 서블릿</title>"
				+ "</head>"
				+ "<body>"
				+ "	<h1>자바 서블릿에서 작성한 코드입니다. </h1>"
				+ "</body>"
				+ "</html>";
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(html);
	}

	//Post방식의 요청이 왔을때 처리해주는 코드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
