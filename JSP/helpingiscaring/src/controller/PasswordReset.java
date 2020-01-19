package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bcrypt.BCrypt;
import model.UserModel;
import dao.UserDao;

@WebServlet("/PasswordReset")
public class PasswordReset extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {

			String hiddenForm = request.getParameter("form");

			String email = request.getParameter("email");
			String pass1 = request.getParameter("pass1");
			String pass = request.getParameter("pass");
			String rpass = request.getParameter("rpass");

			if (hiddenForm.equalsIgnoreCase("form4")) {

				UserModel model =new UserModel();
				model.setEmail(email);
				model.setPass1(pass1);
				
				if (pass1.equals("") || pass.equals("") || rpass.equals("")) {

					request.setAttribute("pmsg", "plz dont leave empty");

					RequestDispatcher rd = request
							.getRequestDispatcher("user_changepassword.jsp");
					rd.include(request, response);
				}

				else if (!pass.equals(rpass)) {
					request.setAttribute("pmsg", "password do not match");
					RequestDispatcher rd = request
							.getRequestDispatcher("user_changepassword.jsp");
					rd.include(request, response);
				}

				else {

					// now after all condition check
					

					// call dao method to update pass in db
					UserDao dao = new UserDao();
					int j = dao.checkPass(model);
					if (j != 0) {
						System.out.println("password is correct");
						 String spass1 = BCrypt.hashpw(pass, BCrypt.gensalt(12));
						 model.setPass1(spass1);
						 model.setPass2(spass1);	
						int i = dao.updatePass(model);
						if (i != 0) {

							model = dao.getUserByEmail(email);
							request.getSession().setAttribute("model", model);
							
							System.out.println("password reset Successfully");
							request.setAttribute("pmsg", "Password updated Successfully");
							request.getRequestDispatcher("user_changepassword.jsp").forward(request, response);

						} else {
							System.out
									.println("password update problem in dbs");

						}

					} else {

						request.setAttribute("pmsg",
								"old password is not correct");
						RequestDispatcher rd = request
								.getRequestDispatcher("user_changepassword.jsp");
						rd.include(request, response);
					}

				}

				System.out.println("this is form 4");

			} // form 4 else if close
		} catch (Exception e) {
			e.printStackTrace();

			response.sendRedirect("user_changepassword.jsp");
		}
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

}
