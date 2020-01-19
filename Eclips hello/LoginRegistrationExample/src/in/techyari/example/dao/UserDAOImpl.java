package in.techyari.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.techyari.example.model.User;

public class UserDAOImpl implements UserDAO{
	
	Database db = new Database();
	

	@Override
	public User getUserByEmail(String email, String password) {
		User user = new User();
		try {
			Connection connection = db.getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE email LIKE ? AND password LIKE ?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				user.setId(rs.getInt("id"));
				user.setFullname(rs.getString("fullname"));
				user.setEmail(rs.getString("email"));
				user.setGender(rs.getString("gender"));
				user.setBirthdate(rs.getString("birthdate"));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return user;
	}

	@Override
	public int createOrUpdateUser(User u) {
		int result = 0;
		try {
			Connection connection = db.getConnection();
			PreparedStatement ps = connection.prepareStatement("INSERT INTO users (fullname,email,password,gender,birthdate) VALUES (?,?,?,?,?)");
			ps.setString(1, u.getFullname());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPassword());
			ps.setString(4, u.getGender());
			ps.setString(5, u.getBirthdate());
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result; 
		
	}

}
