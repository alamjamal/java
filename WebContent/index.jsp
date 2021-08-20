<%@page import="com.sl.util.GlobalConstants"%>
<%@page import="com.sl.google.GlobalCons"%>
<%@page import="com.sl.google.GooglePojo"%>
<%
	String name = (String) request.getSession().getAttribute(GlobalConstants.USER_NAME);
%>
<%@ page language="java" contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset= UTF-8">
<link href="css/main.css" rel="stylesheet" type="text/css" />
<link href="css/footer.css" rel="stylesheet" type="text/css" />
<link href="css/join-contact.css" rel="stylesheet" type="text/css" />
<link href="css/font-awesome.css" rel="stylesheet" type="text/css" />
<title>My Site</title>
<title>Insert title here</title>
</head>
<body>
	<%
		GooglePojo gp = (GooglePojo) session.getAttribute("gp");
	%>
	<div class="header">
		<div class="navbar">
			<nav id="primary_nav_wrap">
			<ul>
				<li class="current-menu-item"><a href="#">HOME</a></li>
				<li><a href="B-Sell-Old-Book.jsp">SELL OLD BOOK</a></li>
				<li><a href="B-Buy-Old-Book.jsp">BUY OLD BOOKS</a></li>
				<li><a href="N-Buy-new-Book.jsp">BUY NEW BOOKS</a></li>
				<%
					if (name == null && gp == null) {
				%>
				<li><a href="#">ACCOUNT</a>
					<ul>
						<li><a href="U-Login.jsp">LOGIN</a></li>
						<li><a href="U-Register.jsp">REGISTER</a></li>
					</ul></li>
				<%
					}
					if (name != null) {
				%>
				<li><a href="#"><%=name%></a>
					<ul>
						<li><a href="U-Profile.jsp">PROFILE</a></li>
						<li><a href="C-Cart.jsp">CART</a></li>
						<li><a href="Logout">LOG OUT</a></li>
					</ul></li>
				<%
					}
				%>
			</ul>
			</nav>
		</div>
		<div class="bg-text">
			<h1>Search Books</h1>
			<p>NO MIDDLE MAN | ON-CAMPUS | PRICE COMPARISON | BEST PRICE</p>
		</div>
		<div class="s search-bar">
			
				<table>
					<tr>
						<td>
							<div class="search-container">
								<div class="ui-widget ">
									<input type="text"  id="search" name="search" class="search"  placeholder="ISBN/AUTHOR/TITLE/KEYWORD"/>
								</div>
							</div>
						</td>
						<td><input type="button" value="FIND BOOKS" id="button"/></td>
					</tr>
				</table>
			
		</div>
	</div>
	<!-- end header -->
	<div>
		<section class="three-column" id="buy-new-4">
		<td><i class="fa fa-book"> </i></td>
		<h1>Buy New Book</h1>
		</section>
		<section class="three-column" id="buy-old-4">
		<td><i class="fa fa-shopping-cart"> </i></td>
		<h1>Buy Old Book</h1>
		</section>
		<section class="three-column" id="sell-old-4">
		<td><i class="fa fa-money"> </i></td>
		<h1>Sell Old Book</h1>
		</section>
	</div>
	<!-- end three coloumn -->
	<!-- start book with slide show -->
	<div id="bookbar">
		<div class="latest-new-book">
			<div id="results"></div>
		</div>
		<div class="latest-old-book"></div>
	</div>
	<div id="join-contact">
		<div class="two-column tc-common1">
			<div id="contact">
				<h2>
					<p>Contact Us</p>
				</h2>
				<i class="fa fa-map-marker"></i> &nbsp; MANUU Gachibowli
				Hyderabad-50032 <br> <i class="fa fa-phone " id="contact"></i>
				&nbsp; 7416815171 <br> <i class="fa fa-envelope-o" id="contact"></i>
				&nbsp; info@bookwoon.com
			</div>
		</div>
		<div class="two-column">
			<div class="s3 ">
				<table>
					<tr>
						<td><input type="text" placeholder="Name" /></td>
					</tr>
					<tr>
						<td><input type="email" placeholder="Email" /></td>
					</tr>
					<tr>
						<td><textarea cols="22" rows="5" wrap="virtual"
								maxlength="100" placeholder="Your Message"
								style="height: 60px; resize: none;">
								</textarea></td>
					</tr>
					<tr>
						<td><input type="button" value="CONTACT US" /></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<!-- end join us -->
	<!-- start 3 column footer-->
	<div id="footer">
		<div id="top-footer">
			<div class="three-column one common">
				<ul>
					<li id="logo"><a href="#"> </a></li>
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
					<li><a href="Z-Return-and-Refund.jsp">| Return and Refund
					</a></li>
					<li><a href="Z-Shipping-Policy.jsp">| Shipping Policy </a></li>
				</ul>
			</div>
		</div>
	</div>
	<!-- import jQuery -->
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js">
		
	</script>
	<!-- write script to toggle class on scroll -->
	<script src="js/book/jq.js"></script>
	
	<!-- custom JavaScript -->
	<script src="js/book/main2.js"></script>
	<script src="js/book/blockui.js"></script>
	<script src="js/jquery-ui.css"></script>
	
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

			setTimeout($.unblockUI, 5000);	
			
		});
	});
</script>
<script>
		$(window).scroll(function() {
			if ($(window).scrollTop() >= 40) {
				$('.navbar').addClass('fixed');
			} else {
				$('.navbar').removeClass('fixed');
			}
		});
	</script>
</body>
</html>