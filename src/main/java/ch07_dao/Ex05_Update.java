package ch07_dao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ch07/city/update")
public class Ex05_Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_ = request.getParameter("id");
		int id = (id_ == null || id_.equals("")) ? 2340 : Integer.parseInt(id_);
		
		CityDao cDao = new CityDao();
		City city = cDao.getCity(id);
		RequestDispatcher rd = request.getRequestDispatcher("/ch07/update.jsp");
		request.setAttribute("city", city);
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  int id = Integer.parseInt(request.getParameter("id"));
		  String name = request.getParameter("name");
	      String countryCode = request.getParameter("countryCode");
	      String district = request.getParameter("district");
	      String population_ = request.getParameter("population");
	      int population = (population_.equals("")) ? 0 : Integer.parseInt(population_);
	      
	      City city = new City(id, name, countryCode, district,population);
	      CityDao cDao = new CityDao();
	      cDao.updaetCity(city);
	      
	      response.sendRedirect("/jw/ch07/city/list?district=" + district + "&num=30&offset=0");
	    		  
	}

}
