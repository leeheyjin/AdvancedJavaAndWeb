<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/tableStyle.css">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-3.7.0.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.serializejson.min.js"></script>
</head>
<body>
	<%
	MemberVO vo = (MemberVO) request.getAttribute("oneMember");
	%>
	<h2>회원 정보 상세 보기</h2>
	<form name="memberForm" id="memberForm">
		<table border="1">
			<tr>
				<td colspan="2"><img alt=""
					src="<%=request.getContextPath()%>/images/imageView.do?mem_id=<%=vo.getMem_id()%>"
					width="200" height="200"></td>
			</tr>
			<tr>
				<td>회원ID</td>
				<td id="id"><%=vo.getMem_id()%></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><%=vo.getMem_pass()%></td>
			</tr>
			<tr>
				<td>회원이름</td>
				<td><%=vo.getMem_name()%></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><%=vo.getMem_tel()%></td>
			</tr>
			<tr>
				<td>회원주소</td>
				<td><%=vo.getMem_addr()%></td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" id="modify" value="수정">
					<input type="button" id="delete" value="삭제"> <input
					type="button" id="list" value="회원목록"></td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
	
		$("#list").on("click", function() {
			history.back();
		});
		
		$("#modify").on("click", function() {
			
		});
		
		$("#delete").on("click", function() {
			
		});
	</script>
</body>
</html>