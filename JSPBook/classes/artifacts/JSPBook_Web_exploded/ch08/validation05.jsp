<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="validation05_process.jsp" method="post">
		<p>
			아이디: <input type="text" name="id">
		</p>
		<p>
			비밀번호: <input type="password" name="password">
		</p>
		<p>
			이름: <input type="text" name="name">
		</p>
		<p>
			연락처: <select name="phone1">
				<option value="010">010</option>
				<option value="011">011</option>
				<option value="016">016</option>
				<option value="017">017</option>
				<option value="018">018</option>
			</select> - <input type="text" maxlength="4" size="4" name="phone2"> -
			<input type="text" maxlength="4" size="4" name="phone3">
		</p>
		<p>
			이메일: <input type="text" name="email">
		</p>
		<p>
			<input type="button" value="전송" onclick="checkMember()">
		</p>
	</form>

	<script type="text/javascript">
		function checkMember() {
			let form = document.forms[0];
			// 아이디는 문자로 시작
			let regExpId = /^[a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
			let id = form.elements.id;
			if (!regExpId.test(id.value)) {
				alert("아이디는 문자로 시작해야 합니다.");
				id.select();
				return;
			}
			// 비밀번호는 숫자만 입력
			let regExpPassword = /^[0-9]*$/;
			let password = form.elements.password;
			if (!regExpPassword.test(password.value)) {
				alert("비밀번호는 숫자만 입력 가능합니다");
				password.select();
				return;
			}
			// 이름은 한글만 입력
			let regExpName = /^[가-힣]*$/;
			let name = form.elements.name;
			if (!regExpName.test(name.value)) {
				alert("이름은 한글로만 입력 가능합니다");
				name.select();
				return;
			}
			// 연락처 형식 준수(010-000-0000, 010-0000-0000)
			let regExpTel = /^\d{3}-\d{3,4}-\d{4}$/;
			let tel = `\${form.elements.phone1.value}-\${form.elements.phone2.value}-\${form.elements.phone3.value}`;
			if (!regExpTel.test(tel)) {
				alert("전화번호 형식에 맞춰 입력해주세요 \nex)010-000-0000 또는 010-0000-0000");
				return;
			}
			// 이메일
			let regExpEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
			let email = form.elements.email;
			if (!regExpEmail.test(email.value)) {
				alert("이메일 형식과 맞지 않습니다. 다시 입력해주세요");
				email.select();
				return;
			}
			form.submit();
		}
	</script>
</body>
</html>