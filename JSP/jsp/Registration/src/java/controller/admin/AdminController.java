/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import bean.RegistrationBean;
import dao.RegistrationDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alam
 */
public class AdminController extends HttpServlet {

   RegistrationDAO rDAO;

    public AdminController() {
        super();
        rDAO = new RegistrationDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //1. insert all data form jsp page
            String uname = req.getParameter("username");
            String pass = req.getParameter("pssword");
            

            String hiddenForm = req.getParameter("form");
   

            //2. invoke bean class 
            RegistrationBean rBean = new RegistrationBean();

           

        }catch(Exception e){ System.out.println(e);}
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}

