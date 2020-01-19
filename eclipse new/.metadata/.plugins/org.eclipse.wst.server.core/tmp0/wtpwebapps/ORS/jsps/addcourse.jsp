
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
if (emptyvalidation(coursename,"Please Enter An CourseName")==false) {coursename.focus(); return false;};
if (emptyvalidation(coursedetails,"Please Write Something About Course Details")==false) {coursedetails.focus(); return false;};
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
				<font color="#1B577C" size="4"><b><i>Welcome On Request Coordinater ,Here you can add a new course...</i></b></font>
				<br/><br/>
					<jsp:include page="statusmsg.jsp"></jsp:include>
				<br/><br/>
				<form action=<%=request.getContextPath()+"/AddCourseAction" %> method="post" onsubmit="return formvalidation(this)">         
         	<table align="center" width="550">
         		<tr>
         			<td><font color="#1B577C"><b>Course Name </b> </font> </td>
         			<td><input type="text" name="coursename" size="20"> </td>
         		</tr>
         		<tr>
         			<td><font color="#1B577C"><b>Course Details </b> </font> </td>
         			<td><textarea name="coursedetails" cols="50" rows="4"></textarea> </td>
         		</tr>
         		<tr>
         			<td align="center" colspan="2"><input type="submit" value="Register Course">  </td>
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



