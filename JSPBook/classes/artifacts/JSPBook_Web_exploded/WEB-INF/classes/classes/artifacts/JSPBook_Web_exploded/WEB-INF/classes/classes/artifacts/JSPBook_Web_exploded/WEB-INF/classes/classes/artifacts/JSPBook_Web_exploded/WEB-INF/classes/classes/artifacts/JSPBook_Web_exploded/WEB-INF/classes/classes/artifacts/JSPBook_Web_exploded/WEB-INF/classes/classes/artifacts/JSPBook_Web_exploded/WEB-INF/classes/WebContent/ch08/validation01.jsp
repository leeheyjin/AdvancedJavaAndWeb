<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="validation02_process.jsp" name="loginForm" method="post">
		<p>
			아이디: <input type="text" name="id">
		</p>
		<p>
			비밀번호: <input type="password" name="password">
		</p>
		<p>
			<input type="button" value="전송" onclick="checkForm()">
		</p>
	</form>
	
	<script type="text/javascript">
	function checkForm() {
		let form = document.loginForm;
		if (form.id.value == "") {
			alert("아이디를 입력해주세요");
			form.id.focus(); // 해당 항목에 커서가 위치함
			return false;
		} else if (form.password.value == "") {
			alert("비밀번호를 입력해주세요");
			form.password.focus();
			return false;
		}
		form.submit();
	}
	
	</script>
</body>
</html>