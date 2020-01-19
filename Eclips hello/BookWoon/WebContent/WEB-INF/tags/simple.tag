<%@ tag language="java" pageEncoding="utf-8"%>
<%@ attribute name="title" required="true" rtexprvalue="true"%>
<%@ attribute name="content" fragment="true"%>
<%@ attribute name="head" fragment="true"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/footer.css" rel="stylesheet" type="text/css" />
<link href="css/header.css" rel="stylesheet" type="text/css" />
<link href="css/join-contact.css" rel="stylesheet" type="text/css" />
<link href="css/sidebar.css" rel="stylesheet" type="text/css" />
<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<style>
		#full{
		width:100% ;
		height:20px;
		background-color:gray;
		clear: both;
		}
		.s{
		margin-top:90px;
		}
	</style>
<jsp:invoke fragment="head"></jsp:invoke>

<title>${title }</title>
</head>
<body>


	<div id="header">
		<div class="navbar">
			<a href="index.jsp" id="logo"></a>
			<nav id="primary_nav_wrap" >
					<ul>
						<li class="current-menu-item"><a href="#">HOME</a></li>
						
						
						<li><a href="B-Sell-Old-Book.jsp">SELL OLD BOOK</a></li>
						<li><a href="B-Buy-Old-Book.jsp">BUY OLD BOOKS</a></li>
						<li><a href="B-Buy-new-Book.jsp">BUY NEW BOOKS</a></li>
						<li><a href="#">ACCOUNT</a>
							<ul>
								<li><a href="U-Login.jsp">LOGIN</a></li>
								<li><a href="U-Register.jsp">REGISTER</a></li>
							</ul>
						</li>
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
	<div class="middle">
		<div class="path"></div>

		<div class="sidebar">
			<ul>
				<li><a href="Z-About-Us.jsp"> About Us </a></li>
				<li><a href="Z-Contact-Us.jsp"> Contact Us </a></li>
				<li><a href="Z-Blog.jsp">Blog </a></li>
				<li><a href="Z-Privacy-Policy.jsp">Privacy Policy </a></li>
				<li><a href="Z-Terms-Of-Use.jsp">Terms Of Use </a></li>
				<li><a href="Z-Disclaimer.jsp">Disclaimer </a></li>
				<li><a href="Z-Return-and-Refund.jsp">Return and Refund </a></li>
				<li><a href="Z-Shipping-Policy.jsp">Shipping Policy </a></li>

			</ul>
		</div>



		<div class="two-column-m">
			<div class="main-content">
				 <jsp:doBody/>

			</div>
		</div>
	</div>


<div id="full">

</div>


	<div id="footer">
		<div id="top-footer">
			<div class="three-column one common">
				<ul>
					<li id="logo-f"><a href="#"> </a></li>
					<li>
						<h3>Get Started</h3>
					</li>
					<li style="text-align: justify; line-height: 25px;">Create an
						account, post the book, and sell away. Meet on-campus to do the
						deal. We help you find a new home for all your textbooks and put
						money back in your pockets where it belongs!</li>
					<li>
						<h3>Connect with us</h3>
					</li>
					<li><a href="www.facebook.com"><i class="fa fa-facebook"
							style="padding-right: 50px;"> </i> </a> <a href="www.facebook.com"><i
							class="fa fa-twitter"> </i> </a></li>
				</ul>
			</div>
			<div class="three-column two common">
				<ul>
					<li>
						<h3>Search From Top BooksSellers And Get The Cheapest Price</h3>
					</li>
					<li><img src="img/amazon_logo.png" /></li>
					<li><img src="img/Bigger_Books.png" /></li>
					<li><img src="img/Valore_Books.png" /></li>
					<li><img src="img/Ebooks.png" /></li>
				</ul>
			</div>
			<div class="three-column three common">
				<ul>
					<li>
						<h3>Useful quick links</h3>
					</li>

					<li><a href="L-Help-and-Safty.jsp"> HELP AND SAFTY</a></li>
					<li><a href="L-Scam-and-Fraud.jsp"> scam and fraud</a></li>
					<li><a href="L-How-it-Works.jsp"> how it works</a></li>
					<li><a href="L-Faq.jsp"> faq</a></li>
					<li><a href="L-College-List.jsp">college list</a></li>
				</ul>
			</div>
		</div>
		<!-- end 3 coloumn footer-->
		<div id="bottom-footer">
			<div id="bf-1">
				<p>copyright &copy; 2017 boooktune.com made with &hearts; in
					india</p>
			</div>
			<div id="bf-2">
				<ul>
					<li><a href="Z-About-Us.jsp"> About Us </a></li>
				<li><a href="Z-Contact-Us.jsp">| Contact Us </a></li>
				<li><a href="Z-Blog.jsp">| Blog </a></li>
				<li><a href="Z-Privacy-Policy.jsp">| Privacy Policy </a></li>
				<li><a href="Z-Terms-Of-Use.jsp">| Terms Of Use </a></li>
				<li><a href="Z-Disclaimer.jsp">| Disclaimer </a></li>
				<li><a href="Z-Return-and-Refund.jsp">| Return and Refund </a></li>
				<li><a href="Z-Shipping-Policy.jsp">| Shipping Policy </a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>