package ch09_cookie_session.user;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet({ "/ch09/user/list", "/ch09/user/register", "/ch09/user/update", "/ch09/user/delect", "/ch09/user/login",
		"/ch09/user/listlogout" })

public class UserContrller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService uSvc = new UserServiceImpl();

	protected void Service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestUri = request.getRequestURI();
		String[] uri = requestUri.split("/");
		String action = uri[uri.length - 1];
		String method = request.getMethod();
		RequestDispatcher rd = null;
		
		switch (action) {
		case "list":
			String page_ = request.getParameter("page");
			int page = (page_ == null || page_.equals("")) ? 1 : Integer.parseInt(page_);
			List<User> list = uSvc.getUserList(page);
			request.setAttribute("list", list);
			rd = request.getRequestDispatcher("/ch09/user/list.jsp");
			rd.forward(request, response);
			break;
		}
	}

}