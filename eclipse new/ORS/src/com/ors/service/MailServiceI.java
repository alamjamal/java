package com.ors.service;

import java.util.ArrayList;

import com.ors.bean.MailTO;
import com.ors.exception.OORSDataAccessException;
import com.ors.exception.OORSInsertException;

public interface MailServiceI {

	public boolean storeMail(MailTO md) throws OORSInsertException;

	public ArrayList<MailTO> getMailList(String username)
			throws OORSDataAccessException;

	public MailTO getMail(int mailid) throws OORSDataAccessException;

	public boolean changeMailStatus(int mailid) throws OORSDataAccessException;

	public boolean deleteMail(ArrayList<MailTO> ar)
			throws OORSDataAccessException;
}
