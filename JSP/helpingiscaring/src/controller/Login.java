package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserModel;
import dao.UserDao;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// 1. retrive all parameter form jsp page

			String email = request.getParameter("email");

			String pass1 = request.getParameter("password");

			String hiddenForm = request.getParameter("form");

			// 2. set all values in model class
			UserModel model = new UserModel();
			UserDao dao = new UserDao();
			System.out.println("before form");

			if (hiddenForm.equalsIgnoreCase("form2")) {

				// double mobile = Double.parseDouble(umobile);

				model.setEmail(email);
				model.setPass1(pass1);
				int i = dao.checkEmail(model);

				if (i != 0) {
					int j = dao.checkPass(model);

					if (j != 0) {
						System.out.println("password is correct");

						model =dao.getUserByEmail(email);

						request.getSession().setAttribute("model", model);

						// request.getSession().setAttribute("email", email);
						RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
						rd.forward(request, response);
					} else {
						request.setAttribute("msg", "your password is not correct");
						request.getRequestDispatcher("user_login.jsp").forward(request, response);

					}

					System.out.println("end of form");

				} else {
					request.setAttribute("msg", "your email is not registerd");
					request.getRequestDispatcher("user_login.jsp").forward(request, response);

				}
			}

		} catch (Exception e) {

			response.sendRedirect("user_login.jsp");
			System.out.println(e);

		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action = request.getParameter("action");
		if (action == null) {
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		} else if (action.equalsIgnoreCase("logout")) {
			HttpSession session = request.getSession();
			session.getAttribute("model");
			session.removeAttribute("model");
			session.invalidate();
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
