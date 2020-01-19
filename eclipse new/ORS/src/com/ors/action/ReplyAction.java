package com.ors.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ors.bean.MailTO;
import com.ors.daos.impl.RequestDAOImpl;
import com.ors.delegate.MailMgrDelegate;
import com.ors.exception.OORSInsertException;
import com.ors.util.UtilConstants;


/**
 * @author JAVAPROJECTS
 *
 */
public class ReplyAction extends HttpServlet{
	
	private static final long serialVersionUID = 3358972065510702376L;
	static final Logger logger = Logger.getLogger(ReplyAction.class);

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		String page=request.getParameter(UtilConstants._PAGE);
		int requestid=Integer.parseInt(request.getParameter(UtilConstants._REQUEST_ID));
		int toid=Integer.parseInt(request.getParameter(UtilConstants._USERNAME));
		String status=request.getParameter(UtilConstants._STATUS);
		request.setAttribute(UtilConstants._STATUS,UtilConstants._REPLY_FAIL_MESSAGE);
		boolean flag=false;
		try{
			flag=new RequestDAOImpl().replyRequest(requestid,status);
			if(flag){
				request.setAttribute(UtilConstants._STATUS,UtilConstants._REPLY_SUCCESS_MESSAGE);
	            MailTO md=new MailTO();
	            md.setFrom(UtilConstants._ADMIN);
	    		md.setRecipient(toid);
	    		md.setSubject(UtilConstants._REQUEST_REPLY_MESSAGE_SUBJECT);
	    		md.setContent(UtilConstants._REQUEST_REPLY_MESSAGE_CONTENT);
	    		@SuppressWarnings("unused")
				boolean flag1=new MailMgrDelegate().storeMail(md);
			}
	         else  
	        	 request.setAttribute(UtilConstants._STATUS,UtilConstants._REPLY_FAIL_MESSAGE);
		}
		catch (OORSInsertException e) {
			logger.info(e.getMessage());
			request.setAttribute(UtilConstants._STATUS,UtilConstants._REPLY_FAIL_MESSAGE);
		}
		RequestDispatcher rd=request.getRequestDispatcher(UtilConstants._REPLY_REQUEST_JSP+page);
		rd.forward(request, response);
	}
}

