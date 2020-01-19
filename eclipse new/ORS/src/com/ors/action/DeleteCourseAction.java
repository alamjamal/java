package com.ors.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ors.bean.CourseTO;
import com.ors.delegate.CourseMgrDelegate;
import com.ors.exception.OORSDataAccessException;
import com.ors.util.UtilConstants;

public class DeleteCourseAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3243380417469198642L;
	static final Logger logger = Logger.getLogger(DeleteCourseAction.class);

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute(UtilConstants._STATUS,
				UtilConstants._COURSE_DELETION_FAIL_MESSAGE);
		String courseid[];
		boolean flag = false;
		try {
			ArrayList<CourseTO> ar = new ArrayList<CourseTO>();
			courseid = request.getParameterValues(UtilConstants._CRID);
			if (courseid != null) {
				for (int i = 0; i < courseid.length; i++) {
					CourseTO sd = new CourseTO();
					sd.setCourseid(Integer.parseInt(courseid[i]));
					ar.add(sd);
				}
				flag = new CourseMgrDelegate().deleteCourse(ar);
			}
			if (flag) {
				request.setAttribute(UtilConstants._STATUS,
						UtilConstants._COURSE_DELETION_SUCCESS_MESSAGE);
			} else
				request.setAttribute(UtilConstants._STATUS,
						UtilConstants._COURSE_DELETION_FAIL_MESSAGE);

		} catch (OORSDataAccessException e) {
			logger.info(e.getMessage());
			request.setAttribute(UtilConstants._STATUS,
					UtilConstants._COURSE_DELETION_FAIL_MESSAGE);
		}
		RequestDispatcher rd = request
				.getRequestDispatcher(UtilConstants._DELETE_COURSE_JSP);
		rd.forward(request, response);
	}
}
