<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
h1 {
	color: red;
}

td {
	width: 300px;
	height: 50px;
	text-align: center;
}
</style>
</head>
<body>
	<h1>JSP: Java Server Page</h1>
	<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String tel = request.getParameter("tel");
	String email = request.getParameter("email");
	String userArea = request.getParameter("area");
	String carSingle = request.getParameter("carsingle");
	String[] carMulti = request.getParameterValues("carmulti");
	String str = "";
	for (String car : carMulti) {
		str += car + "&nbsp;&nbsp;";
	}

	// area 값에는 엔터기호(\r\n)가 포함되어야 한다.
	String area = userArea.replaceAll("\n", "<br>");
	%>

	<table border="1">
		<tr>
			<td>아이디</td>
			<td><%=id%></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><%=tel%></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><%=email%></td>
		</tr>
		<tr>
			<td>의견</td>
			<td><%=area%></td>
		</tr>
		<tr>
			<td>자동차 하나만</td>
			<td><%=carSingle%></td>
		</tr>
		<tr>
			<td>자동차 여러개</td>
			<td><%=str%></td>
		</tr>
	</table>
</body>
</html>