<%@page import="com.book.category.CategoryDAO"%>
<%@page import="com.book.category.CategoryPOJO"%>
<%@page import="com.sl.db.DBConn"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/main.css">
<style type="text/css">
.myform {
	display: block;
}
.myform input[type="text"] {
	width: 250px;
	height: 25px;
	font-size: 20px
}
.myform input[type="submit"] {
	border: 2px solid #FF99CC;
	color: white;
	border-radius: 4px;
	height: 32px;
	width: 100px;
	text-align: center;
	padding-top:;
	text-decoration: none;
	font-size: 17px;
	cursor: pointer;
	background-color: red;
}
table, tr, td, th {
	text-align: left;
	border: 1px solid black;
	border-collapse: collapse;
	padding: 6px;
	border: 1px solid black;
}
table tr:nth-child(even) {
	background-color: #eee;
}
table tr:nth-child(odd) {
	background-color: #fff;
}
table th {
	color: white;
	background-color: gray;
}
.myform {
	display: inline-block;
	margin: auto;
	text-align: center;
	padding-top: 40px;
	padding-left: 35%;
	clear: both;
}
.mytable {
	display: block;
	margin: auto;
	text-align: center;
	margin-left: 35%;
	margin-top: 3%;
	clear: both;
}
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
		<div class="myform">
			<form action="CategoryController" method="Post">
				<input type="hidden" name="form" value="form_add"> <input
					type="text" name="cat_name"> <input type="submit"
					value="Add">
			</form>
		</div>
		<div class="mytable">
			<%
				CategoryDAO dao = new CategoryDAO();
				List<CategoryPOJO> list = dao.getAllCategory();
			%>
			<table>
				<thead>
					<tr>
						<th>Catagory Id</th>
						<th>Catagory Name</th>
						<th>Edit</th>
						<th>Delete</th>
					</tr>
				</thead>
				<%
					for (CategoryPOJO cp : list) {
				%>
				<tr>
					<td><%=cp.getCategory_id()%></td>
					<td><%=cp.getCategory_name()%></td>
					<td><a
						href="CategoryController?action=info&id=<%=cp.getCategory_id()%>&cat_name=<%=cp.getCategory_name()%>"><img
							src="img/edit.png"></a></td>
					<td><a
						href="CategoryController?action=delete&id=<%=cp.getCategory_id()%>&cat_name=<%=cp.getCategory_name()%>"><img
							src="img/delete.png"></a></td>
				</tr>
				<%
					}
				%>
			</table>
		</div>
		<%
			CategoryPOJO cp = (CategoryPOJO) request.getAttribute("cp");
		%>
		<div class="myform">
			<form action="CategoryController" method="Post">
				<input type="hidden" name="form" value="form_update"> <input
					type="text" name="cat_name" value="${cp.getCategory_name()}">
				<input type="submit" value="Update">
			</form>
		</div>
	</div>
	<div class="footer"></div>
</body>
</html>