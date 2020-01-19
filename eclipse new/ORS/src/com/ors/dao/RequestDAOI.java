package com.ors.dao;

import java.util.ArrayList;

import com.ors.bean.RequestTO;

/**
 * @author JAVAPROJECTS
 *
 */
public interface RequestDAOI {
	
	 public boolean setRequest(RequestTO rd);
	 
	 public  ArrayList<RequestTO> getRequestList(String username);
	 
	 public  ArrayList<RequestTO> getAllRequestList();
	 
	 public boolean deleteRequest(ArrayList<RequestTO> ar);
	 
	 public boolean replyRequest(int requestid,String status);
}
