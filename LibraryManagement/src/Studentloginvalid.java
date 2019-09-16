import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/studentloginvalid")
public class Studentloginvalid extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	java.sql.Connection con = null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String username11 = request.getParameter("username");
		String password11 = request.getParameter("password");
		try {
			con = DatabaseConnection.initializeDatabase();
			java.sql.PreparedStatement ps = con
					.prepareStatement("select username,password from student_login where username=? and password=?");
			ps.setString(1, username11);
			ps.setString(2, password11);

			java.sql.ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				response.sendRedirect("Studentview.html");
				return;
			} else {
				response.sendRedirect("StudentErrorpage.html");
			}
			return;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception is here");
		}
	}
}
