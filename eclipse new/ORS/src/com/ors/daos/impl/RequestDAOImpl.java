/**
 * 
 * RequestDAOImpl
 * 
 */

package com.ors.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ors.bean.RequestTO;
import com.ors.dao.RequestDAOI;
import com.ors.db.util.SingletoneDataAccessObject;
import com.ors.db.util.SQLStatementsConstants;

/**
 * @author JAVAPROJECTS
 * 
 */
public class RequestDAOImpl implements RequestDAOI {

	public Connection con;
	private boolean flag;
	static final Logger logger = Logger.getLogger(RequestDAOImpl.class);

	public RequestDAOImpl() {
		SingletoneDataAccessObject singletoneDataAccessObject = SingletoneDataAccessObject
				.getSingletoneDataAccessObject();
		con = singletoneDataAccessObject.getConnection();
	}

	public boolean setRequest(RequestTO rd) {

		String coursedetails = rd.getCoursedetails();
		int courseduration = rd.getCourseduration();
		int noofpaticipent = rd.getPartcipentno();
		String paticipentbackground = rd.getPartcipentbackground();
		String startingdate = rd.getStartingdate();
		String facultyflag = rd.getFacultyflag();
		String fromuser = rd.getFrom();
		int i = 0;
		try {
			PreparedStatement pst = con
					.prepareStatement(SQLStatementsConstants._SET_REQUEST);
			pst.setString(1, fromuser);
			pst.setString(2, coursedetails);
			pst.setInt(3, courseduration);
			pst.setInt(4, noofpaticipent);
			pst.setString(5, paticipentbackground);
			pst.setString(6, startingdate);
			pst.setString(7, facultyflag);
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

	public ArrayList<RequestTO> getRequestList(String username) {

		ArrayList<RequestTO> Requestlist = new ArrayList<RequestTO>();
		RequestTO rd = null;
		try {
			PreparedStatement pst = con
					.prepareStatement(SQLStatementsConstants._GET_REQUEST_LIST);
			pst.setString(1, username);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				rd = new RequestTO();
				rd.setRequestid(rs.getInt(1));
				rd.setCoursedetails(rs.getString(3));
				rd.setCourseduration(rs.getInt(4));
				rd.setPartcipentno(rs.getInt(5));
				rd.setPartcipentbackground(rs.getString(6));
				rd.setStartingdate(rs.getString(7));
				rd.setStatus(rs.getString(8));
				rd.setFacultyflag(rs.getString(9));
				Requestlist.add(rd);
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
		return Requestlist;
	}

	public ArrayList<RequestTO> getAllRequestList() {

		ArrayList<RequestTO> Requestlist = new ArrayList<RequestTO>();
		RequestTO rd = null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st
					.executeQuery(SQLStatementsConstants._GET_ALL_REQUEST_LIST);
			while (rs.next()) {
				rd = new RequestTO();
				rd.setRequestid(rs.getInt(1));
				rd.setFrom(rs.getString(2));
				rd.setCoursedetails(rs.getString(3));
				rd.setCourseduration(rs.getInt(4));
				rd.setPartcipentno(rs.getInt(5));
				rd.setPartcipentbackground(rs.getString(6));
				rd.setStartingdate(rs.getString(7));
				rd.setStatus(rs.getString(8));
				rd.setFacultyflag(rs.getString(9));
				rd.setFromid(rs.getInt(10));
				Requestlist.add(rd);
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
		return Requestlist;
	}

	public boolean deleteRequest(ArrayList<RequestTO> ar) {

		boolean flag = false;
		try {
			for (int i = 0; i < ar.size(); i++) {
				RequestTO rd = ar.get(i);
				int requestid = rd.getRequestid();
				PreparedStatement pst = con
						.prepareStatement(SQLStatementsConstants._DELETE_REQUEST);
				pst.setInt(1, requestid);
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

	public boolean replyRequest(int requestid, String status) {

		boolean flag = false;
		try {
			PreparedStatement pst = con
					.prepareStatement(SQLStatementsConstants._REPLY_REQUEST);
			pst.setString(1, status);
			pst.setInt(2, requestid);
			int j = 0;
			j = pst.executeUpdate();
			if (j > 0)
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
}
