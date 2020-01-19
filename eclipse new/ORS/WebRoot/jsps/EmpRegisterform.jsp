<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<script language="JavaScript" src=<%=request.getContextPath()+"/scripts/gen_validatorv31.js" %> type="text/javascript"></script>
<script language="JavaScript" type="text/javascript" src=<%=request.getContextPath()+"/scripts/ts_picker.js" %>></script>
<script language="JavaScript1.1" src=<%=request.getContextPath()+"/scripts/pass.js" %>></script> 
<script type="text/javascript" src=<%=request.getContextPath()+"/scripts/image.js" %>> </script>
 <script type="text/javascript" src=<%=request.getContextPath()+"/scripts/general.js" %>> </script>
 <script type="text/javascript" src=<%=request.getContextPath()+"/scripts/adi.js" %>> </script>
 <script type="text/javascript" src=<%=request.getContextPath()+"/scripts/form_validation.js" %>> </script>

<script type="text/javascript">

//var x_win = window.self; 

function goOn() {
var port=document.register.port.value;
var host=document.register.host.value;
var userName=document.register.username.value;
window.location.href='http://'+host+':'+port+'/ORS/ChekUserAction?username='+userName+'&formname=employee';

} 
function emailvalidation(entered, alertbox)
{

with (entered)
{
apos=value.indexOf("@");
dotpos=value.lastIndexOf(".");
lastpos=value.length-1;
if (apos<1 || dotpos-apos<2 || lastpos-dotpos>3 || lastpos-dotpos<2)
{if (alertbox) {alert(alertbox);} return false;}
else {return true;}
}
}
</script>

</head>


<body topmargin="0" leftmargin="0"  marginwidth="0" marginheight="0" background=<%=request.getContextPath()+"/images/web-background.png" %> >
	<table width="100%" align="left" border="0" style="vertical-align: top;">
		<tr>
			<td colspan="1" valign="top">
				<jsp:include page="Header.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
			<td colspan="1" width="1000"valign="top">
				<jsp:include page="Menubeforelogin.jsp"></jsp:include><br/>&nbsp;&nbsp;&nbsp; 
				<font color="#1B577C" size="4"><b><i>Registration form for new Employee</i></b></font>
				 <br/>
				 <br/>
 <form action="<%=basePath%>RegisterAction"  method="post" name="register"  onSubmit="return validate()">
 <!--<table border="1"><tr><td></td></tr></table>-->
 <input type="hidden" name="port" value="<%=request.getLocalPort() %>">
 <input type="hidden" name="host" value="<%=request.getServerName() %>">
 <br>
 <jsp:include page="statusmsg.jsp"/>
 <table align="left" width=70%>
<th colspan="6" bgcolor="#1B577C"><span class=Title><font color="#ffffff" size="3"><b>Account Details</b></font></span></th>
<tr></tr><tr></tr>
 <tr>
    <td><pre><span class=Title>    EMP_ID</span></pre></td>
    <td width="303"><input type="text" name="username" value="<%if(request.getParameter("username")!=null)out.print(request.getParameter("username")); %>" size="20" onBlur="goOn()"/>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=Title><%if(request.getAttribute("checkuser")!=null)out.print(request.getAttribute("checkuser"));    %></span></td>
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
      <option value="select" selected="true"><font size="3" face="Verdana">--Select One---</font></option>
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
  <th colspan="6" bgcolor="#1B577C"><span class=Title><font color="#ffffff" size="3"><b>Personal Details</b></font></span>  </th>
  <tr></tr><tr></tr>
  <tr>
    <td><pre><span class=Title>    First Name</span></pre></td>
    <td width="276"><input type="text" name="firstname" value=""></td>
  </tr>
<tr>
    <td width="139"><pre><span class=Title>    Last Name</span></pre></td>
    <td width="276">
      <input type="text" name="lastname" value="" size="20"/>
    </td>
  </tr>
  <tr>
    <td><pre><span class=Title>    Birth Date</span></pre></td>
    <td>
   <input type="text" name="bdate" value="" size="20" readonly="readonly" /><a href="javascript:show_calendar('document.register.bdate', document.register.bdate.value);"> <img src=<%=request.getContextPath()+"/images/cal.gif" %> alt="a" width="18" height="18" border="0"/></a>    </td>
  </tr>
    <tr>
    <td><pre><span class=Title>    Browse Photo</span></pre></td>
    <td><input type="file" name="photo" class="textfield" onChange="preview(this)" /></td>
  </tr>
  <tr></tr><tr></tr>
<th colspan="6" bgcolor="#1B577C"><center><span class=Title><font color="#ffffff" size="3"><b>Contact Details</b></font></span>
</center></th>
<tr></tr><tr></tr>
<tr>
    <td><pre><span class=Title>    Address Type </span></pre></td>
    <td width="276"><select name="addressType" onChange="cleartext()">
    <option value="select" selected="true"><font size="3" face="Verdana">Select </font></option>
    <option value="home"><font size="3" face="Verdana">Home</font></option>
    <option value="office"><font size="3" face="Verdana">Office</font></option>
    <option value="personal"><font size="3" face="Verdana">Personal</font></option>
      </select></td>
</tr>
<tr>
    <td><pre><span class=Title>    House No</span></pre></td>
    <td><input type="text" name="houseNo" value="" size="20"/></td>
</tr>
<tr>
    <td><pre><span class=Title>    Street</span></pre></td>
    <td><input type="text" name="sstreet" value="" size="20"/></td>
</tr>

<tr>
    <td><pre><span class=Title>    Phone No</span></pre></td>
    <td><input type="text" name="phoneNo" value="" size="20" onBlur="ValidateForm()"/></td>
</tr>
<th colspan="5">&nbsp;</th>
<tr></tr><tr></tr>

<tr><td></td>
    <td align="center"><font size="3" face="Verdana">
    <pre>                  <input type="submit" name="register" value="Register"/>&nbsp;  <input type="reset" name="cancel" value="Cancel"/>
   </pre> </font></td>
    <td align="center"></td>
</tr>
</table>
 <p><br/></p>
 <p><br/></p>
 <p><br/></p>
 <p><br/></p>
 <p><br/></p>
 <p><br/></p>
 <p><br/></p>
 <table border="0" align="center">
	<tr>
 		<img alt="See Photo Here" id="previewField" src=<%=request.getContextPath()+"/images/User-icon.png" %> height="150" width="120">
 	</tr>
 </table>
 <table  border="0" align="center">
    <tr>
    <td><pre><span class=Title>    Gender</span></pre></td>
    <td><select name="gender">
    <option value="select" selected="true"><font size="3" face="Verdana">Select </font></option>
    <option value="Male"><font size="3" face="Verdana">Male</font></option>
    <option value="Female"><font size="3" face="Verdana">Female</font></option>
    </select>
    </td>
    </tr>
    <tr>
    <td><pre><span class=Title>    Fax No</span></td>
    <td><input type="text" name="fax" value="" size="20"/></td>
  </tr>
    <tr>
    <td><pre><span class=Title>    Email</span></pre></td>
    <td><input type="text" name="email" value="" size="20" onchange="emailvalidation(this,'Invlid Email')"/></td>
  </tr>
 <tr><td><p><br/></p></td></tr>
 <tr><td><p><br/></p></td></tr>
 <tr><td><p><br/></p></td></tr>
 <tr><td><p><br/></p></td></tr>
  <tr rowspan="2"></tr>
  <tr>
    <td width="120"><pre><span class=Title>   City</span></pre></td>
    <td width="273">
      <input type="text" name="scity" value="" size="20"/>
    </td>
  </tr>
  <tr>
    <td><pre><span class=Title>   State</span></pre></td>
    <td>
      <input type="text" name="sstate" value="" size="20"/>
    </td>
  </tr>
  <tr>
    <td><pre><span class=Title>   Country</span></pre></td>
    <td>
      <input type="text" name="scountry" value="" size="20"/>
   </td>
  </tr>
  
  <tr>
    <td><pre><span class=Title>   Pin</span></pre></td>
    <td>
      <input type="text" name="spin" value="" size="20" onChange="showStatus()"/>
    </td>
  </tr>
  
<input type="hidden" name="logintype" value="employee">
<input type="hidden" name="home" value=""/>
<input type="hidden" name="hno"/>
<input type="hidden" name="street"/>
<input type="hidden" name="country"/>
<input type="hidden" name="pin"/>
<input type="hidden" name="state" value=""/>
<input type="hidden" name="phone"/>
<input type="hidden" name="city"/>



<input type="hidden" name="office" value=""/>
<input type="hidden" name="ohno"/>
<input type="hidden" name="ostreet"/>
<input type="hidden" name="ocountry"/>
<input type="hidden" name="opin"/>
<input type="hidden" name="ostate" value=""/>
<input type="hidden" name="ophone"/>
<input type="hidden" name="ocity"/>



<input type="hidden" name="contact" value=""/>
<input type="hidden" name="chno"/>
<input type="hidden" name="cstreet"/>
<input type="hidden" name="ccountry"/>
<input type="hidden" name="cpin"/>
<input type="hidden" name="cstate" value=""/>
<input type="hidden" name="cphone"/>
<input type="hidden" name="ccity"/>
</table>
</form>		         
  <script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("register");
  
 
   frmvalidator.addValidation("firstname","req","Please enter your First Name");
   frmvalidator.addValidation("firstname","maxlen=20",	"Max length for FirstName is 20");
   frmvalidator.addValidation("firstname","alpha"," First Name Alphabetic chars only");
  
   frmvalidator.addValidation("lastname","req","Please enter your Last Name");
   frmvalidator.addValidation("lastname","maxlen=20","Max length is 20");
   frmvalidator.addValidation("lastname","alpha"," Last Name Alphabetic chars only");
  
   frmvalidator.addValidation("gender","dontselect=0");
   frmvalidator.addValidation("bdate","req","Please enter your DOB"); 
  
   frmvalidator.addValidation("photo","req","Please Load Your Photo"); 
  
   frmvalidator.addValidation("email","maxlen=50");
   frmvalidator.addValidation("email","req");
   frmvalidator.addValidation("email","email");
   
  
   frmvalidator.addValidation("addressType","dontselect=0");
   
   frmvalidator.addValidation("houseNo","req","Please enter your House Number");
   
   frmvalidator.addValidation("sstreet","req","Please enter your Street Number");
   frmvalidator.addValidation("phoneNo","req");
  
   frmvalidator.addValidation("phoneNo","maxlen=50");
   frmvalidator.addValidation("phoneNo","numeric");
   frmvalidator.addValidation("phoneNo","Phone");
   
   frmvalidator.addValidation("scity","req","Please enter your city Name");
   frmvalidator.addValidation("sstate","req","Please enter your State Name");
   frmvalidator.addValidation("scountry","req","Please enter your Country Name");
   frmvalidator.addValidation("spin","req","Please enter your pin Number");
   
   frmvalidator.addValidation("username","req","Please enter your Username");
   frmvalidator.addValidation("password","req","Please enter your Password");
   frmvalidator.addValidation("conformpassword","req","Please enter your Confirm Password");
   frmvalidator.addValidation("secretqans","req","Please enter your Answer");
   frmvalidator.addValidation("secretqid","dontselect=0");
   frmvalidator.addValidation("fax","req","Please enter Fax Number");
 </script>   
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



