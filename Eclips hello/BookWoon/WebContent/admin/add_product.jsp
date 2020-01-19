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
input[type=text] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	font-size: 20px;
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
.search input[type=text] {
}
.search  td {
	width: 80%;
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
		<div class="myfrom">
		<h3>${msg}</h3>
			<table class="search">
				<tr>
					<td><input type="text" id="search" name="isbn"></td>
					<td><input type="button" id="sbutton" value="fetch data"></td>
				</tr>
			</table>
			<form action="NewBookController" method="POST">
			<input type="hidden" name="myform" value="myaddform">
				<table>
					<tr>
						<td>Title</td>
						<td><input type="text" id="title" name="title"></td>
					</tr>
					<tr>
						<td>author</td>
						<td><input type="text" id="author" name="author"></td>
					</tr>
					<tr>
						<td>publisher</td>
						<td><input type="text" id="publisher" name="publisher"></td>
					</tr>
					<tr>
						<td>published_date</td>
						<td><input type="text" id="published_date" name="published_date"></td>
					</tr>
					<tr>
						<td>category</td>
						<td><input type="text" id="category" name="category"></td>
					</tr>
					<tr>
						<td>isbn</td>
						<td><input type="text" id="isbn" name="isbn"></td>
					</tr>
					<tr>
						<td>isbn13</td>
						<td><input type="text" id="isbn13" name="isbn13"></td>
					</tr>
					<tr>
						<td>imageapipath</td>
						<td><input type="text" id="imageapipath" name="imageapipath"></td>
					</tr>
					<tr>
						<td>Description</td>
						<td><textarea id="description" cols="50" rows="5" name="description"></textarea>
						</td>
					</tr>
					<tr>
						<td>pageCount</td>
						<td><input type="text" id="pagecount" name="pagecount"></td>
					</tr>
					<tr>
						<td>price</td>
						<td><input type="text" id="" name="price"></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" id="" name="submit"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="footer"></div>
	<script type="text/javascript" src="js/jq.js"></script>
	<script type="text/javascript">
		function bookSearch() {
			var search = document.getElementById('search').value
			$.ajax({
						url : "https://www.googleapis.com/books/v1/volumes?q="+search+"&key=AIzaSyBPH5NGEgI6LUJT9xGB7ZcQ1axNgSW4f54",
						dataType : "json",
						type : 'GET',
						// on success, do this
						success : function(data) {
							console.log(data)
							// loop through data in data.items
							for (var i = 0; i < 1; i++) {
								// store current DATA info 
								var jdata = data.items[i].volumeInfo
								//store data to var
								var title = jdata.title
								var author = jdata.authors[0]
								var publisher = jdata.publisher
								var published_date = jdata.publishedDate
 								var category = jdata.categories[0]
								var isbn = jdata.industryIdentifiers[0].identifier
								var isbn13 = jdata.industryIdentifiers[1].identifier
								var temp
								if(isbn.length==13){
									temp=isbn13
					   				isbn13=isbn 
					   				isbn=temp
					   			}
					   			
								var imageapipath = jdata.imageLinks.thumbnail
								var description = jdata.description
								var pagecount = jdata.pageCount
								//print data to text boxes
								document.getElementById('title').value = title
								document.getElementById('author').value = author
								document.getElementById('publisher').value = publisher
								document.getElementById('published_date').value = published_date
								document.getElementById('category').value = category
								document.getElementById('isbn').value = isbn
								document.getElementById('isbn13').value = isbn13
								document.getElementById('imageapipath').value = imageapipath
								document.getElementById('description').value = description
								document.getElementById('pagecount').value = pagecount
							}
						}
					})
		}
		document.getElementById('sbutton').addEventListener('click', bookSearch, true)
	</script>
</body>
</html>