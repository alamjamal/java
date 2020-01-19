package com.ors.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ors.bean.CourseTO;
import com.ors.bean.MailTO;
import com.ors.daos.impl.CourseDAOImpl;
import com.ors.delegate.MailMgrDelegate;
import com.ors.exception.OORSInsertException;
import com.ors.util.UtilConstants;

public class AssignSheduleAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6825520824294348478L;
	static final Logger logger = Logger.getLogger(AssignSheduleAction.class);

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute(UtilConstants._STATUS,
				UtilConstants._ASSIGNMENT_SHEDULE_FAIL_MESSAGE);
		CourseTO cd = new CourseTO();
		boolean flag = false;
		cd.setSheduleid(Integer.parseInt(request
				.getParameter(UtilConstants._SHEDULE_ID)));
		cd.setFacultyid(Integer.parseInt(request
				.getParameter(UtilConstants._FACULTY_ID)));
		try {
			flag = new CourseDAOImpl().assignShedule(cd);
			if (flag) {
				request.setAttribute(UtilConstants._STATUS,
						UtilConstants._ASSIGNMENT_SHEDULE_SUCCESS_MESSAGE);
				MailTO md = new MailTO();
				md.setFrom((String) request.getSession().getAttribute(
						UtilConstants._USER));
				md.setRecipient(cd.getFacultyid());
				md
						.setSubject(UtilConstants._NEW_SHEDULE_ASSIGNMENT_MESSAGE_SUBJECT);
				md
						.setContent(UtilConstants._NEW_SHEDULE_ASSIGNMENT_MESSAGE_CONTENT);
				@SuppressWarnings("unused")
				boolean flag1 = new MailMgrDelegate().storeMail(md);
			} else
				request.setAttribute(UtilConstants._STATUS,
						UtilConstants._ASSIGNMENT_SHEDULE_FAIL_MESSAGE);
		} catch (OORSInsertException e) {
			logger.info(e.getMessage());
			request.setAttribute(UtilConstants._STATUS,
					UtilConstants._ASSIGNMENT_SHEDULE_FAIL_MESSAGE);
		}
		RequestDispatcher rd = request
				.getRequestDispatcher(UtilConstants._ASSIGN_COURSE_JSP);
		rd.forward(request, response);
	}
}
