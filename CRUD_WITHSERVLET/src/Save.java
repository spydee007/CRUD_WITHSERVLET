

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Save
 */
@WebServlet("/Save")
public class Save extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**a
     * Default constructor. 
     */
    public Save() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		response.setContentType("text/html");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String emailid = request.getParameter("emailid");
		String address = request.getParameter("address");
		
		User u = new User();
		u.setName(name);
		u.setPass(pass);
		u.setEmail(emailid);
		u.setAddress(address);
		
		new UserDAO();
		int status = UserDAO.save(u);
		PrintWriter pw = response.getWriter();
		if (status > 0 ){
			pw.println("Record Successfully Saved");
			request.getRequestDispatcher("index.html").include(request, response);
		}
		else{
			pw.println("Unable to save!");
			request.getRequestDispatcher("index.html").include(request, response);	
		}
		pw.close();
	}

}
