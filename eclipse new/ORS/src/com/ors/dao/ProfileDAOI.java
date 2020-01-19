package com.ors.dao;

import java.util.ArrayList;

import com.ors.bean.ProfileTO;
import com.ors.util.CoreHash;

/**
 * @author JAVAPROJECTS
 *
 */
public interface ProfileDAOI {
	
	 public boolean registration(ProfileTO regbean);
	 
	 public ProfileTO getProfile(String loginname,String path);
	 
	 public boolean modifyProfile(ProfileTO regbean);
	 
	 public CoreHash getReportFromTo(String sdate,String edate);
	 
	 public boolean changeAccountStatus(String loginid,int status);
	 
	 public ArrayList<ProfileTO> getDeptList();
	 
	 public boolean registerDept(ProfileTO pf);
	 
	 public String getDeptname(String username);
}
