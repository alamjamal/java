package com.ors.service;

import java.util.ArrayList;

import com.ors.bean.ProfileTO;
import com.ors.exception.OORSDataAccessException;
import com.ors.exception.OORSInsertException;

/**
 * @author JAVAPROJECTS
 * 
 */
public interface LoginDetailsServiceI {

	public String getLoginDate(String loginid) throws OORSInsertException;

	public ArrayList<ProfileTO> getLogInDetails(String loginid,
			String fromdate, String todate) throws OORSDataAccessException;
}
