<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.Calendar"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Implicit Object(내장 객체)</title>
</head>
<body>
	<form action="out02_process.jsp" method="post">
		<p>
			아이디: <input type="text" name="id" required placeholder="아이디를 입력하세요">
		</p>
		<p>
			비밀번호: <input type="password" name="password" required
				placeholder="비밀번호를 입력하세요">
		</p>
		<input type="submit" value="전송">
	</form>
</body>
</html>