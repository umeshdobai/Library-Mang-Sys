

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Allocatebook")
public class Allocatebook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {

			// Initialize the database
			Connection con = DatabaseConnection.initializeDatabase();

			// Create a SQL query to insert data into demo table
			// demo table consists of two columns, so two '?' is used
			PreparedStatement st = con.prepareStatement("insert into student_info values(?, ? ,? ,?)");

			// For the first parameter,
			// get the data using request object
			
			// sets the data to st pointer
			st.setString(1, request.getParameter("sId"));

			// Same for second parameter
			st.setString(2, request.getParameter("FirstName"));
			
			st.setString(3, request.getParameter("LastName"));
			
			st.setString(4, request.getParameter("isbn"));

			// Execute the insert command using executeUpdate()
			// to make changes in database
			int count = st.executeUpdate();
			System.out.println("Total number of ros affacted here" + count);

			// Close all the connections
			st.close();
			con.close();
System.out.println("closed connection here");
			// Get a writer pointer
			// to display the succesful result
			PrintWriter out = response.getWriter();
			out.println("<html><body><center><b>Successfully allocated" + "</b></center></body></html>");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception is coming here !!");

		}
	}

}
