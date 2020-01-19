package com.ors.dao;

import java.util.ArrayList;

import com.ors.bean.CourseTO;

/**
 * @author JAVAPROJECTS
 *
 */
public interface CourseDAOI {

	public boolean registerCourse(CourseTO cd);

	public boolean assignShedule(CourseTO cd);

	public ArrayList<CourseTO> getCourseList();

	public ArrayList<CourseTO> getFacultyList();

	public boolean deleteCourse(ArrayList<CourseTO> ar);

	public boolean deleteShedule(ArrayList<CourseTO> ar);

	public boolean sheduleCourse(CourseTO cd);

	public ArrayList<CourseTO> getSheduleList();

	public ArrayList<CourseTO> getAssignmentList();

	public ArrayList<CourseTO> getFacultyAssignmentList(String facultyname);
}
