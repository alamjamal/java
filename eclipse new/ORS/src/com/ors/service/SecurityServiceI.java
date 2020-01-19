package com.ors.service;

import com.ors.bean.ProfileTO;
import com.ors.exception.OORSDataAccessException;
import com.ors.exception.OORSLoginException;

/**
 * @author JAVAPROJECTS
 * 
 */
public interface SecurityServiceI {
	
	public String loginCheck(ProfileTO regbean) throws OORSLoginException;

	public boolean loginaudit(String loginid) throws OORSLoginException;

	public boolean changePassword(ProfileTO regbean)
			throws OORSDataAccessException;

	public String recoverPasswordByQuestion(ProfileTO regbean)
			throws OORSDataAccessException;

	public String checkUser(String userName) throws OORSDataAccessException;

	public String logInTypeCheck(String loginid) throws OORSDataAccessException;
}
