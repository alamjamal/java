package com.ors.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ors.bean.RequestTO;
import com.ors.delegate.RequestMgrDelegate;
import com.ors.exception.OORSDataAccessException;
import com.ors.util.UtilConstants;

public class DeleteRequestAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7010099206315811183L;
	static final Logger logger = Logger.getLogger(DeleteRequestAction.class);

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute(UtilConstants._STATUS,
				UtilConstants._REQUEST_DELETION_FAIL_MESSAGE);
		String requestid[];
		boolean flag = false;
		try {
			ArrayList<RequestTO> ar = new ArrayList<RequestTO>();
			requestid = request.getParameterValues(UtilConstants._CRID);
			if (requestid != null) {
				for (int i = 0; i < requestid.length; i++) {
					RequestTO rd = new RequestTO();
					rd.setRequestid(Integer.parseInt(requestid[i]));
					ar.add(rd);
				}
				flag = new RequestMgrDelegate().deleteRequest(ar);
			}
			if (flag) {
				request.setAttribute(UtilConstants._STATUS,
						UtilConstants._REQUEST_DELETION_SUCCESS_MESSAGE);
			} else
				request.setAttribute(UtilConstants._STATUS,
						UtilConstants._REQUEST_DELETION_FAIL_MESSAGE);
		} 
		catch (OORSDataAccessException e) {
			logger.info(e.getMessage());
			request.setAttribute(UtilConstants._STATUS,
					UtilConstants._REQUEST_DELETION_FAIL_MESSAGE);
		}
		RequestDispatcher rd = request
				.getRequestDispatcher(UtilConstants._DELETE_REQUEST_JSP);
		rd.forward(request, response);
	}
}
