<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.sl.util.GlobalConstants"%>

<%
String name = (String) request.getSession().getAttribute("userName"); 
%>

<div id="header">
	<div class="navbar">
		<a href="index.jsp" id="logo"></a>
		<nav id="primary_nav_wrap">
			<ul>
				<li class="current-menu-item"><a href="index.jsp">HOME</a></li>


				<li><a href="B-Sell-Old-Book.jsp">SELL OLD BOOK</a></li>
				<li><a href="B-Buy-Old-Book.jsp">BUY OLD BOOKS</a></li>
				<li><a href="N-Buy-new-Book.jsp">BUY NEW BOOKS</a></li>
				<%
					if (name == null) {
				%>
				<li><a href="#">ACCOUNT</a>
					<ul>
						<li><a href="U-Login.jsp">LOGIN</a></li>
						<li><a href="U-Register.jsp">REGISTER</a></li>
					</ul></li>


				<%
					} else {
				%>
				<li><a href="#"><%=name%></a>
					<ul>
						<li><a href="U-Profile.jsp">PROFILE</a></li>
						<li><a href="U-Wish-List.jsp">WISH LIST</a></li>
						<li><a href="Logout">LOG OUT</a></li>
					</ul></li>


				<%
					}
				%>

			</ul>
		</nav>
	</div>
	<div class="s search-bar">
		<input type="search" placeholder="Tiltle/Authour/ISBN/Keyword" />
		<button type="submit" class="btn btn-default">
			<i class="fa fa-search"> </i>
		</button>
	</div>
</div>

