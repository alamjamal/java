package in.techyari.example.controller;

import in.techyari.example.dao.UserDAOImpl;
import in.techyari.example.model.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationController
 */
@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String password= request.getParameter("password");
		String gender = request.getParameter("gender");
		String birthdate = request.getParameter("birthdate");
		
		User user = new User(fullname,email,password,gender,birthdate);
		
		UserDAOImpl userDAOImpl = new UserDAOImpl();
		
		int result = userDAOImpl.createOrUpdateUser(user);
		
		if(result == 0){
			
			System.out.println("User could not be registered");
		}else{
			
			System.out.println(user.getFullname()+" You have been registered successfully");
			response.sendRedirect("success.html");
		}
		
	}

}
