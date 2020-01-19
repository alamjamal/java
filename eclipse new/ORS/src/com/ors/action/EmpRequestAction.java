package com.ors.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.ors.bean.CourseTO;
import com.ors.bean.MailTO;
import com.ors.daos.impl.CourseDAOImpl;
import com.ors.delegate.MailMgrDelegate;
import com.ors.exception.OORSInsertException;
import com.ors.util.UtilConstants;

public class EmpRequestAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setAttribute(UtilConstants._STATUS,
				UtilConstants._ASSIGNMENT_SHEDULE_FAIL_MESSAGE);
		CourseTO cd = new CourseTO();
		boolean flag = false;
		String user=(String)session.getAttribute(UtilConstants._USER);
		
		cd.setCoursename(request.getParameter("coursename"));
		cd.setEmpName(user);
		System.out.println(user+"     "+request.getParameter("coursename"));
		try {
			flag = new CourseDAOImpl().EmpRequest(cd);
			if (flag) {
				request.setAttribute(UtilConstants._STATUS,
						UtilConstants._REQUEST_SUCCESS_MESSAGE);
				
			} else
				request.setAttribute(UtilConstants._STATUS,
						UtilConstants._REQUEST_FAIL_MESSAGE);
		} catch (Exception e) {
			//logger.info(e.getMessage());
			request.setAttribute(UtilConstants._STATUS,
					UtilConstants._REQUEST_FAIL_MESSAGE);
		}
		RequestDispatcher rd = request
				.getRequestDispatcher("jsps/sendrequest.jsp");
		rd.forward(request, response);
	}
}
