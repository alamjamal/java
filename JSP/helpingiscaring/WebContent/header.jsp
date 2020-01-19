<%@page import="model.UserModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%
	UserModel model = (UserModel) session.getAttribute("model");
%>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	
		<!-- Bootstrap Core CSS -->
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<!-- Custom CSS: You can use this stylesheet to override any Bootstrap styles and/or apply your own styles -->
		<link href="css/custom.css" rel="stylesheet">
		<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
			<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js">
				
			
			</script>
			<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js">
				
			
			</script>
		<![endif]-->
		<!-- Custom Fonts from Google -->
		<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
	</head>
	<body>
		<!-- Navigation -->
		<nav id="siteNav" class="navbar navbar-default navbar-fixed-top" role="navigation">
			<div class="container">
				<!-- Logo and responsive toggle -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar">
						<span class="sr-only">
							Toggle navigation
						</span>
						<span class="icon-bar">
						</span>
						<span class="icon-bar">
						</span>
					</button>
					<img src="images/logo.png" width="55" height="55" id="logo-img"/>
					<a class="navbar-brand" href="index.jsp">  
					BOOKWOON        	
					</a>
				</div>
				<!-- Navbar links -->
				<div class="collapse navbar-collapse" id="navbar">
					<ul class="nav navbar-nav navbar-right">
						<li class="active">
							<a href="index.jsp">HOME</a>
						</li>
						
						<li>
							<a href="#">SELL BOOKS</a>
						</li>
						<li>
							<a href="#">BUY BOOKS</a>
						</li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">HELP <span class="caret"></span></a>
							<ul class="dropdown-menu" aria-labelledby="account">
								<li>
									<a href="how_it_works.jsp">HOW IT WORKS</a>
								</li>
								<li>
									<a href="help_and_safety.jsp">HELP AND SAFETY</a>
								</li>
							</ul>
						</li>
					<%
						if (model == null) {
					%>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">ACCOUNT <span class="caret"></span></a>
						<ul class="dropdown-menu" aria-labelledby="account">
							<li><a href="user_login.jsp">LOGIN</a></li>
							<li><a href="user_registration.jsp">REGISTER</a></li>
						</ul></li>
					<%
						} else {
					%>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">${model.getName()} <span class="caret"></span></a>
						<ul class="dropdown-menu" aria-labelledby="account">
							<li><a href="user_profile.jsp">PROFILE</a></li>
							<li><a href="user_wishlist.jsp">WISH LIST</a></li>
							<li><a href="user_sellingbooks.jsp">SELLING BOOKS</a></li>
							<li><a href="user_buyingbooks.jsp">BUYING BOOKS</a></li>

							<li><a href="Logout?action=logout">LOG OUT</a></li>


						</ul></li>
					<%
						}
					%>


						<li>
							<a href="#">CONTACT</a>
						</li>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container -->
		</nav>
		
		<!-- jQuery -->
		<script src="js/jquery-1.11.3.min.js">
			
		
		</script>
		<!-- Bootstrap Core JavaScript -->
		<script src="js/bootstrap.min.js">
			
		
		</script>
		<!-- Plugin JavaScript -->
		<script src="js/jquery.easing.min.js">
			
		
		</script>
		<!-- Custom Javascript -->
		<script src="js/custom.js">
			
		
		</script>
	</body>