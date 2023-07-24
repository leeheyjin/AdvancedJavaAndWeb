<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <title>상품 목록</title>
</head>
<body>
<!-- 
scope: 활동영역
ex)    대전			/ 대한민국			/ 아시아				/ 지구  
scope영역	: page(동일jsp)/request(동일요청)/session(동일 웹브라우저)/application(모든 웹브라우저)
scope객체	: pageContext /request  		  / session			   /application 
-->
<!-- include 액션 태그 -->
<jsp:include page="menu.jsp"/>

<!-- body시작 -->
<div class="jumbotron">
    <div class="container">
        <h1 class="display-3">상품목록</h1>
    </div>
</div>
<div class="container">
    <!-- 행 별 처리 -->
    <div class="row" style="justify-content: right; margin: 0 0 30px 0;">
        <a href="addProduct.jsp" class="btn btn-primary">상품 추가</a>
    </div>

    <div class="row" align="center">
        <c:forEach var="product" items="${listOfProducts}" varStatus="stat">
            <div class="col-md-4"><!-- 열 별 처리 -->
                <img src="/resources/images/${product.filename}"
                     style="width:200px; height: 200px; margin-bottom: 30px;"
                     alt="${product.pname}"
                     title="${product.pname}"/>
                <h3>${product.pname}</h3>
                <p>${product.description}</p>
                <p>${product.unitPrice}원</p>
                <p>
                    <a href="/shopping/product?productId=${product.productId}" class="btn btn-secondary" role="button">
                        상세정보
                    </a>
                </p>
            </div>
        </c:forEach>
    </div>
</div>
<!-- body끝 -->

<!-- footer -->
<jsp:include page="footer.jsp"/>
</body>
</html>