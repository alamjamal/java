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
	
<link rel="stylesheet" href="css/login-css/my-block-ui.css">	
<link rel="stylesheet" href="css/login-css/bootstrap.css">
<script src="js/my-block-ui.js"></script>
<script src="js/jquery-1.11.3.min.js"></script>
<script src="js/validator.min.js"></script>
<style>
.form-horizontal .control-label {
	margin-bottom: 5px;
}

.form-horizontal .form-group {
	margin-bottom: 5px;
	margin-left: 0px;
	margin-right: 0px;
}

#f-main {
	background: url('img/2578.jpg') no-repeat center;
	background-size: cover;
	overflow: hidden;
	width: 100%;
	height: auto;
}

h2, h4, h1, h3 {
	color: white;
	text-transform: uppercase;
}

label {
	color: white;
}

a {
	color: white;
	text-decoration: none;
}

a:hover {
	color: red;
}
</style>
<%@include file="XX-Style.jsp" %>
</head>
<body>
<div> <%@include file="XX-Header.jsp" %></div>
<div id="f-main"> 
<div
			style="max-width: 400px; padding: 10px 20px; margin: auto; margin-top:; ">
<h3 style="text-align: center">Forgot Password</h3>
<div class="alert alert-danger" role="alert" id="errorField"
				style="display: none">
  <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
  <span class="sr-only">Error:</span>
  <span class="message"></span>
</div>
<div class="alert alert-success" role="alert" id="successField"
				style="display: none">
  <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
  <span class="sr-only">Success:</span>
  <span class="message"></span>
</div>
<form class="form-horizontal" id="formForgotPassword"
				data-toggle="validator" role="form">
  <div class="form-group">
    <label for="inputEmail" class="control-label">Email</label>
    <input name="inputEmail" type="email" class="form-control"
						id="inputEmail" placeholder="Enter Email"
						data-error="Enter valid Email" required>
    <div class="help-block with-errors"></div>
  </div>
  <div class="form-group">
      <button style="width: 100%" type="submit"
						class="btn btn-default btn-primary">Send Verification Link</button>
  </div>
</form>
<div id="blockUiDiv">
  <img src="wave.svg"/>
</div>
<div id="blockUiBackdrop">
</div>
</div>
 <jsp:include page="XX-Footer.jsp"></jsp:include>
<script>
$(function () {
	$('#formForgotPassword').validator().on('submit', function (e) {
		  if (e.isDefaultPrevented()) {
		    // handle the invalid form...
		  } else {
			  blockUi();
		    // everything looks good!
			  $.post("ForgotPassword", $( "#formForgotPassword").serialize(), function( data ) {
				  var jdata = JSON.parse(data);
				  if(jdata.code == -1) {
					  $("#errorField .message").text(jdata.message);
					  $("#errorField").show();
					  $("#successField").hide();
				  } else {
					  $("#successField .message").text(jdata.message);
					  $("#errorField").hide();
					  $("#successField").show();
					  $("#formForgotPassword").hide();
				  }
			  }).always(function() {
				  unBlockUi(); 
			  });  
		  }
		  return false;
    });
});
</script>

</body>
</html>