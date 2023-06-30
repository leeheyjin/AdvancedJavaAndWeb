<%@page import="book.BookVO"%>
<%@page import="book.BookRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/bootstrap.min.css">
</head>
<body>
	<%@include file="header.jsp"%>
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">도서 정보</h1>
		</div>
	</div>
	<%
	String bookId = request.getParameter("bookId");
	BookRepository repository = BookRepository.getInstance();
	BookVO vo = repository.getProductById(bookId);
	%>
	<c:set var="vo" value="<%=vo%>" />
	<div class="container">
		<h3><%=vo.getName() %></h3>
		<p>${vo.description }</p>
		<p><b>도서코드</b>: <span class="badge badge-info">${vo.bookId}</span></p>
		<p><b>출판사</b>: ${vo.publisher}</p>
		<p><b>저자</b>: ${vo.author}</p>
		<p><b>재고 수</b>: ${vo.unitsInstock}</p>
		<p><b>총 페이지 수</b>: ${vo.totalPages}</p>
		<p><b>발행일</b>: ${vo.releaseDate}</p>
		<p style="font-size: 2rem;">${vo.unitprice}원</p>
		<a href="#" class="btn btn-secondary" style="margin-right: 10px">도서주문</a><a href="products.jsp" class="btn btn-secondary">도서목록</a>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>