<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bbswrite.jsp</title>
<style>
span {
	width: 60px;
	display: inline-block;
}

textarea {
	width: 40%;
	height: 280px;
}
.right {
	text-align: center;
}
img {
	height: 30px;
}
body {
        display: flex;
        flex-direction: column;
        align-items: center;
        height: 100vh;
    }
</style>
</head>
<body>
<h2>kakaoPay결제</h2>

	<form action="kakao2.jsp">
		<table border="1">
			<tr>
			<td>회원ID</td>
			<td><input name="name"></td>
			</tr>

			<!-- 값 가져오기 -->
		<tr>
			<td>이메일:</td> 
			<td><input name="email"></td>
		</tr>

		<tr>
			<td>전화번호</td>
			<td><input type="text" name="phone"></td>
		</tr>	

		<tr>
			<td>주소</td>
			<td><input name="address"></td>
		</tr>
		
		<tr>
			<td>결제금액</td>
			<td><input name="totalPrice"></td>
		</tr>
		<tr>
			<td colspan="2" class="right">
				<button type="submit">
					<img src="./images/payment_icon_yellow_small.png" alt="결제하기">
				  </button>
				<input type="reset" value="취소하기">
			</td>
		</tr>
			
		 
		</table>
	</form>


</body>
</html>
