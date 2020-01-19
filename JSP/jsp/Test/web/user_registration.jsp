<%-- 
    Document   : registration
    Created on : Dec 21, 2016, 5:12:42 PM
    Author     : alam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Page</title>
    </head>
    <body>
        <jsp:include page="index.jsp" />  
        <br>

    <center>
        <h3>User Registration</h3>
        <form action="user_registration" method="post">
            <input type="hidden" name="form" value="form1" />

            <table border="1">
                <thead>
                    <tr>
                        <th colspan="2"> ${msg} </th>

                    </tr>
                </thead>
                <tbody>


                    <tr>
                        <td> name : </td>
                        <td><input type="text" name="name" value="" /> </td>
                    </tr>
                    <tr>
                        <td>email</td>
                        <td><input type="email" name="email" value="" /></td>
                    </tr>
                    <tr>
                        <td>mobile number</td>
                        <td><input type="text" name="mobile" value="" /></td>
                    </tr>
                    <tr>
                        <td>password</td>
                        <td><input type="password" name="pass1" value="" /></td>
                    </tr>
                    <tr>
                        <td>Re Enter Password</td>
                        <td><input type="password" name="pass2" value="" /></td>
                    </tr>



                    <tr>

                        <td colspan="2"><center><input type="submit" value="register" name="register" /></center></td>
                </tr>
                </tbody>
            </table>
        </form>
    </center>
</body>
</html>
