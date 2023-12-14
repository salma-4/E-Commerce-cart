package Servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class RegisterCheck
 */
public class RegisterCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		try {
			Statement st = (Statement) request.getServletContext().getAttribute("statement");
			ResultSet res = st.executeQuery("SELECT * FROM users WHERE email = '" + email + "'");
			if (res.next()) {
				// Email already exists
				 request.setAttribute("emailMessage", "email already exist");
				   RequestDispatcher dis = request.getRequestDispatcher("register.jsp");
	        	    dis.forward(request, response);
			}  else {
					// Both email and password are unique,
					// register done
					PreparedStatement insertStatement = st.getConnection()
						    .prepareStatement("INSERT INTO users (id, name, email, password) VALUES (DEFAULT, ?, ?, ?)",
						                      Statement.RETURN_GENERATED_KEYS);
						insertStatement.setString(1, name);
						insertStatement.setString(2, email);
						insertStatement.setString(3, password);
						insertStatement.executeUpdate();

						// Retrieve the generated ID
						ResultSet generatedKeys = insertStatement.getGeneratedKeys();
						if (generatedKeys.next()) {
						    int generatedId = generatedKeys.getInt(1);
						    // Use the generatedId as needed
						}
						 request.setAttribute("registerMessage", "registered sucessfully ,now login");

						 RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
			        	    dis.forward(request, response);
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
