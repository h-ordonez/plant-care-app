package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.*;

public class SearchServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) 
			throws ServletException, IOException {
		
		String userSearch = req.getParameter("search"); // user entered string
		
		resp.setContentType("text/html"); // used for the catch errors
		PrintWriter out = resp.getWriter();
		
		try {
			String url = "jdbc:mysql://localhost:3306/plants_db?characterEncoding=utf-8";
			String userName= "root"; // database account name
			String pass = ""; // password for database account
			String query = "select * from plants where common_name = ?";
			
			Plant plantObj = new Plant(); // create the javabean
			String outURL = "";
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, userName, pass);
			PreparedStatement ps = con.prepareStatement(query);		// Prepare statement protects against
			ps.setString(1, userSearch);							// most SQL injections
			ResultSet rs = ps.executeQuery();
			
			// rs.next() moves cursor to the first row in result set
			if (rs.next() == false) {
				outURL = "missing_plant.html"; // result set is empty or plant not in database
			}
			else {
				do {
					plantObj.setCommonName(rs.getString("common_name"));
					plantObj.setSciName(rs.getString("scientific_name"));
					plantObj.setWaterInfo(rs.getString("watering_frequency"));
					plantObj.setSunInfo(rs.getString("sunlight_amount"));
					plantObj.setPlantDescription(rs.getString("plant_description"));
					plantObj.setImgFileName(rs.getString("img_file_name"));
					plantObj.setImgPath( plantObj.getImgFolder() + plantObj.getImgFileName() );
					outURL = "output.jsp";
				} while (rs.next());
			}
			
			ps.close();
			con.close();
			
			HttpSession session = req.getSession();
			session.setAttribute("plant", plantObj);
			RequestDispatcher view = req.getRequestDispatcher(outURL);
	        view.forward(req, resp);
			
			
		} catch (ClassNotFoundException e) {
			out.println("<p>Error loading the database driver: <br>"
					+ e.getMessage() + "</p>");
		} catch (SQLException e) {
			out.println("<p>Error executing the SQL statement: <br>"
					+ e.getMessage() + "<br> SQL Error code: " + e.getErrorCode() + "</p>");
			e.printStackTrace();
		}
		
		finally {
			out.close();
		}
		
	}//end of doPost()
	
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) 
			throws ServletException, IOException {
		
		doPost(req, resp); // forward to doPost()
        
	}// end of doGet()

} // end of SearchServlet
