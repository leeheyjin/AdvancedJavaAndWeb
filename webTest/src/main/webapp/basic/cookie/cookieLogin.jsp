<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
td {
	padding: 2px;
}

td#buttonTd {
	text-align: center;
}

#button {
	width: 100%;
}
</style>
</head>
<%
// 쿠키 정보를 읽어와 처리한다
String cookieId = ""; // 쿠키값이 저장될 변수
String checked = "";
Cookie[] cookies = request.getCookies();
for (Cookie cookie : cookies) {
	if (cookie.getName().equals("id")) {
		cookieId = cookie.getValue();
		checked = "checked";
	}
}

%>


<body>
	<h2>Login</h2>
	<form action="<%=request.getContextPath()%>/cookieLoginServlet.do">
		<table>
			<tr>
				<td><label for="id">ID: </label></td>
				<td><input id="id" type="text" size="20" placeholder="ID를 입력하세요." name="id" value="<%=cookieId%>"><br></td>
				<td><input type="checkbox" name="rememberId" id="rememberId" <%=checked %>> ID 기억하기</td>
			</tr>
			<tr>
				<td><label for="pass">PASS: </label></td>
				<td><input id="pass" type="password" size="20" placeholder="PassWord를 입력하세요." name="pass"><br></td>
				<td id="buttonTd"><input type="submit" value="로그인" id="button"></td>
			</tr>
		</table>
	</form>
</body>
</html>