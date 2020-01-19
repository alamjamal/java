package com.ors.bean;

import java.io.Serializable;

public class MailTO implements Serializable {

	private static final long serialVersionUID = 9065247335507967420L;
	private int mailid;
	private int recipient;
	private String from;
	private String subject;
	private String content;
	private String maildate;
	private String readflag;

	public int getRecipient() {
		return recipient;
	}

	public void setRecipient(int recipient) {
		this.recipient = recipient;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMaildate() {
		return maildate;
	}

	public void setMaildate(String maildate) {
		this.maildate = maildate;
	}

	public String getReadflag() {
		return readflag;
	}

	public void setReadflag(String readflag) {
		this.readflag = readflag;
	}

	public int getMailid() {
		return mailid;
	}

	public void setMailid(int mailid) {
		this.mailid = mailid;
	}

}
