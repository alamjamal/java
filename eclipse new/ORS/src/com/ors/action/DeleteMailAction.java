package com.ors.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ors.bean.MailTO;
import com.ors.delegate.MailMgrDelegate;
import com.ors.exception.OORSDataAccessException;
import com.ors.util.UtilConstants;

public class DeleteMailAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1474622144332363179L;
	static final Logger logger = Logger.getLogger(DeleteMailAction.class);

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute(UtilConstants._STATUS,
				UtilConstants._MAIL_DELETION_FAIL_MESSAGE);
		String taskid[];
		boolean flag = false;
		try {
			ArrayList<MailTO> ar = new ArrayList<MailTO>();
			taskid = request.getParameterValues(UtilConstants._CRID);
			if (taskid != null) {
				for (int i = 0; i < taskid.length; i++) {
					MailTO sd = new MailTO();
					sd.setMailid(Integer.parseInt(taskid[i]));
					ar.add(sd);
				}
				flag = new MailMgrDelegate().deleteMail(ar);
			}
			if (flag) {
				request.setAttribute(UtilConstants._STATUS,
						UtilConstants._MAIL_DELETION_SUCCESS_MESSAGE);
			} else
				request.setAttribute(UtilConstants._STATUS,
						UtilConstants._MAIL_DELETION_FAIL_MESSAGE);

		} catch (OORSDataAccessException e) {
			logger.info(e.getMessage());
			request.setAttribute(UtilConstants._STATUS,
					UtilConstants._MAIL_DELETION_FAIL_MESSAGE);
		}
		RequestDispatcher rd = request
				.getRequestDispatcher(UtilConstants._INBOX_JSP);
		rd.forward(request, response);
	}
}
