<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
h1 {
	color: aqua;
}

p {
	background: yellow;
}

table {
	border-collapse: collapse;
	border: 3px solid olive;
}

td {
	width: 300px;
	height: 50px;
	text-align: center;
}
</style>
</head>
<body>
	<h1>JSP: Java Server Page</h1>
	<p>html안에서 자바코드를 기술한다</p>
	<p>기술된 자바코드는 서버내에서 실행된다</p>
	<p>자바코드를 기술할 때앤 &lt;% %&gt; 기호 내에서 한다</p>

	<%
	// 입력한 id와 비번을 받는다
	String userId = request.getParameter("id");
	String userPassword = request.getParameter("password");
	// db처리 - crud 처리를 한다
	// 결과값으로 응답페이지를 만든다
	%>
	<div>
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><%=userId%></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><%=userPassword%></td>
			</tr>
		</table>
	</div>
</body>
</html>