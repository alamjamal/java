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
import com.ors.delegate.ProfileMgrDelegate;
import com.ors.exception.OORSInsertException;
import com.ors.formbean.ProfileFormBean;
import com.ors.util.UtilConstants;
import com.sun.org.apache.commons.beanutils.BeanUtils;

/**
 * @author JAVAPROJECTS
 * 
 */
public class RegisterAction extends HttpServlet {

	private static final long serialVersionUID = -8816033736339042084L;
	static final Logger logger = Logger.getLogger(RegisterAction.class);

	/**
	 * The doPost method of the servlet.
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

		request.setAttribute(UtilConstants._STATUS,
				UtilConstants._REGISTRATION_FAIL_MESSAGE);
		try {
			ProfileFormBean profileformbean = new ProfileFormBean();
			Map map = request.getParameterMap();
			BeanUtils.populate(profileformbean, map);
			ProfileTO rb = new ProfileTO(profileformbean);
			boolean flag = new ProfileMgrDelegate().registration(rb);
			if (flag)
				request.setAttribute(UtilConstants._STATUS,
						UtilConstants._REGISTRATION_SUCCESS_MESSAGE);
			else
				request.setAttribute(UtilConstants._STATUS,
						UtilConstants._REGISTRATION_FAIL_MESSAGE);
		} catch (OORSInsertException e) {
			logger.info(e.getMessage());
			request.setAttribute(UtilConstants._STATUS,
					UtilConstants._REGISTRATION_FAIL_MESSAGE);
		} catch (IllegalAccessException e) {
			logger.info(e.getMessage());
			request.setAttribute(UtilConstants._STATUS,
					UtilConstants._REGISTRATION_FAIL_MESSAGE);
		} catch (InvocationTargetException e) {
			logger.info(e.getMessage());
			request.setAttribute(UtilConstants._STATUS,
					UtilConstants._REGISTRATION_FAIL_MESSAGE);
		} 
		RequestDispatcher rd = request
				.getRequestDispatcher(UtilConstants._EMPREGISTER_FORM_JSP);
		rd.forward(request, response);
	}
}
