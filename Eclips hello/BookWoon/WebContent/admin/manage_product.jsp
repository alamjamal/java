<%@page import="com.book.alam.NewBookPOJO"%>
<%@page import="com.book.alam.NewBookDAO"%>
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
.book-info table, .book-info tr,.book-info  td, .book-info th {
	text-align: left;
	border: 1px solid black;
	border-collapse: collapse;
	padding: 6px;
	border: 1px solid black;
}
.book-info table tr:nth-child(even) {
	background-color: #eee;
}
.book-info table tr:nth-child(odd) {
	background-color: #fff;
}
.book-info table th {
	text-align:center;
	color: white;
	background-color: gray;
}
.book-info{
display:block;
text-align:center;
padding-top: 30px;
padding-left:10%;
margin: auto;
}
.book-edit{
display:block;
text-transform:uppercase;
font-weight:bold;
padding-top: 30px;
padding-left:20%;
margin: auto;
}

input[type=text] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	font-size: 18px;
}
input[type=submit], input[type=button] {
	width: 100%;
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}
input[type=submit]:hover {
	background-color: #45a049;
}
.myfrom {
	margin-left: 30%;
	padding-top: 5%;
	padding-bottom: 5%; font-weight : bold;
	text-transform: uppercase;
	font-weight: bold;
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
		<div class="book-info">
			<%
				NewBookDAO dao = new NewBookDAO();
				List<NewBookPOJO> list = dao.getAllBookInfo();
			%>
			<table>
				<thead>
					<tr>
						<th>Image</th>
						<th>Title</th>
						<th>ISBN</th>
						<th>Author</th>
						<th>Price</th>
						<th>Edit</th>
						<th>Delete</th>
					</tr>
				</thead>
				<%
					for (NewBookPOJO cp : list) {
				%>
				<tr>
					<td><img alt="" src="<%=cp.getIMAGEAPIPATH()%>" width="60px"
						height="80px"></td>
					<td><%=cp.getTITLE()%></td>
					<td><%=cp.getISBN()%></td>
					<td><%=cp.getAUTHOR()%></td>
					<td><%=cp.getPRICE()%></td>
					<td><a
						href="NewBookController?action=info&id=<%=cp.getNBOOKID()%>"><img
							src="img/edit.png"></a></td>
					<td><a
						href="NewBookController?action=delete&id=<%=cp.getNBOOKID()%>"><img
							src="img/delete.png"></a></td>
				</tr>
				<%
					}
				%>
			</table>
		</div>
		<div class="book-edit">
		<%NewBookPOJO np = (NewBookPOJO)request.getAttribute("np");		
		%>
			<form action="NewBookController" method="POST">
				<input type="hidden" name="myform" value="myeditform">
				<table>
					<tr>
						<td>Title</td>
						<td><input type="text" id="title" name="title" value="${np.getTITLE()}"></td>
					</tr>
					<tr>
						<td>author</td>
						<td><input type="text" id="author" name="author" value="${np.getAUTHOR()}"></td>
					</tr>
					<tr>
						<td>publisher</td>
						<td><input type="text" id="publisher" name="publisher"  value="${np.getPUBLISHER()}"></td>
					</tr>
					<tr>
						<td>published_date</td>
						<td><input type="text" id="published_date"
							name="published_date"  value="${np.getPUBLISHEDDATE()}"></td>
					</tr>
					<tr>
						<td>category</td>
						<td><input type="text" id="category" name="category"  value="${np.getCATEGORY()}"></td>
					</tr>
					<tr>
						<td>isbn</td>
						<td><input type="text" id="isbn" name="isbn"  value="${np.getISBN()}"></td>
					</tr>
					<tr>
						<td>isbn13</td>
						<td><input type="text" id="isbn13" name="isbn13"  value="${np.getISBN13()}"></td>
					</tr>
					<tr>
						<td>imageapipath</td>
						<td><input type="text" id="imageapipath" name="imageapipath"  value="${np.getIMAGEAPIPATH()}"></td>
					</tr>
					<tr>
						<td>Description</td>
						<td><textarea id="description" cols="70" rows="5" name="description" >${np.getDESCRIPTION()}</textarea></td>
					</tr>
					<tr>
						<td>pageCount</td>
						<td><input type="text" id="pagecount" name="pagecount"  value="${np.getPAGECOUNT()}"></td>
					</tr>
					<tr>
						<td>price</td>
						<td><input type="text" id="" name="price"  value="${np.getPRICE()}"></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" id="" name="update" ></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="footer"></div>
</body>
</html>