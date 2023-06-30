<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="book.BookVO"%>
<%@page import="book.BookRepository"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.flex {
	display: flex;
	align-items: center;
	justify-content: space-between;
}

.description {
	width: 90%;
}
</style>
</head>
<body>
	<%@include file="header.jsp"%>
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">도서 목록</h1>
		</div>
	</div>
	<%
	BookRepository repository = BookRepository.getInstance();
	List<BookVO> list = repository.getAllProducts();
	%>
	<c:set var="list" value="<%=list%>" />
	<div class="container">
		<div class="media">
			<div class="media-body">
				<c:forEach var="vo" items="${list}" varStatus="stat">
					<h3 class="media-heading">${vo.name}</h3>
					<div class="flex">
						<p class="description">${vo.description}</p>
						<a href="product.jsp?bookId=${vo.bookId}"
							class="btn btn-secondary">상세정보</a>
					</div>
					<p>${vo.author} | ${vo.publisher} | ${vo.unitprice}원</p>
					<hr>
				</c:forEach>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>