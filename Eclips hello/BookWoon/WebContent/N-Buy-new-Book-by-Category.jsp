<%@page import="com.book.alam.NewBookDAO"%>
<%@page import="com.book.alam.NewBookPOJO"%>
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
.middle{
}
.two-column-m{
}
.main-content{


}
.four-image{
background-color: #DDC9C9;
width:100%;
display:block;
text-align: center;
padding-top: 10px;

}
.four-image img{
margin:20px;
margin-left: 40px;
padding-top: 20px;
}
.clear{
padding: 3px;
}
.four-image table{
float: left;
display: inline;
text-align: center;
line-height: 25px;
text-weight:bold;
}
table tr{
padding: 8px;
}
</style>
</head>
<body>
	<div><%@include file="XX-Header.jsp"%></div>
	<div class="middle">
		<div class="path">
		<marquee style="color: white;">Latest Offers : Buy Computer Science Book At Great Discount</marquee>
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
				<li style="font-weight: bold; font-size: 20px; text-align:center; color: black; ">Categories</li>
				<%
					while (rs.next()) {
						String category = rs.getString("category_name");
				%>
				<li><a href="N-Buy-new-Book-by-Category.jsp?category=<%=category%>"><%=category%></a></li>
				<%
					}
				%>
			</ul>
		</div>
		
		<div class="two-column-m">
		
			<div class="main-content">
			<%String category = request.getParameter("category"); %>
				<div class="four-image">
				<h4 style="font-weight: bold; color:black;">Latest Books In <%=category %></h4>
			<%
			
			NewBookDAO dao = new NewBookDAO();
			List<NewBookPOJO> list = dao.getNewBookByCategory(category);
			 int i=1;
					for (NewBookPOJO nbp : list) {
				%>
				<table>
				<tr><td>
				<img alt="" src="<%=nbp.getIMAGEAPIPATH()%>" width="150px" height="200px">
				</td></tr>
				<tr><td style="font-weight: bold;"><%if(nbp.getTITLE().length()>30) {%>
								<%=nbp.getTITLE().substring(0,20)%>
							<%}
							else{%>
								<%=nbp.getTITLE()%>
							<%}%></td></tr>
				<tr><td><%=nbp.getAUTHOR()%></td></tr>
				<tr><td style="font-weight: bold;">Price: <%=nbp.getPRICE()%>  &#8377;</td></tr>
				<tr><td><a href="N-Book-Details-Page.jsp?bookid=<%=nbp.getNBOOKID()%>&cat=<%=category%>" class="btn btn-primary" >Buy Now</a></td></tr>
				</table>				
				<%
					if (i % 4 == 0) {%>
					<div class="clear"></div>
					
				<%} 
				i++;
				}%>
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