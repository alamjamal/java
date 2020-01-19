package com.ors.services.impl;

import java.util.ArrayList;

import com.ors.bean.RequestTO;
import com.ors.dao.RequestDAOI;
import com.ors.daos.impl.RequestDAOImpl;
import com.ors.exception.OORSDataAccessException;
import com.ors.exception.OORSInsertException;
import com.ors.service.RequestServiceI;

public class RequestServiceImpl implements RequestServiceI{

	RequestDAOI requestdao = new RequestDAOImpl();
	
	public boolean deleteRequest(ArrayList<RequestTO> ar) throws OORSDataAccessException {
		
		boolean flag = requestdao.deleteRequest(ar);
		
		if(flag == false)
			throw new OORSDataAccessException("Deletion Of Request Failed");
		
		return flag;
	}

	public ArrayList<RequestTO> getAllRequestList() throws OORSDataAccessException {
		
		ArrayList<RequestTO> list = requestdao.getAllRequestList();
		
		if(list == null || list.size() == 0)
			throw new OORSDataAccessException("Record not found");
		
		return list;
	}

	public ArrayList<RequestTO> getRequestList(String username)
			throws OORSDataAccessException {
		ArrayList<RequestTO> list = requestdao.getRequestList(username);
		
		if(list == null || list.size() == 0)
			throw new OORSDataAccessException("Record not found");
		
		return list;
	}

	public boolean replyRequest(int requestid, String status)
			throws OORSDataAccessException {
		
		boolean flag = requestdao.replyRequest(requestid, status);
		
		if(flag == false)
			throw new OORSDataAccessException("Request Reply Failed");
		
		
		return flag;
	}

	public boolean setRequest(RequestTO rd) throws OORSInsertException {
		
		boolean flag = requestdao.setRequest(rd);
		
		if(flag == false)
			throw new OORSInsertException("Request Setting failed");
		
		return flag;
	}

}
