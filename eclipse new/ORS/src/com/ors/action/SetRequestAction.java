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

import com.ors.bean.MailTO;
import com.ors.bean.RequestTO;
import com.ors.daos.impl.RequestDAOImpl;
import com.ors.delegate.MailMgrDelegate;
import com.ors.exception.OORSInsertException;
import com.ors.formbean.RequestFormBean;
import com.ors.util.UtilConstants;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class SetRequestAction extends HttpServlet {

	private static final long serialVersionUID = -153193332491163067L;
	static final Logger logger = Logger.getLogger(SetRequestAction.class);

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute(UtilConstants._STATUS,
				UtilConstants._SEND_REQUEST_FAIL_MESSAGE);
		boolean flag = false;
		try {
			RequestFormBean requestformbean = new RequestFormBean();
			Map map = request.getParameterMap();
			BeanUtils.populate(requestformbean, map);
			RequestTO rd = new RequestTO(requestformbean);
			rd.setFrom((String) request.getSession().getAttribute(
					UtilConstants._USER));
			flag = new RequestDAOImpl().setRequest(rd);
			if (flag) {
				request.setAttribute(UtilConstants._STATUS,
						UtilConstants._SEND_REQUEST_SUCCESS_MESSAGE);
				MailTO md = new MailTO();
				md.setFrom((String) request.getSession().getAttribute(
						UtilConstants._USER));
				md.setRecipient(1001);
				md.setSubject(UtilConstants._NEW_REQUEST_MESSAGE_SUBJECT);
				md.setContent(UtilConstants._NEW_REQUEST_MESSAGE_CONTENT);
				@SuppressWarnings("unused")
				boolean flag1 = new MailMgrDelegate().storeMail(md);
			} else
				request.setAttribute(UtilConstants._STATUS,
						UtilConstants._SEND_REQUEST_FAIL_MESSAGE);
		} catch (OORSInsertException e) {
			logger.info(e.getMessage());
			request.setAttribute(UtilConstants._STATUS,
					UtilConstants._SEND_REQUEST_FAIL_MESSAGE);
		} catch (IllegalAccessException e) {
			logger.info(e.getMessage());
			request.setAttribute(UtilConstants._STATUS,
					UtilConstants._SEND_REQUEST_FAIL_MESSAGE);
		} catch (InvocationTargetException e) {
			logger.info(e.getMessage());
			request.setAttribute(UtilConstants._STATUS,
					UtilConstants._SEND_REQUEST_FAIL_MESSAGE);
		}
		RequestDispatcher rd1 = request
				.getRequestDispatcher(UtilConstants._SET_REQUEST_JSP);
		rd1.forward(request, response);
	}
}
