package tes1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet ({"/tes1/ski/board/list", "/tes1/ski/board/insert", "/tes1/ski/board/update", 
	 "/tes1/ski/board/delete", "/tes1/ski/board/detail"})
public class tes1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public tes1() {
    }
	
	protected void Servlet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}       


