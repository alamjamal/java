<%@page import="com.ors.daos.impl.*" %>
<%@page import="com.ors.bean.*" %>
<%if(session.getAttribute("role")==null){%>
<jsp:forward page="/logoutaction"></jsp:forward>
<%} %>
<%
	String name=(String)session.getAttribute("user");
    String path=request.getSession().getServletContext().getRealPath("/userimages");
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
			<td colspan="1" width="1000" valign="top">
				<jsp:include page="adminmenu.jsp"></jsp:include><br/>
				<font color="#1B577C" size="4"><b><i>Welcome On Request Coordinater ,Here view the details of the user..</i></b></font>
				<p><br/></p>
				<%String username = request.getParameter("username"); %>
				<center><p><img alt="See Photo Here" id="previewField" src=<%=request.getContextPath()+"/userimages/"+username+".jpg" %> height="150" width="120"></p></center> 
     <br/>
     <table width="403" height="116" align="center" bordercolor="#FEE8B6">
       <tr><strong><span class="Title1"><u>Personal  Details<br/>
                 <br/>
       </u></span></strong></tr>
       <tr>
         <td width="128" bgcolor="#FEE8B6"><strong><span class="style14 Title">FirstName</span></strong></td>
         <td width="366" bgcolor="#FEE8B6"><span class="Title1"><strong><%=aprofile.getFirstname()%></strong></span></td>
       </tr>
       <tr>
         <td bgcolor="#FEE8B6"><span class="Title1"><strong>LastName</strong></span></td>
         <td bgcolor="#FEE8B6"><span class="Title1"><strong><%=aprofile.getLastname()%></strong></span></td>
       </tr>
       <tr>
         <td bgcolor="#FEE8B6"><span class="Title1"><strong>Privilege Type</strong></span></td>
         <td bgcolor="#FEE8B6"><span class="Title1"><strong><%=aprofile.getLogintype()%></strong></span></td>
       </tr>
       
       <tr>
         <td bgcolor="#FEE8B6"><span class="Title1"><strong>Dob</strong></span></td>
         <td bgcolor="#FEE8B6"><span class="Title1"><strong><%=aprofile.getBdate()%></strong></span></td>
       </tr>
       <tr>
         <td bgcolor="#FEE8B6"><span class="Title1"><strong>Email</strong></span></td>
         <td bgcolor="#FEE8B6"><span class="Title1"><strong><%=aprofile.getEmail()%></strong></span></td>
       </tr>
       <tr>
         <td bgcolor="#FEE8B6"><span class="Title1"><strong>Fax</strong></span></td>
         <td bgcolor="#FEE8B6"><span class="Title1"><strong><%=aprofile.getFax()%></strong></span></td>
       </tr>
     </table>
    
<table border="1" align="center" bordercolor="#000000" bgcolor="#CCCCCC" width="719" height="20%">
  <br/>
  <br/>
  <tr><strong><span class="Title"><u> Address Details<br/>
            <br/>
  </u></span></strong></tr>
  <tr>
    <td bgcolor="#CCCCCC"><div align="center" class="Title">Address Type </div>      </td>
    <td bgcolor="#CCCCCC"><div align="center" class="Title">HouseNo</div></td>
    <td bgcolor="#CCCCCC"><div align="center" class="Title">Street</div></td>
    <td bgcolor="#CCCCCC"><div align="center" class="Title">City</div></td>
    <td bgcolor="#CCCCCC"><div align="center" class="Title">State</div></td>
    <td bgcolor="#CCCCCC"><div align="center" class="Title">Country</div></td>
    <td bgcolor="#CCCCCC"><div align="center" class="Title">PhoneNo</div></td>
  </tr>
  <%if(aprofile.getHome()!=null){ %>
  <tr>
    <td bgcolor="#FFFFFF"><span class="Title">Home</span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getHno()%></span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getStreet()%></span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getCity()%></span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getState()%></span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getCountry()%></span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getPhone()%></span></td>
  </tr>
  <%}if(aprofile.getOffice()!=null){  %>
  <tr>
    <td bgcolor="#FFFFFF"><span class="Title">Office</span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getOhno()%></span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getOstreet()%></span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getOcity()%></span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getOstate()%></span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getOcountry()%></span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getOphone()%></span></td>
  </tr>
  <%}if(aprofile.getContact()!=null){  %>
  <tr>
    <td bgcolor="#FFFFFF"><span class="Title">Personal</span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getChno()%></span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getCstreet()%></span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getCcity()%></span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getCstate()%></span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getCcountry()%></span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getCphone()%></span></td>
  </tr>
  <%} %>
</table>      
				
 			     	
			</td>
			
		</tr>
		<tr>
			<td colspan="1" valign="bottom">
				<jsp:include page="Footer.jsp"></jsp:include>
			</td>
		</tr>
	</table>
</body>
</html>



