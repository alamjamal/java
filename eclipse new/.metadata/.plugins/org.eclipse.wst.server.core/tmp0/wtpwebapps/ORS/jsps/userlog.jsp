<%@page import="com.ors.daos.impl.*" %>


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
if (emptyvalidation(username,"Please Enter An UserName")==false) {username.focus(); return false;};
if (emptyvalidation(fromdate,"Please Enter An From Date")==false) {fromdate.focus(); return false;};
if (emptyvalidation(todate,"Please Enter An To Date")==false) {todate.focus(); return false;};
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
				<font color="#1B577C" size="4"><b><i>Welcome On Request Coordinater , here you can view the login details of user...</i></b></font>
				<br/><br/>
					<jsp:include page="statusmsg.jsp"></jsp:include>
				<br/><br/>
				<form action=<%=request.getContextPath()+"/logindetailsaction" %> method="post" name="ViewAllUser" onsubmit="return formvalidation(this)">         
         	<table align="center" width="548">
         		<tr>
         			<td width="620">
         				<center><font color="#1B577C"><b>Enter The User LogInName</b></font> &nbsp; &nbsp; 
         				<input type="text" name="username"/>
         				<br/> 
         				 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp; <font color="#1B577C"><b>From Date &nbsp; &nbsp;  </b></font><input type="text" name="fromdate" value="" size="20" readonly="readonly" /><a href="javascript:show_calendar('document.ViewAllUser.fromdate', document.ViewAllUser.fromdate.value);"> <img src=<%=request.getContextPath()+"/images/cal.gif" %> alt="a" width="18" height="18" border="0"/></a>
         				<br/> 
         				&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; <font color="#1B577C"><b>To Date &nbsp; &nbsp;  </b></font><input type="text" name="todate" value="" size="20" readonly="readonly" /><a href="javascript:show_calendar('document.ViewAllUser.todate', document.ViewAllUser.todate.value);"> <img src=<%=request.getContextPath()+"/images/cal.gif" %> alt="a" width="18" height="18" border="0"/></a>
         				<br/>
         				<br/>
         				<input type="submit" name="submit" value="SUBMIT"/>
         				</center>
         			</td>
         		</tr>
         	</table>
         	</form>         
         	
			</td>
			<td colspan="1" width="300" height="300" valign="top" align="right">
				<img src=<%=request.getContextPath()+"/images/login3.jpg" %> height="300" width="300"/>
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



