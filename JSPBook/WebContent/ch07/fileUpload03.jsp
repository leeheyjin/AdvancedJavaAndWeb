<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Upload</title>
</head>
<body>
	<!-- 
파일 업로드 패키지인 Commons-FileUpload는 서버의 메모리상에서 파일 처리가 가능하도록 지원함.
이 패키지는 Commons-io패키지를 바탕으로 작성되었으므로 웹 브라우저(크롬)에서 서버(톰캣)로 파일을 업로드하기 위해
오픈 라이브러리 commons-fileupload.jar, commons-io.jar파일을 사용함
JSP 페이지에 page 디렉티브 태그의 import속성을 사용해 패키지를 입포트함. lib폴더에 해당  jar를 넣어주면 됨

파일 업르드를 위한 폼태그에 method="post", enctype="multipart/form-data", action 작성
 -->
	<form action="fileUpload03_process.jsp" method="post"
		enctype="multipart/form-data">
		<p>파일: <input type="file" name="file"></p>
		<input type="submit" value="파일올리기">
	</form>

</body>
</html>