<%@page import="model.UserModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%
UserModel model = (UserModel)session.getAttribute("model");
	if(model!=null){
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Login Page</title>
<meta charset="utf-8" />
<link href="css/loginstyle.css" rel="stylesheet" type="text/css" />

</head>
<body class="mybody">
<jsp:include page="header.jsp" /> 

	<div class="content">
	<p style="color:white;">${msg} </p>
		<form method="POST" action="Login" onsubmit="return Validate()"
			name="vForm">
			
<input type="hidden" name="form" value="form2" />
			<div>
				<input type="email" name="email" class="textInput"
					placeholder="Email Address ">
				<div id="email_error" class="val_error" ></div>
			</div>


			<div>
				<input type="password" name="password" class="textInput"
					placeholder="Password">
				<div id="password_error" class="val_error">
				</div>
			</div>

			<div>
				<input type="submit" class="login" name="login" value="Login">
			</div>
			

<div class="foo">

				<div>
					<a href="forgotpass.jsp" id="fg"> Forgot Password </a>
				</div>
				
				<div>
					<a href="user_registration.jsp" id="rg">Register Here</a>
				</div>

</div>

		</form>
	</div>



	<script src="js/script2.js"></script>
	
</body>

</html>
