<%@page import="vo.ProductVO"%>
<%@page import="dao.ProductRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
ProductRepository repository = ProductRepository.getInstance();
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>상품 상세 정보</title>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">상품 정보</h1>
		</div>
	</div>
	<%
	String productId = request.getParameter("productId");
	ProductVO vo = repository.getProductById(productId);
	%>
	<c:set var="vo" value="<%=vo %>"/>
	<div class="container">
		<div class="row">
			<div class="col-md-5">
				<img alt="${vo.filename}"
					src="/images/${vo.filename}" style="width: 100%">
			</div>
			<div class="col">
				<h3>${vo.pname}</h3>
				<p>${vo.description}</p>
				<p>
					<b>상품 코드: </b> 
					<span class="badge badge-danger">${vo.productId}</span>
				</p>
				<p>
					<b>제조사: </b>${vo.manufacturer}
				</p>
				<p>
					<b>분류: </b>${vo.category}
				</p>
				<p>
					<b>재고: </b>${vo.unitsInStock}
				</p>
				<p>
					상품 주문
					장바구니
					<a href="products.jsp" class="btn btn-secondary">상품 목록</a>
				</p>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>