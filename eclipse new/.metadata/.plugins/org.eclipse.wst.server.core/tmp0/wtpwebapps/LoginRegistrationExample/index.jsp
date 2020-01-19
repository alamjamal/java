<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login and registartion example in J2EE</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" href="style.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script>
$(function() {
  $( "#tabs" ).tabs();
});
</script>
</head>
<body>
	<div class="wrapper">
	<div class="header">
		<h1>Tabbed Login and Registration example with jQuery UI in J2EE using MySql database</h1>
	</div>
	
	<div class="container">
		<div class="instruction">
<div id="tabs">
  <ul>
    <li><a href="#login">Login</a></li>
    <li><a href="#register">Register</a></li>
  </ul>
  <div id="login">
  	<% 
  	if("Invalid username or password".equalsIgnoreCase((String)session.getAttribute("error"))){ %>
  		<h6> Invalid user name or password. Please try again.</h6>
  	<%} %>
    <form method="post" action="LoginController">
    	<label for="email">Email:</label>
    	<input type="text" name="email" id="email" class="email" placeholder="Your email address"/>
    	<label for="password">Password:</label>
    	<input type="password" name="password" id="password" class="password" placeholder="Your password"/>
    	<input type="submit" value="Login">
    </form>
  </div>
  <div id="register">
  	<form method="post" action="RegistrationController">
  		<label for="fullname">Full Name:</label><br/>
    	<input type="text" name="fullname" id="fullname" class="fullname" placeholder="Your full name"/>
    	<br/>
    	<label for="email">Email:</label><br/>
    	<input type="text" name="email" id="email" class="email" placeholder="Your email address"/>
    	<br/>
    	<label for="password">Password:</label><br/>
    	<input type="password" name="password" id="password" class="password" placeholder="Your password"/>
    	<br/>
    	<label for="gender">Gender:</label><br/>
    	<select name="gender" id="gender" class="gender">
    		<option value="Male">Male</option>
    		<option value="Male">Female</option>
    	</select>
    	<br/>
    	<label for="birthdate">Birth Date:</label><br/>
    	<input type="text" name="birthdate" id="birthdate" class="birthdate" placeholder="Your birth date"/>
    	<br/>
    	<input type="submit" value="Register">
  	</form>
  </div>
</div>
		</div>
	</div>
	
	<div class="footer">
		
	</div>
	</div>
</body>
</html>