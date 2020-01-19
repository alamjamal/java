<%@page import="com.sl.db.DBConn"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/main.css">
<style type="text/css">

</style>
</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache"); //Forces caches to obtain a new copy of the page from the origin server
		response.setHeader("Cache-Control", "no-store"); //Directs caches not to store the page under any circumstance
		response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
		response.setHeader("Pragma", "no-cache"); //HTTP 1.0 backward compatibility		
		if (session.getAttribute("email") == null) {
			response.sendRedirect("admin_login.jsp");
		}
	%>
	<div class="header">
		<h1>welcome ${email}</h1>
		<a href="account?action=logout"> Log Out</a>
	</div>
	<div class="nav-bar">
		<ul>
			<li><a href="admin_home.jsp"> DASHBOARD </a></li>
			<li><a href="add_product.jsp"> ADD PRODUCT </a></li>
			<li><a href="manage_product.jsp"> MANAGE PRODUCT </a></li>
			<li><a href="manage_catagory.jsp"> MANAGE CATAGORY </a></li>
			<li><a href="order_status.jsp"> ORDER STATUS </a></li>
			<li><a href="manage_user.jsp"> MANAGE USER </a></li>
		</ul>
	</div>
	<div class="main-bar">
	
		
	</div>
	<div class="footer"></div>
</body>
</html>