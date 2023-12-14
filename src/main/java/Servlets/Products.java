package Servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class Products
 */

public class Products extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 List<models.Products> products = new ArrayList<>();
         Statement st = (Statement) request.getServletContext().getAttribute("statement");
         try {
             ResultSet res = st.executeQuery("select * from products");
             while (res.next()) {
                 models.Products product = new models.Products();
                 product.setId(res.getInt("id"));
                 product.setName(res.getString("name"));
                 product.setCategory(res.getString("category"));
                 product.setImage(res.getString("image"));
                 product.setPrice(res.getDouble("price"));
                 products.add(product);
             }
             request.getSession().setAttribute("product", products);
             RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
             dispatcher.forward(request, response);
         } catch (SQLException e) {
             // Handle the exception (log or rethrow if necessary)
             e.printStackTrace();
         }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

 
}
