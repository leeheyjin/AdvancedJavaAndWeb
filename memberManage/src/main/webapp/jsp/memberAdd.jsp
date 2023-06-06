<%@page import="kr.or.ddit.basic.controller.MemberAdd"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-3.7.0.min.js"></script>
</head>
<body>
	<h2>회원 정보 입력 폼</h2>
	<form action="<%=request.getContextPath()%>/memberAdd.do" method="post">
		<table border="1">
			<tr>
				<td>
					<label for="id">회원ID</label>
				</td>
				<td>
					<input type="text" id="id" name="id"><input type="button" value="중복확인" id="checkId">
				</td>
			</tr>
			<tr>
				<td>
					<label for="password">비밀번호</label>
				</td>
				<td>
					<input type="password" id="password" name="password">
				</td>
			</tr>
			<tr>
				<td>
					<label for="passwordConfirm">비밀번호 확인</label>
				</td>
				<td>
					<input type="password" id="passwordConfirm" name="passwordConfirm">
				</td>
			</tr>
			<tr>
				<td>
					<label for="name">회원이름</label>
				</td>
				<td>
					<input type="text" id="name" name="name">
				</td>
			</tr>
			<tr>
				<td>
					<label for="tel">전화번호</label>
				</td>
				<td>
					<input type="text" id="tel" name="tel">
				</td>
			</tr>
			<tr>
				<td>
					<label for="address">회원주소</label>
				</td>
				<td>
					<input type="text" id="address" name="address">
				</td>
			</tr>
			<tr>
				<td>
					<label for="profile">프로필사진</label>
				</td>
				<td>
					<input type="file" id="profile" name="profile">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="저장" id="save">
					<input type="reset" value="취소" id="cancel">
					<input type="button" value="회원목록" id="goToList">
				</td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
		$("#checkId").on("click", function() {
			idValue = $("#id").val();
			$.ajax({
				url: "/memberManage/checkId.do",
				data : {
					"id" : idValue
				},
				type : 'post',
				success : function(res) {
					
				},
				error : function(xhr) {
					alert("상태: " + xhr.status);
				},
				dataType : 'json'
			})
		})
	</script>
</body>
</html>