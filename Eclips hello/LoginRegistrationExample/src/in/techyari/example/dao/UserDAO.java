package in.techyari.example.dao;

import in.techyari.example.model.User;

public interface UserDAO {
	
	public User getUserByEmail(String email,String password);
	public int createOrUpdateUser(User u);
	
}
