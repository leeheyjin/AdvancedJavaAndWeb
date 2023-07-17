<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Scripting Tag</h2>
<!-- 선언문: 변수, 메서드 -->
<%!
/* 전역변수 생성 */
int count = 3;

String makeItLower(String data) {
	return data.toLowerCase();
}
%>

<%
for(int i = 1; i <= count; i++) {
	out.print("J(자)SP(습)으로 실력향상!" + i + "<br>");
}
%>
<%=makeItLower("HELLO WORLD") %>


</body>
</html>