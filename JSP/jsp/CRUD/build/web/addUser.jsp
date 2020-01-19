<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add New User</title>
    </head>
    <body>
        <form method="POST" action='UserController' name="frmAddUser">
            
            <input type="hidden" name="actions" value="insert" />
            <p><b>Add New Record</b></p>
            <table>
                <tr>
                    <td>User ID</td>
                    <td><input type="text" name="userId" /></td>
                </tr>
                <tr>
                    <td> Name</td>
                    <td><input type="text" name="name" /></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="email" name="email" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Submit" /></td>
                </tr>
            </table>
        </form>
        <p><a href="UserController?actions=listUser">View-All-Records</a></p>
    </body>
</html>