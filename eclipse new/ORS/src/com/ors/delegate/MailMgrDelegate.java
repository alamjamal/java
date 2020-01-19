package com.ors.delegate;

import java.util.ArrayList;

import com.ors.bean.MailTO;
import com.ors.exception.OORSDataAccessException;
import com.ors.exception.OORSInsertException;
import com.ors.service.MailServiceI;
import com.ors.services.impl.MailServiceImpl;

public class MailMgrDelegate {
	
	MailServiceI mailservice = new MailServiceImpl();
	
	public boolean deleteMail(ArrayList<MailTO> ar) throws OORSDataAccessException {
		
		return mailservice.deleteMail(ar);
		
	}

	public MailTO getMail(int mailid) throws OORSDataAccessException {
		
		return mailservice.getMail(mailid);
		
	}

	public ArrayList<MailTO> getMailList(String username) throws OORSDataAccessException {
		
		return mailservice.getMailList(username);
	}

	public boolean storeMail(MailTO md) throws OORSInsertException {
		
		return mailservice.storeMail(md);
	}

	public boolean changeMailStatus(int mailid) throws OORSDataAccessException {
		
		return mailservice.changeMailStatus(mailid);
		
	}
	
}
