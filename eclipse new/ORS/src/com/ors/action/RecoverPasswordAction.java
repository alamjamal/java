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

public class RecoverPasswordAction extends HttpServlet {

	private static final long serialVersionUID = -161743941471145122L;
	static final Logger logger = Logger.getLogger(RecoverPasswordAction.class);

	/**
	 * The doPost method of the servlet. <br>
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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String target = UtilConstants._RECOVER_PASSWORD_JSP;
		request.setAttribute(UtilConstants._STATUS,
				UtilConstants._RECOVER_PASSWORD_FAIL_MESSAGE);
		try {
			ProfileFormBean profileformbean = new ProfileFormBean();
			Map map = request.getParameterMap();
			BeanUtils.populate(profileformbean, map);
			ProfileTO rb = new ProfileTO(profileformbean);
			String password = new SecurityMgrDelegate()
					.recoverPasswordByQuestion(rb);
			if (password.equals("") || password == null)
				request.setAttribute(UtilConstants._STATUS,
						UtilConstants._RECOVER_PASSWORD_FAIL_MESSAGE);
			else {
				target = UtilConstants._LOGINFORM_JSP;
				request.setAttribute(UtilConstants._STATUS,
						UtilConstants._RECOVER_PASSWORD_SUCCESS_MESSAGE
								+ password);
			}
		} catch (OORSDataAccessException e) {
			logger.info(e.getMessage());
			request.setAttribute(UtilConstants._STATUS,
					UtilConstants._RECOVER_PASSWORD_FAIL_MESSAGE);
		} catch (IllegalAccessException e) {
			logger.info(e.getMessage());
			request.setAttribute(UtilConstants._STATUS,
					UtilConstants._RECOVER_PASSWORD_FAIL_MESSAGE);
		} catch (InvocationTargetException e) {
			logger.info(e.getMessage());
			request.setAttribute(UtilConstants._STATUS,
					UtilConstants._RECOVER_PASSWORD_FAIL_MESSAGE);
		}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
	}
}
