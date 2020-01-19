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
<link href="css/login-css/bootstrap.css" rel="stylesheet"
	type="text/css" />
<%@include file="XX-Style.jsp"%>
<style type="text/css">
.s {
	
}

.main-content {
	height: auto;
	color: black;
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
		<div class="path"></div>
		<%
			Connection con = null;
			con = DBConn.getConnection();
			Statement st = con.createStatement();
			String getCategory = "SELECT * FROM  `category`  ";
			ResultSet rs = st.executeQuery(getCategory);
		%>
		<div class="sidebar">
			<ul>
				<li
					style="font-weight: bold; font-size: 20px; text-align: center; color: black;">Categories</li>
					<li><a href="N-Buy-new-Book.jsp" > All Books</a></li>
				<%
					while (rs.next()) {
						String category = rs.getString("category_name");
				%>
				<li><a
					href="N-Buy-new-Book-by-Category.jsp?category=<%=category%>"> <%=category%></a></li>
				<%
					}
				%>
				
			</ul>
		</div>

		<%
			NewBookDAO dao = new NewBookDAO();
			List<NewBookPOJO> list = dao.getAllNewBook();
		%>
		<div class="two-column-m">
			<div class="main-content">
				<div class="four-image">
					<div class="textstyle">
						<h4>Latest From All Categories</h4>
					</div>
					<%
						int i = 1;
						for (NewBookPOJO nbp : list) {
					%>
					<table>
						<tr>
							<td><img alt="" src="<%=nbp.getIMAGEAPIPATH()%>"
								width="150px" height="200px"></td>
						</tr>
						<tr>
							<td style="font-weight: bold;">
								<%
									if (nbp.getTITLE().length() > 30) {
								%> <%=nbp.getTITLE().substring(0, 20)%>
								<%
									} else {
								%> <%=nbp.getTITLE()%> <%
 	}
 %>

							</td>
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
							<td><a
								href="N-Book-Details-Page.jsp?bookid=<%=nbp.getNBOOKID()%>&cat=<%=nbp.getCATEGORY()%>"
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
						String cat3 = "Biographies";
						String cat4 = "Adventure";
						String cat5 = "History";
						String cat6 = "Regional";
						String cat7 = "Science ";
						String cat8 = "Literature";
						String cat9 = "Comics";
						
						
						%>
					<%
						List<NewBookPOJO> list1 = dao.getNewBookByCategory(cat1);
						// int i=1;
						for (NewBookPOJO nbp : list1) {
					%>
					<table>
						<tr>
							<td><img alt="" src="<%=nbp.getIMAGEAPIPATH()%>"
								width="150px" height="200px"></td>
						</tr>
						<tr>
							<td style="font-weight: bold;">
								<%
									if (nbp.getTITLE().length() > 30) {
								%> <%=nbp.getTITLE().substring(0, 20)%>
								<%
									} else {
								%> <%=nbp.getTITLE()%>
								 <%
 									}
 									%>
							</td>
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
							<td><a
								href="N-Book-Details-Page.jsp?bookid=<%=nbp.getNBOOKID()%>&cat=<%=cat1%>"
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
						<h4>Latest From Mathematics</h4>
					</div>
					<%
						List<NewBookPOJO> list2 = dao.getNewBookByCategory(cat2);
						// int i=1;
						for (NewBookPOJO nbp : list2) {
					%>
					<table>
						<tr>
							<td><img alt="" src="<%=nbp.getIMAGEAPIPATH()%>"
								width="150px" height="200px"></td>
						</tr>
						<tr>
							<td style="font-weight: bold;">
								<%
									if (nbp.getTITLE().length() > 30) {
								%> <%=nbp.getTITLE().substring(0, 20)%>
								<%
									} else {
								%> <%=nbp.getTITLE()%> <%
	 													}
 														%>
							</td>
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
							<td><a
								href="N-Book-Details-Page.jsp?bookid=<%=nbp.getNBOOKID()%>&cat=<%=cat2%>"
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
						<h4>Latest From Biographies</h4>
					</div>
					<%
						List<NewBookPOJO> list3 = dao.getNewBookByCategory(cat3);
						// int i=1;
						for (NewBookPOJO nbp : list3) {
					%>
					<table>
						<tr>
							<td><img alt="" src="<%=nbp.getIMAGEAPIPATH()%>"
								width="150px" height="200px"></td>
						</tr>
						<tr>
							<td style="font-weight: bold;">
								<%
									if (nbp.getTITLE().length() > 30) {
								%> <%=nbp.getTITLE().substring(0, 20)%>
								<%
									} else {
								%> <%=nbp.getTITLE()%> <%
	 													}
 														%>
							</td>
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
							<td><a
								href="N-Book-Details-Page.jsp?bookid=<%=nbp.getNBOOKID()%>&cat=<%=cat2%>"
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
						<h4>Latest From Adventure</h4>
					</div>
					<%
						List<NewBookPOJO> list4 = dao.getNewBookByCategory(cat4);
						// int i=1;
						for (NewBookPOJO nbp : list4) {
					%>
					<table>
						<tr>
							<td><img alt="" src="<%=nbp.getIMAGEAPIPATH()%>"
								width="150px" height="200px"></td>
						</tr>
						<tr>
							<td style="font-weight: bold;">
								<%
									if (nbp.getTITLE().length() > 30) {
								%> <%=nbp.getTITLE().substring(0, 20)%>
								<%
									} else {
								%> <%=nbp.getTITLE()%> <%
	 													}
 														%>
							</td>
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
							<td><a
								href="N-Book-Details-Page.jsp?bookid=<%=nbp.getNBOOKID()%>&cat=<%=cat2%>"
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
						<h4>Latest From History</h4>
					</div>
					<%
						List<NewBookPOJO> list5 = dao.getNewBookByCategory(cat5);
						// int i=1;
						for (NewBookPOJO nbp : list5) {
					%>
					<table>
						<tr>
							<td><img alt="" src="<%=nbp.getIMAGEAPIPATH()%>"
								width="150px" height="200px"></td>
						</tr>
						<tr>
							<td style="font-weight: bold;">
								<%
									if (nbp.getTITLE().length() > 30) {
								%> <%=nbp.getTITLE().substring(0, 20)%>
								<%
									} else {
								%> <%=nbp.getTITLE()%> <%
	 													}
 														%>
							</td>
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
							<td><a
								href="N-Book-Details-Page.jsp?bookid=<%=nbp.getNBOOKID()%>&cat=<%=cat2%>"
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
						<h4>Latest From Regional</h4>
					</div>
					<%
						List<NewBookPOJO> list6 = dao.getNewBookByCategory(cat6);
						// int i=1;
						for (NewBookPOJO nbp : list6) {
					%>
					<table>
						<tr>
							<td><img alt="" src="<%=nbp.getIMAGEAPIPATH()%>"
								width="150px" height="200px"></td>
						</tr>
						<tr>
							<td style="font-weight: bold;">
								<%
									if (nbp.getTITLE().length() > 30) {
								%> <%=nbp.getTITLE().substring(0, 20)%>
								<%
									} else {
								%> <%=nbp.getTITLE()%> <%
	 													}
 														%>
							</td>
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
							<td><a
								href="N-Book-Details-Page.jsp?bookid=<%=nbp.getNBOOKID()%>&cat=<%=cat2%>"
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
						<h4>Latest From Science</h4>
					</div>
					<%
						List<NewBookPOJO> list7 = dao.getNewBookByCategory(cat7);
						// int i=1;
						for (NewBookPOJO nbp : list7) {
					%>
					<table>
						<tr>
							<td><img alt="" src="<%=nbp.getIMAGEAPIPATH()%>"
								width="150px" height="200px"></td>
						</tr>
						<tr>
							<td style="font-weight: bold;">
								<%
									if (nbp.getTITLE().length() > 30) {
								%> <%=nbp.getTITLE().substring(0, 20)%>
								<%
									} else {
								%> <%=nbp.getTITLE()%> <%
	 													}
 														%>
							</td>
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
							<td><a
								href="N-Book-Details-Page.jsp?bookid=<%=nbp.getNBOOKID()%>&cat=<%=cat2%>"
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
						<h4>Latest From Literature</h4>
					</div>
					<%
						List<NewBookPOJO> list8 = dao.getNewBookByCategory(cat8);
						// int i=1;
						for (NewBookPOJO nbp : list8) {
					%>
					<table>
						<tr>
							<td><img alt="" src="<%=nbp.getIMAGEAPIPATH()%>"
								width="150px" height="200px"></td>
						</tr>
						<tr>
							<td style="font-weight: bold;">
								<%
									if (nbp.getTITLE().length() > 30) {
								%> <%=nbp.getTITLE().substring(0, 20)%>
								<%
									} else {
								%> <%=nbp.getTITLE()%> <%
	 													}
 														%>
							</td>
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
							<td><a
								href="N-Book-Details-Page.jsp?bookid=<%=nbp.getNBOOKID()%>&cat=<%=cat2%>"
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
						<h4>Latest From Comics</h4>
					</div>
					<%
						List<NewBookPOJO> list9 = dao.getNewBookByCategory(cat9);
						// int i=1;
						for (NewBookPOJO nbp : list9) {
					%>
					<table>
						<tr>
							<td><img alt="" src="<%=nbp.getIMAGEAPIPATH()%>"
								width="150px" height="200px"></td>
						</tr>
						<tr>
							<td style="font-weight: bold;">
								<%
									if (nbp.getTITLE().length() > 30) {
								%> <%=nbp.getTITLE().substring(0, 20)%>
								<%
									} else {
								%> <%=nbp.getTITLE()%> <%
	 													}
 														%>
							</td>
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
							<td><a
								href="N-Book-Details-Page.jsp?bookid=<%=nbp.getNBOOKID()%>&cat=<%=cat2%>"
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
				
				
				
				
				
				
			</div>
		</div>
	</div>
	<div id="full"
		style="width: 100%; height: 20px; background-color: gray; clear: both;">
	</div>
	<%@include file="XX-Footer.jsp"%>
</body>
</html>