package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.mysql.jdbc.ResultSet;

import dao.UserDao;
import model.UserModel;

@WebServlet("/UserLoginn")
public class UserLoginn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		if (action == null) {
			UserModel model = checkCookie(request);

			if (model == null) {
				request.getRequestDispatcher("user_loginn.jsp").forward(
						request, response);

			} else {
				 /*UserDao dao = new UserDao();
				String sql = "select * from user_info where email=? and pass1=?";
				
				  UserDao.loginUser(model, sql);
				if ( ) {*/

					session.setAttribute("email", model.getEmail());
					request.getRequestDispatcher("welcome.jsp").forward(
							request, response);

			//	} 
			/*else  {
					request.setAttribute("msg", "invalid login");
					request.getRequestDispatcher("user_loginn.jsp").forward(
							request, response);

				}*/
			}
			System.out.println("do get main if for login");

		} else {

			if (action.equalsIgnoreCase("logout")) {
				session.removeAttribute("email");
				Cookie[] cookies = request.getCookies();
				for (Cookie ck : cookies) {

					if (ck.getName().equalsIgnoreCase("email")) {
						ck.setMaxAge(0);
						response.addCookie(ck);

					}
					if (ck.getName().equalsIgnoreCase("pass1")) {
						ck.setMaxAge(0);
						response.addCookie(ck);

					}

				}
			}

			System.out.println("do get main else for log out");
			request.getRequestDispatcher("user_loginn.jsp").forward(request,
					response);

		}

	}

	private UserModel checkCookie(HttpServletRequest request) {
		UserModel model = null;
		Cookie[] cookies = request.getCookies();
		if (cookies == null) {
			return null;
		} else {

			String email = "", pass1 = "";
			for (Cookie ck : cookies) {
				if (ck.getName().equalsIgnoreCase("email"))
					email = ck.getValue();
				if (ck.getName().equalsIgnoreCase("pass1"))
					pass1 = ck.getValue();
			}

			if (!email.isEmpty() && !pass1.isEmpty()) {
				model = new UserModel(email, pass1);

			}

		}

		return model;
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		if (action == null) {
			// 1. get all value from jsp
			String email = request.getParameter("email");
			String pass1 = request.getParameter("pass1");
			boolean remember = request.getParameter("remember") != null;

			// 2. set all values to model class
			UserModel model = new UserModel();
			model.setEmail(email);
			model.setPass1(pass1);
			String sql = "select * from user_info where email=? and pass1=?";
			// 3. call a method in dao class to perform sql operation
			ResultSet rs = UserDao.loginUser(model, sql);
			try {
				if (rs.next()) {

					session.setAttribute("email", email);
					if (!remember) {
						Cookie ckEmail = new Cookie("email", email);
						ckEmail.setMaxAge(3600);
						response.addCookie(ckEmail);
						Cookie ckPass1 = new Cookie("pass1", pass1);
						ckPass1.setMaxAge(3600);
						response.addCookie(ckPass1);
					}

					request.getRequestDispatcher("welcome.jsp").forward(
							request, response);

				}

				else {
					request.setAttribute("msg", "invalid login");
					request.getRequestDispatcher("user_loginn.jsp").forward(
							request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}// close main if
		else {

		}

	}// close dopost

}
