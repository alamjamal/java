
<%@page import="com.ors.daos.impl.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


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
if (emptyvalidation(username,"Please Enter An UserName")==false) {username.focus(); return false;};
if (emptyvalidation(password,"Please Enter The Oldpassword")==false) {password.focus(); return false;};
if (emptyvalidation(newpassword,"Please Enter The Newpassword")==false) {newpassword.focus(); return false;};
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
				<c:choose>
					<c:when test="${sessionScope.role eq 'admin'}">
						<jsp:include page="adminmenu.jsp"></jsp:include><br/>
						<font color="#1B577C" size="4"><b><i>Welcome On Request Coordinater,Here You Can Change Your Password</i></b></font>
					</c:when>
					<c:when test="${sessionScope.role eq 'department'}">
						<jsp:include page="deptmenu.jsp"></jsp:include><br/>
						<font color="#1B577C" size="4"><b><i>Welcome H.O.D Of Department <%=new ProfileDAOImpl().getDeptname(((String)session.getAttribute("user")))%>,Here You Can Change Your Password</i></b></font>
					</c:when>
					<c:otherwise>
					<jsp:include page="usermenu.jsp"></jsp:include><br/>
					<font color="#1B577C" size="4"><b><i>Welcome <%=(String)session.getAttribute("user") %>,Here You Can Change Your Password</i></b></font>
					</c:otherwise>
				</c:choose>
				
				<br/>
				<jsp:include page="statusmsg.jsp"/><br/>
				
				<p><br/></p>
				
				
		<form method="post" onsubmit="return formvalidation(this)" action=<%=request.getContextPath()+"/ChangePasswordAction" %>>
			<table border="0" align="center">
				<tr>
					<td><span class=Title>
					 <font color="blue"><b> Login Name</b></font>
					</span></td>
					<td><input type="text" name="username" value='<%=(String)session.getAttribute("user") %>' readonly="readonly"/></td>
				</tr>
				<tr>
					<td><span class=Title>
					 <font color="blue"><b> Old Password</b></font>
					</span></td>
					<td>
						<input type="password" name="password" />					</td>
				</tr>
				<tr>
					<td><span class=Title>
					  <font color="blue"><b>New Password</b></font>
					</span></td>
					<td>
						<input type="password" name="newpassword" />					</td>
				</tr>
				<tr>
					<td colspan="2">
						<div align="center"><strong>
						  <input type="submit" name="Submit" value="Change" />
						</strong></div>				  </td>
				</tr>
			</table>
		</form>
 				 			     	
			</td>
			<td colspan="1" width="300" height="300" valign="top" align="right">
				<img src=<%=request.getContextPath()+"/images/membersloginright.jpg" %> height="300" width="300"/>
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



