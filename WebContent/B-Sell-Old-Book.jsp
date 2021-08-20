<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="js/main/main.css">
<%@include file="XX-Style.jsp"%>
<style type="text/css">
.s{
	margin-top:90px;      
}
.header {
	background: url('img/2579.jpg') no-repeat center;
	background-size: cover;
	overflow: hidden;
	width: 100%;
	height: 100vh;
	max-height: 1000vh;
}
.s1 {
	position: absolute;
	top: 50%;
	left: 25%;
}
.search-bar1 input[type="text"] {
	width: 500px;
	height: 40px;
	font-size: 20px;
	padding-left: 10px;
	font-family: monospace;
	font-weight: lighter;
	border: 2px solid #FF99CC;
	border-radius: 4px;
}
.search-bar1 input[type="button"] {
	background-color: #FF0000; /* Green */
	border: 2px solid #FF99CC;
	color: white;
	border-radius: 4px;
	height: 43px;
	width: 150px;
	text-align: center;
	line-height: 40px;
	text-decoration: none;
	display: inline-block;
	font-size: 17px;
	margin: 4px 2px;
	cursor: pointer;
}
.search-bar1 input[type="button"]:hover {
	color: #FF99CC;
}
/* end header with bg image and search bar*/
.bg-text {
	margin-top: 50px;
	text-align: center;
	line-height: 50px;
}
.bg-text h1 {
	color: #FFFFFF;
	text-shadow: -2px 0 black, 0 2px black, 2px 0 black, 0 -2px black;
	font-size: 50px;
}
</style>
</head>
<body>
	<div><%@include file="XX-Header.jsp"%></div>
	<div class="header">
		<div class="bg-text">
			<h1>Sell Text Books</h1>
			<p>BY JUST ENTER ISBN NUMBER</p>
		</div>
		<div class="s1 search-bar1">
				<table>
					<tr>
						<td><input type="text" id="search"
							placeholder="Enter ISBN Number" /></td>
						<td><input type="button" value="SELL NOW" id="button" /></td>
					</tr>
				</table>
			<div class="col-sm-21">
				<!-- display results -->
				<div id="results"></div>
			</div>
		</div>
	</div>
	<%@include file="XX-Footer.jsp"%>
	<!-- jQuery -->
	<script src="js/book/jq.js"></script>
	<!-- custom JavaScript -->
	<script src="js/book/main.js"></script>
	<script src="js/book/blockui.js"></script>
	<script>
		$(document).ready(function() {
			$('#button').click(function() {
				$.blockUI({
					css : {
						border : '1px solid white',
						padding : '15px',
						backgroundColor : '#000',
						'-webkit-border-radius' : '10px',
						'-moz-border-radius' : '10px',
						opacity : .5,
						color : '#fff'
					}
				});
				setTimeout($.unblockUI, 1000);
			});
		});
	</script>
</body>
</html>