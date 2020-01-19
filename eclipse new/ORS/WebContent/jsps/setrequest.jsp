

<%@page import="com.ors.daos.impl.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
if (emptyvalidation(coursedetails,"Please Specifie Course Details")==false) {coursedetails.focus(); return false;};
if (emptyvalidation(courseduration,"Please Enter Course Duration")==false) {courseduration.focus(); return false;};
if (emptyvalidation(partcipentno,"Please Enter No Of Participents")==false) {partcipentno.focus(); return false;};
if (emptyvalidation(partcipentbackground,"Please Specifie participent Backgrounds")==false) {partcipentbackground.focus(); return false;};
if (emptyvalidation(startingdate,"Please Specifie Your Expected Date To Start Batch")==false) {startingdate.focus(); return false;};

var length1=document.getElementById("coursedetails").value.length;
if(length1<5 || length1>50)
{
	alert("The course details field must contain more than 5 characters and less than 50 characters");
	return false;
}
var value1=document.getElementById("courseduration").value;
if(isNaN(value1))
{
	alert("The Course Duration Should Be A Number");
	return false;
}
var value1=document.getElementById("partcipentno").value;
if(isNaN(value1))
{
	alert("The Course Duration Should Be A Number");
	return false;
}

var length2=document.getElementById("partcipentbackground").value.length;
if(length2<5 || length2>50)
{
	alert("The participent background field must contain more than 5 characters and less than 50 characters");
	return false;
}
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
			<td colspan="1"  valign="top">
					
						<jsp:include page="deptmenu.jsp"></jsp:include><br/>
						<font color="#1B577C" size="4"><b><i>Welcome H.O.D Of Department <%=new ProfileDAOImpl().getDeptname(((String)session.getAttribute("user")))%>,Here You Can Send A New Request To On_Request Coordinator To Start New Batch..</i></b></font>
					<br/><br/>
				<jsp:include page="statusmsg.jsp"/>
				<br/><br/>
				<form action=<%=request.getContextPath()+"/SetRequestAction" %> name="requestform" method="post" onsubmit="return formvalidation(this)">
				<table border="0" align="center">
					<tr>
						<td><font color="#1B577C"><b>Course Details<br/>(Less than 50 letters)</b> </font> </td>
						<td><textarea name="coursedetails" rows="3" cols="50"></textarea> </td>
					</tr>
					<tr>
						<td align="center" colspan="2"><P><BR/></P> </td>
					</tr>
					<tr>
						<td><font color="#1B577C"><b>Course Duration<br/>(In Days) </b> </font> </td>
						<td><input type="text" name="courseduration" style="width: 112mm"> </td>
					</tr>
					<tr>
						<td align="center" colspan="2"><P><BR/></P> </td>
					</tr>
					<tr>
						<td><font color="#1B577C"><b>No Of Participants </b> </font> </td>
						<td><input type="text" name="partcipentno" style="width: 112mm"> </td>
					</tr>
					<tr>
						<td align="center" colspan="2"><P><BR/></P> </td>
					</tr>
					<tr>
						<td><font color="#1B577C"><b>Back Ground Of Participants<br/>(Less than 50 letters) </b> </font> </td>
						<td><textarea name="partcipentbackground" rows="3" cols="50"></textarea> </td>
					</tr>
					<tr>
						<td align="center" colspan="2"><P><BR/></P> </td>
					</tr>
					<tr>
						<td><font color="#1B577C"><b>Expected Date To Start </b> </font> </td>
						<td><input type="text" name="startingdate" value="" readonly="readonly"  style="width: 105mm"/><a href="javascript:show_calendar('document.requestform.startingdate', document.requestform.startingdate.value);"> <img src=<%=request.getContextPath()+"/images/cal.gif" %> alt="a" width="18" height="18" border="0"/></a></td>
					</tr>
					<tr>
						<td align="center" colspan="2"><P><BR/></P> </td>
					</tr>
					<tr>
						<td> <font color="#1B577C"><b>External Faculty Help Required<br/>if neccessary comes </b> </font> </td>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio" name="facultyflag" value="yes"><font color="#1B577C"><b>Yes</b></font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio" name="facultyflag" value="no" checked="checked"><font color="#1B577C"><b>No</b></font></td>
					</tr>
					<tr>
						<td align="center" colspan="2"><P><BR/></P> </td>
					</tr>
					<tr>
						<td align="center" colspan="2"><font color="#1B577C"><b><input type="submit" value="SEND REQUEST"> </b> </font> </td>
					</tr>
					
				</table>
		     	</form>
			</td>
			
		</tr>
		<tr><td><p><br/></p></td> </tr>
		<tr>
			<td colspan="1" valign="bottom">
				<jsp:include page="Footer.jsp"></jsp:include>
			</td>
		</tr>
	</table>
</body>
</html>



