<%@page import="model.UserModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%
	UserModel model = (UserModel) session.getAttribute("model");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Book Woon</title>
<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Custom CSS: You can use this stylesheet to override any Bootstrap styles and/or apply your own styles -->
<link href="css/custom.css" rel="stylesheet">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>\
		
			<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js">		
			</script>
			<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js">			
			</script>
			
		<![endif]-->
<!-- Custom Fonts from Google -->
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>
</head>
<body>
	<!-- Navigation -->
	<nav id="siteNav" class="navbar navbar-default navbar-fixed-top"
		role="navigation">
		<div class="container">
			<!-- Logo and responsive toggle -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#navbar">
					<span class="sr-only"> Toggle navigation </span> <span
						class="icon-bar"> </span> <span class="icon-bar"> </span>
				</button>
				<img src="images/logo.png" width="55" height="55" id="logo-img" />
				<a class="navbar-brand" href="index.jsp"> BOOKWOON </a>
			</div>
			<!-- Navbar links -->
			<div class="collapse navbar-collapse" id="navbar">
				<ul class="nav navbar-nav navbar-right">
					<li class="active"><a href="index.jsp">HOME</a></li>

					<li><a href="#">SELL BOOKS</a></li>
					<li><a href="#">BUY BOOKS</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">HELP <span class="caret"></span></a>
						<ul class="dropdown-menu" aria-labelledby="account">
							<li><a href="how_it_works.jsp">HOW IT WORKS</a></li>
							<li><a href="help_and_safety.jsp">HELP AND SAFETY</a></li>
						</ul></li>

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





					<li><a href="#">CONTACT</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>
	<!-- Header -->
	<header>
		<div class="header-content">
			<div class="header-content-inner">
				<h1>Search Books</h1>
				<p>NO MIDDLE MAN | ON-CAMPUS | PRICE COMPARISON | BEST PRICE</p>


				<div class="flexsearch">
					<div class="flexsearch--wrapper">
						<form class="flexsearch--form" action=" " method="">
							<div class="flexsearch--input-wrapper">
								<input class="flexsearch--input" type="search"
									placeholder="Title / Author / ISBN / Keyword...">
							</div>
							<br /> <input class="btn btn-primary btn-lg" type="submit"
								value="Find The Book" />
						</form>
					</div>
				</div>



			</div>
		</div>
	</header>
	<!-- Intro Section -->
	<section class="intro">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2">
					<span class="glyphicon glyphicon-book" style="font-size: 60px">
					</span>
					<h2 class="section-heading" align="justify">Buy and sell
						textbooks directly with the student on-campus. No shipping, no
						credit cards, no hassles... We cut out the middleman and let you
						sell and buy all your textbooks directly to other students
						on-campus.</h2>
					<p class="text-light"></p>
				</div>
			</div>
		</div>
	</section>
	<!-- Content 1 -->
	<section class="content">
		<div class="container">
			<div class="row">
				<div class="col-sm-6">
					<img class="img-responsive img-circle center-block"
						src="images/microphone.jpg" alt="">
				</div>
				<div class="col-sm-6">
					<h2 class="section-header">Sell Old books</h2>
					<p class="lead text-muted" align="justify">There is no point
						keeping those old textbooks around to gather dust. Sell your
						textbooks to students and help them to save money and make some
						extra cash to spend on the finer things in your student life. Oh,
						the possibilities is here.</p>
					<a href="#" class="btn btn-primary btn-lg">Learn More..</a>
				</div>
			</div>
		</div>
	</section>
	<!-- Content 2 -->
	<section class="content content-2">
		<div class="container">
			<div class="row">
				<div class="col-sm-6">
					<h2 class="section-header">Buy Old Books</h2>
					<p class="lead text-light" align="justify">Why pay full price
						when you do not have to? You are probably tired of getting gouged
						by your campus bookstore or outside bookstore at this point, so
						save some money by buying used books from other students just like
						you.</p>
					<a href="#" class="btn btn-default btn-lg">Learn More..</a>
				</div>
				<div class="col-sm-6">
					<img class="img-responsive img-circle center-block"
						src="images/iphone.jpg" alt="">
				</div>
			</div>
		</div>
	</section>
	<!-- Promos -->
	<div class="container-fluid">
		<div class="row promo">
			<a href="#">
				<div class="col-md-4 promo-item item-1">
					<h3>Buy Old Books</h3>
				</div>
			</a> <a href="#">
				<div class="col-md-4 promo-item item-2">
					<h3>Sell Old Books</h3>
				</div>
			</a> <a href="#">
				<div class="col-md-4 promo-item item-3">
					<h3>Buy New Books</h3>
				</div>
			</a>
		</div>
	</div>
	<!-- /.container-fluid -->
	<!-- Content 3 -->
	<section class="content content-3">
		<div class="container">
			<h2 class="section-header">
				<span class="glyphicon glyphicon-shopping-cart text-primary">
				</span> <br> Buy New Books From Our Online Store
			</h2>
			<p class="lead text-muted">If there is nobody selling the
				textbook that you are after on your campus, you can buy these books
				from our online shop at cheapest price as we promised we care about
				your money.</p>
			<a href="#" class="btn btn-primary btn-lg">Buy Now</a>
		</div>

	</section>
	<!-- Footer -->
	<footer class="page-footer">
		<!-- Contact Us -->
		<div class="contact">
			<div class="container">
				<h2 class="section-heading">Get Started</h2>
				<p>
					Create an account, post the book, and sell away. Meet on-campus to
					do the deal. We help you find a new home for all your textbooks and
					put money back in your pockets where it belongs! <br>

				</p>
				<p>

					<br>

				</p>
			</div>
		</div>
		<!-- Copyright etc -->
		<div class="small-print">
			<div class="container">
				<p>Copyright &copy; bookwoon.com 2017</p>
			</div>
		</div>
	</footer>
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

</html>