package com.ors.db.util;

public class SQLStatementsConstants {
	/**
	 * ProfileDAOImpl Class SQL Statements
	 * 
	 */
	public static final String _INSERTPROCEDURE = "{call insertprocedure(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	public static final String _CHANGE_ACCOUNT_STATUS = "UPDATE logindetails SET loginstatus=? WHERE loginid=?";
	public static final String _GET_USERS_FROM_TO = "SELECT DISTINCT(UD.LOGINID ),UD.FIRSTNAME,UD.LASTNAME,UD.DOB,UD.DOR,UD.EMAILID,UD.LOGINTYPE FROM USERDETAILS UD,LOGINMASTER LM WHERE UD.USERID=LM.USERID AND LOGINTIME>=TO_DATE(?,'DD-MM-YYYY') AND LOGINTIME<=TO_DATE(?,'DD-MM-YYYY')";
	public static final String _CHANGEPROFILE_PROCEDURE = "{call changeprofile(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	public static final String _SHOWPROFILE_PROCEDURE = "{call showprofile(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	public static final String _GET_DEPARTMENT_FACULTY_LIST = "SELECT FIRSTNAME,USERID,logintype FROM USERDETAILS WHERE LOGINTYPE <> 'admin'";
	public static final String _REGISTER_DEPARTMENT = "INSERT INTO USERDETAILS VALUES((select nvl(max(userid),1000)+1 from userdetails),?,'','',sysdate,?,?,'department',?,?,'','',?)";
	public static final String _GET_DEPARTMENT_LIST = "SELECT FIRSTNAME FROM USERDETAILS WHERE LOGINID=?";
	
	/**
	 * SecurityDAOImpl Class SQL Statements
	 * 
	 */
	public static final String _LOGINCHECKPROCEDURE = "{call logincheck(?,?,?)}";
	public static final String _SIGNOUTPROCEDURE = "{call signoutprocedure(?)}";
	public static final String _CHANGEPASSWORD_UPDATESTATEMENT = "update userdetails set password=? where loginid=? and password=?";
	public static final String _CHANGEQUESTION_PROCEDURE = "{call ChangeQuetion(?,?,?,?,?)}";
	public static final String _RECOVERPASSWORD_PROCEDURE = "{call RecoverPassword(?,?,?,?)}";
	public static final String _LOGINIDAVAILABLITY_PROCEDURE = "{ call loginidavailablity(?,?) }";
	public static final String _LOGINTYPE_CHECK = "select logintype from userdetails where loginid=?";
	
	/**
	 * 
	 * CourseDAOImpl Class SQL Statements
	 * 
	 */
	public static final String _COURSE_REGISTRATION = "INSERT INTO COURSE VALUES((SELECT NVL(MAX(COURSE_ID),110)+1 FROM COURSE),?,?)";
	public static final String _COURSE_REQUEST = "INSERT INTO EMPREQUEST VALUES((SELECT NVL(MAX(RID),110)+1 FROM EMPREQUEST),?,?,'notaccept',(SELECT userid FROM userdetails where loginid=?))";
	public static final String _ASSIGN_SHEDULE = "UPDATE COURSE_SHEDULE SET FACULTY_ID=? WHERE SHEDULE_ID=?";
	public static final String _GET_COURSE_LIST = "SELECT COURSE_ID,COURSE_NAME,COURSE_DESCRIPTION FROM COURSE";
	public static final String _GET_EMPREQUEST_LIST = "SELECT EMPID,EMPNAME,COURSENAME,STATUS,RID FROM EMPREQUEST where status='notaccept'";
	public static final String _GET_EMPREQUEST_LIST1 = "SELECT EMPID,EMPNAME,COURSENAME,STATUS,RID FROM EMPREQUEST where status='accept' or status='reject'";

	public static final String _GET_FACULTY_LIST = "SELECT USERID,LOGINID FROM USERDETAILS WHERE LOGINTYPE='faculty'";
	public static final String _DELETE_COURSE = "DELETE COURSE WHERE COURSE_ID=?";
	public static final String _DELETE_SHEDULE = "DELETE COURSE_SHEDULE WHERE SHEDULE_ID=?";
	public static final String _SHEDULE_COURSE = "INSERT INTO COURSE_SHEDULE VALUES((SELECT NVL(MAX(SHEDULE_ID),10) FROM COURSE_SHEDULE)+1,?,TO_DATE(?,'dd-MM-yyyy'),TO_DATE(?,'dd-MM-yyyy'),?)";
	public static final String _GET_SHEDULE_LIST = "SELECT S.SHEDULE_ID,C.COURSE_NAME,C.COURSE_DESCRIPTION,TO_CHAR(S.FROM_DATE,'DD-MON-YYYY'),TO_CHAR(S.TO_DATE,'DD-MON-YYYY') FROM COURSE C,COURSE_SHEDULE S WHERE C.COURSE_ID=S.COURSE_ID ORDER BY S.FROM_DATE DESC";
	public static final String _GET_ASSIGNMENT_LIST = "SELECT S.SHEDULE_ID,C.COURSE_NAME,C.COURSE_DESCRIPTION,TO_CHAR(S.FROM_DATE,'DD-MON-YYYY'),TO_CHAR(S.TO_DATE,'DD-MON-YYYY'),U.LOGINID,U.FIRSTNAME FROM COURSE C,COURSE_SHEDULE S,USERDETAILS U WHERE S.FACULTY_ID=U.USERID AND S.COURSE_ID=C.COURSE_ID ORDER BY S.FROM_DATE DESC";
	public static final String _GET_FACULTY_ASSIGNMENT_LIST = "SELECT C.COURSE_NAME,C.COURSE_DESCRIPTION,TO_CHAR(S.FROM_DATE,'DD-MON-YYYY'),TO_CHAR(S.TO_DATE,'DD-MON-YYYY'),U.LOGINID,U.FIRSTNAME FROM COURSE C,COURSE_SHEDULE S,USERDETAILS U WHERE S.FACULTY_ID=U.USERID AND S.COURSE_ID=C.COURSE_ID AND U.LOGINID=? ORDER BY S.FROM_DATE DESC";
	
	/**
	 * 
	 * MailDAOImpl Class SQL Statements
	 * 
	 */
	
	public static final String _STORE_MAIL = "INSERT INTO MAILBOX VALUES((SELECT NVL(MAX(MAIL_ID),550)+1 FROM MAILBOX),(SELECT USERID FROM USERDETAILS WHERE LOGINID=?),?,?,?,'Unread',SYSDATE)";
	public static final String _GET_MAIL_LIST = "SELECT U.LOGINID,M.SUBJECT,TO_CHAR(M.MAIL_DATE,'DD-MON,HH12:MI AM'),M.FLAG,M.MAIL_ID FROM USERDETAILS U,MAILBOX M WHERE U.USERID=M.FROM_ID AND M.TO_ID=(SELECT USERID FROM USERDETAILS WHERE LOGINID=?) ORDER BY M.MAIL_DATE DESC";
	public static final String _GET_MAIL = "SELECT U.LOGINID,M.SUBJECT,TO_CHAR(M.MAIL_DATE,'DD-MON-YYYY,HH12:MI AM'),M.CONTENT FROM USERDETAILS U,MAILBOX M WHERE U.USERID=M.FROM_ID AND M.MAIL_ID=? ORDER BY M.MAIL_ID";
	public static final String _CHANGE_MAIL_STATUS = "UPDATE MAILBOX SET FLAG='READ' WHERE MAIL_ID=?";
	public static final String _DELETE_MAIL = "DELETE MAILBOX WHERE MAIL_ID=?";
	
	/**
	 * 
	 * LogInDetailsDAOImpl Class SQL Statements
	 * 
	 */
	
	public static final String _GET_LOGINDATE = "select to_char(max(logintime),'dd-MON-yy,HH12:MI AM') from userdetails ud,loginmaster lm where ud.userid=lm.userid and ud.loginid=? and logintime<(select max(logintime) from loginmaster)";
	public static final String _GET_LOGINDETAILS = "SELECT UD.LOGINID,NVL(TO_CHAR(LM.LOGINTIME,'DD-MON-YYYY'),'NOT AVAILABLE'),NVL(TO_CHAR(LM.LOGINTIME,'HH12:MI AM'),'NOT AVAILABLE'),NVL(TO_CHAR(LM.LOGOFFTIME,'DD-MM,HH12:MI AM'),'NOT AVAILABLE') FROM USERDETAILS UD,LOGINMASTER LM WHERE UD.USERID=LM.USERID AND UD.LOGINID=? AND (LM.LOGINTIME>=TO_DATE(?,'DD-MM-YYYY') AND LM.LOGINTIME<=TO_DATE(?,'DD-MM-YYYY'))";
	/**
	 * 
	 * RequestDAOImpl Class SQL Statements
	 * 
	 */
	public static final String _SET_REQUEST = "INSERT INTO REQUEST VALUES((SELECT NVL(MAX(REQUEST_ID),440)+1 FROM REQUEST),(SELECT USERID FROM USERDETAILS WHERE LOGINID=?),?,?,?,?,TO_DATE(?,'dd-MM-yyyy'),'Not Processed Yet',?)";
	public static final String _GET_REQUEST_LIST = "SELECT REQUEST_ID,REQUEST_FROM,COURSE_DETAILS,COURSE_DURATION,PARTICIPENTS_NO,PARTICIPENT_BACKGROUND,TO_CHAR(REQUIRED_FROM,'DD-MON-YYYY'),REQUEST_STATUS,OUTSIDE_FACULTY_FLAG FROM REQUEST WHERE REQUEST_FROM=(SELECT USERID FROM USERDETAILS WHERE LOGINID=?) order by request_id desc";
	public static final String _GET_ALL_REQUEST_LIST = "SELECT REQUEST_ID,U.FIRSTNAME,COURSE_DETAILS,COURSE_DURATION,PARTICIPENTS_NO,PARTICIPENT_BACKGROUND,TO_CHAR(REQUIRED_FROM,'DD-MON-YYYY'),REQUEST_STATUS,OUTSIDE_FACULTY_FLAG,REQUEST_FROM FROM REQUEST R,USERDETAILS U WHERE R.REQUEST_FROM=U.USERID order by request_id desc";
	public static final String _DELETE_REQUEST = "DELETE REQUEST WHERE REQUEST_ID=?";
	public static final String _REPLY_REQUEST = "UPDATE REQUEST SET REQUEST_STATUS=? WHERE REQUEST_ID=?";
}
