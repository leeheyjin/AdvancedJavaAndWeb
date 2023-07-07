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
			이름: <input type="text" name="name" value="Java Server Page">
		</p>
		<p>
			<input type="button" value="전송" onclick="checkForm()">
		</p>
	</form>
	
	<script type="text/javascript">
		function checkForm() {
			// 정규 표현식 선언: /로 시작해서 /로 끝남
			let regExp = /Java/i; // i: ignore 대소문자를 구별하지 않음
			let nameValue = document.forms[0].elements.name.value;
			let result = regExp.exec(nameValue); // exec(): 글자 추출
			console.log(result);
		}
	
	</script>
</body>
</html>