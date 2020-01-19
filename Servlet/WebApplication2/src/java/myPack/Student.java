
package myPack;

import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class Student extends GenericServlet{

    @Override
    public void init(ServletConfig config) throws ServletException {
        String username=config.getInitParameter("username");
         String password=config.getInitParameter("password");
        super.init(config); 
        
    }
    
    
    

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
  
        
        
    }

    
   

}
