package com.ors.dao;

import java.util.ArrayList;

import com.ors.bean.ProfileTO;

/**
 * @author JAVAPROJECTS
 * 
 */
public interface LoginDetailsDAOI {

	public String getLoginDate(String loginid);

	public ArrayList<ProfileTO> getLogInDetails(String loginid,
			String fromdate, String todate);
}
