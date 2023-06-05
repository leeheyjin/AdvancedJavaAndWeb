<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
img {
	width: 300px;
}
</style>
</head>
<body>
<img alt="Penguins.jpg" src="../../images/Penguins.jpg"></img>
<img alt="Penguins.jpg" src="<%=request.getContextPath() %>/images/imageView.do?fileno=4"></img>
</body>
</html>