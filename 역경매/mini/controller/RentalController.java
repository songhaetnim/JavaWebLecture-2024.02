package mini.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mini.entity.Rental;
import mini.entity.SkiEquipment;
import mini.service.RentalService;
import mini.service.RentalServiceImpl;
import mini.service.SkiEqService;
import mini.service.SkiEqServiceImpl;

@WebServlet({ "/auction/rental/list", "/auction/rental/rent", "/auction/rental/return" })
public class RentalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RentalService rSvc = new RentalServiceImpl();
	private SkiEqService sSvc = new SkiEqServiceImpl();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] uri = request.getRequestURI().split("/");
		String action = uri[uri.length - 1];
		HttpSession session = request.getSession();
		RequestDispatcher rd = null;
		String sessuser_id = (String) session.getAttribute("sessuser_id");

		switch (action) {
		case "list":
			List<Rental> rentals = rSvc.getRentalList(1, "rental_id", "");
			request.setAttribute("rentals", rentals);
			rd = request.getRequestDispatcher("/WEB-INF/miniview/rental/list.jsp");
			rd.forward(request, response);
			break;

		case "rent":
			if(sessuser_id == null || sessuser_id.equals("")) {
				response.sendRedirect("/jw/auctiondb/user/login");
				break;
			}
			if ("GET".equalsIgnoreCase(request.getMethod())) {
				rd = request.getRequestDispatcher("/WEB-INF/miniview/rental/rent.jsp");
				rd.forward(request, response);
			} else if ("POST".equalsIgnoreCase(request.getMethod())) {
				String equipmentId = request.getParameter("equipmentId");
				LocalDateTime startDate = LocalDateTime.parse(request.getParameter("startDate"),
						DateTimeFormatter.ISO_LOCAL_DATE_TIME);
				LocalDateTime endDate = LocalDateTime.parse(request.getParameter("endDate"),
						DateTimeFormatter.ISO_LOCAL_DATE_TIME);
				int totalPrice = Integer.parseInt(request.getParameter("totalPrice"));
				Rental rental = new Rental(sessuser_id, equipmentId, startDate, endDate, totalPrice, 0);
				int result = rSvc.insertRental(rental);
				if (result == RentalService.RENTAL_SUCCESS) {
					response.sendRedirect("list");
				} else {
					request.setAttribute("error", "렌탈 등록에 실패했습니다.");
					rd = request.getRequestDispatcher("/WEB-INF/miniview/rental/error.jsp");
					rd.forward(request, response);
				}
			}
			break;

		case "return":
			if(sessuser_id == null || sessuser_id.equals("")) {
				response.sendRedirect("/jw/auctiondb/user/login");
				break;
			}
			if ("GET".equalsIgnoreCase(request.getMethod())) {
				// 렌탈 반납 폼 페이지로 리다이렉션
				rd = request.getRequestDispatcher("/WEB-INF/miniview/rental/return.jsp");
				rd.forward(request, response);
			} else if ("POST".equalsIgnoreCase(request.getMethod())) {
				int rentalId = Integer.parseInt(request.getParameter("rentalId"));
				Rental returnRental = rSvc.getRental(rentalId); // 렌탈 정보 조회
				if (returnRental != null) {
					if (returnRental.getPaymentStatus() == 1) {
						// 이미 반납이 완료된 렌탈인 경우
						request.setAttribute("error", "이미 반납이 완료된 렌탈입니다.");
						rd = request.getRequestDispatcher("/WEB-INF/miniview/rental/error.jsp");
						rd.forward(request, response);
					} else {
						returnRental.setPaymentStatus(1); // 결제 상태를 "완료"로 업데이트
						int updateResult = rSvc.updateRental(returnRental); // 변경 사항 저장
						if (updateResult == RentalService.RENTAL_SUCCESS) {
							// 반납 처리 성공, 렌탈 목록 페이지로 리다이렉션
							response.sendRedirect("list");
						} else {
							// 반납 처리 실패, 에러 메시지와 함께 에러 페이지로 포워딩
							request.setAttribute("error", "렌탈 반납에 실패했습니다.");
							rd = request.getRequestDispatcher("/WEB-INF/miniview/rental/error.jsp");
							rd.forward(request, response);
						}
					}
				} else {
					// 렌탈 정보가 없는 경우, 에러 메시지와 함께 에러 페이지로 포워딩
					request.setAttribute("error", "해당 렌탈 정보를 찾을 수 없습니다.");
					rd = request.getRequestDispatcher("/WEB-INF/miniview/rental/error.jsp");
					rd.forward(request, response);
				}
			}
			break;

		default:
			response.sendRedirect("list");
			break;
		}
	}
}
