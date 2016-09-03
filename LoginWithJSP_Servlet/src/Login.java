

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@SuppressWarnings("unused")
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String UserName = null;
	private String UserPass = null;
    /**
     * Default constructor. 
     */
    public Login() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		UserName = request.getParameter("user").trim();
		UserPass = request.getParameter("pass").trim();
		response.setContentType("text/html");
		PrintWriter pw= response.getWriter();
		if (UserName.isEmpty() || UserPass.isEmpty()){
			pw.println("");
			pw.println("Invalid User name and Password or Username/password is blank");
			RequestDispatcher rd = request.getRequestDispatcher("/index.html");
			rd.include(request, response);
		}
		else if (UserName.equals("admin") && UserPass.equals("admin")){
			pw.println("");
			pw.println("Login Success");
			RequestDispatcher rd = request.getRequestDispatcher("test.jsp");
			Cookie ck = new Cookie(UserName, Integer.toString(UserName.hashCode()));
			response.addCookie(ck);
			HttpSession s = request.getSession();
			s.setMaxInactiveInterval(300);
			s.setAttribute("sessionname", UserName);
			
			rd.forward(request, response);
		}
		else{
			RequestDispatcher rd = request.getRequestDispatcher("/index.html");
			rd.include(request, response);
			}
			
			
		}
	}

