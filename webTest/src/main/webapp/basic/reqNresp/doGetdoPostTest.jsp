<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Servlet 요청 연습</title>
</head>
<body>
	<h2>Servlet 요청하기</h2>
	<hr>
	<h3>GET방식 요청 방식1: a태그의 href속성에 url 직접 지정</h3>
	<a href="http://localhost/webTest/servletTest03.do">GET방식 요청1</a>
	<hr>
	<h3>GET방식 요청 방식2: form태그의 method속성을 생략하거나 'get'으로 설정</h3>
	<form action="http://localhost/webTest/servletTest03.do" method="get" target="_blank">
		<input type="submit" value="GET방식 요청2">
	</form>
	<hr>
	<h3>GET방식 요청 방식3: JavaScript의 location.href속성 이용</h3>
	<form>
		<input type="button" id="getBtn" value="GET방식 요청3">
	</form>
	<hr>
	<h3>POST방식 요청 방식: form태그의 method속성을 'post'으로 설정</h3>
	<form action="http://localhost/webTest/servletTest03.do" method="post">
		<input type="submit" value="POST방식 요청">
	</form>
	
	<script type="text/javascript">
	document.getElementById("getBtn").addEventListener("click", function() {
		location.href = "http://localhost/webTest/servletTest03.do";
	})
	</script>
	
</body>
</html>