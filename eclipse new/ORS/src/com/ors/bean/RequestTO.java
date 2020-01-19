package com.ors.bean;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.log4j.Logger;

import com.ors.formbean.RequestFormBean;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class RequestTO implements Serializable {

	public RequestTO() {

	}

	public RequestTO(RequestFormBean requestformbean) {

		try {
			Map map = BeanUtils.describe(requestformbean);
			BeanUtils.populate(this, map);
		} catch (IllegalAccessException e) {
			logger.info(e.getMessage());
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			logger.info(e.getMessage());
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			logger.info(e.getMessage());
			e.printStackTrace();
		}
	}

	private static final long serialVersionUID = 1528833186018818628L;
	static final Logger logger = Logger.getLogger(RequestTO.class);
	private int requestid;
	private String from;
	private String coursedetails;
	private int courseduration;
	private int partcipentno;
	private String partcipentbackground;
	private String startingdate;
	private String status;
	private String facultyflag;
	private int fromid;

	public int getFromid() {
		return fromid;
	}

	public void setFromid(int fromid) {
		this.fromid = fromid;
	}

	public int getRequestid() {
		return requestid;
	}

	public void setRequestid(int requestid) {
		this.requestid = requestid;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getCoursedetails() {
		return coursedetails;
	}

	public void setCoursedetails(String coursedetails) {
		this.coursedetails = coursedetails;
	}

	public int getCourseduration() {
		return courseduration;
	}

	public void setCourseduration(int courseduration) {
		this.courseduration = courseduration;
	}

	public String getStartingdate() {
		return startingdate;
	}

	public void setStartingdate(String startingdate) {
		this.startingdate = startingdate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the partcipentno
	 */
	public int getPartcipentno() {
		return partcipentno;
	}

	/**
	 * @param partcipentno
	 *            the partcipentno to set
	 */
	public void setPartcipentno(int partcipentno) {
		this.partcipentno = partcipentno;
	}

	/**
	 * @return the partcipentbackground
	 */
	public String getPartcipentbackground() {
		return partcipentbackground;
	}

	/**
	 * @param partcipentbackground
	 *            the partcipentbackground to set
	 */
	public void setPartcipentbackground(String partcipentbackground) {
		this.partcipentbackground = partcipentbackground;
	}

	/**
	 * @return the facultyflag
	 */
	public String getFacultyflag() {
		return facultyflag;
	}

	/**
	 * @param facultyflag
	 *            the facultyflag to set
	 */
	public void setFacultyflag(String facultyflag) {
		this.facultyflag = facultyflag;
	}

}
