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
public class DeptRegisterAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8827988073379517538L;
	static final Logger logger = Logger.getLogger(DeptRegisterAction.class);

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute(UtilConstants._STATUS,
				UtilConstants._REGISTER_DEPARTMENT_FAIL_MESSAGE);
		try {
			ProfileFormBean profileFormBean = new ProfileFormBean();
			Map map = request.getParameterMap();
			BeanUtils.populate(profileFormBean, map);
			ProfileTO pf = new ProfileTO(profileFormBean);
			boolean flag = false;
			flag = new ProfileMgrDelegate().registerDept(pf);
			if (flag)
				request.setAttribute(UtilConstants._STATUS,
						UtilConstants._REGISTER_DEPARTMENT_SUCCESS_MESSAGE);
			else
				request.setAttribute(UtilConstants._STATUS,
						UtilConstants._REGISTER_DEPARTMENT_FAIL_MESSAGE);
		} catch (OORSInsertException e) {
			logger.info(e.getMessage());
			request.setAttribute(UtilConstants._STATUS,
					UtilConstants._REGISTER_DEPARTMENT_FAIL_MESSAGE);
		} catch (IllegalAccessException e) {
			logger.info(e.getMessage());
			request.setAttribute(UtilConstants._STATUS,
					UtilConstants._REGISTER_DEPARTMENT_FAIL_MESSAGE);
		} catch (InvocationTargetException e) {
			logger.info(e.getMessage());
			request.setAttribute(UtilConstants._STATUS,
					UtilConstants._REGISTER_DEPARTMENT_FAIL_MESSAGE);
		}
		RequestDispatcher rd = request
				.getRequestDispatcher(UtilConstants._DEPARTMENT_REGISTER_JSP);
		rd.forward(request, response);
	}
}
