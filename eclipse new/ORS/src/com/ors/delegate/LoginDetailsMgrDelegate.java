package com.ors.delegate;

import java.util.ArrayList;

import com.ors.bean.ProfileTO;
import com.ors.exception.OORSDataAccessException;
import com.ors.exception.OORSInsertException;
import com.ors.service.LoginDetailsServiceI;
import com.ors.services.impl.LoginServiceImpl;


public class LoginDetailsMgrDelegate {
	
	LoginDetailsServiceI loginservice = new LoginServiceImpl();
	
	public ArrayList<ProfileTO> getLogInDetails(String loginid,
			String fromdate, String todate) throws OORSDataAccessException {
		
		return loginservice.getLogInDetails(loginid, fromdate, todate);
	}

	public String getLoginDate(String loginid) throws OORSInsertException {
		
		return loginservice.getLoginDate(loginid);
	}


}
