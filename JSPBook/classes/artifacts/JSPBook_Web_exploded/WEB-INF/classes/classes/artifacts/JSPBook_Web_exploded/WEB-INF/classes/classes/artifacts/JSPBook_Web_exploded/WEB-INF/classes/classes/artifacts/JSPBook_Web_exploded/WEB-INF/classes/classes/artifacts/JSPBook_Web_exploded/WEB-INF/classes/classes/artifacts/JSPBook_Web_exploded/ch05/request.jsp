<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Implicigt Object</title>
</head>
<body>
	<form action="request01_process.jsp" method="post">
		<p>
			아이디: <input type="text" name="id" placeholder="아이디를 입력해주세요" required>
		</p>
		<p>
			비밀번호: <input type="password" name="password" placeholder="비밀번호를 입력해주세요" required>
		</p>
		<p>
			<input type="submit" value="전송">
		</p>
	</form>
</body>
</html>