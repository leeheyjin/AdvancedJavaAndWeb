<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
p {
	border: 2px solid blue;
	padding: 5px;
}
</style>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
	String username = request.getParameter("name");
	String userAge = request.getParameter("age");
	%>
	<h1>JSP: Java Server Page</h1>
	<p>
		이름: <%=username%><br>
		나이: <%=userAge%>
	</p>
</body>
</html>