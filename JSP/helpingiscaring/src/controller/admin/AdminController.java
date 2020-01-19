package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/admin/account")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if(action==null) {
		request.getRequestDispatcher("admin_login.jsp").forward(request, response);
	}
		else if (action.equalsIgnoreCase("logout")) {
			HttpSession session = request.getSession();
			session.removeAttribute("email");
			session.invalidate();
			request.getRequestDispatcher("admin_login.jsp").forward(request, response);

		}
		else if (action.equalsIgnoreCase("login")) {
			
			request.getRequestDispatcher("admin_login.jsp").forward(request, response);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		if(email.equalsIgnoreCase("alam") && pass.equalsIgnoreCase("alam"))
		{
			HttpSession session = request.getSession();
			session.setAttribute("email",email );
			request.getRequestDispatcher("admin_home.jsp").forward(request, response);
			
		}
		else {
			
			request.setAttribute("msg", "invalid login");
			request.getRequestDispatcher("admin_login.jsp").forward(request, response);
			
		}
		
		
		
	}

}
