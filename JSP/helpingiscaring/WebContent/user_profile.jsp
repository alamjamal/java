<%@page import="model.UserModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
UserModel model = (UserModel)session.getAttribute("model");
    if(model==null){
    	request.getRequestDispatcher("index.jsp").forward(request, response);
    }

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/loginstyle.css" rel="stylesheet" type="text/css" />
<title>Insert title here</title>
</head>
<body class="mybody">
<jsp:include page="header.jsp" />  

 
     
        
   <div class="content">
			<p style="color:white;">${editmsg} </p>
			<form action="UserProfileUpdate" method="POST"  onsubmit="return Validate()" name="vForm">
			 <input type="hidden" name="form" value="form3" />
				<div>
			<input type="text" name="name" class="textInput"  value="${model.getName()}"  placeholder="Name">
					<div id="name_error" class="val_error">
					</div>
				</div>
                
              
				<div>
					<input type="text" name="mobile" class="textInput"  value="${model.getMobile()}" placeholder="Mobile Number">
					<div id="email_error" class="val_error">
					</div>
				</div>
				  <div>
					<input type="email" name="email" class="textInput"  value="${model.getEmail()}"  readonly="readonly" >
					<div id="name_error" class="val_error">
					</div>
				</div>
			
				<div>
					<input type="submit" class="login" name="register" value="UPDATE">
				</div>
				<div class="foo">

				<div>
					<a href="user_changepassword.jsp" id="fg"> Change Password </a>
				</div>
				
				<div>
					<a href="user_registration.jsp" id="rg"></a>
				</div>

</div>
			</form>
		</div>
		
		
</body>
</html>