package com.ors.bean;

import java.io.Serializable;

public class CourseTO implements Serializable {

	private static final long serialVersionUID = 6059944006005344218L;
	private int courseid;
	private int sheduleid;
	private int facultyid;
	private int assignmentid;
	private String coursename;
	private String coursedetails;
	private String coursestartdate;
	private String courseenddate;
	private String facultyname;
	private String facultyloginid;
	private String empName;

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getFacultyloginid() {
		return facultyloginid;
	}

	public void setFacultyloginid(String facultyloginid) {
		this.facultyloginid = facultyloginid;
	}

	public int getFacultyid() {
		return facultyid;
	}

	public void setFacultyid(int facultyid) {
		this.facultyid = facultyid;
	}

	public String getFacultyname() {
		return facultyname;
	}

	public void setFacultyname(String facultyname) {
		this.facultyname = facultyname;
	}

	public String getCoursestartdate() {
		return coursestartdate;
	}

	public void setCoursestartdate(String coursestartdate) {
		this.coursestartdate = coursestartdate;
	}

	public String getCourseenddate() {
		return courseenddate;
	}

	public void setCourseenddate(String courseenddate) {
		this.courseenddate = courseenddate;
	}

	public int getCourseid() {
		return courseid;
	}

	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public String getCoursedetails() {
		return coursedetails;
	}

	public void setCoursedetails(String coursedetails) {
		this.coursedetails = coursedetails;
	}

	public int getSheduleid() {
		return sheduleid;
	}

	public void setSheduleid(int sheduleid) {
		this.sheduleid = sheduleid;
	}

	public int getAssignmentid() {
		return assignmentid;
	}

	public void setAssignmentid(int assignmentid) {
		this.assignmentid = assignmentid;
	}
}
