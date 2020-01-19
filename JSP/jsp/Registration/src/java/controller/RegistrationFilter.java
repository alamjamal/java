/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.regex.Pattern;
import javax.servlet.*;

public class RegistrationFilter implements Filter {    
    
    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }    
    
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        //1. insert all data form jsp page
        
        try{
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String umobile = req.getParameter("mobile");
        String pass1 = req.getParameter("pass1");
        String pass2 = req.getParameter("pass2");
        String secques = req.getParameter("secques");
        
        String hiddenForm = req.getParameter("form");
        
        if (name.equals("") || email.equals("") || umobile.equals("") || pass1.equals("") || pass2.equals("") || secques.equals("")) {
            req.setAttribute("msg", "plz dont leave empty");
            
            RequestDispatcher rd = req.getRequestDispatcher("registration.jsp");
            rd.forward(req, resp);
        } else if (!Pattern.matches("[0-9]{10}", umobile)) {
            
            req.setAttribute("msg", "mobile must be in valid fomate and of 10 digit");
            RequestDispatcher rd = req.getRequestDispatcher("registration.jsp");
            rd.forward(req, resp);
        } else if (!pass1.equals(pass2)) {
            req.setAttribute("msg", "password do not match");
            RequestDispatcher rd = req.getRequestDispatcher("registration.jsp");
            rd.forward(req, resp);
        } else {
            chain.doFilter(req, resp);
        }
        }catch(Exception e) { System.out.println(e);
            RequestDispatcher rd = req.getRequestDispatcher("registration.jsp");
            rd.include(req, resp); }
        
    }    

    @Override
    public void destroy() {
    }    
    
}
