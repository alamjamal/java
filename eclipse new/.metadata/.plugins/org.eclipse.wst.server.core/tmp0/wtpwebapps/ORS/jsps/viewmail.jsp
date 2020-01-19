
<%@page import="com.ors.daos.impl.*" %>
<%@page import="com.ors.bean.MailTO"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	if(session.getAttribute("role")==null){
%>
<jsp:forward page="/logoutaction"></jsp:forward>
<%
	}
%>
<%
	int mailid=Integer.parseInt(request.getParameter("mailid"));
	MailTO md=new MailDAOImpl().getMail(mailid);
	new MailDAOImpl().changeMailStatus(mailid);
%>

<html>
<head>
<script type="text/javascript" src=<%=request.getContextPath()+"/scripts/checkboxvalidation.js" %>></script>
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
						<font color="#1B577C" size="4"><b><i>Welcome On Request Cordinater,Here You Can See Your Mails</i></b></font>
					</c:when>
					<c:when test="${sessionScope.role eq 'department'}">
						<jsp:include page="deptmenu.jsp"></jsp:include><br/>
						<font color="#1B577C" size="4"><b><i>Welcome H.O.D Of Department <%=new ProfileDAOImpl().getDeptname(((String)session.getAttribute("user")))%>,Here You Can See Your Mails</i></b></font>
					</c:when>
					<c:when test="${sessionScope.role eq 'faculty'}">
						<jsp:include page="usermenu.jsp"></jsp:include><br/>
						<font color="#1B577C" size="4"><b><i>Welcome <%=(String)session.getAttribute("user") %>,Here You Can See Your Mails</i></b></font>
					</c:when>
				</c:choose><br/>
				<jsp:include page="statusmsg.jsp"/>
				<table align="center" width="548" border="1" bordercolor="#FFDEE0" bgcolor="#F3F6EF">
					<tr>
						<td width="5" valign="top"><font color="blue"><b>From : </b></font></td>
						<td width="540"><b><%=md.getFrom() %></b><br/></td>
					</tr>
                    <tr>
						<td width="5" valign="top"><font color="blue"><b>Subject : </b></font></td>
						<td width="540"><b><%=md.getSubject() %></b><br/></td>
					</tr>
					<tr>
						<td width="5" valign="top"><font color="blue"><b>Date : </b></font></td>
						<td width="540"><b><%=md.getMaildate() %></b><br/></td>
					</tr>
					<tr>
						<td align="center" valign="top" colspan="2"><font color="blue"><b>Message</b></font></td>
					</tr>
                     <tr>
						<td  colspan="2" valign="top" height="150"><br/><%=md.getContent() %><br></td>
					</tr>                
                    </table>
  
				
 			     	
			</td>
			<td colspan="1" width="300" height="300" valign="top" align="right">
				<img src=<%=request.getContextPath()+"/images/Training.20085544_std.jpg" %> height="300" width="300"/>
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



