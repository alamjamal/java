package com.ors.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ors.bean.ProfileTO;
import com.ors.delegate.LoginDetailsMgrDelegate;
import com.ors.exception.OORSDataAccessException;
import com.ors.util.UtilConstants;

/**
 * @author JAVAPROJECTS
 * 
 */
public class LogInDetailsAction extends HttpServlet {

	private static final long serialVersionUID = -418296536277676766L;
	static final Logger logger = Logger.getLogger(LogInDetailsAction.class);

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String target = "";
		String name = request.getParameter(UtilConstants._USERNAME);
		String fromdate = request.getParameter(UtilConstants._FROMDATE);
		String todate = request.getParameter(UtilConstants._TO_DATE);
		try {
			ArrayList<ProfileTO> ar = new LoginDetailsMgrDelegate()
					.getLogInDetails(name, fromdate, todate);
			request.getSession().setAttribute(UtilConstants._LOG_DETAILS_ARRAY,
					ar);
			request.getSession().setAttribute(UtilConstants._LOG_DETAILS_USERS,
					name);
			target = UtilConstants._LOGDETAILS_JSP;
		} catch (OORSDataAccessException e) {
			logger.info(e.getMessage());
			target = UtilConstants._USERLOG_JSP;
			request.setAttribute(UtilConstants._STATUS,
					UtilConstants._RECORD_NOT_FOUND);
		}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
	}
}
