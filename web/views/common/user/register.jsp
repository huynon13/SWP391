<%-- 
    Document   : register
    Created on : Mar 2, 2024, 12:27:18 AM
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
        <h2>Register Form</h2>
        <h3 style="color: red">${requestScope.errorRegister}</h3>
        <form action="${pageContext.request.contextPath}/register" method="post">
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
                    <td><input type="checkbox"/> Remember me</td>  
                    <td><a href="${pageContext.request.contextPath}/views/common/user/login.jsp">Login</a></td>
                </tr>
                <tr>
                    <td><input type="submit" value="REGISTER"/></td>
                </tr>
            </table>

        </form>
    </center>

</body>
</html>
