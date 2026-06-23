package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.Plant;
import dao.PlantDAO;

public class PlantListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        try {
            PlantDAO dao = new PlantDAO();
            List<Plant> plants = dao.getAllPlants();
            req.setAttribute("plants", plants);
            RequestDispatcher view = req.getRequestDispatcher("plants.jsp");
            view.forward(req, resp);
        } catch (SQLException e) {
            out.println("<p>Error loading plants: " + e.getMessage() + "</p>");
        } finally {
            out.close();
        }
    }
}
