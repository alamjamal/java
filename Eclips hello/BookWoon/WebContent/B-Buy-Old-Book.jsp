<%@page import="com.book.old.OldBookDAO"%>
<%@page import="com.book.old.OldBookPOJO"%>
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
<link href="css/login-css/bootstrap.css" rel="stylesheet" type="text/css" />
<%@include file="XX-Style.jsp"%>
<style type="text/css">
.s {
}
body {
	font-family: sans-serif;
	color: black;
}
.middle {
}
.two-column-m {
}
.main-content {
	height:auto;
}
.textstyle {
	width: 100%;
	height: 7vh;
	background-color: #665AA6;
	color: white;
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
	<div><%@include file="XX-Header.jsp"%></div>
	<div class="middle">
		<div class="path">
			<marquee style="color: white;">Latest Offers : Buy Computer
				Science Book At Great Discount</marquee>
		</div>
		<%
			Connection con = null;
			con = DBConn.getConnection();
			Statement st = con.createStatement();
			String getCategory = "SELECT * FROM  `category`  ";
			ResultSet rs = st.executeQuery(getCategory);
		%>
		<div class="sidebar">
			<ul>
				<li style="font-weight: bold; font-size: 20px; text-align: center; color: black;">Categories</li>
				<%
					while (rs.next()) {
						String category = rs.getString("category_name");
				%>
				<li><a href="B-Old-Book-By-Category.jsp?category=<%=category%>">
						<%=category%></a></li>
				<%
					}
				%>
			</ul>
		</div>
		<%
			OldBookDAO dao = new OldBookDAO();
			List<OldBookPOJO> list = dao.getAllOldBook();
		%>
		<div class="two-column-m">
			<div class="main-content">
				<div class="four-image">
					<div class="textstyle">
						<h4>Latest From All Categories</h4>
					</div>
					<%
						int i = 1;
						for (OldBookPOJO obp : list) {
					%>
					<table>
						<tr>
							<td><img alt="" src="<%=obp.getIMAGEAPIPATH()%>"
								width="150px" height="200px"></td>
						</tr>
						<tr>
							<td style="font-weight: bold;">
							<%if(obp.getTITLE().length()>30) {%>
								<%=obp.getTITLE().substring(0,20)%>
							<%}
							else{%>
								<%=obp.getTITLE()%>
							<%}%>
							</td>
						</tr>
						<tr>
							<td><%=obp.getAUTHOR()%></td>
						</tr>
						<tr>
							<td style="font-weight: bold;">Price: <%=obp.getPRICE()%>
								&#8377;
							</td>
						</tr>
						<tr>
							<td><a
								href="B-Old-Book-Detail-Page.jsp?bookid=<%=obp.getBOOKID()%>&cat=<%=obp.getCATEGORY() %>"
								class="btn btn-primary">Buy Now</a></td>
						</tr>
					</table>
					<%
						if (i % 4 == 0) {
					%>
					<div class="clear"></div>
					<%
						}
							i++;
						}
					%>
				</div>
				<div class="four-image" style="padding-top: 20px;">
					<div class="textstyle">
						<h4>Latest From Computer Science</h4>
					</div>
<%!String cat1 = "Computer"; 
String cat2 = "Mathematics";
%>
					<%	
						List<OldBookPOJO> list1 = dao.getOldBookByCategory(cat1);
						// int i=1;
						for (OldBookPOJO obp : list1) {
					%>
					<table>
						<tr>
							<td><img alt="" src="<%=obp.getIMAGEAPIPATH()%>"
								width="150px" height="200px"></td>
						</tr>
						<tr>
							<td style="font-weight: bold;"><%if(obp.getTITLE().length()>30) {%>
								<%=obp.getTITLE().substring(0,20)%>
							<%}
							else{%>
								<%=obp.getTITLE()%>
							<%}%></td>
						</tr>
						<tr>
							<td><%=obp.getAUTHOR()%></td>
						</tr>
						<tr>
							<td style="font-weight: bold;">Price: <%=obp.getPRICE()%>
								&#8377;
							</td>
						</tr>
						<tr>
							<td><a href="B-Old-Book-Detail-Page.jsp?bookid=<%=obp.getBOOKID()%>&cat=<%=cat1%>" class="btn btn-primary">Buy Now</a></td>
						</tr>
					</table>
					<%
						if (i % 4 == 0) {
					%>
					<div class="clear"></div>
					<%
						}
							i++;
						}
					%>
				</div>
				<div class="four-image" style="padding-top: 20px;">
					<div class="textstyle">
						<h4>Latest From Mathematics</h4>
					</div>
					<%
						List<OldBookPOJO> list2 = dao.getOldBookByCategory(cat2);
						// int i=1;
						for (OldBookPOJO obp : list2) {
					%>
					<table>
						<tr>
							<td><img alt="" src="<%=obp.getIMAGEAPIPATH()%>"
								width="150px" height="200px"></td>
						</tr>
						<tr>
							<td style="font-weight: bold;"><%if(obp.getTITLE().length()>30) {%>
								<%=obp.getTITLE().substring(0,20)%>
							<%}
							else{%>
								<%=obp.getTITLE()%>
							<%}%></td>
						</tr>
						<tr>
							<td><%=obp.getAUTHOR()%></td>
						</tr>
						<tr>
							<td style="font-weight: bold;">Price: <%=obp.getPRICE()%>
								&#8377;
							</td>
						</tr>
						<tr>
							<td><a href="B-Old-Book-Detail-Page.jsp?bookid=<%=obp.getBOOKID()%>&cat=<%=cat2%>" class="btn btn-primary">Buy Now</a></td>
						</tr>
					</table>
					<%
						if (i % 4 == 0) {
					%>
					<div class="clear"></div>
					<%
						}
							i++;
						}
					%>
				</div>
			</div>
		</div>
	</div>
	<div id="full"
		style="width: 100%; height: 20px; background-color: gray; clear: both;">
	</div>
	<%@include file="XX-Footer.jsp"%>
</body>
</html>