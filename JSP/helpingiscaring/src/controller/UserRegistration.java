package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import javax.servlet.http.HttpSession;

import bcrypt.*;
import model.UserModel;
import dao.UserDao;

public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
	            //1. retrive all parameter form jsp page
	            String name = request.getParameter("name");
	            String email = request.getParameter("email");
	            String mobile = request.getParameter("mobile");
	            String pass1 = request.getParameter("password");
	            //String pass2 = request.getParameter("pass2");
	    	
	        	String spass1 = BCrypt.hashpw(pass1, BCrypt.gensalt(12));
	    		//String spass2 = BCrypt.hashpw(pass2, BCrypt.gensalt(12));
	            
	          //2. set all values in model class 
	            UserModel model = new UserModel();
                model.setName(name);
                model.setEmail(email);
                model.setMobile(mobile);
                model.setPass1(spass1);
                model.setPass2(spass1);
                
                UserDao dao = new UserDao();
                

	            String hiddenForm = request.getParameter("form");

	           

	            if (hiddenForm.equalsIgnoreCase("form1")) {
	            	            	
	                
	                //true means check has some value mean email is already there
	            	int i =dao.checkEmail(model);
	                if(i!=0) {           	       
	                	request.setAttribute("msg", "email is already registerd");
	    	            RequestDispatcher rd = request.getRequestDispatcher("user_registration.jsp");
	    	            rd.include(request, response);
	                	
	                }
	                //3. call a method in dao class to perform sql operation
	                else {
	                dao.addUser(model);
	                
	                
	                //4. set values to the session so that we can use it in another servlet or jsp
	                
	                
	                
	                model =dao.getUserByEmail(email);
	                HttpSession session = request.getSession();
					session.setAttribute("model", model);
	            

	                System.out.println("Record Added Successfully");
	               RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	               rd.forward(request, response);
	               
	                }
	            }

	        } catch (Exception e) {
	        	e.printStackTrace();
	         response.sendRedirect("user_registration.jsp");
	            System.out.println(e);

	        }
	    }
		
		
		

}
