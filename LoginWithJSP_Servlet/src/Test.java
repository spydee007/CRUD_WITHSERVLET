

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//String name = request.getParameter("name");
		PrintWriter pw = response.getWriter();
		//pw.println(name);
		Enumeration<String> str = request.getParameterNames();
		while(str.hasMoreElements()){
			pw.println('\n');
			pw.println(str.nextElement());	
		}
		pw.print(request.getContentLength());
		pw.print(request.getContentType());
		pw.println(request.getContextPath());
		pw.println(request.getCharacterEncoding());
		pw.println(request.getServerName());
		pw.println(request.getServerPort());
		pw.println(request.getServletPath());
		pw.println(request.getServletContext());
		pw.println(request.getRequestedSessionId());
		//response.sendRedirect("index.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
