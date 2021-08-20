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
	String email=(String)request.getSession().getAttribute("email");
	if(email==null){
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.sl.util.GlobalConstants"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/login-css/my-block-ui.css">
<script src="js/my-block-ui.js"></script>
<script src="js/jquery-1.11.3.min.js"></script>
<script src="js/validator.min.js"></script>
<jsp:include page="XX-Style.jsp" />
<style type="text/css">
.main-content {
	height: 130vh;
}

.sidebar {
	height: 130vh;
}

.s {
	margin-top: 60px;
}

.form {
	display: block;
	text-align: center;
	color: black;
	padding-top: 5%;
	padding-left: 30%;
}

#inner-from {
	display: block;
	margin: 50px;
	padding: 50px;
}

.form input[type="text"], .form input[type="email"] {
	width: 250px;
	height: 30px;
	margin: 10px;
	font-size: 19px;
	background: 1px solid black;
}

.form button[type="submit"] {
	width: 250px;
	height: 30px;
	margin: 10px;
	font-size: 19px;
}

.form button[type="submit"]:hover {
	background-color: aqua;
	color: white;
	cursor: pointer;
}
</style>
</head>
<body>
	<div><jsp:include page="XX-Header.jsp" />
	</div>
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
			<div class="main-content">
				<div class="form">
					<div id="errorField" style="display: none;"></div>
					<div id="successField" style="display: none;"></div>
					<div id="ajaxResponse"></div>

					<h1 style="text-align: left">Update Profile</h1>
					<form id="inner-form" method="post" action="ProfileUpdate">

						<table>
							<tr>
								<td>First Name :</td>
								<td><input type="text" id="fname" name="fname"
									value="${up.getFIRST_NAME()}"></td>
							</tr>
							<tr>
								<td>Last Name :</td>
								<td><input type="text" id="lname" name="lname"
									value="${up.getLAST_NAME()}"></td>
							</tr>
							<tr>
								<td>Email :</td>
								<td><input type="email" id="email" name="email"
									value="${up.getEMAIL()}" readonly="readonly"></td>
							</tr>
							<tr>
								<td></td>
								<td>
									<button id="submit" type="submit"
										class="btn btn-default btn-primary">update</button>
								</td>
							</tr>
						</table>
					</form>

<%!int pin;
String city;
String address;
String state;
String country; 

%>
					<%
						Connection con = null;
						PreparedStatement ps = null;
						
						try {
							
							String email2 = (String)session.getAttribute("email");
							
							con = DBConn.getConnection();
							String sql = "select * from demo_user_address where email=?";
							ps = con.prepareStatement(sql);
							ps.setString(1, email2);
							ResultSet rs = ps.executeQuery();
							while(rs.next()){
								pin=rs.getInt("pin");
								city=rs.getString("city");
								address=rs.getString("address");
								state = rs.getString("state");
								country = rs.getString("country");
								
							}
									} catch (Exception e) {
										e.printStackTrace();
									}
									con.close();
								%>		
					<h1 style="text-align: left">Update Address</h1>
					<form id="inner-form" method="post" action="add">
						<input type="hidden" name="email" value="${up.getEMAIL()}">
						<table>
							<tr>
								<td>Pin :</td>
								<td><input type="text" id="pin" name="pin" value="<%=pin%>"></td>
							</tr>
							<tr>
								<td>Address:</td>
								<td><input type="text" id="address" name="address" value="<%=address%>"></td>
							</tr>
							<tr>
								<td>City :</td>
								<td><input type="text" id="city" name="city" value="<%=city%>"></td>
							</tr>
							<tr>
								<td>State :</td>
								<td><input type="text" id="state" name="state" value="<%=state%>"></td>
							</tr>
							<tr>
								<td>Country :</td>
								<td><input type="text" id="country" name="country" value="<%=country%>"></td>
							</tr>
							<tr>
								
								<td></td>
								<td>
									<button id="submit" type="submit"
										class="btn btn-default btn-primary">update</button>
								</td>
							</tr>
						</table>
						
							
						
					</form>
				</div>
			</div>
		</div>
	</div>

	<div id="full"
		style="width: 100%; height: 20px; background-color: gray; clear: both;">
	</div>
	<jsp:include page="XX-Footer.jsp" />
	<script src="js/jquery-1.11.3.min.js"></script>

	<script type="text/javascript">
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
