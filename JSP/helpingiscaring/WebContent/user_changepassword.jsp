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
			<p style="color:white;">${pmsg} </p>
			<form action="PasswordReset" method="POST" >
			 <input type="hidden" name="form" value="form4" />
				<div>
			<input type="password" name="pass1" class="textInput"  value=""  placeholder="Old Password">
					<div id="name_error" class="val_error">
					</div>
				</div>
                
              
				<div>
			<input type="password" name="pass" class="textInput"  value=""  placeholder="Enter New password">
					<div id="name_error" class="val_error">
					</div>
				</div>
				<div>
			<input type="password" name="rpass" class="textInput"  value=""  placeholder="Re-Enter New password">
					<div id="name_error" class="val_error">
					</div>
				</div>
				
				<div>
					<input type="submit" class="login" name="register" value="UPDATE">
				</div>
				
			</form>
		</div>
		
		
		
 
</body>
</html>