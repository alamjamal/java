

<%if(session.getAttribute("role")==null){%>
<jsp:forward page="/logoutaction"></jsp:forward>
<%} %>
<html>
<head>
<link href="scripts/MyStyle.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="scripts/gen_validatorv31.js" type="text/javascript"></script>
<script language="JavaScript" type="text/javascript" src="scripts/ts_picker.js"></script>
<script language="JavaScript1.1" src="scripts/pass.js"></script> 
<script type="text/javascript" src="scripts/image.js"> </script>
 <script type="text/javascript" src="scripts/general.js"> </script>
 <script type="text/javascript" src="scripts/adi.js"> </script>
 <script type="text/javascript" src="scripts/form_validation.js"> </script>

		<script language="JavaScript" src="images/javascripts.js"></script>
		<script language="JavaScript" src="images/pop-closeup.js"></script>
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

function validate(thisform)
{
with (thisform)
{
if (emptyvalidation(username,"Please Enter An User Name")==false) {username.focus(); return false;};
if (emptyvalidation(password,"Please Enter A Password")==false) {password.focus(); return false;};
if (emptyvalidation(conformpassword,"Please Enter The Confirm Password")==false) {conformpassword.focus(); return false;};
if (emptyvalidation(secretqid,"Please Choose A Security Quesstion")==false) {secretqid.focus(); return false;};
if (emptyvalidation(secretqans,"Please Answer Your Security Question..")==false) {secretqans.focus(); return false;};
if (emptyvalidation(deptname,"Please Enter A Department Name")==false) {deptname.focus(); return false;};
if (emptyvalidation(fax,"Please Enter A Department Fax No")==false) {fax.focus(); return false;};
}
}

function goOn() {
var port=document.register.port.value;
var host=document.register.host.value;
var userName=document.register.username.value;
window.location.href='http://'+host+':'+port+'/ORS/ChekUserAction?username='+userName+'&formname=dept';

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
				<jsp:include page="adminmenu.jsp"></jsp:include><br/>&nbsp;&nbsp;&nbsp; 
				<font color="#1B577C" size="4"><b><i>Registration form for new dept....</i></b></font>
				<br/>
				 <br/>
				 <jsp:include page="statusmsg.jsp"/> 
				 <br/>
				 <br/>
 <form action=<%=request.getContextPath()+"/DeptRegisterAction" %> method="post" name="register"  onSubmit="return validate(this)">
 <!--<table border="1"><tr><td></td></tr></table>-->
 <input type="hidden" name="port" value="<%=request.getLocalPort() %>">
 <input type="hidden" name="host" value="<%=request.getServerName() %>">
 <br>
 
<table align="left" width=70%>

<tr></tr><tr></tr>
<tr>
    <td><pre><span class=Title>    User Name</span></pre></td>
    <td width="303"><input type="text" name="username" value="<%if(request.getParameter("username")!=null)out.print(request.getParameter("username")); %>" size="20" onBlur="goOn()"/>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=Title><%if(request.getAttribute("checkuser")!=null)                                       out.print(request.getAttribute("checkuser"));    %></span></td>
</tr>
<tr>
 <td><pre><span class=Title>    PassWord</span></pre></td>
  <td>
    
        <input type="password" name="password"  onkeyup="testPassword(document.forms.register.password.value);" onChange="Encrypt(document.forms.register.password.value);"></td></tr>
        <tr><td></td><td>
     <span class=Title><a id="Words"> Strength:</a></td>
      <td><table cellpadding=0 cellspacing=0><tr><td height=15  bgcolor=#dddddd></td></tr></table></td>
</tr>
<tr>
    <td><pre><span class=Title>    Confirm</span><pre></td>
    <td><input type="password" name="conformpassword" value="" size="20" onBlur="checkconformpassword()"/></td>
   </tr>
   
<tr>
    <td><pre><span class=Title>    SecurityQuestion</span></pre></td>
    <td><select name="secretqid">
      <option value="" selected="true"><font size="3" face="Verdana">--Select One---</font></option>
      <option value="What is your favorite pastime?"><font size="3" face="Verdana">What is your favorite pastime?</font></option>
      <option value="Who your childhood hero?"><font size="3" face="Verdana">Who your childhood hero?</font></option>
      <option value="What is the name of your first school?"><font size="3" face="Verdana">What is the name of your first school?</font></option>
      <option value="Where did you meet your spouse?"><font size="3" face="Verdana">Where did you meet your spouse?</font></option>
      <option value="What is your favorite sports team?"><font size="3" face="Verdana">What is your favorite sports team?</font></option>
      <option value="What is your father middle name?"><font size="3" face="Verdana">What is your father middle name?</font></option>
      <option value="What was your high school mascot?"><font size="3" face="Verdana">What was your high school mascot?</font></option>
      <option value="What make was your first car or bike?"><font size="3" face="Verdana">What make was your first car or bike?</font></option>
      <option value="What is your pet name?"><font size="3" face="Verdana">What is your pet name?</font></option>
    </select></td>
</tr>
 
<tr>
    <td><pre><span class=Title>    Security Answer</span></pre></td>
    <td><input type="text" name="secretqans" value="" size="20"/></td>
</tr>

<tr></tr><tr></tr>
  <tr></tr><tr></tr>
  <tr>
    <td><pre><span class=Title>    Department Name</span></pre></td>
    <td width="276"><input type="text" name="deptname" value=""></td>
  </tr>
  <tr>
    <td><pre><span class=Title>    Dept. Fax no</span></pre></td>
    <td width="276"><input type="text" name="fax" value=""></td>
  </tr>
 <tr>
 	<td colspan="2" align="center"><input type="submit" value="Register"/> </td>
 </tr>

				</table>
				</form>
 
			</td>
			<td colspan="1" width="300" height="300" valign="top" align="right">
				<img src=<%=request.getContextPath()+"/images/Ind_Trng.jpg" %> height="300" width="300"/>
			</td>
		</tr>
		<tr>
			<td colspan="2" valign="bottom">
				<jsp:include page="Footer.jsp"></jsp:include>
			</td>
		</tr>
	</table>
</body>
<html>



