<%--
  Created by IntelliJ IDEA.
  User: leehyejin
  Date: 2023/07/18
  Time: 9:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.net.URLDecoder" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String shipping_cartId = request.getParameter("cartId");
    String shipping_name = request.getParameter("name");
    String shipping_shippingDate = request.getParameter("shippingDate");
    String shipping_country = request.getParameter("country");
    String shipping_zipCode = request.getParameter("zipCode");
    String shipping_addressName = request.getParameter("addressName");

    Cookie[] cookies = request.getCookies();
    for (int i = 0; i < cookies.length; i++) {
        Cookie thisCookie = cookies[i];
        if (thisCookie.getName().equals("shipping_cartId")) {
            shipping_cartId = URLDecoder.decode(thisCookie.getValue(), "utf-8");
        }
        if (thisCookie.getName().equals("shipping_name")) {
            shipping_name = URLDecoder.decode(thisCookie.getValue(), "utf-8");
        }
        if (thisCookie.getName().equals("shipping_shippingDate")) {
            shipping_shippingDate = URLDecoder.decode(thisCookie.getValue(), "utf-8");
        }
        if (thisCookie.getName().equals("shipping_country")) {
            shipping_country = URLDecoder.decode(thisCookie.getValue(), "utf-8");
        }
        if (thisCookie.getName().equals("shipping_zipCode")) {
            shipping_zipCode = URLDecoder.decode(thisCookie.getValue(), "utf-8");
        }
        if (thisCookie.getName().equals("shipping_addressName")) {
            shipping_addressName = URLDecoder.decode(thisCookie.getValue(), "utf-8");
        }
    }
%>
<%@ include file="menu.jsp" %>

<div class="jumbotron">
    <div class="container">
        <h1 class="display-3">
            배송 정보
        </h1>
    </div>
</div>
<div class="container">
    <%-- 주문 완료 내용 시작 --%>
    <h2 class="alert alert-danger">주문 감사합니다.</h2>
    <p>주문은 <%=shipping_shippingDate%>에 배송될 예정입니다.</p>
    <p>주문번호: <%=shipping_cartId%>
    </p>
    <%-- 주문 완료 내용 끝 --%>
</div>
<div class="container">
    <p><a href="products.jsp" class="btn btn-secondary">&laquo;상품 목록</a></p>
</div>
<%@ include file="footer.jsp" %>
<%
    // 장바구니 비우기
    session.removeAttribute("cartlist");
    // 쿠키 비우기
    for (int i = 0; i < cookies.length; i++) {
        Cookie thisCookie = cookies[i];
        if (thisCookie.getName().equals("shipping_cartId")) {
            thisCookie.setMaxAge(0);
        }
        if (thisCookie.getName().equals("shipping_name")) {
            thisCookie.setMaxAge(0);
        }
        if (thisCookie.getName().equals("shipping_shippingDate")) {
            thisCookie.setMaxAge(0);
        }
        if (thisCookie.getName().equals("shipping_country")) {
            thisCookie.setMaxAge(0);
        }
        if (thisCookie.getName().equals("shipping_zipCode")) {
            thisCookie.setMaxAge(0);
        }
        if (thisCookie.getName().equals("shipping_addressName")) {
            thisCookie.setMaxAge(0);
        }
        response.addCookie(thisCookie);
    }
%>
</body>
</html>
