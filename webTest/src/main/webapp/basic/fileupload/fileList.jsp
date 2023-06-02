<%@page import="kr.or.ddit.basic.vo.FileInfoVO"%>
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
List<FileInfoVO> list = (List<FileInfoVO>) request.getAttribute("fileInfoList");
%>
<body>
	<h2>전체 파일 목록</h2>
	<a href="<%=request.getContextPath()%>/fileUpload.do">파일업로드하기</a><br><br>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>저장파일명</th>
			<th>원래파일명</th>
			<th>파일크기</th>
			<th>저장날짜</th>
			<th>비고</th>
		</tr>
		<%
		if (list == null || list.size() == 0) {
		%>
		<tr>
			<td colspan="7">파일 목록이 하나도 없습니다.</a></td>
		</tr>
		<%
		} else {
			for (FileInfoVO vo : list) {
		%>
		<tr>
			<td><%=vo.getFile_no()%></td>
			<td><%=vo.getFile_writer()%></td>
			<td><%=vo.getSave_file_name()%></td>
			<td><%=vo.getOrigin_file_name()%></td>
			<td><%=vo.getFile_size()%></td>
			<td><%=vo.getFile_date()%></td>
			<td>-</td>
		</tr>
		<%
			}

		}
		%>
	</table>
</body>
</html>