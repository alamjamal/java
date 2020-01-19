<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	if(session.getAttribute("email")!=null){
		
		response.sendRedirect("admin_home.jsp");
	}
%>
  
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>

	<center>
${msg}
		<form action="account" method="post">
		
			<table border="1">
				<thead>
					<tr>
						<th colspan="2">admin login</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>user name</td>
						<td><input type="text" name="email" value="" /></td>
					</tr>
					<tr>
						<td>password</td>
						<td><input type="password" name="pass" value="" /></td>
					</tr>
					<tr>
						<td colspan="2">
							<center>
								<input type="submit" value="submit" name="submit" />
							</center>
						</td>

					</tr>
				</tbody>
			</table>
		</form>

	</center>
</body>
</html>