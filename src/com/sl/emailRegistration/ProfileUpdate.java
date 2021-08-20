package com.sl.emailRegistration;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sl.dao.UserDAO;
import com.sl.model.UserPojo;


/**
 * Servlet implementation class ProfileUpdate
 */
@WebServlet("/ProfileUpdate")
public class ProfileUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProfileUpdate() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			System.out.println("get method");
			String action = request.getParameter("action");
			if (action == null) {
				request.getRequestDispatcher("U-Profile.jsp").forward(request, response);
			}
		} catch (Exception e) {
			request.getRequestDispatcher("U-Profile.jsp").forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			
			
			// 1. retrive all parameter form jsp page
				String email = request.getParameter("email");
				String lname = request.getParameter("lname");
				String fname = request.getParameter("fname");
				if (fname.equalsIgnoreCase("") || lname.equalsIgnoreCase("")) {
					RequestDispatcher rd = request.getRequestDispatcher("U-Profile.jsp");
					rd.forward(request, response);
					// response.sendRedirect("user_profile.jsp");
				} else {
					// 2. set all values in model class
					UserPojo up = new UserPojo();
					up.setFIRST_NAME(fname);
					up.setLAST_NAME(lname);
					up.setEMAIL(email);
					// 3. upadte record
					int i = UserDAO.profileUpdate(up);
					if (i != 0) {
						up = UserDAO.selectUSERbyEmail(email);
						request.getSession().setAttribute("up", up);
						System.out.println("Record updated Successfully");
						request.getRequestDispatcher("U-Profile.jsp").forward(request, response);
					} else {
						System.out.println("Record is not updated there" + "is any problem in dbs");
					}
				}
			// main if, if else, else closed
		} catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("U-Profile.jsp").forward(request, response);
		}
		PrintWriter pw = response.getWriter();
		//pw.write();
		pw.flush();
		pw.close();
	}
}
