/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import dao.user.DaoUser;
import model.user.ModelUser;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author alam
 */
public class UserRegistration extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String hform = req.getParameter("form");

            if (hform.equalsIgnoreCase("form")) {

                //1. get all data from jsp form        
                //2. set all values to the model class
                ModelUser model = new ModelUser();

                model.setName(req.getParameter("name"));
                model.setEmail(req.getParameter("email"));
                model.setMobile(req.getParameter("mobile"));
                model.setPass1(req.getParameter("pass1"));
                model.setPass2(req.getParameter("pass2"));

                //3. call dao method    
                DaoUser dao = new DaoUser();

                dao.register(model);

                HttpSession hs = req.getSession();
                hs.setAttribute("name", model.getName());
                hs.setAttribute("email", model.getEmail());
                hs.setAttribute("pass1", model.getPass1());

                System.out.println("Record Added Successfully");
                resp.sendRedirect("profile.jsp");

                System.out.println("inseted");

            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);//To change body of generated methods, choose Tools | Templates.
    }

    
    
}


