package com.ors.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ors.bean.MailTO;
import com.ors.delegate.MailMgrDelegate;
import com.ors.exception.OORSInsertException;
import com.ors.util.UtilConstants;

/**
 * @author JAVAPROJECTS
 * 
 */
public class MailAction extends HttpServlet {

	private static final long serialVersionUID = -6583322583746781205L;
	static final Logger logger = Logger.getLogger(MailAction.class);

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute(UtilConstants._STATUS,
				UtilConstants._MAIL_SEND_FAIL_MESSAGE);
		MailTO md = new MailTO();
		boolean flag = false;
		md.setFrom((String) request.getSession().getAttribute(
				UtilConstants._USER));
		md.setRecipient(Integer.parseInt(request
				.getParameter(UtilConstants._RECEIVER)));
		md.setSubject(request.getParameter(UtilConstants._SUBJECT));
		md.setContent(request.getParameter(UtilConstants._MESSAGE));
		try {
			flag = new MailMgrDelegate().storeMail(md);
			if (flag)
				request.setAttribute(UtilConstants._STATUS,
						UtilConstants._MAIL_SEND_SUCCESS_MESSAGE);
			else
				request.setAttribute(UtilConstants._STATUS,
						UtilConstants._MAIL_SEND_FAIL_MESSAGE);
		} catch (OORSInsertException e) {
			logger.info(e.getMessage());
			request.setAttribute(UtilConstants._STATUS,
					UtilConstants._MAIL_SEND_FAIL_MESSAGE);
		}
		RequestDispatcher rd = request
				.getRequestDispatcher(UtilConstants._SEND_MAIL_JSP);
		rd.forward(request, response);
	}
}
