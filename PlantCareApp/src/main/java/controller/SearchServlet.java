package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.Plant;
import dao.PlantDAO;

public class SearchServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String userSearch = req.getParameter("search");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		try {
			PlantDAO dao = new PlantDAO();
			Plant plantObj = dao.searchByName(userSearch);

			String outURL;
			if (plantObj == null) {
				outURL = "missing_plant.html";
			} else {
				HttpSession session = req.getSession();
				session.setAttribute("plant", plantObj);
				outURL = "output.jsp";
			}

			RequestDispatcher view = req.getRequestDispatcher(outURL);
			view.forward(req, resp);

		} catch (SQLException e) {
			out.println("<p>Error executing SQL: " + e.getMessage()
					+ " (Error code: " + e.getErrorCode() + ")</p>");
		} finally {
			out.close();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		doPost(req, resp); // forward to doPost()
        
	}

}
