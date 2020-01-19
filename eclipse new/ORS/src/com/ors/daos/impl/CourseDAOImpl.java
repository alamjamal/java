package com.ors.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ors.bean.CourseTO;
import com.ors.dao.CourseDAOI;
import com.ors.db.util.SingletoneDataAccessObject;
import com.ors.db.util.SQLStatementsConstants;

/**
 * @author JAVAPROJECTS
 * 
 */
public class CourseDAOImpl implements
		CourseDAOI {

	public Connection con;
	private boolean flag;
	static final Logger logger = Logger.getLogger(CourseDAOImpl.class);

	public CourseDAOImpl() {
		SingletoneDataAccessObject singletoneDataAccessObject = SingletoneDataAccessObject
				.getSingletoneDataAccessObject();
		con = singletoneDataAccessObject.getConnection();
	}
	public boolean registerCourse(CourseTO cd) {

		String coursename = cd.getCoursename();
		String coursedetails = cd.getCoursedetails();
		int i = 0;
		try {
			PreparedStatement pst = con
					.prepareStatement(SQLStatementsConstants._COURSE_REGISTRATION);
			pst.setString(1, coursename);
			pst.setString(2, coursedetails);
			i = pst.executeUpdate();
			if (i > 0)
				flag = true;
			else
				flag = false;
		} catch (NullPointerException ne) {
			logger.info(ne.getMessage());
		} catch (SQLException se) {
			logger.info(se.getMessage());
		}finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				logger.info(e.getMessage());
			}
		}
		return flag;
	}

	public boolean assignShedule(CourseTO cd) {

		int sheduleid = cd.getSheduleid();
		int facultyid = cd.getFacultyid();
		int i = 0;
		try {
			PreparedStatement pst = con
					.prepareStatement(SQLStatementsConstants._ASSIGN_SHEDULE);
			pst.setInt(1, facultyid);
			pst.setInt(2, sheduleid);
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

	
	public boolean AddEmpReq(String req,int rid) {

		
		int i = 0;
		try {
			PreparedStatement pst = con.prepareStatement("update EMPREQUEST set status=? where rid=?");
			pst.setString(1, req);
			pst.setInt(2, rid);
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
	
	public boolean EmpRequest(CourseTO cd) {

		String coursename = cd.getCoursename();
		String employeename = cd.getEmpName();
		int i = 0;
		try {
			PreparedStatement pst = con
					.prepareStatement(SQLStatementsConstants._COURSE_REQUEST);
			pst.setString(1, employeename);
			pst.setString(2, coursename);
			pst.setString(3, employeename);
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

	public ArrayList<CourseTO> getCourseList() {
		
		ArrayList<CourseTO> courselist = new ArrayList<CourseTO>();
		CourseTO cd = null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st
					.executeQuery(SQLStatementsConstants._GET_COURSE_LIST);
			while (rs.next()) {
				cd = new CourseTO();
				cd.setCourseid(rs.getInt(1));
				cd.setCoursename(rs.getString(2));
				cd.setCoursedetails(rs.getString(3));
				courselist.add(cd);
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
		return courselist;
	}
public ArrayList<CourseTO> getEmpRequestList() {
		
		ArrayList<CourseTO> courselist = new ArrayList<CourseTO>();
		CourseTO cd = null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st
					.executeQuery(SQLStatementsConstants._GET_EMPREQUEST_LIST);
			while (rs.next()) {
				cd = new CourseTO();
				cd.setCourseid(rs.getInt(1));
				cd.setEmpName(rs.getString(2));
				cd.setCoursename(rs.getString(3));
				cd.setCoursedetails(rs.getString(4));
				cd.setSheduleid(rs.getInt(5));
				courselist.add(cd);
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
		return courselist;
	}

public ArrayList<CourseTO> getEmpRequestList1(String emp) {
	
	ArrayList<CourseTO> courselist = new ArrayList<CourseTO>();
	CourseTO cd = null;
	System.out.println();
	try {
		Statement st = con.createStatement();
		ResultSet rs = st
				.executeQuery("SELECT e.EMPID,e.EMPNAME,e.COURSENAME,e.STATUS,e.RID ,u.FIRSTNAME FROM EMPREQUEST e ,userdetails u where u.userid=e.rid and EMPNAME= '"+emp+"'");
		
		while (rs.next()) {
			cd = new CourseTO();
			cd.setCourseid(rs.getInt(1));
			cd.setEmpName(rs.getString(2));
			cd.setCoursename(rs.getString(3));
			cd.setCoursedetails(rs.getString(4));
			cd.setSheduleid(rs.getInt(5));
			cd.setFacultyname(rs.getString(6));
			courselist.add(cd);
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
	return courselist;
}



	
	
	public ArrayList<CourseTO> getFacultyList() {
		
		ArrayList<CourseTO> facultylist = new ArrayList<CourseTO>();
		CourseTO cd = null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st
					.executeQuery(SQLStatementsConstants._GET_FACULTY_LIST);
			while (rs.next()) {
				cd = new CourseTO();
				cd.setFacultyid(rs.getInt(1));
				cd.setFacultyname(rs.getString(2));
				facultylist.add(cd);
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
		return facultylist;
	}

	public boolean deleteCourse(ArrayList<CourseTO> ar) {
		
		boolean flag = false;
		try {
			for (int i = 0; i < ar.size(); i++) {
				CourseTO db = ar.get(i);
				int courseid = db.getCourseid();
				PreparedStatement pst = con
						.prepareStatement(SQLStatementsConstants._DELETE_COURSE);
				pst.setInt(1, courseid);
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
			} catch (Exception e) {
				logger.info(e.getMessage());
			}
		}
		return flag;
	}

	public boolean deleteShedule(ArrayList<CourseTO> ar) {
		
		boolean flag = false;
		try {
			for (int i = 0; i < ar.size(); i++) {
				CourseTO db = ar.get(i);
				int sheduleid = db.getSheduleid();
				PreparedStatement pst = con
						.prepareStatement(SQLStatementsConstants._DELETE_SHEDULE);
				pst.setInt(1, sheduleid);
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

	public boolean sheduleCourse(CourseTO cd) {

		int courseid = cd.getCourseid();
		String fromdate = cd.getCoursestartdate();
		String todate = cd.getCourseenddate();
		int facultyid = cd.getFacultyid();
		int i = 0;
		try {
			PreparedStatement pst = con
					.prepareStatement(SQLStatementsConstants._SHEDULE_COURSE);
			pst.setInt(1, courseid);
			pst.setString(2, fromdate);
			pst.setString(3, todate);
			pst.setInt(4, facultyid);
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

	public ArrayList<CourseTO> getSheduleList() {
		
		ArrayList<CourseTO> courselist = new ArrayList<CourseTO>();
		CourseTO cd = null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st
					.executeQuery(SQLStatementsConstants._GET_SHEDULE_LIST);
			while (rs.next()) {
				cd = new CourseTO();
				cd.setSheduleid(rs.getInt(1));
				cd.setCoursename(rs.getString(2));
				cd.setCoursedetails(rs.getString(3));
				cd.setCoursestartdate(rs.getString(4));
				cd.setCourseenddate(rs.getString(5));
				courselist.add(cd);
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
		return courselist;
	}

	public ArrayList<CourseTO> getAssignmentList() {
		
		ArrayList<CourseTO> courselist = new ArrayList<CourseTO>();
		CourseTO cd = null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st
					.executeQuery(SQLStatementsConstants._GET_ASSIGNMENT_LIST);
			while (rs.next()) {
				cd = new CourseTO();
				cd.setSheduleid(rs.getInt(1));
				cd.setCoursename(rs.getString(2));
				cd.setCoursedetails(rs.getString(3));
				cd.setCoursestartdate(rs.getString(4));
				cd.setCourseenddate(rs.getString(5));
				cd.setFacultyloginid(rs.getString(6));
				cd.setFacultyname(rs.getString(7));
				courselist.add(cd);
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
		return courselist;
	}

	public ArrayList<CourseTO> getFacultyAssignmentList(String facultyname) {
		
		ArrayList<CourseTO> courselist = new ArrayList<CourseTO>();
		CourseTO cd = null;
		try {
			PreparedStatement pst = con
					.prepareStatement(SQLStatementsConstants._GET_FACULTY_ASSIGNMENT_LIST);
			pst.setString(1, facultyname);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				cd = new CourseTO();
				cd.setCoursename(rs.getString(1));
				cd.setCoursedetails(rs.getString(2));
				cd.setCoursestartdate(rs.getString(3));
				cd.setCourseenddate(rs.getString(4));
				cd.setFacultyloginid(rs.getString(5));
				cd.setFacultyname(rs.getString(6));
				courselist.add(cd);
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
		return courselist;
	}
}
