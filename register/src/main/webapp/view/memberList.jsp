<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/tableStyle.css">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.7.0.min.js"></script>
</head>
<body>
	<h2>회원 목록 보기</h2>
	<table border="1">
		<tr>
			<td colspan="5" id="insertMember"><input type="button" id="insertMember" value="회원추가"></td>
		</tr>
		<tr>
			<th>ID</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>전화</th>
			<th>주소</th>
		</tr>
		<%
		List<MemberVO> list = (List<MemberVO>) request.getAttribute("allMembers");
		if (list == null || list.size() == 0) {
		%>
		<tr>
			<td colspan="5">등록된 회원이 없습니다.</td>
		</tr>
		<%
		} else {
			for (int i = 0; i < list.size(); i++) {
				MemberVO mvo = list.get(i);
		%>
		<tr>
			<td><a href="#"><%=mvo.getMem_id()%></a></td>
			<td><%=mvo.getMem_pass()%></td>
			<td><%=mvo.getMem_name()%></td>
			<td><%=mvo.getMem_tel()%></td>
			<td><%=mvo.getMem_addr()%></td>
		</tr>
		<%
			}
		}
		%>
	</table>
	<script type="text/javascript">
		$("#insertMember").on("click", function() {
			location.href = "<%=request.getContextPath()%>/memberAdd.do";
		});
	</script>
</body>
</html>