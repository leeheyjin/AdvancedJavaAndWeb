<%--
  Created by IntelliJ IDEA.
  User: leehyejin
  Date: 2023/08/29
  Time: 12:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Login</h1>
<form action="/login" method="post">
    ID <input type="text" name="username" value=""><br>
    PASSWORD <input type="password" name="password" value=""><br>
    <input type="submit" value="Login">
    <sec:csrfInput/>
</form>
<hr>
<h1>Logout</h1>

<form action="/logout" method="post">
    <sec:csrfInput/>
    <input type="submit" value="LogOut">
</form>
</body>
</html>
