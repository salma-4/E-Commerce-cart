package Filters;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Users;

import java.io.IOException;
import java.io.PrintWriter;
 
public class Loginfilter extends HttpFilter implements Filter {
       
   
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req= (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		Users user =(Users) req.getSession().getAttribute("user");
		if(user==null) {
		 res.sendRedirect("login.jsp");
		}else
				chain.doFilter(request, response);
	}
}
