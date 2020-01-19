package com.ors.delegate;

import com.ors.bean.ProfileTO;
import com.ors.exception.OORSDataAccessException;
import com.ors.exception.OORSLoginException;
import com.ors.service.SecurityServiceI;
import com.ors.services.impl.SecurityServiceImpl;

public class SecurityMgrDelegate {
	
	SecurityServiceI securityservice = new SecurityServiceImpl();
	
	public boolean changePassword(ProfileTO regbean) throws OORSDataAccessException {
		
		return securityservice.changePassword(regbean);
	}

	public String checkUser(String userName) throws OORSDataAccessException {
		
		return securityservice.checkUser(userName);
	}

	public String logInTypeCheck(String loginid) throws OORSDataAccessException {
		
		return securityservice.logInTypeCheck(loginid);
	}

	public String loginCheck(ProfileTO regbean) throws OORSLoginException {
		
		return securityservice.loginCheck(regbean);
	}

	public boolean loginaudit(String loginid) throws OORSLoginException {
		
		return securityservice.loginaudit(loginid);
	}

	public String recoverPasswordByQuestion(ProfileTO regbean)
			throws OORSDataAccessException {
		
		return securityservice.recoverPasswordByQuestion(regbean);
	}

}
