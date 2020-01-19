package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserModel;
import dao.UserDao;

/**
 * Servlet implementation class UserProfileUpdate
 */
@WebServlet("/UserProfileUpdate")
public class UserProfileUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {

			String email = request.getParameter("email");
			String hiddenForm = request.getParameter("form");

			if (hiddenForm.equalsIgnoreCase("form3")) {

				// 1. retrive all parameter form jsp page

				String name = request.getParameter("name");

				String mobile = request.getParameter("mobile");

				// 3. call a method in dao class to perform sql operation

				if (name.equalsIgnoreCase("") || mobile.equalsIgnoreCase("")) {

					// ServletContext context = getServletContext();
					// context.setAttribute("editmsg",
					// "please fill all the field");
					request.setAttribute("editmsg", "plz dont leave empty");

					RequestDispatcher rd = request
							.getRequestDispatcher("user_profile.jsp");
					rd.forward(request, response);

					// response.sendRedirect("user_profile.jsp");
				}

				else {

					// 2. set all values in model class
					UserModel model = new UserModel();
					model.setName(name);
					model.setEmail(email);
					model.setMobile(mobile);

					// 3. upadte record
					UserDao dao = new UserDao();
					int i = dao.updateuser(model);
					if(i!=0)
					{
						model = dao.getUserByEmail(email);
						request.getSession().setAttribute("model", model);

						System.out.println("Record updated Successfully");
						request.setAttribute("editmsg", "Record updated Successfully");
						request.getRequestDispatcher("user_profile.jsp").forward(request, response);
		
					}
					else {
						System.out.println("Record is not updated there"
								+ "is any problem in dbs");
						
					}

				
				}
			}

			
			else {
				System.out.println("  end of form");

				response.sendRedirect("user_profile.jsp");
			} // main if, if else, else closed

		} catch (Exception e) {
			response.sendRedirect("user_profile.jsp");
			e.printStackTrace();
			System.out.println("unresolved exception  " + e);

		}
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
