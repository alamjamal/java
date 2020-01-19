package com.ors.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ors.bean.CourseTO;
import com.ors.bean.MailTO;
import com.ors.daos.impl.CourseDAOImpl;
import com.ors.delegate.MailMgrDelegate;
import com.ors.exception.OORSInsertException;
import com.ors.util.UtilConstants;

public class AddEmpReqAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6825520824294348478L;
	static final Logger logger = Logger.getLogger(AddEmpReqAction.class);

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setAttribute(UtilConstants._STATUS,
				UtilConstants._ASSIGNMENT_SHEDULE_FAIL_MESSAGE);
		CourseTO cd = new CourseTO();
		boolean flag = false;
		
		
		
		int rid=Integer.parseInt(request.getParameter("rid"));
		System.out.println(rid);
		String req=request.getParameter("req");
		System.out.println(req);
		try {
			flag = new CourseDAOImpl().AddEmpReq(req,rid);
			if (flag) {
				request.setAttribute(UtilConstants._STATUS,
						"Emp Request Succussfully Updated");
				
			} else
				request.setAttribute(UtilConstants._STATUS,
						"Emp Request Succussfully Not Updated");
		} catch (Exception e) {
			logger.info(e.getMessage());
			request.setAttribute(UtilConstants._STATUS,
					"Fail");
		}
		RequestDispatcher rd = request
				.getRequestDispatcher(UtilConstants._ASSIGN_REQ_JSP);
		rd.forward(request, response);
	}
}
