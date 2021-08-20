<%@page import="com.sl.address.AddressDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.sun.org.apache.bcel.internal.generic.GETSTATIC"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.sl.db.DBConn"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.sl.address.AddressPOJO"%>
<%@page import="com.sl.model.UserPojo"%>
<%@page import="com.sl.model.StatusPojo"%>
<%
	UserPojo up = new UserPojo();
	AddressPOJO ap = new AddressPOJO();
	up = (UserPojo) request.getSession().getAttribute("up");
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String title = request.getParameter("title");
	String author = request.getParameter("author");
	String publishedDate = request.getParameter("publishDate");
	String img1 = request.getParameter("myimg");
	String img2 = request.getParameter("printsec");
	String img3 = request.getParameter("img");
	String img4 = request.getParameter("zoom");
	String img5 = request.getParameter("edge");
	String img6 = request.getParameter("source");
	String isbn = request.getParameter("isbn");
	String isbn13 = request.getParameter("isbn13");
	String publisher = request.getParameter("pub");
	String cat = request.getParameter("cat");
	String imgf = img1 + "&printsec=" + img2 + "&img=" + img3 + "&zoom=" + img4 + "&edge=" + img5 + "&source="
			+ img6;
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@include file="XX-Style.jsp"%>
<style type="text/css">
.main-content {
	height: 200vh;
}

.s {
	margin-top: 60px;
}

.two-column-m {
	width: 100%;
}

.form input[type="text"], .form input[type="email"] {
	border: 1px solid black;
	width: 250px;
	height: 30px;
	margin: 10px;
	font-size: 19px;
}

#bookpic {
	width: 30%;
	float: left;
	display: block;
	padding-top: 40px;
}

#bookinfo {
	color: black;
	padding-top: 40px;
	text-align: left;
	width: 70%;
	height: auto;
	float: left;
	display: block;
}

h2, h3 {
	color: black;
}

#bookcondition {
	line-height: 50px;
	font-weight: bold;
}

#bookcondition textarea {
	width: 115%;
	height: 60px;
	font-size: 20px;
	padding-left: 10px;
	font-family: monospace;
	font-weight: lighter;
	border: 2px solid #FF99CC;
	border-radius: 4px;
	opacity: 0.5;
	color: black;
}

#bookcondition input[type="submit"] {
	background-color: #FF0000; /* Green */
	color: white;
	border-radius: 4px;
	height: 35px;
	width: 118%;
	text-decoration: none;
	display: inline-block;
	font-size: 17px;
	margin: 4px 2px;
	cursor: pointer;
}

#bookcondition input[type="button"]:hover {
	color: #FF99CC;
}

#bookcondition input[type="radio"] {
	color: blue;
}
</style>
</head>
<body>
	<div><%@include file="XX-Header.jsp"%></div>
	<div class="middle">
		<div class="path">${msg}</div>
		<div class="two-column-m">
			<div class="main-content">
				<div id="bookpic">
					<img alt="" src="<%=imgf%>">
				</div>
				<div id="bookinfo">
					<table>
						<tr>
							<td><h3>Title :</h3></td>
							<td style="padding-left: 30px;"><h3><%=title%></h3></td>
						</tr>
						<tr>
							<td><h4>Author :</h4></td>
							<td style="padding-left: 30px;"><h4><%=author%>
								</h4></td>
						</tr>
						<tr>
							<td><h4>Published Date:</h4></td>
							<td style="padding-left: 30px;"><h4>
									<%=publishedDate%>
								</h4></td>
						</tr>
						<tr>
							<td><h4>Publisher :</h4></td>
							<td style="padding-left: 30px;"><h4><%=publisher%>
								</h4></td>
						</tr>
						<tr>
							<td><h4>CATAGORY :</h4></td>
							<td style="padding-left: 30px;"><h4><%=cat%>
								</h4></td>
						</tr>
						<tr>
							<td><h4>ISBN :</h4></td>
							<td style="padding-left: 30px;"><h4><%=isbn%>
								</h4></td>
						</tr>
						<tr>
							<td><h4>ISBN13 :</h4></td>
							<td style="padding-left: 30px;"><h4><%=isbn13%>
								</h4></td>
						</tr>
					</table>
					<h2>information about condition of the book</h2>
					<div id="bookcondition">
						<form action="OldBookController" method="post" class="form" >
						<input type="hidden" name="title" value="<%=title%>"> 
						<input type="hidden" name="author" value="<%=author%>"> 
						<input type="hidden" name="publish_date" value="<%=publishedDate%>"> 
						<input type="hidden" name="publisher" value="<%=publisher%>"> 
						<input type="hidden" name="category" value="<%=cat%>"> 
						<input type="hidden" name="isbn" value="<%=isbn%>"> 
						<input type="hidden" name="isbn13" value="<%=isbn13%>"> 
						<input type="hidden" name="imageapipath" value="<%=imgf%>"> 
				
							<table>
								<tr>
									<td>CONDITION OF BOOK :</td>
									<td><input type="radio" name="cob" value="New"> New <input
										type="radio" name="cob" value="Rarely Used"> Rarely Used <input
										type="radio" name="cob" value="Used"> Used<input type="radio"
										name="cob" value="Heavily Used">Heavily Used</td>
								</tr>
								<tr>
									<td>TEXT HIGHLIGHTED :</td>
									<td><input type="radio" name="th" value="Yes"> Yes <input
										type="radio" name="th" value="No"> No <input type="radio" name="th" value="Little Bit"> Little Bit </td>
								</tr>
								<tr>
									<td>NOTES IN TEXTBOOK :</td>
									<td><input type="radio" name="nib" value="Yes"> Yes <input
										type="radio" name="nib" value="No" > No <input type="radio" name="th" value="Little Bit"> Little Bit</td>
								</tr>

								<%
									if (up != null) {
										String a = up.getEMAIL().toString();
										ap = AddressDAO.getAddressByEmail(a);
									}
								%>



								<tr>
									<td colspan="2"><h2>Address Information</h2></td>
								</tr>
								<tr>
									<td>Pin :</td>
									<td><input type="text" id="pin" name="pin"
										value="<%=ap.getPin()%>" required></td>
								</tr>
								<tr>
									<td>Address:</td>
									<td><input type="text" id="address" name="address"
										value="<%=ap.getAddress()%>" required></td>
								</tr>
								<tr>
									<td>City :</td>
									<td><input type="text" id="city" name="city"
										value="<%=ap.getCity()%>" required></td>
								</tr>
								<tr>
									<td>State :</td>
									<td><input type="text" id="state" name="state"
										value="<%=ap.getState()%>" required></td>
								</tr>
								<tr>
									<td>Country :</td>
									<td><input type="text" id="country" name="country"
										value="<%=ap.getCountry()%>" required></td>
								</tr>
								<tr>
									<td colspan="2"><h2>Other Details</h2></td>
								</tr>
								<tr>
									<td>Price :</td>
									<td><input type="text" id="price" name="price" value="" required></td>
								</tr>
								<tr>
									<td>Mobile Number :</td>
									<td><input type="text" id="mobile" name="mobile" value="" required></td>
								</tr>

								<tr>
									<td colspan="2"><h2>Upload Personal Image</h2></td>
								</tr>
								
								
								<tr>
									<td><h3>Agreement :</h3></td>
									<td><input type="checkbox" name="agree" required> I Agree</td>
								</tr>


								<tr>
									<td colspan="2"><input type="submit"></td>
								</tr>
							</table>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div id="full"
		style="width: 100%; height: 20px; background-color: gray; clear: both;">
	</div>
	<%@include file="XX-Footer.jsp"%>

	<script src="js/jquery-1.11.3.min.js"></script>

	<script type="text/javascript">
		var a = document.getElementById('pin').value
		if (a == 0) {
			document.getElementById('pin').value = ""
			document.getElementById('address').value = ""
			document.getElementById('city').value = ""
			document.getElementById('state').value = ""
			document.getElementById('country').value = ""
		}

		function pinSearch() {
			// store user input
			var pin = document.getElementById('pin').value
			// clear any previous data
			// make a data request
			$
					.ajax({
						// url for database 
						url : "https://www.whizapi.com/api/v2/util/ui/in/indian-city-by-postal-code?project-app-key=ceqbtke2czk5biepxxinhadd&pin="
								+ pin,
						dataType : "json",
						type : 'GET',
						// on success, do this
						success : function(data) {
							console.log(data)
							// loop through data in data.items
							for (var i = 0; i < 1; i++) {
								// store current DATA info 
								var jdata = data.Data[i]

								//store data to var

								var address = jdata.Address
								var city = jdata.City
								var state = jdata.State
								var country = jdata.Country

								//print data to text boxes

								document.getElementById('address').value = address
								document.getElementById('city').value = city
								document.getElementById('state').value = state
								document.getElementById('country').value = country

							}
						}
					})
		}

		document.getElementById('pin')
				.addEventListener('blur', pinSearch, true)
		document.getElementById('pin').addEventListener('focus', pinSearch,
				true)
		document.getElementById('pin').addEventListener('keyup', pinSearch,
				true)
	</script>
</body>
</html>