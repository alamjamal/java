<%@page import="com.ors.delegate.*" %>
<%@page import="com.ors.bean.*" %>
<%@page import="java.util.*" %>
<%@page import="com.ors.daos.impl.CourseDAOImpl"%>

<%if(session.getAttribute("role")==null){%>
<jsp:forward page="/logoutaction"></jsp:forward>
<%} %>


<html>
<head>
<script language="JavaScript" type="text/javascript" src=<%=request.getContextPath()+"/scripts/ts_picker.js" %>></script>
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

if (emptyvalidation(sheduleid,"Please Choose A Shedule")==false) {sheduleid.focus(); return false;};
if (emptyvalidation(facultyid,"Please Choose A Faculty")==false) {facultyid.focus(); return false;};
}
}
</script>
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
				<font color="#1B577C" size="4"><b><i>Welcome On Request Coordinater ,Here you can update assignment of a shedule to a faculty..</i></b></font>
				<br/><br/>
					<jsp:include page="statusmsg.jsp"></jsp:include>
				<br/><br/>
				<form action=<%=request.getContextPath()+"/AssignSheduleAction" %> method="post" name="ViewAllUser" onsubmit="return formvalidation(this)">         
         	<table align="center">
         		<tr>
         			<td><font color="#1B577C"><b>Shedule </b> </font> </td>
         			<%
         				ArrayList<CourseTO> ar=new CourseDAOImpl().getSheduleList();
         			         							Iterator it=ar.iterator();
         			%>
						<td><select name="sheduleid">
						<option value="">--Choose A Shedule--</option>
						<%
							if(ar.size()!=0){
															while(it.hasNext()){
															  CourseTO pf=(CourseTO)it.next();
						%>
						 <option value="<%=pf.getSheduleid()%>"><%=pf.getSheduleid()%></option>
						 <%
						 	}}
						 %>
						</select></td>
         		</tr>
         		<tr>
         			<td colspan="2" align="center"><font color="red"><b>Note: Before choosing the sheduleid it is advisable to conform it from course->view shedules.... </b> </font> </td>	
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
         			<td align="center" colspan="2"><input type="submit" value="Assign Shedule">  </td>
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



