

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class View
 */
@WebServlet("/View")
public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public View() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		response.getWriter().println("<html>");
		response.getWriter().println("<title>");
		response.getWriter().println("View Users List");
		response.getWriter().println("</title>");
		response.getWriter().println("<body>");
		response.getWriter().println("<h3> List of Users </h3>");
		response.getWriter().println("<table width='100%' border='2'>");
		new UserDAO();
		List<User> l = null;
		try {
			l = UserDAO.viewUsers();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.getWriter().println("<tr><th>Id</th><th>Name</th><th>Emailid</th><th>Address</th></tr>");
		for(User u:l){
			response.getWriter().println("<tr><td>"+u.getId()+"</td><td>"+u.getName()+"</td><td>"+u.getEmail()+"</td><td>"+u.getAddress()+"</td>");
		}
		response.getWriter().println("</table>");
		response.getWriter().println("</body>");
		response.getWriter().println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
