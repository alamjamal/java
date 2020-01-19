<%@page import="com.ors.daos.impl.*" %>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ors.bean.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.ors.bean.RequestTO"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	if(session.getAttribute("role")==null){
%>
<jsp:forward page="/logoutaction"></jsp:forward>
<%
	}
%>
<%
	String username=(String)session.getAttribute("user");
	ArrayList<RequestTO> ar=new RequestDAOImpl().getAllRequestList();
%>

<html>
<head>
<script type="text/javascript">

function reply(id,page,user,path)
{
	
	var status=prompt("Please Enter The Status Of The Request..");
	
	if(status==null || status=="" || status=="undefined")
	{
		return false;
	}
	else{
		var url=path+'/ReplyAction?requestid='+id+'&page='+page+'&username='+user+'&status='+status;
		window.location.href=url;
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
						<jsp:include page="adminmenu.jsp"></jsp:include><br/>
						<font color="#1B577C" size="4"><b><i>Welcome On Request Coordinater,Here You Can View And Reply A Request..</i></b></font>
					<br/><br/>
				<jsp:include page="statusmsg.jsp"/>
				<br/><br/>
				
				<!--START OF PAGINATION-->
<%
	String pa = request.getParameter("page");
           
         
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
	  	<td bgcolor="#E0FEFD"><div align="center" class="style16"><font color="#1B577C">Sl No</font></div></td>
	  	<td bgcolor="#E0FEFD"><div align="center" class="style16"><font color="#1B577C">FormDept</font></div></td>
	    <td bgcolor="#E0FEFD"><div align="center" class="style16"><font color="#1B577C">CourseDetails</font></div></td>
	    <td bgcolor="#E0FEFD"><div align="center" class="style16"><font color="#1B577C">Course Duration</font></div></td>
	    <td bgcolor="#E0FEFD"><div align="center" class="style16"><font color="#1B577C">No Of Participants</font></div></td>
	    <td bgcolor="#E0FEFD"><div align="center" class="style16"><font color="#1B577C">ParticipantsBackGround</font></div></td>
	    <td bgcolor="#E0FEFD"><div align="center" class="style16"><font color="#1B577C">Expected Date (To Start Course)</font></div></td>
	    <td bgcolor="#E0FEFD"><div align="center" class="style16"><font color="#1B577C">Outside Faculty (If Required)</font></div></td>
	    <td bgcolor="#E0FEFD"><div align="center" class="style16"><font color="#1B577C">Status</font></div></td>
	    <td bgcolor="#E0FEFD"><div align="center" class="style16"><font color="#1B577C">Reply</font></div></td>
	    
	    
	    
          <%
	    	    	              	RequestTO rd=null;
	    	    	                           for(int intIndex =startrow-1; intIndex < endrow; intIndex++)     
	    	    	                          {
	    	    	                             rd = (RequestTO)ar.get(intIndex);
	    	    	              %>
         <tr bgcolor="#C3D7BA">
      	<td bgcolor="#FFFFFF" width="40"><center><%=intIndex+1 %></center></td>
      	<td bgcolor="#FFFFFF" width="100"><center><%=rd.getFrom()%> </center></td>
    	<td bgcolor="#FFFFFF" width="250"><center><%=rd.getCoursedetails()%> </center></td>
    	<td bgcolor="#FFFFFF" width="40"><center><%=rd.getCourseduration()%> </center></td>
    	<td bgcolor="#FFFFFF" width="40"><center><%=rd.getPartcipentno()%> </center></td>
    	<td bgcolor="#FFFFFF" width="250"><center><%=rd.getPartcipentbackground()%> </center></td>
    	<td bgcolor="#FFFFFF" width="130"><center><%=rd.getStartingdate()%> </center></td>
    	<td bgcolor="#FFFFFF" width="40"><center><%=rd.getFacultyflag()%> </center></td>
    	<td bgcolor="#FFFFFF" width="100"><center><%=rd.getStatus()%> </center></td>
    	<td bgcolor="#FFFFFF" width="100"><center><a href="#" onClick="return reply(<%=rd.getRequestid() %>,<%=pageNo %>,<%=rd.getFromid() %>,'<%=request.getContextPath() %>')"> Reply </a> </center></td>
    	
    	
      <%} %>
      </table>
      <table align="center"><tr><td width="100%">
      (<%=startrow %>-<%if(endrow>totalrows)endrow=totalrows;%><%=endrow %> of <%=totalrows %> Total)
      <%if(pageNo>0) {%><a href='<%=request.getContextPath()%>/jsps/replyrequest.jsp'>First</a>|<a href='<%=request.getContextPath()%>/jsps/replyrequest.jsp?page=<%=pageNo-1%>'><< |</a><%} %>
      <%
     // int count=0;
      for(int i=0;i<totalpages;i++){
      if((i==pageNo-2)||(i==pageNo-1)||(i==pageNo)||(i==pageNo+1)||(i==pageNo+2)){
      if(!(pageNo==i)){%><a href='<%=request.getContextPath()%>/jsps/replyrequest.jsp?page=<%=i %>'><%}%> <%=(i+1) %></a> | 
      <%//count++;
      }
      //if(count==5)break;
      }
      %><%if(pageNo<totalpages-1) {%><a href='<%=request.getContextPath()%>/jsps/replyrequest.jsp?page=<%=pageNo+1%>'>>> |</a><a href='<%=request.getContextPath()%>/jsps/replyrequest.jsp?page=<%=totalpages-1%>'>Last</a><%} %></td></tr>
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
					
<!--End of pagination  -->
					        
				
 			     	
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



