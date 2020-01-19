/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbUtil.ConnectionProvider;
import bean.RegistrationBean;
import java.sql.*;

/**
 *
 * @author alam
 */
public class RegistrationDAO {

    
    

    private final  Connection con;

    public RegistrationDAO() {
        con = ConnectionProvider.getConnection();
    }

    public void addUser(RegistrationBean rBean) {

        try {
            String url;
            url = "insert into register1 (id, name, email, mobile, pass1, pass2, secques) values(?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(url);

            ps.setInt(1, rBean.getId());
            ps.setString(2, rBean.getName());
            ps.setString(3, rBean.getEmail());
            ps.setDouble(4, rBean.getMobile());
            ps.setString(5, rBean.getPass1());
            ps.setString(6, rBean.getPass2());
            ps.setString(7, rBean.getSecques());
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
  public static ResultSet login(RegistrationBean bean, String sql) {
        ResultSet rs= null;
        try{
            Connection con = ConnectionProvider.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(3, bean.getEmail());
            ps.setString(4, bean.getPass1());
            rs = ps.executeQuery();
            
        }catch(SQLException e){}
                
       
        
        
        
  return rs;
    }

    
}
