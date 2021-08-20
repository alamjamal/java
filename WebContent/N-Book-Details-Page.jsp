<%@page import="com.book.alam.NewBookDAO"%>
<%@page import="com.book.alam.NewBookPOJO"%>
<%@page import="com.sl.db.DBConn"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<% String email = (String)session.getAttribute("email"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@include file="XX-Style.jsp"%>
<style type="text/css">
.s {
	margin-top: 90px;
}
.middle {
	height: auto;
	background-color: #FAF7F7;
	color: black;
}
.old-book-info {
	display: inline;
	padding-top: 20px;
	float: left;
	width: 100%;
}
.img-info {
	display: block;
	width: 20%;
	float: left;
}
.img-info img {
	padding-left: 60px;
}
.text-info {
	width: 80%;
	float: left;
	display: block;
}
.other-info {
	width: 100%;
	display: block;
	float: left;
	padding-left: 60px;
	padding-top: 60px;
}
.middle h2 {
	color: black;
	text-transform: capitalize;
}
.middle h3 {
	color: black;
	text-transform: capitalize;
}
.middle h4 {
	color: black;
	text-transform: capitalize;
}
.old-book-info table {
	width: 50%;
}
.old-book-info table, .old-book-info tr, .old-book-info td {
	text-align: left;
	border-collapse: collapse;
	padding: 6px;
	border: 1px solid black;
}
.old-book-info table tr:nth-child(even) {
	background-color: #eee;
}
.old-book-info table tr:nth-child(odd) {
	background-color: #fff;
}
.buy-button {
	width: 100px;
	cursor: pointer;
	text-align: center;
	border-radius: 6px;
	font-weight: bold;
	background-color: navy;
	color: black;
	border: 2px solid #4CAF50;
	padding: 5px 10px;
	-webkit-transition-duration: 0.4s; /* Safari */
	transition-duration: 0.4s;
	margin-top: 20px;
}
.buy-button a{
color: black;
}
.buy-button:hover {
	background-color: #008CBA;
	color: white;
}
.textstyle {
	width: 100%;
	height: 7vh;
	background-color: #665AA6;
	text-align: center;
	padding-top: 0.03px
}
.four-image {
	width: 100%;
	display: inline-block;
	text-align: center;
	padding-top: 10px;
	width: 100%;
	text-align: center;
}
.four-image img {
	margin: 20px;
	margin-left: 40px;
	padding-top: 20px;
}
.clear {
	padding: 3px;
}
.four-image table {
	float: left;
	display: inline;
	text-align: center;
	line-height: 25px;
	text-weight: bold;
}
.four-image table tr {
	padding: 8px;
}
</style>
</head>
<body>
	<%@include file="XX-Header.jsp"%>
	<div class="middle">
		<div class="path" style="color:white;text-align: center; font-weight: bold;">
			 ${msg }
		</div>
		<div class="old-book-info">
			<%
				String temp = request.getParameter("bookid");
				int bookid = Integer.parseInt(temp.trim());
				NewBookDAO dao = new NewBookDAO();
				List<NewBookPOJO> list = dao.getNewBookByBookid(bookid);
				int i = 1;
				for (NewBookPOJO nbp : list) {
			%>
			<div class="img-info">
				<img alt="" src="<%=nbp.getIMAGEAPIPATH()%>">
			</div>
			<div class="text-info">
				<h2><%=nbp.getTITLE()%></h2>
				<h3>
					By :
					<%=nbp.getAUTHOR()%></h3>
				<h4>
					PUBLISHER :
					<%=nbp.getPUBLISHER()%></h4>
				<h2>
					Price :
					<%=nbp.getPRICE()%>
					&#8377;
				</h2>
				<a class="buy-button" href="CartController?action=addtocart&isbn13=<%=nbp.getISBN13()%>"> Buy Now</a>
				<a class="buy-button" href="C-Cart.jsp"> CheckOut</a>
			</div>
			<div class="other-info">
				<h2>book details</h2>
				<table>
					<tr>
						<td>PUBLISHEDDATE</td>
						<td><%=nbp.getPUBLISHEDDATE()%></td>
					</tr>
					<tr>
						<td>CATEGORY</td>
						<td><%=nbp.getCATEGORY()%></td>
					</tr>
					<tr>
						<td>ISBN</td>
						<td><%=nbp.getISBN()%></td>
					</tr>
					<tr>
						<td>ISBN13</td>
						<td><%=nbp.getISBN13()%></td>
					</tr>
				</table>
				
				
			</div>
			<%
				}
			%>
		</div>
		<div class="four-image" style="padding-top: 20px;">
			<div class="textstyle">
			<h4 style="color:white;">You May Like In This Category</h4>
			</div>
			<%
				String cat = request.getParameter("cat");
				List<NewBookPOJO> list1 = dao.getNewBookByCategory(cat);
				// int i=1;
				for (NewBookPOJO nbp : list1) {
			%>
			<table>
				<tr>
					<td><img alt="" src="<%=nbp.getIMAGEAPIPATH()%>" width="150px"
						height="200px"></td>
				</tr>
				<tr>
					<td style="font-weight: bold;"><%if(nbp.getTITLE().length()>30) {%>
								<%=nbp.getTITLE().substring(0,20)%>
							<%}
							else{%>
								<%=nbp.getTITLE()%>
							<%}%></td>
				</tr>
				<tr>
					<td><%=nbp.getAUTHOR()%></td>
				</tr>
				<tr>
					<td style="font-weight: bold;">Price: <%=nbp.getPRICE()%>
						&#8377;
					</td>
				</tr>
				<tr>
					<td><a href="#" class="btn btn-primary">Buy Now</a></td>
				</tr>
			</table>
			<%
				if (i % 5 == 0) {
			%>
			<div class="clear"></div>
			<%
				}
					i++;
				}
			%>
		</div>
	</div>
	<%@include file="XX-Footer.jsp"%>
</body>
</html>