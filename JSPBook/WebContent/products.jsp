<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="vo.ProductVO"%>
<%@page import="java.util.List"%>
<%@page import="dao.ProductRepository"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
ProductRepository productDAO = ProductRepository.getInstance();
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>상품목록</title>
</head>
<body>
	<%
	List<ProductVO> list = productDAO.getAllProducts();
	%>
	<!-- 
	scope: 영역
	ex) 토르 활동 영역: 대전	          / 대한민국          / 아시아                / 지구
		scope:		 page(동일jsp) / request(동일요청) / session(동일웹브라우저) / application(모든웹브라우저)
		 
	 -->
	<c:set var="list" value="<%=list %>" scope="page"/>
	<%@include file="menu.jsp"%>
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">상품목록</h1>
		</div>
	</div>
	<div class="container">
		<div class="row" align="center">
		<%-- <%
		for(ProductVO productVO : list) {
			%> --%>
		<c:forEach var="product" items="${list}" varStatus="stat">
			<div class="col-md-4">
			<img src="images/${product.filename}" style="width: 100%;">
			<h3>${product.pname}</h3>
			<p>${product.description}</p>
			<p>${product.unitPrice}</p>
			<p><a href="product.jsp?productId=${product.productId}" class="btn btn-secondary">상세정보</a></p>
			</div>
			</c:forEach>
			<%-- <%
		}
		%> --%>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>