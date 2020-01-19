/*
 * ProfileDAOImpl.java
 *
 * 
 * 
 */

package com.ors.daos.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ors.bean.ProfileTO;
import com.ors.dao.ProfileDAOI;
import com.ors.db.util.SQLStatementsConstants;
import com.ors.db.util.SingletoneDataAccessObject;
import com.ors.util.CoreHash;
import com.ors.util.DateWrapper;
import com.ors.util.UtilConstants;

/**
 * @author JAVAPROJECTS
 * 
 */
public class ProfileDAOImpl implements ProfileDAOI {

	public Connection con;
	private boolean flag;
	static final Logger logger = Logger.getLogger(ProfileDAOImpl.class);

	public ProfileDAOImpl() {
		SingletoneDataAccessObject singletoneDataAccessObject = SingletoneDataAccessObject
				.getSingletoneDataAccessObject();
		con = singletoneDataAccessObject.getConnection();
	}

	public boolean registration(ProfileTO regbean) {

		String loginid = regbean.getUsername();
		String password = regbean.getPassword();
		String firstname = regbean.getFirstname();
		String lastname = regbean.getLastname();
		String logintype = regbean.getLogintype();
		String secretquest = regbean.getSecretqid();
		String secretans = regbean.getSecretqans();
		String bdate = DateWrapper.parseDate(regbean.getBdate());
		String hno = regbean.getHno();
		String home = regbean.getHome();
		String street = regbean.getStreet();
		String city = regbean.getCity();
		String state = regbean.getState();
		String country = regbean.getCountry();
		String pin = regbean.getPin();
		String phone = regbean.getPhone();
		String ohno = regbean.getOhno();
		String office = regbean.getOffice();
		String ostreet = regbean.getOstreet();
		String ocity = regbean.getOcity();
		String ostate = regbean.getOstate();
		String ocountry = regbean.getOcountry();
		String opin = regbean.getOpin();
		String ophone = regbean.getOphone();
		String phno = regbean.getChno();
		String contact = regbean.getContact();
		String pstreet = regbean.getCstreet();
		String pcity = regbean.getCcity();
		String pstate = regbean.getCstate();
		String pcountry = regbean.getCcountry();
		String ppin = regbean.getCpin();
		String pphone = regbean.getCphone();
		String fax = regbean.getFax();
		String email = regbean.getEmail();
		String photo = regbean.getPhoto();
		try {
			File f = new File(photo);
			FileInputStream fis = new FileInputStream(f);
			CallableStatement cstmt = con
					.prepareCall(SQLStatementsConstants._INSERTPROCEDURE);
			cstmt.setBinaryStream(1, fis, (int) f.length());
			cstmt.setString(2, firstname);
			cstmt.setString(3, lastname);
			cstmt.setString(4, bdate);
			cstmt.setString(5, loginid);
			cstmt.setString(6, password);
			cstmt.setString(7, secretquest);
			cstmt.setString(8, secretans);
			cstmt.setString(9, email);
			cstmt.setString(10, fax);
			cstmt.setString(11, home);
			cstmt.setString(12, hno);
			cstmt.setString(13, street);
			cstmt.setString(14, city);
			cstmt.setString(15, state);
			cstmt.setString(16, country);
			cstmt.setString(17, pin);
			cstmt.setString(18, office);
			cstmt.setString(19, ohno);
			cstmt.setString(20, ostreet);
			cstmt.setString(21, ocity);
			cstmt.setString(22, ostate);
			cstmt.setString(23, ocountry);
			cstmt.setString(24, opin);
			cstmt.setString(25, contact);
			cstmt.setString(26, phno);
			cstmt.setString(27, pstreet);
			cstmt.setString(28, pcity);
			cstmt.setString(29, pstate);
			cstmt.setString(30, pcountry);
			cstmt.setString(31, ppin);
			cstmt.setString(32, phone);
			cstmt.setString(33, ophone);
			cstmt.setString(34, pphone);
			cstmt.registerOutParameter(35, Types.VARCHAR);
			cstmt.setString(36, logintype);
			cstmt.execute();
			cstmt.getString(35);
			if ((cstmt.getString(35)).equalsIgnoreCase(UtilConstants._TRUE)) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (NullPointerException ne) {
			logger.info(ne.getMessage());
		} catch (SQLException se) {
			logger.info(se.getMessage());
		} catch (FileNotFoundException e) {
			logger.info(e.getMessage());
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

	public ProfileTO getProfile(String loginname, String path) {

		ProfileTO rb = null;
		try {
			CallableStatement cs = con
					.prepareCall(SQLStatementsConstants._SHOWPROFILE_PROCEDURE);
			cs.setString(1, loginname);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.registerOutParameter(6, Types.VARCHAR);
			cs.registerOutParameter(7, Types.VARCHAR);
			cs.registerOutParameter(8, Types.VARCHAR);
			cs.registerOutParameter(9, Types.VARCHAR);
			cs.registerOutParameter(10, Types.VARCHAR);
			cs.registerOutParameter(11, Types.VARCHAR);
			cs.registerOutParameter(12, Types.VARCHAR);
			cs.registerOutParameter(13, Types.VARCHAR);
			cs.registerOutParameter(14, Types.VARCHAR);
			cs.registerOutParameter(15, Types.VARCHAR);
			cs.registerOutParameter(16, Types.VARCHAR);
			cs.registerOutParameter(17, Types.VARCHAR);
			cs.registerOutParameter(18, Types.VARCHAR);
			cs.registerOutParameter(19, Types.VARCHAR);
			cs.registerOutParameter(20, Types.VARCHAR);
			cs.registerOutParameter(21, Types.VARCHAR);
			cs.registerOutParameter(22, Types.VARCHAR);
			cs.registerOutParameter(23, Types.VARCHAR);
			cs.registerOutParameter(24, Types.VARCHAR);
			cs.registerOutParameter(25, Types.VARCHAR);
			cs.registerOutParameter(26, Types.VARCHAR);
			cs.registerOutParameter(27, Types.VARCHAR);
			cs.registerOutParameter(28, Types.VARCHAR);
			cs.registerOutParameter(29, Types.VARCHAR);
			cs.registerOutParameter(30, Types.VARCHAR);
			cs.registerOutParameter(31, Types.VARCHAR);
			cs.registerOutParameter(32, Types.BLOB);
			cs.registerOutParameter(33, Types.VARCHAR);
			cs.execute();
			rb = new ProfileTO();
			rb.setPassword(cs.getString(2));
			rb.setFirstname(cs.getString(3));
			rb.setLastname(cs.getString(4));
			rb.setBdate(cs.getString(5));
			rb.setEmail(cs.getString(6));
			rb.setFax(cs.getString(7));
			rb.setHome(cs.getString(8));
			rb.setHno(cs.getString(9));
			rb.setStreet(cs.getString(10));
			rb.setCity(cs.getString(11));
			rb.setState(cs.getString(12));
			rb.setCountry(cs.getString(13));
			rb.setPin(cs.getString(14));
			rb.setOffice(cs.getString(15));
			rb.setOhno(cs.getString(16));
			rb.setOstreet(cs.getString(17));
			rb.setOcity(cs.getString(18));
			rb.setOstate(cs.getString(19));
			rb.setOcountry(cs.getString(20));
			rb.setOpin(cs.getString(21));
			rb.setContact(cs.getString(22));
			rb.setChno(cs.getString(23));
			rb.setCstreet(cs.getString(24));
			rb.setCcity(cs.getString(25));
			rb.setCstate(cs.getString(26));
			rb.setCcountry(cs.getString(27));
			rb.setCpin(cs.getString(28));
			rb.setPhone(cs.getString(29));
			String o = cs.getString(30);
			rb.setOphone(o);
			String s = cs.getString(31);
			rb.setCphone(s);
			Blob b = cs.getBlob(32);
			if (b != null) {
				byte b1[] = b.getBytes(1, (int) b.length());
				OutputStream fout = new FileOutputStream(path + "/" + loginname
						+ ".jpg");
				fout.write(b1);
			}
			rb.setLogintype(cs.getString(33));
		} catch (NullPointerException ne) {
			logger.info(ne.getMessage());
		} catch (SQLException se) {
			logger.info(se.getMessage());
		} catch (FileNotFoundException e) {
			logger.info(e.getMessage());
		} catch (IOException e) {
			logger.info(e.getMessage());
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				logger.info(e.getMessage());
			}
		}
		return rb;
	}

	public boolean modifyProfile(ProfileTO regbean) {

		String loginid = regbean.getUsername();
		String firstname = regbean.getFirstname();
		String lastname = regbean.getLastname();
		String hno = regbean.getHno();
		String home = regbean.getHome();
		String street = regbean.getStreet();
		String city = regbean.getCity();
		String state = regbean.getState();
		String country = regbean.getCountry();
		String pin = regbean.getPin();
		String Phonetype = regbean.getHomePhoneType();
		String phone = regbean.getPhone();
		String ohno = regbean.getOhno();
		String office = regbean.getOffice();
		String ostreet = regbean.getOstreet();
		String ocity = regbean.getOcity();
		String ostate = regbean.getOstate();
		String ocountry = regbean.getOcountry();
		String opin = regbean.getOpin();
		String oPhonetype = regbean.getOfficePhoneType();
		String ophone = regbean.getOphone();
		String phno = regbean.getChno();
		String contact = regbean.getContact();
		String pstreet = regbean.getCstreet();
		String pcity = regbean.getCcity();
		String pstate = regbean.getCstate();
		String pcountry = regbean.getCcountry();
		String ppin = regbean.getCpin();
		String pPhonetype = regbean.getPersonalPhoneType();
		String pphone = regbean.getCphone();
		String fax = regbean.getFax();
		String email = regbean.getEmail();
		try {
			CallableStatement cs = con
					.prepareCall(SQLStatementsConstants._CHANGEPROFILE_PROCEDURE);
			cs.setString(1, firstname);
			cs.setString(2, lastname);
			cs.setString(3, loginid);
			cs.setString(4, email);
			cs.setString(5, fax);
			cs.setString(6, home);
			cs.setString(7, hno);
			cs.setString(8, street);
			cs.setString(9, city);
			cs.setString(10, state);
			cs.setString(11, country);
			cs.setString(12, pin);
			cs.setString(13, office);
			cs.setString(14, ohno);
			cs.setString(15, ostreet);
			cs.setString(16, ocity);
			cs.setString(17, ostate);
			cs.setString(18, ocountry);
			cs.setString(19, opin);
			cs.setString(20, contact);
			cs.setString(21, phno);
			cs.setString(22, pstreet);
			cs.setString(23, pcity);
			cs.setString(24, pstate);
			cs.setString(25, pcountry);
			cs.setString(26, ppin);
			cs.setString(27, Phonetype);
			cs.setString(28, phone);
			cs.setString(29, oPhonetype);
			cs.setString(30, ophone);
			cs.setString(31, pPhonetype);
			cs.setString(32, pphone);
			cs.registerOutParameter(33, Types.INTEGER);
			cs.execute();
			int n = cs.getInt(33);
			if (n > 0) {
				flag = true;
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

	@SuppressWarnings("unchecked")
	public CoreHash getReportFromTo(String sdate, String edate) {

		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		int sno = 1;
		ProfileTO aProfile = null;
		try {
			PreparedStatement pst = con
					.prepareStatement(SQLStatementsConstants._GET_USERS_FROM_TO);
			pst.setString(1, sdate);
			pst.setString(2, edate);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				aProfile = new ProfileTO();
				aProfile.setUsername(rs.getString(1));
				aProfile.setFirstname(rs.getString(2));
				aProfile.setLastname(rs.getString(3));
				String date = DateWrapper.parseDate(rs.getDate(4)).trim();
				aProfile.setBdate(date);
				aProfile
						.setRegdate(DateWrapper.parseDate(rs.getDate(5)).trim());
				aProfile.setEmail(rs.getString(6));
				aProfile.setLogintype(rs.getString(7));
				aCoreHash.put(new Integer(sno), aProfile);
				sno++;
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
		return aCoreHash;
	}

	public boolean changeAccountStatus(String loginid, int status) {

		try {
			con.setAutoCommit(false);
			PreparedStatement cstmt = con
					.prepareStatement(SQLStatementsConstants._CHANGE_ACCOUNT_STATUS);
			cstmt.setInt(1, status);
			cstmt.setString(2, loginid);
			int i = cstmt.executeUpdate();
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

	public ArrayList<ProfileTO> getDeptList() {

		ArrayList<ProfileTO> ar = new ArrayList<ProfileTO>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st
					.executeQuery(SQLStatementsConstants._GET_DEPARTMENT_FACULTY_LIST);
			while (rs.next()) {
				ProfileTO bean = new ProfileTO();
				bean.setDeptname(rs.getString(1));
				bean.setUserid(rs.getInt(2));
				bean.setLogintype(rs.getString(3));
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
			} catch (SQLException e) {
				logger.info(e.getMessage());
			}
		}
		return ar;
	}

	public boolean registerDept(ProfileTO pf) {

		boolean flag = false;
		int i = 0;
		String loginid = pf.getUsername();
		String password = pf.getPassword();
		String squestion = pf.getSecretqans();
		String sanswer = pf.getSecretqans();
		String deptname = pf.getDeptname();
		String faxno = pf.getFax();
		try {
			PreparedStatement pst = con
					.prepareStatement(SQLStatementsConstants._REGISTER_DEPARTMENT);
			pst.setString(1, deptname);
			pst.setString(2, loginid);
			pst.setString(3, password);
			pst.setString(4, squestion);
			pst.setString(5, sanswer);
			pst.setString(6, faxno);
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

	public String getDeptname(String username) {

		String deptname = "";
		try {
			PreparedStatement pst = con
					.prepareStatement(SQLStatementsConstants._GET_DEPARTMENT_LIST);
			pst.setString(1, username);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				deptname = rs.getString(1);
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
		return deptname;
	}
}
