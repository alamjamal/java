package controller;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



public class UserRegistrationFilter implements Filter {


	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		try{
	        String name = request.getParameter("name");
	        String email = request.getParameter("email");
	        String mobile = request.getParameter("mobile");
	        String pass1 = request.getParameter("password");
	        String pass2 = request.getParameter("password_confirmation");
	        
	    	HttpServletRequest req = (HttpServletRequest)request;
    		HttpSession session =req.getSession();
	   // String hiddenForm = request.getParameter("form");
	        
	        
	        if (name.equals("") || email.equals("") || mobile.equals("") || pass1.equals("") || pass2.equals("") ) {
	            request.setAttribute("msg", "plz dont leave empty");
	            session.setAttribute("name", name);
	    		session.setAttribute("email", email);
	    		session.setAttribute("mobile", mobile);
	    		request.setAttribute("msg", "plz don't leave any fields");
	            RequestDispatcher rd = request.getRequestDispatcher("user_registration.jsp");
	            rd.include(request, response);
	        } else if (!Pattern.matches("[0-9]{10}", mobile)) {
	        	session.setAttribute("name", name);
	    		session.setAttribute("email", email);
	    		session.setAttribute("mobile", mobile);
	            request.setAttribute("msg", "mobile must be in valid fomate and of 10 digit");
	            RequestDispatcher rd = request.getRequestDispatcher("user_registration.jsp");
	            rd.include(request, response);
	        } else if (!pass1.equals(pass2)) {
	        
	    		session.setAttribute("name", name);
	    		session.setAttribute("email", email);
	    		session.setAttribute("mobile", mobile);
	    		
	            request.setAttribute("msg", "password do not match");
	            RequestDispatcher rd = request.getRequestDispatcher("user_registration.jsp");
	            rd.include(request, response);
	        } else {
	        	
	        	System.out.println("filter condition end going to servlet");
	            chain.doFilter(request, response);
	        }
	        
	      
	      	
	     
	        }catch(Exception e) { System.out.println(e);
	            RequestDispatcher rd = request.getRequestDispatcher("user_registration.jsp");
	            rd.forward(request, response); }
	        
	}


	
	public void destroy() {
		// TODO Auto-generated method stub
	}

}
