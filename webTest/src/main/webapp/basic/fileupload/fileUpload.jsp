<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>파일 업로드 연습</h2>
	<!-- 파일을 업로드할 때 form태그의 속성 중에서 method속성은 post로, enctype속성은 multipart/form-data로 해야 한다. -->
	<form action="<%=request.getContextPath()%>/fileUpload.do" method="post" enctype="multipart/form-data">
		<label for="userName">작성자 이름</label> 
		<input type="text" id="userName" name="userName"><br><br>
		<label for="selectOne">하나의 파일 선택</label> 
		<input type="file" id="selectOne" name="selectOne"><br><br>
		<label for="selectMulti">여러 개의 파일 선택</label> 
		<input type="file" id="selectMulti" name="selectMulti" multiple><br><br>
		<button type="submit">전송</button><br><br>
		<a href="<%=request.getContextPath()%>/fileList.do">파일 목록 보기</a>
	</form>
</body>
</html>