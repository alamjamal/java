package com.ors.services.impl;

import java.util.ArrayList;

import com.ors.bean.ProfileTO;
import com.ors.dao.ProfileDAOI;
import com.ors.daos.impl.ProfileDAOImpl;
import com.ors.exception.OORSDataAccessException;
import com.ors.exception.OORSInsertException;
import com.ors.service.ProfileServiceI;
import com.ors.util.CoreHash;

public class ProfileServiceImpl implements ProfileServiceI{
	
	ProfileDAOI profiledao = new ProfileDAOImpl();
	
	public boolean changeAccountStatus(String loginid, int status)
			throws OORSDataAccessException {
		
		boolean flag = profiledao.changeAccountStatus(loginid, status);
		
		if(flag == false)
			throw new OORSDataAccessException("Change of acount status Failed");
		
		return flag;
	}

	public ArrayList<ProfileTO> getDeptList() throws OORSDataAccessException {
		
		ArrayList<ProfileTO> list = profiledao.getDeptList();
		
		if(list == null || list.size() == 0)
			throw new OORSDataAccessException("Record Not Found");
		
		return list;
	}

	public String getDeptname(String username) throws OORSDataAccessException {
		
		String deptname = profiledao.getDeptname(username);
		
		if(deptname == null || deptname.equals(""))
			throw new OORSDataAccessException("Department Not Found");
		
		return deptname;
	}

	public ProfileTO getProfile(String loginname, String path)
			throws OORSDataAccessException {
		
		ProfileTO  profile = profiledao.getProfile(loginname, path);
		
		if(profile == null)
			throw new OORSDataAccessException("Failed To Retrieve Profile");
		
		return profile;
	}

	public CoreHash getReportFromTo(String sdate, String edate)
			throws OORSDataAccessException {
		
		CoreHash list = profiledao.getReportFromTo(sdate, edate);
		
		if(list == null || list.size() == 0)
			throw new OORSDataAccessException("Record Not Found");
		
		return list;
	}

	public boolean modifyProfile(ProfileTO regbean) throws OORSDataAccessException {
		
		boolean flag = profiledao.modifyProfile(regbean);
		
		if(flag == false)
			throw new OORSDataAccessException("Profile Not Found");
		return flag;
	}

	public boolean registerDept(ProfileTO pf) throws OORSInsertException {
		
		boolean flag = profiledao.registerDept(pf);
		
		if(flag == false)
			throw new OORSInsertException("Registration of Department Failed");
		
		return flag;
	}

	public boolean registration(ProfileTO regbean) throws OORSInsertException {
		
		boolean flag = profiledao.registration(regbean);
		if(flag == false)
			throw new OORSInsertException("Registration of faculty Failed");
		return flag;
	}

}
