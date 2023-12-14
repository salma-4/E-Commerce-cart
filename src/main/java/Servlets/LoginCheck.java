package Servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import models.Users;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
   	   String password =request.getParameter("password");

        try {
       	 Statement st=(Statement)request.getServletContext().getAttribute("statement");

       	 ResultSet res=st.executeQuery("select * from users where email ='"+email+"'and password ='"+password+"'");
		         if (res.next()) {
		        	 Users user=  new Users();
		        	 user.setId(res.getInt("id"));
		        	 user.setPassword(res.getString("password"));
		        	 user.setEmail(res.getString("email"));
		        	 request.getSession().setAttribute("user", user);
		           PrintWriter out = response.getWriter();
		           RequestDispatcher dis=request.getRequestDispatcher("index.jsp");
		           dis.forward(request, response);
		   
		         }else {
		        	    // Set an error message attribute in the request
		        	    request.setAttribute("errorMessage", "Incorrect email or password");

		        	    // Forward the request to the login page
		        	    RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
		        	    dis.forward(request, response);
		        	}
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
		
	}

}
