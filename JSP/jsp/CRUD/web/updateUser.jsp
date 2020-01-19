<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="dao.UserDAOImplementation"%>
<%@ page import="bean.UserBean"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update User</title>
    </head>
    <body>
        <%
            UserBean user = new UserBean();
        %>
        <%
            UserDAOImplementation uidao = new UserDAOImplementation();
        %>
        <form method="POST" action='UserController' name="frmEditUser">
            <input  type="hidden" name="actions" value="edit" /> 
            <%
                String uid = request.getParameter("userId");
                if (!((uid) == null)) {
                    int id = Integer.parseInt(uid);
                    user = uidao.getUserById(id);
            %>
            <table>
                <tr>
                    <td>User ID</td>
                    <td><input type="text" name="userId" readonly="readonly"
                               value="<%=user.getId()%>"></td>
                </tr>
                <tr>
                    <td> Name</td>
                    <td><input type="text" name="name" /></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="text" name="email" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Update" /></td>

                </tr>

            </table>
            <%
                } else
                    out.println("ID Not Found");
            %>
        </form>
    </body>
</html>