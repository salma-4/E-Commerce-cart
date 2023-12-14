package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Servlet implementation class AddToCart
 */
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html;charset=UTF-8");

	        try (PrintWriter out = response.getWriter()) {
//	        	out.print("add to cart servlet");

	            ArrayList<Cart> cartList = new ArrayList<>();
	            int id = Integer.parseInt(request.getParameter("id"));
	            Cart cm = new Cart();
	            cm.setId(id);
	            cm.setQuatity(1);
	            HttpSession session = request.getSession();
	            ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
	            if (cart_list == null) {
	                cartList.add(cm);
	                session.setAttribute("cart-list", cartList);
	                request.setAttribute("successMessage", "Item added successfully!");
	            } else {
	                cartList = cart_list;

	                boolean exist = false;
	                for (Cart c : cart_list) {
	                    if (c.getId() == id) {
	                        exist = true;
		                    request.setAttribute("errorMessage", "item already in the cart  ");
	                    }
	                }

	                if (!exist) {
	                    cartList.add(cm);
	                    request.setAttribute("successMessage", "Item added successfully!");
	                }
	            }
	            request.getRequestDispatcher("index.jsp").forward(request, response);
   
	        }
		}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
