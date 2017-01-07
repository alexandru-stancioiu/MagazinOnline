<%--
  Created by IntelliJ IDEA.
  User: stancioi
  Date: 12/25/2016
  Time: 2:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<form method="post" action="/do_register">
    <table border="1" width="30%" cellpadding="3">
        <thead>
        <tr>
            <th colspan="2">Register</th>
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
            <td colspan="2"><input type="submit" value="Register" /></td>
        </tr>
        </tbody>
    </table>
</form>
<a href="/">Back to login page</a>
</body>
</html>
