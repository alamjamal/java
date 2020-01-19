package com.ors.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ors.bean.ProfileTO;
import com.ors.delegate.SecurityMgrDelegate;
import com.ors.exception.OORSLoginException;
import com.ors.formbean.ProfileFormBean;
import com.ors.util.UtilConstants;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class LoginAction extends HttpServlet {
	
	private static final long serialVersionUID = 1816350248524181137L;
	static final Logger logger = Logger.getLogger(LoginAction.class);

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
	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String target = UtilConstants._LOGINFORM_JSP;
		try {
			HttpSession session = request.getSession();
			ProfileFormBean profileformbean = new ProfileFormBean();
			Map map = request.getParameterMap();
			BeanUtils.populate(profileformbean, map);
			ProfileTO rb = new ProfileTO(profileformbean);
			SecurityMgrDelegate mgrdelegate = new SecurityMgrDelegate();
			String role = mgrdelegate.loginCheck(rb);
			if (role.equalsIgnoreCase(UtilConstants._ADMIN)) {
				target = UtilConstants._ADMINHOME_JSP;
				session.setAttribute(UtilConstants._USER, rb.getUsername());
				session.setAttribute(UtilConstants._ROLE, role);
			} else if (role.equalsIgnoreCase(UtilConstants._DEPARTMENT)) {
				target = UtilConstants._DEPARTMENT_HOME_JSP;
				session.setAttribute(UtilConstants._USER, rb.getUsername());
				session.setAttribute(UtilConstants._ROLE, role);
			} else if (role.equalsIgnoreCase(UtilConstants._FACULTY)) {
				target = UtilConstants._USER_HOME_JSP;
				session.setAttribute(UtilConstants._USER, rb.getUsername());
				session.setAttribute(UtilConstants._ROLE, role);
			}else if (role.equalsIgnoreCase(UtilConstants._EMPLOYEE)) {
				target = UtilConstants._EMP_HOME_JSP;
				session.setAttribute(UtilConstants._USER, rb.getUsername());
				session.setAttribute(UtilConstants._ROLE, role);
			}
			
			else
				request.setAttribute(UtilConstants._STATUS,
						UtilConstants._INVALID_LOGIN);
		} catch (OORSLoginException e) {
			logger.info(e.getMessage());
			request.setAttribute(UtilConstants._STATUS,
					UtilConstants._INVALID_LOGIN);
		} catch (IllegalAccessException e) {
			logger.info(e.getMessage());
			request.setAttribute(UtilConstants._STATUS,
					UtilConstants._INVALID_LOGIN);
		} catch (InvocationTargetException e) {
			logger.info(e.getMessage());
			request.setAttribute(UtilConstants._STATUS,
					UtilConstants._INVALID_LOGIN);
		}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
	}
}
