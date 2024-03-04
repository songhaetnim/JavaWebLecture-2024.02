package mini.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mini.entity.SkiEquipment;
import mini.service.SkiEqService;
import mini.service.SkiEqServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/auction/ski_equipment/list", "/auction/ski_equipment/add", "/auction/ski_equipment/update", "/auction/ski_equipment/delete",
        "/auction/ski_equipment/detail"})
public class SkiEqController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SkiEqService sSvc = new SkiEqServiceImpl();

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] uri = request.getRequestURI().split("/");
        String action = uri[uri.length - 1];
        String method = request.getMethod();
        HttpSession session = request.getSession();
        RequestDispatcher rd = null;
        String equipmentId = "", userId = "", equipmentName = "", description = "", condition = "", imageUrl = "";
        String page_ = "", field = "", query = "";
        SkiEquipment equipment = null;
        int page = 0;
        String sessuser_id = (String) session.getAttribute("sessuser_id");

        switch (action) {
            case "list":
                page_ = request.getParameter("p");
                field = request.getParameter("f");
                query = request.getParameter("q");
                page = (page_ == null || page_.equals("")) ? 1 : Integer.parseInt(page_);
                session.setAttribute("currentSkiEquipmentPage", page);
                field = (field == null || field.equals("")) ? "" : field;
                query = (query == null || query.equals("")) ? "" : query;
                session.setAttribute("field", field);
                session.setAttribute("query", query);
                List<SkiEquipment> equipmentList = sSvc.listEquipment(page, field, query);
                request.setAttribute("equipmentList", equipmentList);

                // Pagination
                int totalItems = sSvc.countEquipment(field, query);
                int totalPages = (int) Math.ceil(totalItems * 1.0 / sSvc.COUNT_PER_PAGE);
                List<String> pageList = new ArrayList<String>();
                for (int i = 1; i <= totalPages; i++)
                    pageList.add(String.valueOf(i));
                request.setAttribute("pageList", pageList);
                rd = request.getRequestDispatcher("/WEB-INF/miniview/SkiEquipment/list.jsp");
                rd.forward(request, response);
                break;

            case "add":
            	if(sessuser_id == null || sessuser_id.equals("")) {
					response.sendRedirect("/jw/auctiondb/user/login");
					break;
				}
                if (method.equals("GET")) {
                    rd = request.getRequestDispatcher("/WEB-INF/miniview/SkiEquipment/add.jsp");
                    rd.forward(request, response);
                } else {
                    equipmentId = request.getParameter("equipmentId");
                    description = request.getParameter("description");
                    condition = request.getParameter("condition");
                    imageUrl = request.getParameter("imageUrl");

                    equipment = new SkiEquipment(equipmentId, sessuser_id, description, condition, imageUrl);
                    sSvc.addEquipment(equipment);
                    response.sendRedirect(request.getContextPath() + "/auction/ski_equipment/list?p=1");
                }
                break;

            case "detail":
                equipmentId = request.getParameter("equipmentId");
                equipment = sSvc.getEquipmentById(equipmentId);
                request.setAttribute("equipment", equipment);

                rd = request.getRequestDispatcher("/WEB-INF/miniview/SkiEquipment/detail.jsp");
                rd.forward(request, response);
                break;

            case "delete":
                equipmentId = request.getParameter("equipmentId");
                sSvc.removeEquipment(equipmentId);
                response.sendRedirect(request.getContextPath() + "/auction/ski_equipment/list?p=1");
                break;

            case "update":
            	if(sessuser_id == null || sessuser_id.equals("")) {
					response.sendRedirect("/jw/auctiondb/user/login");
					break;
				}
                if (method.equals("GET")) {
                    equipmentId = request.getParameter("equipmentId");
                    equipment = sSvc.getEquipmentById(equipmentId);
                    request.setAttribute("equipment", equipment);
                    rd = request.getRequestDispatcher("/WEB-INF/miniview/SkiEquipment/update.jsp");
                    rd.forward(request, response);
                } else {
                    equipmentId = request.getParameter("equipmentId");
                    userId = request.getParameter("userId");
                    description = request.getParameter("description");
                    condition = request.getParameter("condition");
                    imageUrl = request.getParameter("imageUrl");
                    equipment = new SkiEquipment(equipmentId, userId, equipmentName, description, condition, imageUrl);
                    sSvc.updateEquipment(equipment);
                    response.sendRedirect(request.getContextPath() + "/auction/ski_equipment/list");
                }
                break;
        }
    }
}
