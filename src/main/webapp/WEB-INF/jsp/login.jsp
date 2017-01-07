<%--
  Created by IntelliJ IDEA.
  User: stancioi
  Date: 12/24/2016
  Time: 5:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form method="post" action="/do_login">
    <table border="1" width="30%" cellpadding="3" style="text-align: center">
        <thead>
        <tr>
            <th colspan="2">Login</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>User Name</td>
            <td><input type="text" name="username" value="" /></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password" value="" /></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Login" /></td>
        </tr>
        </tbody>
    </table>
    <a href="/register">Register here!</a>
    </form>
</body>
</html>
