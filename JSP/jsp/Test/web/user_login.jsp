<%-- 
    Document   : login
    Created on : Dec 22, 2016, 4:44:30 PM
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
        <br> <br>  <br>
    <center>
        <form action="user_login" method="post">
            <table border="1">
                <thead>
                    <tr>
                        <th colspan="2">user login</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td> user name</td>
                        <td> <input type="email" name="email" value="" /></td>
                    </tr>
                    <tr>
                        <td>password</td>
                        <td><input type="password" name="pass1" value="" /></td>
                    </tr>
                    <tr>
                        <td colspan="2"> <center><input type="submit" value="submit" name="submit" /> </center></td>

                </tr>
                </tbody>
            </table>
        </form>
    </center>
</body>
</html>
