<%--
  Created by IntelliJ IDEA.
  User: leehyejin
  Date: 2023/07/17
  Time: 2:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>너를위해구웟지</title>
</head>
<body>
<%
    String userId = request.getParameter("id");
    String userPassword = request.getParameter("password");

    Cookie cookieId = new Cookie("userId", userId);
    Cookie cookiePassword = new Cookie("userPassword", userPassword);
    response.addCookie(cookieId);
    response.addCookie(cookiePassword);

    Cookie[] cookies = request.getCookies();
    out.print("cookie length: " + cookies.length + "<br>");
    for (int i = 0; i < cookies.length; i++) {
        out.print(cookies[i].getName() + ": " + cookies[i].getValue());
    }
%>
</body>
</html>
