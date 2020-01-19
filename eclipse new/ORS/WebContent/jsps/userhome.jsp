<%@page import="com.ors.daos.impl.*" %>

<% 
  // get client locale
  java.util.Locale locale = request.getLocale();
 
  // get Dateformat for client's locale
  java.text.DateFormat dateFormat =
	 java.text.DateFormat.getDateTimeInstance(
		 java.text.DateFormat.LONG,
		 java.text.DateFormat.LONG, locale);     
%>
<%if(session.getAttribute("role")==null){%>
<jsp:forward page="/logoutaction"></jsp:forward>
<%} %>
<html>
<head>

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
				<jsp:include page="usermenu.jsp"></jsp:include><br/>
				<font color="#1B577C" size="4"><b><i>Welcome <%=(String)session.getAttribute("user") %>,To The Faculty Home Page Of</i></b></font>
				<br/><br/>
				<center><h2><font color="green"><b> ON REQUEST COURSES COORDINATION </b></font> </h2></center>
				<jsp:include page="statusmsg.jsp"/><br/>
 				<center><font color="#1B577C"><b><%=dateFormat.format( new java.util.Date() ) %><br/><br/>Your lastlogin:<%=new LogInDetailsDAOImpl().getLoginDate((String)session.getAttribute("user"))%> </b></font></center>	
			</td>
			<td colspan="1" width="300" height="270" valign="top" align="right">
				<img src=<%=request.getContextPath()+"/images/training4.jpg" %> height="270" width="300"/>
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



