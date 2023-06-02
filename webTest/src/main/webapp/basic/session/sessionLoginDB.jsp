<%@page import="kr.or.ddit.basic.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
td {
	padding: 2px;
}

td#buttonTd {
	text-align: center;
}

#button {
	width: 100%;
}
</style>
</head>
<%
// JSP문서에는 HTTPSession객체가 session이라는 변수명으로 저장되어 있다.
MemberVO loginMember = (MemberVO) session.getAttribute("loginMember");
if (loginMember == null) { // 로그인 실패시
%>
<body>
	<h2>Login</h2>
	<form action="<%=request.getContextPath()%>/sessionLoginDB.do" method="post">
		<table>
			<tr>
				<td><label for="id">ID: </label></td>
				<td><input id="id" type="text" size="20"
					placeholder="ID를 입력하세요." name="id"><br></td>
				<td><input type="checkbox" name="rememberId" id="rememberId">
					ID 기억하기</td>
			</tr>
			<tr>
				<td><label for="pass">PASS: </label></td>
				<td><input id="pass" type="password" size="20"
					placeholder="PassWord를 입력하세요." name="pass"><br></td>
				<td id="buttonTd"><input type="submit" value="로그인" id="button"></td>
			</tr>
		</table>
	</form>
	<%
	} else { // 로그인 성공시
	%>
	<h3><%=loginMember.getMem_name()%>님 반갑습니다.</h3>
	<a href="<%=request.getContextPath()%>/sessionLogoutDB.do">로그아웃</a>
	<%
	}
	%>
</body>
</html>