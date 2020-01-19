package com.ors.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ors.bean.ProfileTO;
import com.ors.delegate.ProfileMgrDelegate;
import com.ors.exception.OORSDataAccessException;
import com.ors.util.UtilConstants;

public class ViewUserAction extends HttpServlet {

	private static final long serialVersionUID = 6672098776764904293L;
	static final Logger logger = Logger.getLogger(ViewUserAction.class);

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String target = "";
		String name = request.getParameter(UtilConstants._USERNAME);
		String path = request.getSession().getServletContext().getRealPath(
				UtilConstants._USER_IMAGE_FOLDER);
		ProfileTO aprofile = null;
		try {
			aprofile = new ProfileMgrDelegate().getProfile(name, path);
			if (aprofile == null) {
				target = UtilConstants._VIEW_USER_JSP;
				request.setAttribute(UtilConstants._STATUS,
						UtilConstants._USER_NOT_FOUND_MESSAGE);
			} else {
				request.setAttribute(UtilConstants._BEAN, aprofile);
				if (aprofile.getLogintype().equalsIgnoreCase(
						UtilConstants._DEPARTMENT))
					target = UtilConstants._VIEW_DEPARTMENT_JSP + name;
				else
					target = UtilConstants._VIEW_PROFILE_JSP + name;
			}
		} catch (OORSDataAccessException e) {
			logger.info(e.getMessage());
			request.setAttribute(UtilConstants._STATUS,
					UtilConstants._USER_NOT_FOUND_MESSAGE);
		}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
	}
}
