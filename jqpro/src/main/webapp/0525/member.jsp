<%@page import="kr.or.ddit.basic.vo.MemberVO"%>
<%@page import="kr.or.ddit.mybatis.config.MyBatisSqlSessionFactory"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	border: 2px solid blue;
	border-collapse: collapse;
}

td {
	width: 200px;
	height: 50px;
	text-align: center;
}

tr:first-child {
	background-color: skyblue;
}
</style>
</head>
<body>
	<%
	// 전송 데이터 받기 ( 컨트롤러_서블릿)

	// db처리 - 결과값을 받는다  ( 컨트롤러_서블릿)
	// SqlSession이 필요 - SqlSessionFactory에 의해 생성
	// 1. SqlSessionFactory - mybatis-config.xml(db설정, VOalias설정, mapper 설정)이 필요
	// 2. SqlSession
	// 3. SqlSession 객체로 mapper의 SQL문장들을 수행

	// http 객체에 이미 session 이라는 내장객체가 존재하기 때문에 사용할 수 없음
	// SqlSession session = MyBatisSqlSessionFactory.getSqlSession();

	SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();

	List<MemberVO> list = sqlSession.selectList("member.getAllMember");

	// 결과값 출력 ( 뷰페이지로 출력 )
	%>

	<table border="1">
		<tr>
			<td>아이디</td>
			<td>이름</td>
			<td>전화번호</td>
			<td>주소</td>
		</tr>
		<%
		for (int i = 0; i < list.size(); i++) {
			MemberVO vo = list.get(i);
		%>
		<tr>
			<td><%=vo.getMem_id()%></td>
			<td><%=vo.getMem_name()%></td>
			<td><%=vo.getMem_tel()%></td>
			<td><%=vo.getMem_addr()%></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>