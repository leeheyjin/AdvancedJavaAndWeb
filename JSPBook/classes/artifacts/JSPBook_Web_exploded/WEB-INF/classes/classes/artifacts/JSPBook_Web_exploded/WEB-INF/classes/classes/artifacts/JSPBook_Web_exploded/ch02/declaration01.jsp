<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 선언문태그로 정수형 변수 data에 50을 할당 -->
<%!
int data = 50;
%>

<%
out.println("data: " + data);
%>
</body>
</html>