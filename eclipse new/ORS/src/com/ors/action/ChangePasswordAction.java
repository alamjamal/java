package com.ors.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ors.bean.ProfileTO;
import com.ors.delegate.SecurityMgrDelegate;
import com.ors.exception.OORSDataAccessException;
import com.ors.formbean.ProfileFormBean;
import com.ors.util.UtilConstants;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class ChangePasswordAction extends HttpServlet {

	private static final long serialVersionUID = -3903185988984124774L;
	static final Logger logger = Logger.getLogger(ChangePasswordAction.class);

	/**
	 * The doGet method of the servlet.
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
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
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean flag = false;
		request.setAttribute(UtilConstants._STATUS,
				UtilConstants._PASSWORD_CHANGE_FAIL_MESSAGE);
		try {
			ProfileFormBean profileformbean = new ProfileFormBean();
			Map map = request.getParameterMap();
			BeanUtils.populate(profileformbean, map);
			ProfileTO rb = new ProfileTO(profileformbean);
			if ((rb.getPassword().equals(rb.getNewpassword()))) {
				request.setAttribute(UtilConstants._STATUS,
						UtilConstants._SAME_PASSWORD_ERROR_MESSAGE);
			} else {
				flag = new SecurityMgrDelegate().changePassword(rb);
				if (flag)
					request.setAttribute(UtilConstants._STATUS,
							UtilConstants._PASSWORD_CHANGE_SUCCESS_MESSAGE);
				else
					request.setAttribute(UtilConstants._STATUS,
							UtilConstants._PASSWORD_CHANGE_FAIL_MESSAGE);
			}
		} catch (OORSDataAccessException e) {
			logger.info(e.getMessage());
			request.setAttribute(UtilConstants._STATUS,
					UtilConstants._PASSWORD_CHANGE_FAIL_MESSAGE);
		} catch (IllegalAccessException e) {
			logger.info(e.getMessage());
			request.setAttribute(UtilConstants._STATUS,
					UtilConstants._PASSWORD_CHANGE_FAIL_MESSAGE);
		} catch (InvocationTargetException e) {
			logger.info(e.getMessage());
			request.setAttribute(UtilConstants._STATUS,
					UtilConstants._PASSWORD_CHANGE_FAIL_MESSAGE);
		}
		RequestDispatcher rd = request
				.getRequestDispatcher(UtilConstants._CHANGE_PASSWORD_JSP);
		rd.forward(request, response);
	}
}
