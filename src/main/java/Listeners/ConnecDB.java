package Listeners;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class ConnecDB implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        String url = "jdbc:mysql://localhost:3306/e-commerce_shopping_cart";
        String username = "root";
        String password = "";

    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			  Connection connection = DriverManager.getConnection(url, username, password);
				Statement st=connection.createStatement();
				sce.getServletContext().setAttribute("statement",st);
		} 
		
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /*Statement st = (Statement) sce.getServletContext().getAttribute("statement");

        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                // Log or display the exception
                e.printStackTrace();
            }
        }*/
    }
}
