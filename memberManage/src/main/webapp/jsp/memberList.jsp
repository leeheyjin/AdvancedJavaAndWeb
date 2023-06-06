<%@page import="kr.or.ddit.basic.controller.CheckId"%>
<%@page import="kr.or.ddit.basic.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.0.min.js"></script>
</head>
<body>
<h2>회원 목록 보기</h2>
	<table border="1">
		<tr>
			<td colspan="5" class="addMember"><input type="button" value="회원추가" name="addMember"></td>
		</tr>
		<tr>
			<th>ID</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>전화</th>
			<th>주소</th>
		</tr>
		<%
		List<MemberVO> list = (List<MemberVO>) request.getAttribute("selectAll");
		if (list == null || list.size() == 0) {
		%>
		<tr>
			<td colspan="5">등록된 회원이 없습니다.</td>
		</tr>
		<%
		} else {
			for (MemberVO vo : list) {
		%>
			<tr>
				<td><a href=""><%=vo.getMem_id()%></a></td>
				<td><%=vo.getMem_pass()%></td>
				<td><%=vo.getMem_name()%></td>
				<td><%=vo.getMem_tel()%></td>
				<td><%=vo.getMem_addr()%></td>
			</tr>
		<%
			}
		}
		%>
	</table>
	<script type="text/javascript">
		$("input[name=addMember]").on("click", function() {
			window.open("/memberAdd.jsp", "_blank", "width=200, height=500");
		});
	</script>
</body>
</html>