<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSP: Java Server Page</h1>
	<%
	// request.setCharacterEncoding("UTF-8");
	String userId = request.getParameter("id");
	int userNum = Integer.parseInt(request.getParameter("num"));
	String userFile = request.getParameter("file");
	%>

	<p>
		아이디:
		<%=userId%>
	</p>

	<p>
		번호:
		<%=userNum%>
	</p>

	<p>
		파일:
		<%=userFile%>
	</p>
</body>
</html>