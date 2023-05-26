<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>forward방식, redirect방식</h2>
	<form action="<%=request.getContextPath()%>/responseTest01.do">
		forward방식 요청: <input type="text" name="userName"> <input
			type="submit" value="확인">
	</form>
	<form action="/webTest/responseTest02.do">
		redirect방식 요청: <input type="text" name="userName"> <input
			type="submit" value="확인">
	</form>
	<%
	request.setCharacterEncoding("UTF-8");
	%>
</body>
</html>