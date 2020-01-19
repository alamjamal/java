package com.ors.delegate;

import java.util.ArrayList;

import com.ors.bean.CourseTO;
import com.ors.exception.OORSDataAccessException;
import com.ors.exception.OORSInsertException;
import com.ors.service.CourseServiceI;
import com.ors.services.impl.CourseServiceImpl;

public class CourseMgrDelegate {

	CourseServiceI courseservice = new CourseServiceImpl();
	
	public boolean assignShedule(CourseTO cd) throws OORSInsertException {
	
		return courseservice.assignShedule(cd);
	}

	public boolean deleteCourse(ArrayList<CourseTO> ar) throws OORSDataAccessException {
		
		return courseservice.deleteCourse(ar);
	}

	public boolean deleteShedule(ArrayList<CourseTO> ar) throws OORSDataAccessException {
		
		return courseservice.deleteShedule(ar);
	}

	public ArrayList<CourseTO> getAssignmentList() throws OORSDataAccessException {

		return courseservice.getAssignmentList();
	}

	public ArrayList<CourseTO> getCourseList() throws OORSDataAccessException {
		
		return courseservice.getCourseList();
	}

	public ArrayList<CourseTO> getFacultyAssignmentList(String facultyname)
			throws OORSDataAccessException {
		
		return courseservice.getFacultyAssignmentList(facultyname);
		
	}

	public ArrayList<CourseTO> getFacultyList() throws OORSDataAccessException {
		
		return courseservice.getFacultyList();
	}

	public ArrayList<CourseTO> getSheduleList() throws OORSDataAccessException {
		
		return courseservice.getSheduleList();
	}

	public boolean registerCourse(CourseTO cd) throws OORSInsertException {
		
		return courseservice.registerCourse(cd);
	}

	public boolean sheduleCourse(CourseTO cd) throws OORSInsertException {
		
		return courseservice.sheduleCourse(cd);
	}
}
