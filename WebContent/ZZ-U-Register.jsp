<%@page import="com.sl.util.GlobalConstants"%>
<%Integer userId = (Integer) request.getSession().getAttribute(GlobalConstants.USER);
if(userId!=null){
	request.getRequestDispatcher("index.jsp").forward(request, response);
}
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>

<mt:login-register title="Register">
	<jsp:attribute name="head">
	
	
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
#side-main-common{
background: url('./img/2578.jpg')no-repeat center;
    background-size:cover;
    overflow:hidden;
      width:100%;
      height:auto;
      
}
#mainbar {
	float: left;
	width: 49%;
	border-right: 1px solid white;
	height: 100%;
}

#sidebar {
	float: left;
	width: 50%;
	
	text-align: center;
	
	list-style: none;
	text-decoration: none;
	
}

.g-button button[type="button"] {
	color: white;
	background-color: red;
}

.g-button button[type="button"]:hover, .g-button button[type="button"]:visited
	{
	color: red;
	background-color: white;
}
h2,h4,h1,h3{
color:white;
text-transform: uppercase;

}
label{
color:white;
}
a{
color:white;
text-decoration: none;
}
a:hover{
color:red;
}

.form-sign-in-with-social{
    display: inline-block;
    max-width: 180px;
    box-sizing: border-box;
    vertical-align: top;
    text-align: center;
    margin-top: 100px;
}

.form-sign-in-with-social .form-title-row{
    margin-bottom: 50px;
}

.form-sign-in-with-social .form-title{
    box-sizing: border-box;
    color:  #4c565e;
    font-size: 24px;
    padding: 15px 20px;
    border-bottom: 2px solid #6caee0;
}

.form-sign-in-with-social .form-google-button{
    color:  #ffffff;
    display: block;
    width: 145px;
    height: 40px;
    font-size: 12px;
    line-height: 40px;
    background-color:  rgba(222, 110, 60, 0.9);
    box-shadow: 1px 2px 2px 0 rgba(0, 0, 0, 0.08);
    border-radius: 2px;
    margin: 8px auto;
    text-decoration: none;
}

.form-sign-in-with-social .form-facebook-button{
    color:  #ffffff;
    display: block;
    width: 145px;
    height: 40px;
    font-size: 12px;
    line-height: 40px;
    background-color:  rgba(75, 136, 194, 0.9);
    box-shadow: 1px 2px 2px 0 rgba(0, 0, 0, 0.08);
    border-radius: 2px;
    margin: 8px auto;
    text-decoration: none;
}

.form-sign-in-with-social .form-twitter-button{
    color:  #ffffff;
    display: block;
    width: 145px;
    height: 40px;
    font-size: 12px;
    line-height: 40px;
    background-color:  rgba(123, 195, 226, 0.9);
    box-shadow: 1px 2px 2px 0 rgba(0, 0, 0, 0.08);
    border-radius: 2px;
    margin: 8px auto;
    text-decoration: none;
}

</style>


</jsp:attribute>

	<jsp:attribute name="content">
<div id="side-main-common">
<div id="mainbar">
<div style="max-width: 390px; padding: 5px; margin: auto;">
<h2 style="text-align: center">Register Here</h2>
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

<form class="form-horizontal" id="formRegister" data-toggle="validator"
						role="form">
					
  <div class="form-group">
  
    <label for="inputEmail" class="control-label">Email</label>
    <input name="inputEmail"
								pattern="^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$"
								class="form-control" id="inputEmail" placeholder="Enter Email"
								data-error="Enter valid Email" required>
    <div class="help-block with-errors"></div>
  </div>
  <div class="form-group">
    <label for="inputFirstName" class="control-label">First Name</label>
    <input pattern="[A-Za-z0-9]{1,20}" name="inputFirstName"
								class="form-control" id="inputFirstName"
								placeholder="Enter First Name"
								data-error="First name should not be null. It should be less than 20 characters. Use only A-Z, a-z, 0-9 charecters"
								required>
    <div class="help-block with-errors"></div>
  </div>
  <div class="form-group">
    <label for="inputLastName" class="control-label">Last Name</label>
    <input pattern="[A-Za-z0-9]{1,20}" name="inputLastName"
								class="form-control" id="inputLastName"
								placeholder="Enter Last Name"
								data-error="last name should not be null. It should be less than 20 characters. Use only A-Z, a-z, 0-9 charecters"
								data-toggle="tooltip" data-placement="right" required>
    <div class="help-block with-errors"></div>
  </div>
  <div class="form-group">
    <label for="inputPassword" class="control-label">Password</label>
    <input type="password" pattern="[A-Za-z0-9@#$%!^&*]{6,30}"
								name="inputPassword" class="form-control" id="inputPassword"
								placeholder="Enter Password"
								data-error="Password should not be null. It should be greater than 6 and less than 30 characters . Use only A-Z, a-z, 0-9, @ # $ % ! ^ & * charecters"
								required>
    <div class="help-block with-errors"></div>
  </div>
  <div class="form-group">
    <label for="inputPassword1" class="control-label">Confirm Password</label>
    <input type="password" name="inputPassword1" class="form-control"
								id="inputPassword1" data-match="#inputPassword"
								placeholder="Enter Password Again"
								data-error="It should not be null and should match with above password"
								required>
							
					
					
					
					
					
    <div class="help-block with-errors"></div>
  
			
			
			
			
			</div>
  <div class="form-group">
      <button style="width: 100%" type="submit"
								class="btn btn-default btn-primary">Register</button>
  </div>
</form>

<div id="blockUiDiv">
  <img src="wave.svg" />
</div>
<div id="blockUiBackdrop">
</div>
</div>
</div>
<div id="sidebar">


 <div class="form-sign-in-with-social">

                <div class="form-row form-title-row">
                    <span class="form-title" style="color:white">Sign in with</span>
                </div>

                <a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/google/oauth2callback&response_type=code&client_id=724643168870-p7u2eli0uqcfrbuliq1id1se2erkl4mv.apps.googleusercontent.com&approval_prompt=force" class="form-google-button">Google</a>
                <a href="#" class="form-facebook-button">Facebook</a>
                <a href="#" class="form-twitter-button">Twitter</a>

            </div>
</div>
</div>
<script>
	$(function() {
		$('#formRegister').validator().on(
				'submit',
				function(e) {
					if (e.isDefaultPrevented()) {
						// handle the invalid form...
					} else {
						blockUi();
						// everything looks good!
						$.post(
								"RegisterEmail",
								$("#formRegister").serialize(),
								function(data) {
									var jdata = JSON.parse(data);
									if (jdata.code == -1) {
										$("#errorField .message").text(
												jdata.message);
										$("#errorField").show();
										$("#successField").hide();
									} else {
										$("#successField .message").text(
												jdata.message);
										$("#errorField").hide();
										$("#successField").show();
										$("#formRegister").hide();
									}
								}).always(function() {
							unBlockUi();
						});
					}
					return false;
				});

	});
</script>

</jsp:attribute>
</mt:login-register>