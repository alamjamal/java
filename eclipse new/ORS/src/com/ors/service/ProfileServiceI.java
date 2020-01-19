package com.ors.service;

import java.util.ArrayList;

import com.ors.bean.ProfileTO;
import com.ors.exception.OORSDataAccessException;
import com.ors.exception.OORSInsertException;
import com.ors.util.CoreHash;

/**
 * @author JAVAPROJECTS
 *
 */
public interface ProfileServiceI {
	
	public boolean registration(ProfileTO regbean) throws OORSInsertException;

	public ProfileTO getProfile(String loginname, String path)
			throws OORSDataAccessException;

	public boolean modifyProfile(ProfileTO regbean)
			throws OORSDataAccessException;

	public CoreHash getReportFromTo(String sdate, String edate)
			throws OORSDataAccessException;

	public boolean changeAccountStatus(String loginid, int status)
			throws OORSDataAccessException;

	public ArrayList<ProfileTO> getDeptList() throws OORSDataAccessException;

	public boolean registerDept(ProfileTO pf) throws OORSInsertException;

	public String getDeptname(String username) throws OORSDataAccessException;
}
