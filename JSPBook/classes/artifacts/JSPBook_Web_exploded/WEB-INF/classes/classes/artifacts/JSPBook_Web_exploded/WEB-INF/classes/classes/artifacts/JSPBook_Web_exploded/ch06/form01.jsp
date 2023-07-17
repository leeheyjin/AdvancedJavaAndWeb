<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>form processing</title>
</head>
<body>
	<h3>회원가입</h3>
	<!-- form의 -->
	<form action="form01_process.jsp" name="member" method="post" onsubmit="return submitCheck()">
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
				<option value="019">019</option>
			</select> - <input type="text" name="phone2" size="4" maxlength="4" onkeypress="checkInputNum()"> -
			<input type="text" name="phone3" maxlength="4" size="4" onkeypress="checkInputNum()">
		</p>
		<p>
			성별: 
			<input type="radio" name="gender" value="female" id="female" checked><label for="female">여성</label>
			<input type="radio" name="gender" value="etc" id="etc"><label for="etc">그 외</label>
		</p>
		<p>
			취미: 
			<input type="checkbox" name="hobby" value="reading" id="reading"> <label for="reading">독서</label>
			<input type="checkbox" name="hobby" value="coding" id="coding"> <label for="coding">코딩</label>
			<input type="checkbox" name="hobby" value="exercise" id="exercise"> <label for="exercise">운동</label>
		</p>
		<p>
		<textarea rows="3" cols="30" name="comment" placeholder="가입인사를 작성해주세요"></textarea>
		</p>
		<p><input type="submit" value="가입하기"></p>
		<p>취소하기</p>
	</form>

	<script type="text/javascript">
		function checkInputNum() {
			if ((event.keyCode < 48) || (event.keyCode > 57)) {
				event.returnValue = false;
			}
		}
		
		function submitCheck() {
			let form = document.member;
			if(isNaN(form.phone2.value)){
				alert("휴대폰 번호는 숫자만 입력 가능합니다.");
				form.phone2.select(); // 커서를 해당 요소에 위치
				return false;
			}
			if(isNaN(form.phone3.value)){
				alert("휴대폰 번호는 숫자만 입력 가능합니다.");
				form.phone3.select(); // 커서를 해당 요소에 위치
				return false;
			}
			return true;
			
		}
	</script>
</body>
</html>