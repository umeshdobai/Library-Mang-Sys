
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Allocatebookvalid")
public class Allocatebookvalid extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Connection con = DatabaseConnection.initializeDatabase();
			java.sql.PreparedStatement ps = con.prepareStatement("select isbn from student_info where isbn=?");
			ps.setString(1, request.getParameter("isbn"));

			java.sql.ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				// response.sendRedirect("adminmodulepage.html");
				return;
			}
			PrintWriter out = response.getWriter();
			out.println("<html><body>Invalid ISBN number</body></html>");
			return;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception is here");
		}
	}
}
