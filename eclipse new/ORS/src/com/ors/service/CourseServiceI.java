package com.ors.service;

import java.util.ArrayList;

import com.ors.bean.CourseTO;
import com.ors.exception.OORSDataAccessException;
import com.ors.exception.OORSInsertException;

/**
 * @author JAVAPROJECTS
 *
 */
public interface CourseServiceI {

	public boolean registerCourse(CourseTO cd) throws OORSInsertException;

	public boolean assignShedule(CourseTO cd) throws OORSInsertException;

	public ArrayList<CourseTO> getCourseList() throws OORSDataAccessException;

	public ArrayList<CourseTO> getFacultyList() throws OORSDataAccessException;

	public boolean deleteCourse(ArrayList<CourseTO> ar)
			throws OORSDataAccessException;

	public boolean deleteShedule(ArrayList<CourseTO> ar)
			throws OORSDataAccessException;

	public boolean sheduleCourse(CourseTO cd) throws OORSInsertException;

	public ArrayList<CourseTO> getSheduleList() throws OORSDataAccessException;

	public ArrayList<CourseTO> getAssignmentList()
			throws OORSDataAccessException;

	public ArrayList<CourseTO> getFacultyAssignmentList(String facultyname)
			throws OORSDataAccessException;
}
