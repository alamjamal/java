/*
 * RegistrationBean.java
 *
 * 
 */

package com.ors.bean;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.log4j.Logger;

import com.ors.formbean.ProfileFormBean;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class ProfileTO implements Serializable {

	public ProfileTO() {

	}

	public ProfileTO(ProfileFormBean profileformbean) {
		try {
			Map map = BeanUtils.describe(profileformbean);
			BeanUtils.populate(this, map);
		} catch (IllegalAccessException e) {
			logger.info(e.getMessage());
		} catch (InvocationTargetException e) {
			logger.info(e.getMessage());
		} catch (NoSuchMethodException e) {
			logger.info(e.getMessage());
		}
	}

	private static final long serialVersionUID = -7576311061729743519L;
	static final Logger logger = Logger.getLogger(ProfileTO.class);
	private String secretqid;
	private String photo;
	private String id;
	private int userid;
	private String username;
	private String password;
	private String newpassword;
	private String firstname;
	private String lastname;
	private String logintype;
	private String fax;
	private String email;
	private String home;
	private String office;
	private String contact;
	private int status;
	private String regdate;
	private int roleid;
	private int flogin;
	private String timezone;
	private String pin;
	private String phone;
	private String city;
	private String hno;
	private String street;
	private String state;
	private String country;
	private String opin;
	private String ophone;
	private String ocity;
	private String ohno;
	private String ostreet;
	private String ostate;
	private String ocountry;
	private String cpin;
	private String cphone;
	private String ccity;
	private String chno;
	private String cstreet;
	private String cstate;
	private String ccountry;
	private String bdate;
	private String locale;
	private String secretqans;
	private String passwordmoddate;
	private String profilemoddate;
	private String officePhoneType;
	private String homePhoneType;
	private String personalPhoneType;
	private String logindate;
	private String logintime;
	private String logofftime;
	private String managerid;
	private String deptname;

	/**
	 * @return the secretqid
	 */
	public String getSecretqid() {
		return secretqid;
	}

	/**
	 * @param secretqid
	 *            the secretqid to set
	 */
	public void setSecretqid(String secretqid) {
		this.secretqid = secretqid;
	}

	/**
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * @param photo
	 *            the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the newpassword
	 */
	public String getNewpassword() {
		return newpassword;
	}

	/**
	 * @param newpassword
	 *            the newpassword to set
	 */
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname
	 *            the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname
	 *            the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the logintype
	 */
	public String getLogintype() {
		return logintype;
	}

	/**
	 * @param logintype
	 *            the logintype to set
	 */
	public void setLogintype(String logintype) {
		this.logintype = logintype;
	}

	/**
	 * @return the fax
	 */
	public String getFax() {
		return fax;
	}

	/**
	 * @param fax
	 *            the fax to set
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the home
	 */
	public String getHome() {
		return home;
	}

	/**
	 * @param home
	 *            the home to set
	 */
	public void setHome(String home) {
		this.home = home;
	}

	/**
	 * @return the office
	 */
	public String getOffice() {
		return office;
	}

	/**
	 * @param office
	 *            the office to set
	 */
	public void setOffice(String office) {
		this.office = office;
	}

	/**
	 * @return the contact
	 */
	public String getContact() {
		return contact;
	}

	/**
	 * @param contact
	 *            the contact to set
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the regdate
	 */
	public String getRegdate() {
		return regdate;
	}

	/**
	 * @param regdate
	 *            the regdate to set
	 */
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	/**
	 * @return the roleid
	 */
	public int getRoleid() {
		return roleid;
	}

	/**
	 * @param roleid
	 *            the roleid to set
	 */
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	/**
	 * @return the flogin
	 */
	public int getFlogin() {
		return flogin;
	}

	/**
	 * @param flogin
	 *            the flogin to set
	 */
	public void setFlogin(int flogin) {
		this.flogin = flogin;
	}

	/**
	 * @return the timezone
	 */
	public String getTimezone() {
		return timezone;
	}

	/**
	 * @param timezone
	 *            the timezone to set
	 */
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	/**
	 * @return the pin
	 */
	public String getPin() {
		return pin;
	}

	/**
	 * @param pin
	 *            the pin to set
	 */
	public void setPin(String pin) {
		this.pin = pin;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the hno
	 */
	public String getHno() {
		return hno;
	}

	/**
	 * @param hno
	 *            the hno to set
	 */
	public void setHno(String hno) {
		this.hno = hno;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street
	 *            the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the opin
	 */
	public String getOpin() {
		return opin;
	}

	/**
	 * @param opin
	 *            the opin to set
	 */
	public void setOpin(String opin) {
		this.opin = opin;
	}

	/**
	 * @return the ophone
	 */
	public String getOphone() {
		return ophone;
	}

	/**
	 * @param ophone
	 *            the ophone to set
	 */
	public void setOphone(String ophone) {
		this.ophone = ophone;
	}

	/**
	 * @return the ocity
	 */
	public String getOcity() {
		return ocity;
	}

	/**
	 * @param ocity
	 *            the ocity to set
	 */
	public void setOcity(String ocity) {
		this.ocity = ocity;
	}

	/**
	 * @return the ohno
	 */
	public String getOhno() {
		return ohno;
	}

	/**
	 * @param ohno
	 *            the ohno to set
	 */
	public void setOhno(String ohno) {
		this.ohno = ohno;
	}

	/**
	 * @return the ostreet
	 */
	public String getOstreet() {
		return ostreet;
	}

	/**
	 * @param ostreet
	 *            the ostreet to set
	 */
	public void setOstreet(String ostreet) {
		this.ostreet = ostreet;
	}

	/**
	 * @return the ostate
	 */
	public String getOstate() {
		return ostate;
	}

	/**
	 * @param ostate
	 *            the ostate to set
	 */
	public void setOstate(String ostate) {
		this.ostate = ostate;
	}

	/**
	 * @return the ocountry
	 */
	public String getOcountry() {
		return ocountry;
	}

	/**
	 * @param ocountry
	 *            the ocountry to set
	 */
	public void setOcountry(String ocountry) {
		this.ocountry = ocountry;
	}

	/**
	 * @return the cpin
	 */
	public String getCpin() {
		return cpin;
	}

	/**
	 * @param cpin
	 *            the cpin to set
	 */
	public void setCpin(String cpin) {
		this.cpin = cpin;
	}

	/**
	 * @return the cphone
	 */
	public String getCphone() {
		return cphone;
	}

	/**
	 * @param cphone
	 *            the cphone to set
	 */
	public void setCphone(String cphone) {
		this.cphone = cphone;
	}

	/**
	 * @return the ccity
	 */
	public String getCcity() {
		return ccity;
	}

	/**
	 * @param ccity
	 *            the ccity to set
	 */
	public void setCcity(String ccity) {
		this.ccity = ccity;
	}

	/**
	 * @return the chno
	 */
	public String getChno() {
		return chno;
	}

	/**
	 * @param chno
	 *            the chno to set
	 */
	public void setChno(String chno) {
		this.chno = chno;
	}

	/**
	 * @return the cstreet
	 */
	public String getCstreet() {
		return cstreet;
	}

	/**
	 * @param cstreet
	 *            the cstreet to set
	 */
	public void setCstreet(String cstreet) {
		this.cstreet = cstreet;
	}

	/**
	 * @return the cstate
	 */
	public String getCstate() {
		return cstate;
	}

	/**
	 * @param cstate
	 *            the cstate to set
	 */
	public void setCstate(String cstate) {
		this.cstate = cstate;
	}

	/**
	 * @return the ccountry
	 */
	public String getCcountry() {
		return ccountry;
	}

	/**
	 * @param ccountry
	 *            the ccountry to set
	 */
	public void setCcountry(String ccountry) {
		this.ccountry = ccountry;
	}

	/**
	 * @return the bdate
	 */
	public String getBdate() {
		return bdate;
	}

	/**
	 * @param bdate
	 *            the bdate to set
	 */
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	/**
	 * @return the locale
	 */
	public String getLocale() {
		return locale;
	}

	/**
	 * @param locale
	 *            the locale to set
	 */
	public void setLocale(String locale) {
		this.locale = locale;
	}

	/**
	 * @return the secretqans
	 */
	public String getSecretqans() {
		return secretqans;
	}

	/**
	 * @param secretqans
	 *            the secretqans to set
	 */
	public void setSecretqans(String secretqans) {
		this.secretqans = secretqans;
	}

	/**
	 * @return the passwordmoddate
	 */
	public String getPasswordmoddate() {
		return passwordmoddate;
	}

	/**
	 * @param passwordmoddate
	 *            the passwordmoddate to set
	 */
	public void setPasswordmoddate(String passwordmoddate) {
		this.passwordmoddate = passwordmoddate;
	}

	/**
	 * @return the profilemoddate
	 */
	public String getProfilemoddate() {
		return profilemoddate;
	}

	/**
	 * @param profilemoddate
	 *            the profilemoddate to set
	 */
	public void setProfilemoddate(String profilemoddate) {
		this.profilemoddate = profilemoddate;
	}

	/**
	 * @return the officePhoneType
	 */
	public String getOfficePhoneType() {
		return officePhoneType;
	}

	/**
	 * @param officePhoneType
	 *            the officePhoneType to set
	 */
	public void setOfficePhoneType(String officePhoneType) {
		this.officePhoneType = officePhoneType;
	}

	/**
	 * @return the homePhoneType
	 */
	public String getHomePhoneType() {
		return homePhoneType;
	}

	/**
	 * @param homePhoneType
	 *            the homePhoneType to set
	 */
	public void setHomePhoneType(String homePhoneType) {
		this.homePhoneType = homePhoneType;
	}

	/**
	 * @return the personalPhoneType
	 */
	public String getPersonalPhoneType() {
		return personalPhoneType;
	}

	/**
	 * @param personalPhoneType
	 *            the personalPhoneType to set
	 */
	public void setPersonalPhoneType(String personalPhoneType) {
		this.personalPhoneType = personalPhoneType;
	}

	/**
	 * @return the logindate
	 */
	public String getLogindate() {
		return logindate;
	}

	/**
	 * @param logindate
	 *            the logindate to set
	 */
	public void setLogindate(String logindate) {
		this.logindate = logindate;
	}

	/**
	 * @return the logintime
	 */
	public String getLogintime() {
		return logintime;
	}

	/**
	 * @param logintime
	 *            the logintime to set
	 */
	public void setLogintime(String logintime) {
		this.logintime = logintime;
	}

	/**
	 * @return the logofftime
	 */
	public String getLogofftime() {
		return logofftime;
	}

	/**
	 * @param logofftime
	 *            the logofftime to set
	 */
	public void setLogofftime(String logofftime) {
		this.logofftime = logofftime;
	}

	/**
	 * @return the managerid
	 */
	public String getManagerid() {
		return managerid;
	}

	/**
	 * @param managerid
	 *            the managerid to set
	 */
	public void setManagerid(String managerid) {
		this.managerid = managerid;
	}

	/**
	 * @return the deptname
	 */
	public String getDeptname() {
		return deptname;
	}

	/**
	 * @param deptname
	 *            the deptname to set
	 */
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	/**
	 * @return the serialVersionUID
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	/**
	 * @return the logger
	 */
	public static Logger getLogger() {
		return logger;
	}

	/**
	 * @return the userid
	 */
	public int getUserid() {
		return userid;
	}

	/**
	 * @param userid
	 *            the userid to set
	 */
	public void setUserid(int userid) {
		this.userid = userid;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

}
