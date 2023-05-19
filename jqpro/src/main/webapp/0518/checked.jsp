<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSP: Java Server Page</h1>
	hello
	<%
	request.setCharacterEncoding("UTF-8");
	String userName = request.getParameter("user");
	String[] hobbies = request.getParameterValues("hobby");
	
	String hobbiesStr = "";
	for (int i = 0; i < hobbies.length; i++){
		hobbiesStr += hobbies[i] + " ";
	}
	%>
	<p>
	이름 <%= userName %><br>	
	취미 <%= hobbiesStr %>
	</p>
</body>
</html>