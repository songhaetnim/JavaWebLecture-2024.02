package ch07_dao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ch07/city/insert")
public class Ex03_lnsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 // 입력 폼 보여주기
	   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       RequestDispatcher rd = request.getRequestDispatcher("/ch07/insert.jsp");
	       rd.forward(request, response);
	   }

	   // 사용자 입력 처리하기
	   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      String name = request.getParameter("name");
	      String countryCode = request.getParameter("countryCode");
	      String district = request.getParameter("district");
	      String population_ = request.getParameter("population");
	      int population = (population_.equals("")) ? 0 : Integer.parseInt(population_);
	      
	      City city = new City(name, countryCode, district, population);
	      CityDao cDao = new CityDao();
	      cDao.insertCity(city);
	      
	      response.sendRedirect("/jw/ch07/city/list?district=" + district + "&num=30&offset=0");
	   }

	}