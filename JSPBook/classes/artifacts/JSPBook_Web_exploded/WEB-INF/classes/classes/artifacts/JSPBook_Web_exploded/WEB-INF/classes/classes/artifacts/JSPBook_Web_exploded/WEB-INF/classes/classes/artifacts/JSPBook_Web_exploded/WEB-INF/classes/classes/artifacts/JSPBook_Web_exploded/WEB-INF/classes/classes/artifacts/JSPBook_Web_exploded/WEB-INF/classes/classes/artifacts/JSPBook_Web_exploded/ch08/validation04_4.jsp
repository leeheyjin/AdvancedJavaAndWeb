<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form>
		<p>
			이름: <input type="text" name="name" value="1개똥이">
		</p>
		<p>
			<input type="button" value="전송" onclick="checkForm()">
		</p>
	</form>
	
	<script type="text/javascript">
		function checkForm() {
			// 이름은 숫자로 시작할 수 없음
			let nameValue = document.forms[0].elements.name.value;
			let regExp = /^[0-9]/; // i: ignore 대소문자를 구별하지 않음
			if(regExp.test(nameValue)) { // test(): 정규식 실행후 성공이면 true, 실패면 false 반환
				alert("이름을 숫자로 시작할 수 없습니다.")
				return;
			} 
			console.log(result);
		}
	
	</script>
</body>
</html>