<%--
  Created by IntelliJ IDEA.
  User: leehyejin
  Date: 2023/07/18
  Time: 10:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>주문 취소</title>
</head>
<body>
<%@ include file="menu.jsp" %>
<div class="jumbotron">
    <div class="container">
        <h1 class="display-3">
            주문 취소
        </h1>
    </div>
</div>
<%
session.removeAttribute("cartlist");
%>
<div class="container">
    <h2 class="alert alert-danger">주문이 취소되었습니다.</h2>
</div>
<div class="container">
    <p><a href="products.jsp" class="btn btn-secondary">&laquo;상품 목록</a></p>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>
