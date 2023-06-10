<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="kr.or.ddit.member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/tableStyle.css">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.7.0.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.serializejson.min.js"></script>
</head>
<body>
	<h2>회원 정보 입력 폼</h2>
	<form action="<%=request.getContextPath()%>/memberAdd.do" method="post" enctype="multipart/form-data" id="inputForm">
		<table>
			<tr>
				<td><label for="mem_id">회원ID</label></td>
				<td>
					<input type="text" id="mem_id" name="mem_id"> 
					<input type="button" id="idExists" value="중복확인"><br>
					<span id="idCheckResult"></span>
				</td>
			</tr>
			<tr>
				<td><label for="mem_pass">비밀번호</label></td>
				<td><input type="password" id="mem_pass" name="mem_pass"></td>
			</tr>
			<tr>
				<td><label for="passwordConfirm">비밀번호 확인</label></td>
				<td>
					<input type="password" id="passwordConfirm" name="passwordConfirm">
				</td>
			</tr>
			<tr>
				<td><label for="mem_name">회원이름</label></td>
				<td><input type="text" id="mem_name" name="mem_name"></td>
			</tr>
			<tr>
				<td><label for="mem_tel">전화번호</label></td>
				<td><input type="text" id="mem_tel" name="mem_tel"></td>
			</tr>
			<tr>
				<td><label for="mem_addr">회원주소</label></td>
				<td><input type="text" id="mem_addr" name="mem_addr"></td>
			</tr>
			<tr>
				<td><label for="mem_photo">프로필 사진</label></td>
				<td><input type="file" id="mem_photo" name="mem_photo"></td>
			</tr>
			<tr>
				<td colspan="2" id="buttons">
					<input type="button" id="save" name="save" value="저장">
					<input type="reset" value="취소">
					<input type="button" id="memberList" name="memberList" value="회원목록">
				</td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
		$("#idExists").on("click", function() {
			idValue = $("#id").val();
			if (idValue == "") {
				alert("ID를 입력하세요");
				return;
			}
			
			$.ajax({
				url: "<%=request.getContextPath()%>/memberIdCheck.do",
				data: {"mem_id": idValue},
				type: "post",
				success: function(result) { 
					if (result == "possible") {
						$("#idCheckResult").html("사용 가능한 ID입니다.");
					} else {
						$("#idCheckResult").html("이미 존재하는 ID입니다.");
					}
				},
				error: function(xhr) {
					alert("상태: " + xhr.status);
				},
				dataType: 'json'
			});
		});
		
		$("#save").on("click", function() {
			idValue = $("#id").val();
			passwordValue = $("#password").val();
			nameValue = $("#name").val();
			telValue = $("#tel").val();
			addressValue = $("#address").val();
			profileValue = $("#profile").val();
			
			inputData = {
					"mem_id": idValue,
					"mem_pass": passwordValue,
					"mem_name": nameValue,
					"mem_tel": telValue,
					"mem_addr": addressValue,
					"mem_photo": profileValue
			}
			
			$.ajax({
				url: "<%=request.getContextPath()%>/memberAdd.do",
				data: inputData,
				type: 'post',
				success: function(res) {
					location.href = "<%=request.getContextPath()%>/memberList.do";
				},
				error: function(xhr) {
					alert("상태: " + xhr.status);
				},
				dataType: 'json'
			})
		});
	</script>
</body>
</html>