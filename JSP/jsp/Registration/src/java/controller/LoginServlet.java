/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.RegistrationBean;
import dao.RegistrationDAO;
import java.sql.ResultSet;
import javax.servlet.http.HttpSession;
/**
 *
 * @author alam
 */
public class LoginServlet extends HttpServlet {
       
    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        //1. get all value from form
        
        String email = req.getParameter("email");
        String pass1 = req.getParameter("pass1");
        
        //2. set all vlues to model class
        RegistrationBean bean = new RegistrationBean();
        bean.setEmail(email);
        bean.setPass1(pass1);
        
        //3. call dao login method
       String sql = "Select * from registration where email=? and pass1=?";
       
       
     ResultSet rs;
     rs = RegistrationDAO.login(bean , sql);
     try{
         if(rs.next())
         {
             getServletContext().getRequestDispatcher("welcome.jsp").forward(req, resp);
         }
         else{
                          getServletContext().getRequestDispatcher("login.jsp").forward(req, resp);

         }
     }catch(Exception e){}
       
        
      
        
        

    }

  
  
}
