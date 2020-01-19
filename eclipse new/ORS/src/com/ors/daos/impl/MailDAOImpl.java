/**
 * MailDAOImpl
 */

package com.ors.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ors.bean.MailTO;
import com.ors.dao.MailDAOI;
import com.ors.db.util.SingletoneDataAccessObject;
import com.ors.db.util.SQLStatementsConstants;
import com.ors.util.UtilConstants;

/**
 * @author JAVAPROJECTS
 * 
 */
public class MailDAOImpl implements MailDAOI {

	public Connection con;
	private boolean flag;
	static final Logger logger = Logger.getLogger(MailDAOImpl.class);

	public MailDAOImpl() {
		SingletoneDataAccessObject singletoneDataAccessObject = SingletoneDataAccessObject
				.getSingletoneDataAccessObject();
		con = singletoneDataAccessObject.getConnection();
	}

	public boolean storeMail(MailTO md) {

		int receiver = md.getRecipient();
		String from = md.getFrom();
		String subject = md.getSubject();
		String message = md.getContent();
		int i = 0;
		try {
			PreparedStatement pst = con
					.prepareStatement(SQLStatementsConstants._STORE_MAIL);
			pst.setString(1, from);
			pst.setInt(2, receiver);
			pst.setString(3, subject);
			pst.setString(4, message);
			i = pst.executeUpdate();
			if (i > 0)
				flag = true;
			else
				flag = false;

		} catch (NullPointerException ne) {
			logger.info(ne.getMessage());
		} catch (SQLException se) {
			logger.info(se.getMessage());
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				logger.info(e.getMessage());
			}
		}
		return flag;
	}

	public ArrayList<MailTO> getMailList(String username) {

		ArrayList<MailTO> maillist = new ArrayList<MailTO>();
		MailTO md = null;
		try {
			PreparedStatement pst = con
					.prepareStatement(SQLStatementsConstants._GET_MAIL_LIST);
			pst.setString(1, username);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				md = new MailTO();
				String from = rs.getString(1).trim();
				if (from.equalsIgnoreCase(UtilConstants._ADMIN))
					from = UtilConstants._ON_REQUEST_COORDINATOR;
				md.setFrom(from);
				md.setSubject(rs.getString(2));
				md.setMaildate(rs.getString(3));
				md.setReadflag(rs.getString(4));
				md.setMailid(rs.getInt(5));
				maillist.add(md);
			}
		} catch (NullPointerException ne) {
			logger.info(ne.getMessage());
		} catch (SQLException se) {
			logger.info(se.getMessage());
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				logger.info(e.getMessage());
			}
		}
		return maillist;
	}

	public MailTO getMail(int mailid) {

		MailTO md = null;
		try {
			PreparedStatement pst = con
					.prepareStatement(SQLStatementsConstants._GET_MAIL);
			pst.setInt(1, mailid);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				md = new MailTO();
				String from = rs.getString(1).trim();
				if (from.equalsIgnoreCase(UtilConstants._ADMIN))
					from = UtilConstants._ON_REQUEST_COORDINATOR;
				md.setFrom(from);
				md.setSubject(rs.getString(2));
				md.setMaildate(rs.getString(3));
				md.setContent(rs.getString(4));
			}
		} catch (NullPointerException ne) {
			logger.info(ne.getMessage());
		} catch (SQLException se) {
			logger.info(se.getMessage());
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				logger.info(e.getMessage());
			}
		}
		return md;
	}

	public boolean changeMailStatus(int mailid) {

		int i = 0;
		try {
			PreparedStatement pst = con
					.prepareStatement(SQLStatementsConstants._CHANGE_MAIL_STATUS);
			pst.setInt(1, mailid);
			i = pst.executeUpdate();
			if (i > 0)
				flag = true;
			else
				flag = false;
		} catch (NullPointerException ne) {
			logger.info(ne.getMessage());
		} catch (SQLException se) {
			logger.info(se.getMessage());
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				logger.info(e.getMessage());
			}
		}
		return flag;
	}

	public boolean deleteMail(ArrayList<MailTO> ar) {

		boolean flag = false;
		try {
			for (int i = 0; i < ar.size(); i++) {
				MailTO db = ar.get(i);
				int mailid = db.getMailid();
				PreparedStatement pst = con
						.prepareStatement(SQLStatementsConstants._DELETE_MAIL);
				pst.setInt(1, mailid);
				int j = 0;
				j = pst.executeUpdate();
				if (j > 0)
					flag = true;
				else {
					flag = false;
					return flag;
				}
			}
		} catch (NullPointerException ne) {
			logger.info(ne.getMessage());
		} catch (SQLException se) {
			logger.info(se.getMessage());
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				logger.info(e.getMessage());
			}
		}
		return flag;
	}
}
