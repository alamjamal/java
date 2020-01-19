package com.ors.dao;

import java.util.ArrayList;

import com.ors.bean.MailTO;

/**
 * @author JAVAPROJECTS
 *
 */
public interface MailDAOI {
	
	public boolean storeMail(MailTO md);
	 
	public  ArrayList<MailTO> getMailList(String username);
	 
	public  MailTO getMail(int mailid);
	
	public boolean changeMailStatus(int mailid);
	 
	public boolean deleteMail(ArrayList<MailTO> ar);
}
