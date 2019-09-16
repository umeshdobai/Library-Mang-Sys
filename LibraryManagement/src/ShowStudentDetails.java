
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ShowStudentDetails")
public class ShowStudentDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Connection con = DatabaseConnection.initializeDatabase();

			PrintWriter out = response.getWriter();
			int id = Integer.parseInt(request.getParameter("sId"));

			PreparedStatement ps = con.prepareStatement("select * from student_info where sId=? ");
			ps.setInt(1, id);

			out.print("<table width=50% border=1>");
			out.print("<caption>Result:</caption>");

			ResultSet rs = ps.executeQuery();

			/* Printing column names */
			ResultSetMetaData rsmd = rs.getMetaData();
			int total = rsmd.getColumnCount();
			out.print("<tr>");
			for (int i = 1; i <= total; i++) {
				out.print("<th>" + rsmd.getColumnName(i) + "</th>");
			}

			out.print("</tr>");

			/* Printing result */

			while (rs.next()) {
				out.print("<tr><td>" + rs.getInt(1) + "</td><td>" + rs.getString(2) + "</td><td>" + rs.getString(3)
						+ "</td><td>" + rs.getInt(4) + "</td></tr>");

			}

			out.print("</table>");

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
	}

}
