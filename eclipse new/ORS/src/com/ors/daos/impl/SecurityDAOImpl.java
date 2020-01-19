/*
 * SecurityDAOImpl.java
 *
 * 
 */

package com.ors.daos.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.apache.log4j.Logger;

import com.ors.bean.ProfileTO;
import com.ors.dao.SecurityDAOI;
import com.ors.db.util.SingletoneDataAccessObject;
import com.ors.db.util.SQLStatementsConstants;
import com.ors.util.UtilConstants;

/**
 * @author JAVAPROJECTS
 * 
 */
public class SecurityDAOImpl implements SecurityDAOI {

	Connection con;
	private boolean flag = false;
	static final Logger logger = Logger.getLogger(SecurityDAOImpl.class);

	public SecurityDAOImpl() {
		SingletoneDataAccessObject singletoneDataAccessObject = SingletoneDataAccessObject
				.getSingletoneDataAccessObject();
		con = singletoneDataAccessObject.getConnection();
	}

	public String loginCheck(ProfileTO regbean) {

		String loginid = regbean.getUsername();
		String password = regbean.getPassword();
		String role = "";
		try {
			CallableStatement cstmt = con
					.prepareCall(SQLStatementsConstants._LOGINCHECKPROCEDURE);
			cstmt.setString(1, loginid);
			cstmt.setString(2, password);
			cstmt.registerOutParameter(3, Types.VARCHAR);
			flag = cstmt.execute();
			role = cstmt.getString(3);
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
		return role;
	}

	public boolean loginaudit(String loginid) {

		boolean flag = false;
		try {
			CallableStatement cstmt = con
					.prepareCall(SQLStatementsConstants._SIGNOUTPROCEDURE);
			cstmt.setString(1, loginid);
			cstmt.execute();
			flag = true;
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

	public boolean changePassword(ProfileTO regbean) {

		String loginid = regbean.getUsername();
		String oldpassword = regbean.getPassword();
		String newpassword = regbean.getNewpassword();
		try {
			con.setAutoCommit(false);
			PreparedStatement pstmt = con
					.prepareCall(SQLStatementsConstants._CHANGEPASSWORD_UPDATESTATEMENT);
			pstmt.setString(2, loginid);
			pstmt.setString(3, oldpassword);
			pstmt.setString(1, newpassword);
			
			int i = pstmt.executeUpdate();
			if (i == 1) {
				flag = true;
				con.commit();
			} else {
				flag = false;
				con.rollback();
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

	public boolean changeQuestion(ProfileTO regbean) {

		String loginid = regbean.getUsername();
		String password = regbean.getPassword();
		String secretquestid = regbean.getSecretqid();
		String secretans = regbean.getSecretqans();
		CallableStatement cstmt;
		int i = 0;
		try {
			cstmt = con
					.prepareCall(SQLStatementsConstants._CHANGEQUESTION_PROCEDURE);
			cstmt.setString(1, loginid);
			cstmt.setString(2, password);
			cstmt.setString(3, secretquestid);
			cstmt.setString(4, secretans);
			cstmt.registerOutParameter(5, Types.INTEGER);
			cstmt.execute();
			i = cstmt.getInt(5);
			if (i == 1) {
				flag = true;
				con.commit();
			} else {
				flag = false;
				con.rollback();
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

	public String recoverPasswordByQuestion(ProfileTO regbean) {

		String password = "";
		String loginid = regbean.getUsername();
		String secretquestid = regbean.getSecretqid();
		String secretans = regbean.getSecretqans();
		try {
			con.setAutoCommit(true);
			CallableStatement cstmt = con
					.prepareCall(SQLStatementsConstants._RECOVERPASSWORD_PROCEDURE);
			cstmt.setString(1, loginid);
			cstmt.setString(2, secretquestid);
			cstmt.setString(3, secretans);
			cstmt.registerOutParameter(4, Types.VARCHAR);
			cstmt.execute();
			password = cstmt.getString(4);
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
		return password;
	}

	public String checkUser(String userName) {

		String user = null;
		try {
			con.setAutoCommit(true);
			CallableStatement cstmt = con
					.prepareCall(SQLStatementsConstants._LOGINIDAVAILABLITY_PROCEDURE);
			cstmt.setString(1, userName);
			cstmt.registerOutParameter(2, Types.VARCHAR);
			cstmt.execute();
			user = cstmt.getString(2);
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
		return user;
	}

	public String logInTypeCheck(String loginid) {

		String usertype = "";
		try {
			PreparedStatement pst = con
					.prepareStatement(SQLStatementsConstants._LOGINTYPE_CHECK);
			pst.setString(1, loginid);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				usertype = rs.getString(1);
			} else {
				usertype = UtilConstants._USER_NOT_FOUND;
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
		return usertype;
	}
}
