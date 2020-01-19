package com.ors.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ors.bean.ProfileTO;
import com.ors.dao.LoginDetailsDAOI;
import com.ors.db.util.SingletoneDataAccessObject;
import com.ors.db.util.SQLStatementsConstants;

/**
 * @author JAVAPROJECTS
 * 
 */
public class LogInDetailsDAOImpl implements LoginDetailsDAOI {

	public Connection con;
	static final Logger logger = Logger.getLogger(LogInDetailsDAOImpl.class);

	public LogInDetailsDAOImpl() {
		SingletoneDataAccessObject singletoneDataAccessObject = SingletoneDataAccessObject
				.getSingletoneDataAccessObject();
		con = singletoneDataAccessObject.getConnection();
	}

	public String getLoginDate(String loginid) {

		String lastlog = "";
		try {
			PreparedStatement pst = con
					.prepareStatement(SQLStatementsConstants._GET_LOGINDATE);
			pst.setString(1, loginid);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				lastlog = rs.getString(1);
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
		return lastlog;
	}

	public ArrayList<ProfileTO> getLogInDetails(String loginid,
			String fromdate, String todate) {

		ArrayList<ProfileTO> ar = new ArrayList<ProfileTO>();
		try {
			PreparedStatement pst = con
					.prepareStatement(SQLStatementsConstants._GET_LOGINDETAILS);
			pst.setString(1, loginid);
			pst.setString(2, fromdate);
			pst.setString(3, todate);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				ProfileTO bean = new ProfileTO();
				bean.setUsername(rs.getString(1));
				bean.setLogindate(rs.getString(2));
				bean.setLogintime(rs.getString(3));
				bean.setLogofftime(rs.getString(4));
				ar.add(bean);
			}
		} catch (NullPointerException ne) {
			logger.info(ne.getMessage());
		} catch (SQLException se) {
			logger.info(se.getMessage());
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception e) {
				logger.info(e.getMessage());
			}
		}
		return ar;
	}
}
