<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>

*{
    margin: 0;
    padding: 0;
    border: 0;
}
body{
	background-image: url(../img/4.jpg);
	background-position:center;
	background-repeat:no-repeat;
	background-attachment:fixed;
    background-size:cover;
    overflow:hidden;
    font-family: 'Open Sans', sans-serif;
    word-wrap:break-word !important;
    font-size:15px;  
	line-height: 32px;
	color: #FFFFFF;
    width: 100%;
}
.s3 input[type="text"],.s3 input[type="password"]{
    width: 200px;
    height: 30px;
    font-size: 20px;
    padding-left: 10px;
    font-family: monospace;
    font-weight: lighter;
     border: 2px solid #FF99CC;
     border-radius: 4px;
    
     background-color:#000000;
     opacity: 0.5;
      color: #FFFFFF;
    
     
}
.s3 input[type="submit"]{
     background-color: #FF0000; /* Green */
    
    color: white;
    border-radius: 4px;
    height: 35px;
    width: 212px;
    text-decoration: none;
    display: inline-block;
    font-size: 17px;
    margin: 4px 2px;
    cursor: pointer;
   
}
.s3 input[type="button"]:hover{
    color:  #FF99CC;
}

</style>
</head>
<body>
<%
	if(session.getAttribute("email")!=null){
		
		response.sendRedirect("admin_home.jsp");
	}
%>
<br><br><br><br><br>
<center>
${msg}
		<form action="account" method="post" class="s3">
		
			<table border="1">
				<thead>
					<tr>
						<th colspan="2"><h2>Admin Login</h2></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						
						<td><input type="text" name="email" value="" placeholder="email"/></td>
					</tr>
					<tr>
						
						<td><input type="password" name="pass" value="" placeholder="password"/></td>
					</tr>
					<tr>
						<td >
							
								<input type="submit" value="submit" name="submit" />
						
						</td>

					</tr>
				</tbody>
			</table>
		</form>

	</center>
</body>
</html>