<%-- 
    Document   : login
    Created on : Mar 2, 2024, 12:25:21 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Form</title>
    </head>
    <body>

    <center>
        <h2>Login Form</h2>
        <h3 style="color: red">${requestScope.errorLogin}</h3>
        <form action="${pageContext.request.contextPath}/login" method="post">
            <table>
                <tr>
                    <td>UserName:</td>
                    <td><input type="text" name="username" value="${param.username}" required/></td>
                </tr>

                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="password" value="${param.password}" required/></td>
                </tr>

                <tr>
                    <td><input type="checkbox" name="rememberme"/> Remember me</td>  
                    <td><a href="${pageContext.request.contextPath}/views/common/user/register.jsp">Register</a></td>
                </tr>
                <tr>
                    <td><input type="submit" value="LOGIN"/></td>
                </tr>
            </table>

        </form>
    </center>

</body>
</html>

