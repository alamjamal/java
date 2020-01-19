package com.ors.services.impl;

import java.util.ArrayList;

import com.ors.bean.ProfileTO;
import com.ors.dao.LoginDetailsDAOI;
import com.ors.daos.impl.LogInDetailsDAOImpl;
import com.ors.exception.OORSDataAccessException;
import com.ors.exception.OORSInsertException;
import com.ors.service.LoginDetailsServiceI;

public class LoginServiceImpl implements LoginDetailsServiceI{

	LoginDetailsDAOI logindao = new LogInDetailsDAOImpl();
	

	public ArrayList<ProfileTO> getLogInDetails(String loginid,
			String fromdate, String todate) throws OORSDataAccessException {
		ArrayList<ProfileTO> list = logindao.getLogInDetails(loginid, fromdate, todate);
		
		if(list == null || list.size() == 0)
			throw new OORSDataAccessException("Failed to get login details");
		
		return list;
	}

	public String getLoginDate(String loginid) throws OORSInsertException {
		
		String logindate = logindao.getLoginDate(loginid);
		
		if(logindate == null || logindate.equals(""))
			throw new OORSInsertException("Failed to get logiondate");
		
		return null;
	}

}
