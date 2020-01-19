<%@page import="com.ors.daos.impl.*" %>
<%@page import="com.ors.bean.*" %>

<%if(session.getAttribute("role")==null){%>
<jsp:forward page="/logoutaction"></jsp:forward>
<%} %>
<%
	ProfileTO aprofile=(ProfileTO)request.getAttribute("bean");
%>
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
				<jsp:include page="adminmenu.jsp"></jsp:include><br/>
				<font color="#1B577C" size="4"><b><i>Welcome On Request Coordinater , here is the details of required user(This is a department..)</i></b></font>
				<br/><br/>
					<jsp:include page="statusmsg.jsp"></jsp:include>
				<br/><br/>
				         
         	<table align="center" width="550" border="1">
         		<tr>
         			<td align="left"><font color="#1B577C"><b>Department LoginId  </b> </font> </td>
         			<td><font color="#1B577C"><b><%=request.getParameter("username") %>  </b> </font> </td>
         		</tr>
         		<tr>
         			<td align="left"><font color="#1B577C"><b>Department Name  </b> </font> </td>
         			<td><font color="#1B577C"><b><%=aprofile.getFirstname() %>  </b> </font> </td>
         		</tr>
         		<tr>
         			<td align="left"><font color="#1B577C"><b>Department Fax No  </b> </font> </td>
         			<td><font color="#1B577C"><b><%=aprofile.getFax() %>  </b> </font> </td>
         		</tr>
         	</table>
         	
 			     	
			</td>
			<td colspan="1" width="300" height="300" valign="top" align="right">
				<img src=<%=request.getContextPath()+"/images/admin1.jpeg" %> height="300" width="300"/>
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



