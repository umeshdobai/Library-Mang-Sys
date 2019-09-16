
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

@WebServlet("/Adminloginvalid")
public class Adminloginvalid extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Adminloginvalid() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	java.sql.Connection con = null;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String username1 = request.getParameter("username");
		String password1 = request.getParameter("password");
		try {
			con = DatabaseConnection.initializeDatabase();
			java.sql.PreparedStatement ps = con
					.prepareStatement("select username,password from admin where username=? and password=?");
			ps.setString(1, username1);
			ps.setString(2, password1);

			java.sql.ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				response.sendRedirect("adminmodulepage.html");
				return;
			}

			response.sendRedirect("AdminErrorpage.html");
			return;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception is here");
		}
	}
}
