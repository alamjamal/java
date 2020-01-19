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
				<jsp:include page="Menubeforelogin.jsp"></jsp:include><br/>&nbsp;&nbsp;&nbsp; 
				<font color="#1B577C" size="4"><b><i>Contact us @</i></b></font>
			</td>
			<td colspan="1" width="300" height="300" valign="top" align="right">
				<img src=<%=request.getContextPath()+"/images/Contact_Us.247115147.jpg" %> height="300" width="300"/>
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



