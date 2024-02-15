package ch07_dao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ch07/city/delete")
public class Ex04_Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_ = request.getParameter("id");
		int id = (id_ == null || id_.equals("")) ? 2505 : Integer.parseInt(id_);
		
		CityDao cDao = new CityDao();
		cDao.deleteCity(id);
		
		response.sendRedirect("/jw/ch07/city/list?district=Kyonggi&num=30&offset=0");
	}
}


