/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.UserBean;
import java.util.List;
import connectionProvider.ConnectionProvider;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author alam
 */
public class UserDAOImplementation implements UserDao {

   private final Connection con;

    public UserDAOImplementation() {

        con = ConnectionProvider.getConnection();

    }

    @Override
    public void addUser(UserBean userBean) {
        try {
            String sql = "insert into user_info (userid, name, email) values (?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userBean.getId());
            ps.setString(2, userBean.getName());
            ps.setString(3, userBean.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public void removeUser(int userId) {
        try {
            String sql = "delete from user_info where userid=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
        }

    }

    @Override
    public void updateUser(UserBean userBean) {
        try {
            String sql = "update  user_info set name=? , email=? where userid=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, userBean.getName());
            ps.setString(2, userBean.getEmail());
            ps.setInt(3, userBean.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
        }
    }

    @Override
    public List<UserBean> getAllUsers() {
        List<UserBean> users = new ArrayList<>();
        try {
            String sql = "select * from user_info";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UserBean userBean = new UserBean();
                userBean.setId(rs.getInt("userid"));
                userBean.setName(rs.getString("name"));
                userBean.setEmail(rs.getString("email"));
                users.add(userBean);
            }
        } catch (SQLException e) {
        }
        return users;
    }
//user for vlue stored when we go to update value
    @Override
    public UserBean getUserById(int userId) {
        UserBean userBean = new UserBean();
     try {
            String sql = "select * from user_info where userid=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId); //enter current coming userId
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                userBean.setId(rs.getInt("userid"));
                userBean.setName(rs.getString("name"));
                userBean.setEmail(rs.getString("email"));

            }
        } catch (SQLException e) {
        }
        return userBean;
    }

}
