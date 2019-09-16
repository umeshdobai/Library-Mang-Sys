

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Deletebook")
public class Deletebook extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try{
			int isbn=Integer.parseInt(request.getParameter("isbn"));
			Connection con = DatabaseConnection.initializeDatabase();
			PreparedStatement ps=con.prepareStatement("delete from book where isbn=?");
			ps.setInt(1,isbn);
			ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
	}

}
