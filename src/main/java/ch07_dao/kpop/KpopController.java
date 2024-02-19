package ch07_dao.kpop;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

/**
 * Servlet implementation class KpopController
 */
@WebServlet({"/ch07/kpop/list", "/ch07/kpop/insertArtist", "/ch07/kpop/insertSong", 
	"/ch07/kpop/updateArtist", "/ch07/kpop/updateSong", "/ch07/kpop/deleteArtist", "/ch07/kpop/deleteSong"})
public class KpopController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private KpopDao kDao = new KpopDaoImpl();

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] uri = request.getRequestURI().split("/");
		String action = uri[uri.length - 1];
		String method = request.getMethod();
		RequestDispatcher rd = null;
		Artist artist = null;
		Song song = null;
		int aid = 0, sid = 0;
		String name = null, debut = null, title = null, lyrics = null;
		
		switch(action) {
		case "list":
			List<Kpop> list = kDao.getKpopList();
			rd = request.getRequestDispatcher("/ch07/kpop/list.jsp");
			request.setAttribute("list", list);
			rd.forward(request, response);
			break;
			
		case "insertArtist":
			if (method.equals("GET")) {
				rd = request.getRequestDispatcher("/ch07/kpop/insertArtist.jsp");
				rd.forward(request, response);
			} else {
				name = request.getParameter("name");
				debut = request.getParameter("debut");
				sid = Integer.parseInt(request.getParameter("songId"));
				artist = new Artist(name, LocalDate.parse(debut), sid);
				kDao.insertArtist(artist);
				response.sendRedirect("/jw/ch07/kpop/list");
			}
			break;
			
		case "updateArtist":
			if (method.equals("GET")) {
				aid = Integer.parseInt(request.getParameter("aid"));
				artist = kDao.getArtist(aid);
				rd = request.getRequestDispatcher("/ch07/kpop/updateArtist.jsp");
				request.setAttribute("artist", artist);
				rd.forward(request, response);
			} else {
				aid = Integer.parseInt(request.getParameter("aid"));
				name = request.getParameter("name");
				debut = request.getParameter("debut");
				sid = Integer.parseInt(request.getParameter("songId"));
				artist = new Artist(aid, name, LocalDate.parse(debut), sid);
				kDao.updateArtist(artist);
				response.sendRedirect("/jw/ch07/kpop/list");
			}
			break;
			
		case "deleteArtist":
			aid = Integer.parseInt(request.getParameter("aid"));
			kDao.deleteArtist(aid);
			response.sendRedirect("/jw/ch07/kpop/list");
			break;
			
		case "insertSong":
			if (method.equals("GET")) {
				rd = request.getRequestDispatcher("/ch07/kpop/insertSong.jsp");
				rd.forward(request, response);
			} else {
				title = request.getParameter("title");
				lyrics = request.getParameter("lyrics");
				song = new Song(title, lyrics);
				kDao.insertSong(song);
				response.sendRedirect("/jw/ch07/kpop/list");
			}
			break;
		
		case "updateSong":
			if (method.equals("GET")) {
				sid = Integer.parseInt(request.getParameter("sid"));
				song = kDao.getSong(sid);
				rd = request.getRequestDispatcher("/ch07/kpop/updateSong.jsp");
				request.setAttribute("song", song);
				rd.forward(request, response);
			} else {
				sid = Integer.parseInt(request.getParameter("sid"));
				title = request.getParameter("title");
				lyrics = request.getParameter("lyrics");
				song = new Song(sid, title, lyrics);
				kDao.updateSong(song);
				response.sendRedirect("/jw/ch07/kpop/list");
			}
			break;
			
		case "deleteSong":
			sid = Integer.parseInt(request.getParameter("sid"));
			kDao.deleteSong(sid);
			response.sendRedirect("/jw/ch07/kpop/list");
			break;
		}
	}

}