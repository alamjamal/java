package com.ors.service;

import java.util.ArrayList;

import com.ors.bean.RequestTO;
import com.ors.exception.OORSDataAccessException;
import com.ors.exception.OORSInsertException;

/**
 * @author JAVAPROJECTS
 * 
 */
public interface RequestServiceI {
	
	public boolean setRequest(RequestTO rd) throws OORSInsertException;

	public ArrayList<RequestTO> getRequestList(String username)
			throws OORSDataAccessException;

	public ArrayList<RequestTO> getAllRequestList()
			throws OORSDataAccessException;

	public boolean deleteRequest(ArrayList<RequestTO> ar)
			throws OORSDataAccessException;

	public boolean replyRequest(int requestid, String status)
			throws OORSDataAccessException;
}
