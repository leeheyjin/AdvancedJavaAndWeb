<%--
  Created by IntelliJ IDEA.
  User: leehyejin
  Date: 2023/07/07
  Time: 9:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>국제화</h2>
<%--tntwk: 3,200,100--%>
<p>숫자: <fmt:formatNumber value="3200100"/></p>
<p>숫자: <fmt:formatNumber value="3200100" type="number"/></p>
<p>숫자: <fmt:formatNumber value="3200100" type="number" groupingUsed="false"/></p>
<p>숫자: <fmt:formatNumber value="3200100" type="currency" groupingUsed="true"/></p>
<p>숫자: <fmt:formatNumber value="3200100" type="currency" currencySymbol="금"/></p>
<p>숫자: <fmt:formatNumber value="0.45" type="percent" currencySymbol="금"/></p>
<p>숫자: <fmt:formatNumber value="3200100.45" pattern=".000"/></p>
<%-- 가장 많이 사용함--%>
<p>숫자: <fmt:formatNumber value="3200100.456" pattern="#,#00.0#"/></p>
</body>
</html>
