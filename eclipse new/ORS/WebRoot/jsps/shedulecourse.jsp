<%@page import="com.ors.delegate.*" %>
<%@page import="com.ors.bean.*" %>
<%@page import="java.util.*" %>
<%@page import="com.ors.daos.impl.CourseDAOImpl"%>

<%if(session.getAttribute("role")==null){%>
<jsp:forward page="/logoutaction"></jsp:forward>
<%} %>


<html>
<head>
<script type="text/javascript">
function emptyvalidation(entered, alertbox)
{

with (entered)
{
if (value==null || value=="")
{if (alertbox!="") {alert(alertbox);} return false;}
else {return true;}
}
} 

function formvalidation(thisform)
{
with (thisform)
{
if (emptyvalidation(courseid,"Please Enter An CourseName")==false) {courseid.focus(); return false;};
if (emptyvalidation(fromdate,"Please Enter An From Date")==false) {fromdate.focus(); return false;};
if (emptyvalidation(todate,"Please Enter An To Date")==false) {todate.focus(); return false;};
}
}
</script>
<script language="JavaScript" type="text/javascript" src=<%=request.getContextPath()+"/scripts/ts_picker.js" %>></script>
</head>
<body topmargin="0" leftmargin="0"  marginwidth="0" marginheight="0" background=<%=request.getContextPath()+"/images/web-background.png" %> >
	<table width="100%" align="left" border="0" style="vertical-align: top;">
		<tr>
			<td colspan="2" valign="top">
				<jsp:include page="Header.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
			<td colspan="1" width="700" height="300" valign="top">
				<jsp:include page="adminmenu.jsp"></jsp:include><br/>
				<font color="#1B577C" size="4"><b><i>Welcome On Request Coordinater ,Here you can shedule a course...</i></b></font>
				<br/><br/>
					<jsp:include page="statusmsg.jsp"></jsp:include>
				<br/><br/>
				<form action=<%=request.getContextPath()+"/SheduleCourseAction" %> method="post" name="ViewAllUser" onsubmit="return formvalidation(this);">         
         	<table align="center">
         		<tr>
         			<td><font color="#1B577C"><b>Course Name </b> </font> </td>
         			<%
         				ArrayList<CourseTO> ar=new CourseDAOImpl().getCourseList();
         			         							Iterator it=ar.iterator();
         			%>
						<td><select name="courseid">
						<option value="">--Choose A Course--</option>
						<%
							if(ar.size()!=0){
											while(it.hasNext()){
											  CourseTO pf=(CourseTO)it.next();
						%>
						 <option value="<%=pf.getCourseid() %>"><%=pf.getCoursename() %></option>
						 <%}} %>
						</select></td>
         		</tr>
         		<tr>
         			<td><font color="#1B577C"><b>Starting From </b> </font> </td>
         			<td><input type="text" name="fromdate" value="" size="20" readonly="readonly" /><a href="javascript:show_calendar('document.ViewAllUser.fromdate', document.ViewAllUser.fromdate.value);"> <img src=<%=request.getContextPath()+"/images/cal.gif" %> alt="a" width="18" height="18" border="0"/></a>  </td>
         		</tr>
         		<tr>
         			<td><font color="#1B577C"><b>Expected To Be Completed </b> </font> </td>
         			<td><input type="text" name="todate" value="" size="20" readonly="readonly" /><a href="javascript:show_calendar('document.ViewAllUser.todate', document.ViewAllUser.todate.value);"> <img src=<%=request.getContextPath()+"/images/cal.gif" %> alt="a" width="18" height="18" border="0"/></a></td>
         		</tr>
         		<tr>
         			<td><font color="#1B577C"><b>Assign To </b> </font> </td>
         			<%
         				ArrayList<CourseTO> ar1=new CourseDAOImpl().getFacultyList();
         			         							Iterator it1=ar1.iterator();
         			%>
						<td><select name="facultyid">
						<option value="">--Choose A Faculty--</option>
						<%
							if(ar1.size()!=0){
											while(it1.hasNext()){
											  CourseTO pf=(CourseTO)it1.next();
						%>
						 <option value="<%=pf.getFacultyid() %>"><%=pf.getFacultyname() %></option>
						 <%}} %>
						</select></td>
         		</tr>
         		<tr>
         			<td align="center" colspan="2"><input type="submit" value="Shedule Course">  </td>
         		</tr>
         	</table>
         	</form>
 			     	
			</td>
			<td colspan="1" width="300" height="300" valign="top" align="right">
				<img src=<%=request.getContextPath()+"/images/full_avatar_admin1.gif" %> height="300" width="300"/>
			</td>
		</tr>
		<tr>
			<td colspan="2" valign="bottom">
				<jsp:include page="Footer.jsp"></jsp:include>
			</td>
		</tr>
	</table>
</body>
</html>



