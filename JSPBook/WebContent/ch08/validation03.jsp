<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="validation03_process.jsp" method="post">
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
			// 아이디: 4~12글자
			if(id.value.length < 4 || id.value.length > 12) {
				alert("아이디는 4~12자 사이여야 합니다");
				id.select(); // select() == focus()
				return;
			} 
			
			if (password.value.length < 4) {
				alert("비밀번호는 4자 이상이어야 합니다");
				password.select();
				return;
			}
			form.submit();
		}
	
	</script>
</body>
</html>