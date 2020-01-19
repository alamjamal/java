package com.ors.dao;

import com.ors.bean.ProfileTO;

/**
 * @author JAVAPROJECTS
 *
 */
public interface SecurityDAOI {
	
	public String loginCheck(ProfileTO regbean);
	
	public boolean loginaudit(String loginid);
	
	public boolean changePassword(ProfileTO regbean);
	
	public boolean changeQuestion(ProfileTO regbean);
	
	public String recoverPasswordByQuestion(ProfileTO regbean);
	
	public String  checkUser(String userName);
	
	public String logInTypeCheck(String loginid);
}
