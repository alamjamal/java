package controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UserLoginFilter implements Filter {

	public void init(FilterConfig fConfig) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		try{
			  HttpServletRequest req = (HttpServletRequest) request;
			    HttpServletResponse res = (HttpServletResponse) response;
			   
	        String email = request.getParameter("email");
	       
	        String pass1 = request.getParameter("password");
	     
	      
	        
	   // String hiddenForm = request.getParameter("form");
	        
	        
	        if (email.equals("") || pass1.equals("") ) {
	        	
	        	
	         req.setAttribute("msg", "plz dont leave empty any fields");
	           
	            
	            RequestDispatcher rd = request.getRequestDispatcher("user_login.jsp");
	            rd.forward(request, response);
	        }  else {
	        	
	        	
	            chain.doFilter(req, res);
	        }
	        
	      
	      	
	     
	        }catch(Exception e) { System.out.println(e);
	            RequestDispatcher rd = request.getRequestDispatcher("user_login.jsp");
	            rd.include(request, response); }
	}

	public void destroy() {

	}

}
