<%@page import="model.UserModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
		<%
UserModel model = (UserModel)session.getAttribute("model");
	if(model!=null){
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
%>
	<% 
 String name = (String)session.getAttribute("name");
 String email = (String)session.getAttribute("email");
 String mobile = (String)session.getAttribute("mobile");

 %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<title>
			Login Page
		</title>
		<meta charset="utf-8" />
		<link href="css/loginstyle.css" rel="stylesheet" type="text/css" />
             
	</head>
	<body class="mybody">
	<jsp:include page="header.jsp" /> 

		<div class="content">
			<p style="color:white;">${msg} </p>
			<form action="UserRegistration" method="POST"  onsubmit="return Validate()" name="vForm">
			 <input type="hidden" name="form" value="form1" />
				<div>
			<input type="text" name="name" class="textInput" placeholder="Name" value="${name }">
					<div id="name_error" class="val_error">
					</div>
				</div>
                
                
				<div>
					<input type="email" name="email" class="textInput" placeholder="Email" value="${email }">
					<div id="email_error" class="val_error">
					</div>
				</div>
				<div>
					<input type="text" name="mobile" class="textInput" placeholder="mobile number" value="${mobile }">
					<div id="name_error" class="val_error">
					</div>
				</div>
				<div>
					<input type="password" name="password" class="textInput" placeholder="Password">
				</div>
				<div>
					<input type="password" name="password_confirmation" class="textInput" placeholder="Re Enter Password">
					<div id="password_error" class="val_error">
					</div>
				</div>
				<div>
					<input type="submit" class="login" name="register" value="Register">
				</div>
			</form>
		</div>
		
		
		
 
	




	</body>

</html>
