/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myPack;

import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


/**
 *
 * @author coder
 */
public class Course extends GenericServlet{

    @Override
    public void init(ServletConfig config) throws ServletException {
        String username=config.getInitParameter("username");
         String password=config.getInitParameter("password");
        super.init(config); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    public void service(ServletRequest sr, ServletResponse sr1) throws ServletException, IOException {
        
           
    }
}