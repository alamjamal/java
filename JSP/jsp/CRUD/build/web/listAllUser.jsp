<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="bean.UserBean"%>
<%@ page import="dao.UserDAOImplementation"%>
<%@ page import="java.util.*"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Of All User</title>
    </head>
    <body>
        <%
            //UserBean user = new UserBean();
            UserDAOImplementation uidao = new UserDAOImplementation();
            List<UserBean> userList = uidao.getAllUsers();
            // Iterator<UserBean> itr = userList.iterator();
        %>
        <table border="1">
            <tr>
                <th>Id</th>
                <th> Name</th>
                <th>Email</th>
            </tr>
            <tr>
                <%
                    /*while(itr.hasNext())
{
System.out.println(user.getId());*/
                    for (UserBean user : userList) {%>


                <td><%=user.getId()%></td>
                <td><%=user.getName()%></td>
                <td><%=user.getEmail()%></td>
                <td><a
                        href="UserController?actions=editform&userId=<%=user.getId()%>">Update</a></td>
                <td><a
                        href="UserController?actions=delete&userId=<%=user.getId()%>">Delete</a></td>

            </tr>
            <%
                }

            %>
        </table>
        <p><a href="UserController?actions=insert">Add User</a></p>
    </body>
</html>