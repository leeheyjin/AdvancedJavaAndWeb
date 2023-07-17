<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
// setHeader(): 헤더 이름에 문자열 값을 설정
response.setHeader("Cache-control", "use-cache");
// addHeader(): 헤더 이름에 값을 설정
response.addHeader("contentType", "text/html; charset=utf-8");
// setDateHeader(): 헤더 이름에 날짜/시간 설정
response.setDateHeader("date", 10000L);
%>
<p>Cache-control: <%=response.getHeader("Cache-control") %></p>
<p>contentType: <%=response.getHeader("contentType") %></p>
<p>date: <%=response.getHeader("date") %></p>
</body>
</html>