
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	 String userName = request.getParameter("userName").trim();
		if(userName == null || "".equals(userName)){
			userName = "Guest";
		}
		
		String greetings = "Hello " + userName;
		
		response.setContentType("text/plain");
		response.getWriter().write(greetings);
	}
	
}

