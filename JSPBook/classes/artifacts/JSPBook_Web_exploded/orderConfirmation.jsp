<%--
  Created by IntelliJ IDEA.
  User: leehyejin
  Date: 2023/07/17
  Time: 4:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="vo.ProductVO" %>
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

    ArrayList<ProductVO> cartList = (ArrayList<ProductVO>) session.getAttribute("cartlist");
%>
<c:set var="cartList" value="<%=cartList%>"/>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <title>주문정보</title>
</head>
<body>
<jsp:include page="menu.jsp"/>
<div class="jumbotron">
    <div class="container">
        <h1 class="display-3">주문 정보</h1>
    </div>
</div>
<div class="container col-8 alert alert-info">
    <div class="text-center">
        <h1>영수증</h1>
    </div>
    <div class="row justify-content-between">
        <strong>배송 주소</strong><br>
        성명: <%=shipping_name%><br>
        우편번호: <%=shipping_zipCode%><br>
        주소: <%=shipping_addressName%> <%=shipping_country%><br>
    </div>
    <div class="col-4" align="right">
        <p>
            <em>배송일: <%=shipping_shippingDate%>
            </em>
        </p>
    </div>
    <div>
        <table class="table table-hover">
            <tr>
                <th class="text-center">상품명</th>
                <th class="text-center">#</th>
                <th class="text-center">가격</th>
                <th class="text-center">소계</th>
            </tr>
            <tr>
                <c:forEach var="productVO" items="${cartList}" varStatus="stat">
                    <c:set var="total" value="${total + productVO.unitPrice * productVO.quantity}"/>
                    <td class="text-center"><em>${productVO.pname}</em></td>
                    <td class="text-center">${productVO.quantity}</td>
                    <td class="text-center">
                        <fmt:formatNumber value="${productVO.unitPrice}" pattern="#,###"/></td>
                    <td class="text-center">${productVO.unitPrice * productVO.quantity}</td>
                </c:forEach>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td class="text-align"><strong>총액:</strong></td>
                <td class="text-center text-danger">
                    <strong><fmt:formatNumber value="${total}" pattern="#,###"/> </strong>원
                </td>
            </tr>
        </table>
    </div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
