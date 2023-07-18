<%--
  Created by IntelliJ IDEA.
  User: leehyejin
  Date: 2023/07/17
  Time: 2:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>내가만든국희</title>
</head>
<body>
<%
    Cookie[] cookies = request.getCookies();
    out.print("cookie length: " + cookies.length + "<br>");
    for (int i = 0; i < cookies.length; i++) {
        out.print(cookies[i].getName() + ": " + cookies[i].getValue());
    }
    out.print("<br>session.getId(): " + session.getId());
%>
<form action="cookie01_process.jsp" method="post">
    <p>아이디: <input type="text" name="id"></p>
    <p>비밀번호: <input type="password" name="password"></p>
    <p><input type="submit" value="전송"></p>
</form>
</body>
</html>
