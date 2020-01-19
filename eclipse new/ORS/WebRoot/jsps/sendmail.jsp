<%@page import="com.ors.daos.impl.*" %>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ors.bean.*"%>
<%@page import="java.util.Iterator"%>
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
if (emptyvalidation(receiver,"Please Enter A Recipient")==false) {receiver.focus(); return false;};
if (emptyvalidation(subject,"Please Enter A Subject")==false) {subject.focus(); return false;};
if (emptyvalidation(message,"Please Enter Some Message")==false) {message.focus(); return false;};
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
						<font color="#1B577C" size="4"><b><i>Welcome On Request Coordinater,Here You Can Send Mail To Different Departments</i></b></font>
					</c:when>
					<c:when test="${sessionScope.role eq 'department'}">
						<jsp:include page="deptmenu.jsp"></jsp:include><br/>
						<font color="#1B577C" size="4"><b><i>Welcome H.O.D Of Department <%=new ProfileDAOImpl().getDeptname(((String)session.getAttribute("user")))%>,Here You Can Send Mail To On Request Cordinator</i></b></font>
					</c:when>
					<c:when test="${sessionScope.role eq 'faculty'}">
						<jsp:include page="usermenu.jsp"></jsp:include><br/>
						<font color="#1B577C" size="4"><b><i>Welcome  <%=(String)session.getAttribute("user")%>,Here You Can Send Mail To On Request Cordinator</i></b></font>
					</c:when>
				</c:choose><br/>
				<jsp:include page="statusmsg.jsp"/>
				<form method="post" action=<%=request.getContextPath()+"/MailAction" %> name="myform" onsubmit="return formvalidation(this)">
					<table align="center" width="548">
					<tr>
						<td width="5" valign="top"><font color="#1B577C"><b>To :&nbsp;</b></font></td>
						<c:choose>
					<c:when test="${sessionScope.role eq 'admin'}">
					<%
						ArrayList<ProfileTO> deptlist=new ProfileDAOImpl().getDeptList();
												Iterator it=deptlist.iterator();
					%>
						<td width="540"><select name="receiver" style="width: 110mm">
						<option value="">--Choose A Department or Faculty--</option>
						<%
							if(deptlist.size()!=0){
											while(it.hasNext()){
											  ProfileTO pf=(ProfileTO)it.next();
						%>
						 <option value="<%=pf.getUserid() %>"><%=pf.getDeptname() %>(<%=(pf.getLogintype()).toUpperCase() %>) </option>
						 <%}} %>
						</select> <br></td>
					</c:when>
					<c:otherwise>
						<td><input type="text" name="" value="On Request Coordinater" size="65" readonly="readonly" > <br></td>
						<input type="hidden" name="receiver" value="1001">
					</c:otherwise>
				</c:choose>
						
					</tr>
                    <tr>
						<td width="5" valign="top"><font color="#1B577C"><b>Subject :&nbsp;</b></font></td>
						<td width="540"><input type=text name="subject" size="65"><br></td>
					</tr>
                     <tr>
						<td width="5" valign="top"><font color="#1B577C"><b>Message :&nbsp;</b></font></td>
						<td width="540"><textarea name="message" cols="49" rows="5"></textarea><br></td>
					</tr>
                      <tr>
						<td colspan="2" align="center"><br><a href="javascript:document.myform.submit()" 
																onclick="return formvalidation(document.myform)">
																
																<img src=<%=request.getContextPath()+"/images/form-button-send.gif" %> 
																width="70" height="25" border="0" alt="Send this mail" 
																name="sub_but" /></a>
						</td>
						
					</tr>                       
                    
					</table>        
				</form>
 			     	
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



