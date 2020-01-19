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
import javax.servlet.http.HttpSession;

/**
 *
 * @author alam
 */
public class RegistrationController extends HttpServlet {

    RegistrationDAO rDAO;

    public RegistrationController() {
        super();
        rDAO = new RegistrationDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //1. retrive all parameter form jsp page
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String umobile = req.getParameter("mobile");
            String pass1 = req.getParameter("pass1");
            String pass2 = req.getParameter("pass2");
            String secques = req.getParameter("secques");

            String hiddenForm = req.getParameter("form");

            //2. set all values in model class 
            RegistrationBean rBean = new RegistrationBean();

            if (hiddenForm.equalsIgnoreCase("form1")) {

                double mobile = Double.parseDouble(umobile);

                rBean.setName(name);
                rBean.setEmail(email);
                rBean.setMobile(mobile);
                rBean.setPass1(pass1);
                rBean.setPass2(pass2);
                rBean.setSecques(secques);

                //3. call a method in dao class to perform sql operation
                rDAO.addUser(rBean);

                HttpSession hs = req.getSession();
                hs.setAttribute("name", rBean.getName());
                hs.setAttribute("email", rBean.getEmail());
                hs.setAttribute("pass1", rBean.getPass1());

                System.out.println("Record Added Successfully");
                resp.sendRedirect("welcome.jsp");

            }

        } catch (Exception e) {
            //resp.sendRedirect("registration.jsp");
            System.out.println(e);

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}
