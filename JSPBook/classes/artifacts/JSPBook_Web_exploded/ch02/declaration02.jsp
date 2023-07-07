<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!int sum(int num1, int num2) {
		return num1 + num2;
	}%>
	<%
	out.println("2 + 3 = " + sum(2, 3));
	%>

	<%!int mul(int num1, int num2) {
		return num1 * num2;
	}%>

	<%
	for (int i = 2; i <= 9; i++) {
		for (int j = 1; j <= 9; j++) {
			out.print("<p>" + i + " * " + j + " = " + mul(i, j) + "</p>");
		}
	}
	%>
</body>
</html>