package com.ors.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ors.delegate.SecurityMgrDelegate;
import com.ors.exception.OORSDataAccessException;
import com.ors.util.UtilConstants;

public class ChekUserAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2069284714996725047L;
	static final Logger logger = Logger.getLogger(ChekUserAction.class);

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username = request.getParameter(UtilConstants._USERNAME);
		String reqfrom=request.getParameter(UtilConstants._FORMNAME);
		String rkey="";
		if(reqfrom.equalsIgnoreCase(UtilConstants._USER))
		{
			 rkey=UtilConstants._REGISTER_FORM_JSP;
		}
			 else if(reqfrom.equalsIgnoreCase(UtilConstants._EMPLOYEE))
			 {
				 rkey=UtilConstants._EMPREGISTER_FORM_JSP;
			 }
			else
			rkey=UtilConstants._DEPARTMENT_REGISTER_FORM_JSP;
			try
			{
				String user = new SecurityMgrDelegate().checkUser(username);
				if (user.equals(null))
				{
					request.setAttribute(UtilConstants._CHECKUSER,UtilConstants._USER_AVAILABLE_MESSAGE);	
				}
				else
					request.setAttribute(UtilConstants._CHECKUSER,UtilConstants._USER_ALREADYEXIST_MESSAGE);
			}
			catch (OORSDataAccessException e)
			{
				logger.info(e.getMessage());
				request.setAttribute(UtilConstants._CHECKUSER,UtilConstants._USER_AVAILABLE_MESSAGE);
			}
		RequestDispatcher rd = request.getRequestDispatcher(rkey);
		rd.forward(request, response);
	}
}
