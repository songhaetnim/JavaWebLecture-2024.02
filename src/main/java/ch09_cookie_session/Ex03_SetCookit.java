package ch09_cookie_session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

@WebServlet("/ch09/setCookie")
public class Ex03_SetCookit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html; charset=utf-8");
		
		Cookie c1 = new Cookie("cookie-name","cookie-value");
		c1.setMaxAge(24 * 60 *60);         // 유효기간: 24 * 60 * 60 초	--> 1일
		c1.setDomain("c1"); 
		response.addCookie(c1);
		 
		 String kMsg = URLEncoder.encode("한글 데이터", "utf-8");
		 Cookie c2 = new Cookie("hangul-name", kMsg);
		 c2.setMaxAge(-1);               //브라우저가 닫히면 사라짐
		 c2.setDomain("c2"); 
		 response.addCookie(c2);
		 
		 out.write("<h1>현재시간" + new Date() + "</h1>");
	}

}
