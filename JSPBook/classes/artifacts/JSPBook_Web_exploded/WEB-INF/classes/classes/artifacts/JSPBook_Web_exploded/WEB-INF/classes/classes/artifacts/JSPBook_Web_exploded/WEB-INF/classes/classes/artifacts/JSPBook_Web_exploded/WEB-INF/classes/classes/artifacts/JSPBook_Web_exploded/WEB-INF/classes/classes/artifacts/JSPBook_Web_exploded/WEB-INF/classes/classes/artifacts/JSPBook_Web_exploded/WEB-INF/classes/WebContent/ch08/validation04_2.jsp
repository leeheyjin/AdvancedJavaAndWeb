<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="validation03_process.jsp" method="post" name="loginForm">
		<p>
			아이디: <input type="text" name="id">
		</p>
		<p>
			비밀번호: <input type="password" name="password">
		</p>
		<p>
			<input type="button" value="전송" onclick="checkLogin()">
		</p>
	</form>

	<script type="text/javascript">
		function checkLogin() {
			let form = document.forms[0];
			let id = form.elements.id;
			let password = form.elements.password;
			// 아이디는 영문 소문자만 입력 가능
			for (let i = 0; i < id.value.length; i++) {
				let ch = id.value.charAt(i);
				if ((ch < 'a' || ch > 'z') && (ch >= 'A' || ch <= 'Z') && (ch >= '0' || ch <= '9')) {
					alert("아이디는 영문 소문자만 입력할 수 있습니다.")
					id.select();
					return;
				}
			}
			// 비밀번호는 숫자만 입력 가능
			if (isNaN(password.value)) {
				alert("비밀번호는 숫자만 입력 가능하빈다");
				password.select();
				return;
			}
			form.submit();
		}
	
	</script>
</body>
</html>