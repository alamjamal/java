package com.ors.services.impl;

import com.ors.bean.ProfileTO;
import com.ors.dao.SecurityDAOI;
import com.ors.daos.impl.SecurityDAOImpl;
import com.ors.exception.OORSDataAccessException;
import com.ors.exception.OORSLoginException;
import com.ors.service.SecurityServiceI;

public class SecurityServiceImpl implements SecurityServiceI{

	SecurityDAOI securitydao = new SecurityDAOImpl();
	
	public boolean changePassword(ProfileTO regbean) throws OORSDataAccessException {
		
		boolean flag = securitydao.changePassword(regbean);
		
		if(flag == false)	
			throw new OORSDataAccessException("Change Password Failed");
		
		return flag;
	}


	public String checkUser(String userName) throws OORSDataAccessException {
		
		String user = securitydao.checkUser(userName);
		
		if(user == null || user.equals(""))
			throw new OORSDataAccessException("Checking User Existance Failed");
		
		return user;
	}

	public String logInTypeCheck(String loginid) throws OORSDataAccessException {
		
		String logintype = securitydao.logInTypeCheck(loginid);
		
		if(logintype == null || logintype.equals(""))
			throw new OORSDataAccessException("Checking of Logintype Failed");
		
		return logintype;
	}

	public String loginCheck(ProfileTO regbean) throws OORSLoginException {
		
		String role = securitydao.loginCheck(regbean);
		
		if(role == null || role.equals(""))
			throw new OORSLoginException("Invalid Login");
		
		return role;
	}

	public boolean loginaudit(String loginid) throws OORSLoginException {
		
		boolean flag = securitydao.loginaudit(loginid);
		
		if(flag == false)
			throw new OORSLoginException("Logout Failed");
		
		return flag;
	}

	public String recoverPasswordByQuestion(ProfileTO regbean)
			throws OORSDataAccessException {
		String password = securitydao.recoverPasswordByQuestion(regbean);
		
		if(password == null || password.equals(""))
			throw new OORSDataAccessException("Password Recovery Failed");
		
		return password;
	}

}
