<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
 	import = "in.techyari.example.model.User"   
    
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login and registartion example in J2EE</title>
</head>
<body>
	<%
			User user = (User)session.getAttribute("user");
			if(user!=null){ %>
		
		    <h3>Welcome <% out.print(user.getFullname()); %></h3>
		    <a href="LoginController?query=logout">Logout</a>
		    
		    <% }else{ %> 
		    	<h3>Your don't have permission to access this page</h3>
		    <% } %>
	
	
</body>
</html>