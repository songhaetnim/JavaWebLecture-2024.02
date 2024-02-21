package ch14_el_jstl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/ch14/el3")
public class Ex03_Collections extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] array = {"apple", "banana", "cherry", "mango"};
		request.setAttribute("array", array);
		
		List<String> list = new ArrayList<String>();
		list.add("축구"); list.add("야구"); list.add("배구"); 
		request.setAttribute("list", list);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("key", "el"); map.put("value", "jstl"); 
		request.setAttribute("map", map);
		
		RequestDispatcher rd = request.getRequestDispatcher("/ch14/ex03_collections.jsp");
		rd.forward(request, response);
	}

}