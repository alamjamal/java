
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
if (emptyvalidation(secretqid,"Please Choose A Secret Question")==false) {secretqid.focus(); return false;};
if (emptyvalidation(secretqans,"Please Give An Answer To Your Secret Question")==false) {secretqans.focus(); return false;};
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
				<jsp:include page="Menubeforelogin.jsp"></jsp:include><br/>&nbsp;&nbsp;&nbsp; 
				<font color="#1B577C" size="4"><b><i>Here you can recover your forgotten password...</i></b></font>
				
				 <br/>
				 <br/>
				 <jsp:include page="statusmsg.jsp"/> 
				 <br/>
				 <br/>
		    <FORM action=<%=request.getContextPath()+"/RecoverPasswordAction" %> method="post" name="register" onsubmit="return formvalidation(this)">
			<TABLE border="0" align="center" bgcolor="white" width=80%>
			<TR>
			<TD>
			<TABLE border="0" align="center">
                      

			
			<TR>
			<TD align="right"></TD>
			<TD>
			<TABLE border="0" align="center">
				<TR>
					<TD><span class=Title><font color="#1B577C"><b>Login Name</b></font></span></TD>
					<TD><INPUT type="text" name="username"/></TD>
				</TR>
				<TR>
					<TD><span class=Title><font color="#1B577C"><b>Secret Question</b></font></span></TD>
					<TD><span class=Title><select name="secretqid">
			      <option value="select" selected="true"><font size="3" face="Verdana">--Select One---</font></option>
			      <option value="What is your favorite pastime?"><font size="3" face="Verdana">What is your favorite pastime?</font></option>
			      <option value="Who your childhood hero?"><font size="3" face="Verdana">Who your childhood hero?</font></option>
			      <option value="What is the name of your first school?"><font size="3" face="Verdana">What is the name of your first school?</font></option>
			      <option value="Where did you meet your spouse?"><font size="3" face="Verdana">Where did you meet your spouse?</font></option>
			      <option value="What is your favorite sports team?"><font size="3" face="Verdana">What is your favorite sports team?</font></option>
			      <option value="What is your father middle name?"><font size="3" face="Verdana">What is your father middle name?</font></option>
			      <option value="What was your high school mascot?"><font size="3" face="Verdana">What was your high school mascot?</font></option>
			      <option value="What make was your first car or bike?"><font size="3" face="Verdana">What make was your first car or bike?</font></option>
			      <option value="What is your pet name?"><font size="3" face="Verdana">What is your pet name?</font></option></select></span></TD>
				</TR>
				
				<TR>
					<TD><span class=Title><font color="#1B577C"><b>Secret Answer</b></font></span></TD>
					<TD><INPUT name="secretqans" type="text"/></TD>
				</TR>
				<TR><TD colspan="2"><span class=Title><DIV align="center">
						<INPUT name="Input" type="submit" value="Recover"/>&nbsp;
						<INPUT name="Input" type="reset" value="Clear"/>
				</DIV></span></TD></TR>
			</TABLE>
						

		</TD>
						

		<TD>&nbsp;
						

			
						

	  </TD>
						

	</TR>
						

</TABLE>
					</TD>
				</TR>
			</TABLE>
		</FORM>     
          
			</td>
			<td colspan="1" width="300" height="300" valign="top" align="right">
				<img src="<%=request.getContextPath() %>/images/login3.jpg" height="300" width="300"/>
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



