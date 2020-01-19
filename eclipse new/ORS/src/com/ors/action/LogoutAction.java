package com.ors.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ors.delegate.SecurityMgrDelegate;
import com.ors.exception.OORSLoginException;
import com.ors.util.UtilConstants;

/**
 * @author JAVAPROJECTS
 * 
 */
public class LogoutAction extends HttpServlet {

	private static final long serialVersionUID = -4575185881871808094L;
	static final Logger logger = Logger.getLogger(LogoutAction.class);

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
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		try {
			new SecurityMgrDelegate().loginaudit((String) session
					.getAttribute(UtilConstants._USER));
			session.setAttribute(UtilConstants._USER, null);
			session.setAttribute(UtilConstants._ROLE, null);
			session.invalidate();
		} catch (OORSLoginException e) {
			logger.info(e.getMessage());
		}
		request.setAttribute(UtilConstants._STATUS,
				UtilConstants._LOGOUT_MESSAGE);
		RequestDispatcher rd = request
				.getRequestDispatcher(UtilConstants._LOGINFORM_JSP);
		rd.forward(request, response);
	}
}
