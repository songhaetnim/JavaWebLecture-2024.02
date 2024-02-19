package ch09_cookie_session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

@WebServlet("/ch09/getCookie")
public class Ex04_GetCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html; charset=utf-8");
		out.print("<h1>Cookie</h1>");
		
		for (Cookie c: cookies) {
			String value = c.getName().equals("hangul-name") ? 
					URLDecoder.decode(c.getValue(), "utf-8"): c.getValue();
			out.print("<h3>" + c.getName() + ", " + value +" , " + c.getMaxAge() + "</h3>");
		}

		
//		out.print("<br>");
//		out.print("<h3>" + "</h3>");
	}

}
