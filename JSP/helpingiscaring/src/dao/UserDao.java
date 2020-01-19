package dao;

import java.sql.SQLException;

import bcrypt.BCrypt;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import dbUtil.ConnectionProvider;
import model.UserModel;

public class UserDao {

	public void addUser(UserModel model) {
		// TODO Auto-generated method stub

		try {
			Connection con = (Connection) ConnectionProvider.getConnection();
			String url;
			url = "insert into user_info (id, name, email, mobile, pass1, pass2) values(?,?,?,?,?,?)";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(url);

			ps.setInt(1, model.getId());
			ps.setString(2, model.getName());
			ps.setString(3, model.getEmail());
			ps.setString(4, model.getMobile());
			ps.setString(5, model.getPass1());
			ps.setString(6, model.getPass2());

			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	public static ResultSet loginUser(UserModel model, String sql) {
		ResultSet rs = null;
		try {
			System.out.println("dao1");
			Connection con = (Connection) ConnectionProvider.getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, model.getEmail());
			ps.setString(2, model.getPass1());
			rs = (ResultSet) ps.executeQuery();
			System.out.println("dao2");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return rs;
	}

	public void updateUser(UserModel model) {
		try {
			Connection con = (Connection) ConnectionProvider.getConnection();

			String sql = "update  user_info set name=? , mobile=? where email=?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);

			ps.setString(1, model.getName());
			ps.setString(2, model.getMobile());
			ps.setString(3, model.getEmail());
			ps.executeUpdate();

		} catch (SQLException e) {
		}
	}

	/*
	 * public List<UserModel> getAllUsers() { List<UserBean> users = new
	 * ArrayList<>(); try { String sql = "select * from user_info";
	 * PreparedStatement ps = con.prepareStatement(sql); ResultSet rs =
	 * ps.executeQuery(); while (rs.next()) { UserBean userBean = new
	 * UserBean(); userBean.setId(rs.getInt("userid"));
	 * userBean.setName(rs.getString("name"));
	 * userBean.setEmail(rs.getString("email")); users.add(userBean); } } catch
	 * (SQLException e) { } return users; }
	 */

	public UserModel getUserByEmail(String email) {
		UserModel model = new UserModel();

		try {

			Connection con = (Connection) ConnectionProvider.getConnection();

			String sql = "select * from user_info where email=?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			System.out.println("get user by email excutequery excuted");
			ps.setString(1, email);
			ResultSet rs = (ResultSet) ps.executeQuery();
			System.out.println("get user by email excutequery excuted");
			while (rs.next()) {

				model.setEmail(rs.getString("email"));
				model.setName(rs.getString("name"));
				model.setMobile(rs.getString("mobile"));
				model.setPass1(rs.getString("pass1"));
				model.setPass1(rs.getString("pass2"));
				System.out.println("get user by email found");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}

	public int updatePass(UserModel model) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			System.out.println("update pass1");
			Connection con = (Connection) ConnectionProvider.getConnection();

			String sql = "update  user_info set pass1=? , pass2=? where email=?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);

			ps.setString(1, model.getPass1());
			ps.setString(2, model.getPass2());
			ps.setString(3, model.getEmail());
			i = ps.executeUpdate();
			System.out.println("update pass2");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;

	}

	public static boolean chekEmail(String email) {
		// TODO Auto-generated method stub
		boolean chek = false;
		try {

			Connection con = (Connection) ConnectionProvider.getConnection();

			String sql = "select count(*) from user_info where email=?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = (ResultSet) ps.executeQuery();
			chek = rs.next();

		} catch (Exception e) {
			// TODO: handle exception
		}

		return chek;
	}

	public int checkEmail(UserModel model) {
		int i = 0;
		// UserModel model = new UserModel();
		try {
			System.out.println("check email1");
			Connection con = (Connection) ConnectionProvider.getConnection();
			String sql = "select pass1 from user_info where email=?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, model.getEmail());

			ResultSet rs = (ResultSet) ps.executeQuery();
			while (rs.next()) {
				System.out.println("check email 2");
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}

	public int checkPass(UserModel model) {
		int j = 0;
		String dpass = "";
		try {
			System.out.println("check pass1");
			Connection con = (Connection) ConnectionProvider.getConnection();
			String sql = "select pass1 from user_info where email=?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, model.getEmail());

			ResultSet rs = (ResultSet) ps.executeQuery();
			while (rs.next()) {
				System.out.println("check pass 2");
				dpass = rs.getString("pass1");

				if (BCrypt.checkpw(model.getPass1(), dpass)) {
					j++;
					System.out.println("check pass 3");
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return j;
	}

	public int updateuser(UserModel model) {
		// TODO Auto-generated method stub
		int i = 0;

		try {
			Connection con = (Connection) ConnectionProvider.getConnection();

			String sql = "update  user_info set name=? , mobile=? where email=?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);

			ps.setString(1, model.getName());
			ps.setString(2, model.getMobile());
			ps.setString(3, model.getEmail());
			i = ps.executeUpdate();

		} catch (SQLException e) {
		}

		return i;
	}

}
