<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: leehyejin
  Date: 2023/07/07
  Time: 9:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>국제화</h2>
<%-- 2023.07.07 --%>
<p><fmt:formatDate value="<%=new Date()%>" type="date"/></p>
<%-- 오전 9:38:44 --%>
<p><fmt:formatDate value="<%=new Date()%>" type="time"/></p>
<%-- 2023.07.07 오전 9:38:44 --%>
<p><fmt:formatDate value="<%=new Date()%>" type="both" dateStyle="default" timeStyle="default"/></p>
<p><fmt:formatDate value="<%=new Date()%>" type="both" dateStyle="short" timeStyle="short"/></p>
<p><fmt:formatDate value="<%=new Date()%>" type="both" dateStyle="medium" timeStyle="medium"/></p>
<p><fmt:formatDate value="<%=new Date()%>" type="both" dateStyle="long" timeStyle="long"/></p>
<p><fmt:formatDate value="<%=new Date()%>" type="both" dateStyle="full" timeStyle="full"/></p>
<%-- 가장 많이 사용됨 --%>
<p><fmt:formatDate value="<%=new Date()%>" pattern="yyyy-MM-dd"/></p>
<p><fmt:formatDate value="<%=new Date()%>" pattern="yyyy-MM-dd hh:mm:ss"/></p>
</body>
</html>
