<%-- 
    Document   : welcome
    Created on : Dec 21, 2016, 10:10:41 PM
    Author     : alam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="index.jsp" />  
        <h1>Welcome! ${email}</h1>
    </body>
</html>
