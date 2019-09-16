

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home implements Servlet {


    public Home() {
    }

	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("singh");
	}

	
	public void destroy() {
		
	}


	public ServletConfig getServletConfig() {
		
		return null;
	}

	public String getServletInfo() {
		
		return null; 
	}

	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		System.out.println("Pritesh");
	}

}
