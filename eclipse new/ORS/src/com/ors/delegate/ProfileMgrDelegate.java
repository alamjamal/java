package com.ors.delegate;

import java.util.ArrayList;

import com.ors.bean.ProfileTO;
import com.ors.exception.OORSDataAccessException;
import com.ors.exception.OORSInsertException;
import com.ors.service.ProfileServiceI;
import com.ors.services.impl.ProfileServiceImpl;
import com.ors.util.CoreHash;

public class ProfileMgrDelegate {
	
	ProfileServiceI profileservice = new ProfileServiceImpl();
	
	public boolean changeAccountStatus(String loginid, int status)
		throws OORSDataAccessException {
		
	return profileservice.changeAccountStatus(loginid, status);
	
	}
	
	public ArrayList<ProfileTO> getDeptList() throws OORSDataAccessException {
	
	return profileservice.getDeptList();
	}
	
	public String getDeptname(String username) throws OORSDataAccessException {
	
	return profileservice.getDeptname(username);
	}
	
	public ProfileTO getProfile(String loginname, String path)
		throws OORSDataAccessException {
	
	return profileservice.getProfile(loginname, path);
	}
	
	public CoreHash getReportFromTo(String sdate, String edate)
		throws OORSDataAccessException {
	
	return profileservice.getReportFromTo(sdate, edate);
	}
	
	public boolean modifyProfile(ProfileTO regbean) throws OORSDataAccessException {
	
	return profileservice.modifyProfile(regbean);
	}
	
	public boolean registerDept(ProfileTO pf) throws OORSInsertException {
	
	return profileservice.registerDept(pf);
	}
	
	public boolean registration(ProfileTO regbean) throws OORSInsertException {
	
	return  profileservice.registration(regbean);
	}

}
