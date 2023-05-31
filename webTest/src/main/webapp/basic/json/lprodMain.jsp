<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-3.7.0.min.js"></script>
</head>
<body>
	<form action="">
		<input type="button" id="lprodButton" value="Lprod자료 가져오기">
		<h2>LPROD 자료 목록</h2>
		<div id="result"></div>
	</form>

	<script type="text/javascript">
		$("#lprodButton").on("click", function() {
			$.ajax({
				url: "<%=request.getContextPath()%>/lprodList.do",
				type : "post",
				success : function(res) {
					code = "<table border=1>";
					code += "<tr><td>LPROD_ID</td><td>LPROD_GU</td><td>LPROD_NM</td><tr>";
					$.each(res, function(i, v) {
						code += "<tr><td>"+v.lprod_id+"</td><td>"+v.lprod_gu+"</td><td>"+v.lprod_nm+"</td></tr>";
					});
					code += "</table>"
					$("#result").html(code);
				},
				error : function(xhr) {
					alert("상태: " + xhr.status);
				},
				dataType : 'json'
			});
		});
	</script>
</body>
</html>