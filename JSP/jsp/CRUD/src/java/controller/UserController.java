package controller;

import bean.UserBean;
import dao.UserDAOImplementation;
import java.io.Externalizable;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alam
 */
public class UserController extends HttpServlet implements Externalizable{

   
    private static final String ADDUSER = "/addUser.jsp";
    private static final String UPDATEUSER = "/updateUser.jsp";
    private static final String LISTALLUSER = "/listAllUser.jsp";

    /**
     *
     */
    UserDAOImplementation uidao;

    /**
     *
     */
    public UserController() {
        
        super();
       
        uidao = new UserDAOImplementation();
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        
        String redirect = "";
        String uId = request.getParameter("userId");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String actions = request.getParameter("actions");
        
        
        if (!((uId) ==null) && actions.equalsIgnoreCase("insert")) {
            
          
            int id = Integer.parseInt(uId);
            UserBean user = new UserBean();
            user.setId(id);
            //user.setName(request.getParameter("name"));
            user.setName(name);
            
            user.setEmail(request.getParameter("email"));
            uidao.addUser(user);
            redirect = ADDUSER;
            request.setAttribute("users", uidao.getAllUsers());
            System.out.println("Record Added Successfully");
          
        } 
        else if (actions.equalsIgnoreCase("delete")) {
            String userId = request.getParameter("userId");
            int uid = Integer.parseInt(userId);
            uidao.removeUser(uid);
            redirect = LISTALLUSER;
            request.setAttribute("users", uidao.getAllUsers());
            System.out.println("Record Deleted Successfully");
        } 
        else if (actions.equalsIgnoreCase("editform")) {
            redirect = UPDATEUSER;
        } 
        else if (!("".equals(name)) && !("".equals(email)) && actions.equalsIgnoreCase("edit") ) {
            String userId = request.getParameter("userId");
            int uid = Integer.parseInt(userId);
            UserBean user = new UserBean();
            user.setId(uid);
            user.setName(request.getParameter("name"));
            user.setEmail(request.getParameter("email"));
            uidao.updateUser(user);
            request.setAttribute("user", user);
            redirect = LISTALLUSER;
            System.out.println("Record updated Successfully");
        } 
        else if (actions.equalsIgnoreCase("listUser")) {
            redirect = LISTALLUSER;
            request.setAttribute("users", uidao.getAllUsers());
        } 
        else {
            redirect = ADDUSER;
        }

        RequestDispatcher rd = request.getRequestDispatcher(redirect);
        rd.forward(request, response);

    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     *
     * @param oo
     * @throws IOException
     */
    @Override
    public void writeExternal(ObjectOutput oo) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param oi
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public void readExternal(ObjectInput oi) throws IOException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
