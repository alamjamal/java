<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%String email=(String)request.getSession().getAttribute("email");
	if(email==null){
		request.getRequestDispatcher("index.jsp").forward(request, response);
	} %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@include file="XX-Style.jsp"%>
<style type="text/css">
.s{
	margin-top: 60px;      
}
</style>

</head>
<body>
	<div><%@include file="XX-Header.jsp"%></div>
	<div class="middle">
		<div class="path"></div>

		<div class="sidebar">
			<ul>
				<li><a href="U-Profile.jsp"> Profile </a></li>
				<li><a href="U-Change-Pass.jsp"> Change Password </a></li>
				<li><a href="U-Order-History.jsp">Buying History </a></li>
				<li><a href="U-Order-History.jsp">Selling History </a></li>

			</ul>
		</div>

		<div class="two-column-m">
			<div class="main-content"></div>
		</div>

	</div>


	<div id="full"
		style="width: 100%; height: 20px; background-color: gray; clear: both;">

	</div>
	<%@include file="XX-Footer.jsp"%>
</body>
</html>