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
			이름: <input type="text" name="name">
		</p>
		<p>
			<input type="button" value="전송" onclick="checkForm()">
		</p>
	</form>
	
	<script type="text/javascript">
		function checkForm() {
			let form = document.forms[0];
			let name = form.elements.name;
			if(!isNaN(name.value.substr(0, 1))){
				alert("이름은 숫자로 시작할 수 없습니다");
				name.select();
				return;
			}
			form.submit();
		}
	
	</script>
</body>
</html>