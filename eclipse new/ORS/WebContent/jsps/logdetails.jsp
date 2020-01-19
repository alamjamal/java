
<%@page import="java.util.ArrayList"%>
<%@page import="com.ors.bean.*"%>
<%@page import="java.util.ListIterator"%>
<%@page import="com.ors.daos.impl.*" %>


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
				<font color="#1B577C" size="4"><b><i>Welcome On Request Coordinater , here is the log details of the required user</i></b></font>
				<br/><br/>
					<jsp:include page="statusmsg.jsp"></jsp:include>
				<br/><br/>
				         
         	<!--START OF PAGENATION-->
<%
	String pa = request.getParameter("page");
           
         ArrayList<ProfileTO> ar=(ArrayList<ProfileTO>)session.getAttribute("logdetailsarray");
          int pageNo=0;
          if(pa==null)
            pageNo=0;
           else
           pageNo=Integer.parseInt(pa);
           int totalrows=ar.size();
           int totalpages=totalrows/5;
           if(totalrows%5!=0)
           totalpages=totalpages+1;
  	      int startrow=(pageNo*5)+1;
  	      int endrow=(pageNo*5)+5;
  	      if(endrow>totalrows)
  	          endrow=totalrows;
%>
  	     <table border=1 align="center">
  	     <%
  	     	try{
  	                	if(ar.size()!=0)
  	                	{
  	     %>
  
  	<tr bgcolor="#cyan">
  	<td bgcolor="#E0FEFD"><div align="center" class="style16"><font color="blue">Sl No</font></div></td>
    <td bgcolor="#E0FEFD"><div align="center" class="style16"><font color="blue">LogInDate</font></div></td>
    <td bgcolor="#E0FEFD"><div align="center" class="style16"><font color="blue">LogInTime</font></div></td>
    <td bgcolor="#E0FEFD"><div align="center" class="style16"><font color="blue">LogOffTime</font></div></td>      
      </tr>
          <%
          	ProfileTO aProfile;
                       for(int intIndex =startrow-1; intIndex < endrow; intIndex++)     
                      {
                         aProfile = (ProfileTO)ar.get(intIndex);
          %>
      	<tr bgcolor="#C3D7BA">
      	<td bgcolor="#FEE8B6" width="74"><center><%=intIndex+1 %></center></td>
    	<td bgcolor="#FEE8B6" width="98"><center><%=aProfile.getLogindate() %></center></td>
    	<td bgcolor="#FEE8B6" width="100"><center><%=aProfile.getLogintime() %></center></td>
    	<td bgcolor="#FEE8B6"><center><%=aProfile.getLogofftime() %></center></td>
         </tr>
      <%} 
      %></table>
      <table align="center"><tr><td width="100%">
      (<%=startrow %>-<%if(endrow>totalrows)endrow=totalrows;%><%=endrow %> of <%=totalrows %> Total)
      <%if(pageNo>0) {%><a href='<%=request.getContextPath()%>/jsps/logdetails.jsp'>First</a>|<a href='<%=request.getContextPath()%>/jsps/logdetails.jsp?page=<%=pageNo-1%>'><< |</a><%} %>
      <%
     // int count=0;
      for(int i=0;i<totalpages;i++){
      if((i==pageNo-2)||(i==pageNo-1)||(i==pageNo)||(i==pageNo+1)||(i==pageNo+2)){
      if(!(pageNo==i)){%><a href='<%=request.getContextPath()%>/jsps/logdetails.jsp?page=<%=i %>'><%}%> <%=(i+1) %></a> | 
      <%//count++;
      }
      //if(count==5)break;
      }
      %><%if(pageNo<totalpages-1) {%><a href='<%=request.getContextPath()%>/jsps/logdetails.jsp?page=<%=pageNo+1%>'>>> |</a><a href='<%=request.getContextPath()%>/jsps/logdetails.jsp?page=<%=totalpages-1%>'>Last</a><%} %></td></tr>
      <%
      
      }
      
      else 
      {%>
         <tr><td height="24" colspan="6"><div align="center" class="style3"><strong><font color="red">No Records Found</font></strong></div></td>
         </tr>
      <%}
      }
      catch(Exception e){}
       
       %>
    </table>
					
<!--End of pagenation  -->
         	
 			     	
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



