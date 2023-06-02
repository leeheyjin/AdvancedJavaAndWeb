<%@page import="kr.or.ddit.basic.vo.LprodVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
List<LprodVO> list = (List<LprodVO>) request.getAttribute("selectAll");
%>
<body>
	<h3>Lprod자료 목록</h3>
	<table border="1">
		<tr>
			<td>LPROD_ID</td>
			<td>LPROD_GU</td>
			<td>LPROD_NM</td>
		</tr>
		<%
		for (LprodVO vo : list) {
		%>
		<tr>
			<td><%=vo.getLprod_id()%></td>
			<td><%=vo.getLprod_gu()%></td>
			<td><%=vo.getLprod_nm()%></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>