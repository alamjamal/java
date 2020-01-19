package com.ors.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ors.bean.CourseTO;
import com.ors.delegate.CourseMgrDelegate;
import com.ors.exception.OORSInsertException;
import com.ors.util.UtilConstants;

public class AddCourseAction extends HttpServlet {

	private static final long serialVersionUID = 6387339085454438275L;
	static final Logger logger = Logger.getLogger(AddCourseAction.class);

	/**
	 * The doPost method of the servlet.
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.This method captures course registration data from users and going
	 * to populate into bean and going to call required manager delegate method
	 * for data processing
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute(UtilConstants._STATUS,
				UtilConstants._COURSE_REG_FAIL_MESSAGE);
		CourseTO cd = new CourseTO();
		boolean flag = false;
		cd.setCoursename(request.getParameter(UtilConstants._COURSE_NAME));
		cd
				.setCoursedetails(request
						.getParameter(UtilConstants._COURSE_DETAILS));
		try {
			flag = new CourseMgrDelegate().registerCourse(cd);
			if (flag)
				request.setAttribute(UtilConstants._STATUS,
						UtilConstants._COURSE_REG_SUCCESS_MESSAGE);
			else
				request.setAttribute(UtilConstants._STATUS,
						UtilConstants._COURSE_REG_FAIL_MESSAGE);
		} catch (OORSInsertException e) {
			logger.info(e.getMessage());
			request.setAttribute(UtilConstants._STATUS,
					UtilConstants._COURSE_REG_FAIL_MESSAGE);
		}
		RequestDispatcher rd = request
				.getRequestDispatcher(UtilConstants._ADD_COURSE_JSP);
		rd.forward(request, response);
	}
}
