package com.ors.services.impl;

import java.util.ArrayList;

import com.ors.bean.MailTO;
import com.ors.dao.MailDAOI;
import com.ors.daos.impl.MailDAOImpl;
import com.ors.exception.OORSDataAccessException;
import com.ors.exception.OORSInsertException;
import com.ors.service.MailServiceI;

/**
 * @author JAVAPROJECTS
 *
 */
public class MailServiceImpl implements MailServiceI{
	
	MailDAOI maildao = new MailDAOImpl();

	public boolean deleteMail(ArrayList<MailTO> ar) throws OORSDataAccessException {
		
		boolean flag = maildao.deleteMail(ar);
		
		if(flag == false)
			throw new OORSDataAccessException("Mail Deletion Failed");
		
		return flag;
	}

	public MailTO getMail(int mailid) throws OORSDataAccessException {
		
		MailTO mail = maildao.getMail(mailid);
		
		if(mail == null)
			throw new OORSDataAccessException("Failed to retrieve mail");
		
		return mail;
	}

	public ArrayList<MailTO> getMailList(String username) throws OORSDataAccessException {
		
		ArrayList<MailTO> maillist = maildao.getMailList(username);
		
		if(maillist == null || maillist.size() == 0)
			throw new OORSDataAccessException("Failed to retrieve mail list..");
		
		return maillist;
	}

	public boolean storeMail(MailTO md) throws OORSInsertException {
		
		boolean flag = maildao.storeMail(md);
		
		if(flag == false)
			throw new OORSInsertException("Failed to store the mail");
		
		return flag;
	}

	public boolean changeMailStatus(int mailid) throws OORSDataAccessException {
		
		boolean flag = maildao.changeMailStatus(mailid);
		
		if(flag == false)
			throw new OORSDataAccessException("Mail status updation failed");
		
		return flag;
		
	}

}
