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

/**
 * @author JAVAPROJECTS
 * 
 */
public class SheduleCourseAction extends HttpServlet {

	private static final long serialVersionUID = -5964318921473977827L;
	static final Logger logger = Logger.getLogger(SheduleCourseAction.class);

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute(UtilConstants._STATUS,
				UtilConstants._COURSE_SHEDULE_FAIL_MESSAGE);
		CourseTO cd = new CourseTO();
		boolean flag = false;
		cd.setCourseid(Integer.parseInt(request
				.getParameter(UtilConstants._COURSE_ID)));
		cd.setCoursestartdate(request.getParameter(UtilConstants._FROMDATE));
		cd.setCourseenddate(request.getParameter(UtilConstants._TO_DATE));
		cd.setFacultyid(Integer.parseInt(request
				.getParameter(UtilConstants._FACULTY_ID)));
		try {
			flag = new CourseMgrDelegate().sheduleCourse(cd);
			if (flag) {
				request.setAttribute(UtilConstants._STATUS,
						UtilConstants._COURSE_SHEDULE_SUCCESS_MESSAGE);
			} else
				request.setAttribute(UtilConstants._STATUS,
						UtilConstants._COURSE_SHEDULE_FAIL_MESSAGE);
		} catch (OORSInsertException e) {
			logger.info(e.getMessage());
			request.setAttribute(UtilConstants._STATUS,
					UtilConstants._COURSE_SHEDULE_FAIL_MESSAGE);
		}
		RequestDispatcher rd = request
				.getRequestDispatcher(UtilConstants._SHEDULE_COURSE_JSP);
		rd.forward(request, response);
	}
}
