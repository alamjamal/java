
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
if (emptyvalidation(username,"Please Enter An User Name")==false) {username.focus(); return false;};
if (emptyvalidation(password,"Please Enter A Password")==false) {password.focus(); return false;};
}
}
</script>
</head>
<body topmargin="0" leftmargin="0"  marginwidth="0" marginheight="0" background=<%=request.getContextPath()+"/images/web-background.png" %> >
	<jsp:include page="Header.jsp"></jsp:include>
	
	<table width="100%" align="left" border="0" style="vertical-align: top;">
		
		<tr>
			<td colspan="1" width="900" height="300" valign="top">
				<jsp:include page="Menubeforelogin.jsp"></jsp:include><br/>&nbsp;&nbsp;&nbsp; 
				<font color="#1B577C" size="4"><b><i>Login Here...</i></b></font>
				
				 <jsp:include page="statusmsg.jsp"/>      
          <form action=<%=request.getContextPath()+"/LoginAction" %> method=post onsubmit="return formvalidation(this)">
        <table  border="0" align="center"  bgcolor="white" width="80%">
               <tr>
                 <td height="120" align="right"></td>
                 <td><table border="0" align="center">
                   <tr>
                     <td ><span class="Title"><font color="#1B577C"><b>UserID</b></font></span></td>
                      <td ><input type="#1B577C" name="username"/>                      </td>
                      </tr>
                   <tr>
                     <td><span class="Title"><font color="#1B577C"><b>Password</b></font></span></td>
                      <td>
                        <input type="password" name="password"/>                      </td>
                      </tr>
                      <tr>
                     <td colspan="2"><p><br/></p></td>
                      </tr>
                   <tr>
                     <td colspan="2" align="center">
                         <input type="image" src=<%=request.getContextPath()+"/images/LOGINBUTTON.jpg" %> height="30" width="100"/>
                     </td>
                      </tr>
                 </table></td>
                 <td>&nbsp;</td>
               </tr>
               <tr>
                 <td >&nbsp;</td>
                 <td>
                 <div align="center"><a href="<%=request.getContextPath() %>/jsps/Recoverpassword.jsp"><strong><font color="#1B577C">Forgot Password ! !......</font></strong></a></div></td>
                 <td>&nbsp;</td>
               </tr>
               
               
             </table>
		
		
          </form>
			
		</tr>
		<tr>
			<td colspan="2" valign="bottom">
				<jsp:include page="Footer.jsp"></jsp:include>
			</td>
		</tr>
	</table>
</body>
</html>



