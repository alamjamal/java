package com.ors.services.impl;

import java.util.ArrayList;

import com.ors.bean.CourseTO;
import com.ors.dao.CourseDAOI;
import com.ors.daos.impl.CourseDAOImpl;
import com.ors.exception.OORSDataAccessException;
import com.ors.exception.OORSInsertException;
import com.ors.service.CourseServiceI;

public class CourseServiceImpl implements CourseServiceI{

	CourseDAOI coursedao = new CourseDAOImpl();
	
	public boolean assignShedule(CourseTO cd) throws OORSInsertException {
		
		boolean flag = coursedao.assignShedule(cd);
		
		if(flag == false)
			throw new OORSInsertException("Shedule Assignment failed");
			
		return flag;
	}

	

	public boolean deleteCourse(ArrayList<CourseTO> ar) throws OORSDataAccessException {
		
		boolean flag = coursedao.deleteCourse(ar);
		
		if(flag == false)
			throw new OORSDataAccessException("Deletion Of Course Failed");
		
		return flag;
	}

	public boolean deleteShedule(ArrayList<CourseTO> ar) throws OORSDataAccessException {
		
		boolean flag = coursedao.deleteShedule(ar);
		
		if(flag == false)
			throw new OORSDataAccessException("Course Deletion failed");
		
		return flag;
	}

	public ArrayList<CourseTO> getAssignmentList() throws OORSDataAccessException {

		ArrayList<CourseTO> list = coursedao.getAssignmentList();
		
		if(list == null || list.size() == 0)
			throw new OORSDataAccessException("Failed to get assignment list");
		return list;
	}

	public ArrayList<CourseTO> getCourseList() throws OORSDataAccessException {
		
		ArrayList<CourseTO> list = coursedao.getCourseList();
		
		if(list == null || list.size() == 0)
			throw new OORSDataAccessException("Failed to get courselist");
		
		return list;
	}

	public ArrayList<CourseTO> getFacultyAssignmentList(String facultyname)
			throws OORSDataAccessException {
		ArrayList<CourseTO> list = coursedao.getFacultyAssignmentList(facultyname);
		
		if(list == null || list.size() == 0)
			throw new OORSDataAccessException("Failed to get faculty assignment list");
		
		return list;
	}

	public ArrayList<CourseTO> getFacultyList() throws OORSDataAccessException {
		
		ArrayList<CourseTO> list = coursedao.getFacultyList(); 
		
		if(list == null || list.size() == 0)
			throw new OORSDataAccessException("Failed to get faculty  list");
		
		return list;
	}

	public ArrayList<CourseTO> getSheduleList() throws OORSDataAccessException {
		
		ArrayList<CourseTO> list = coursedao.getSheduleList();
		
		if(list == null || list.size() == 0)
			throw new OORSDataAccessException("Failed to get shedule list");
		
		return list;
	}

	public boolean registerCourse(CourseTO cd) throws OORSInsertException {
		
		boolean flag = coursedao.registerCourse(cd);
		
		if(flag == false)
			throw new OORSInsertException("Failed to register a course");
		
		return flag;
	}

	public boolean sheduleCourse(CourseTO cd) throws OORSInsertException {
		
		boolean flag = coursedao.sheduleCourse(cd);
		
		if(flag == false)
			throw new OORSInsertException("Failed to shedule course");
		
		return flag;
	}

}
