package com.ors.delegate;

import java.util.ArrayList;

import com.ors.bean.RequestTO;
import com.ors.exception.OORSDataAccessException;
import com.ors.exception.OORSInsertException;
import com.ors.service.RequestServiceI;
import com.ors.services.impl.RequestServiceImpl;

public class RequestMgrDelegate {
	
	RequestServiceI requestservice = new RequestServiceImpl();
	
	public boolean deleteRequest(ArrayList<RequestTO> ar) throws OORSDataAccessException {
		
		return requestservice.deleteRequest(ar);
	}

	public ArrayList<RequestTO> getAllRequestList() throws OORSDataAccessException {
		
		return requestservice.getAllRequestList();
	}

	public ArrayList<RequestTO> getRequestList(String username)
			throws OORSDataAccessException {
		return requestservice.getRequestList(username);
	}

	public boolean replyRequest(int requestid, String status)
			throws OORSDataAccessException {
		
		return requestservice.replyRequest(requestid, status);
	}

	public boolean setRequest(RequestTO rd) throws OORSInsertException {
		
		return requestservice.setRequest(rd);
	}

}
