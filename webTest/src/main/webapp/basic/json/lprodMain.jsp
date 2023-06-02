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
		<input type="button" id="lprodButton1" value="Lprod자료 가져오기">
		<input type="button" id="lprodButton2" value="Lprod자료 가져오기">
		<h2>LPROD 자료 목록</h2>
		<div id="result"></div>
	</form>

	<script type="text/javascript">
		$("#lprodButton1").on("click", function() {
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
		
		/* ajax사용X */
		$("#lprodButton2").on("click", function() {
			/* 
				서블릿으로 요청을 하면 서블릿에서 DB의 자료를 가져오고 가져온 자료를 view용 jsp문서로 forward방식으로 보낸다.
				view용 jsp문서에서는 서블릿이 보낸 데이터를 받아서 화면에 출력한다
			*/
			location.href = "<%=request.getContextPath()%>/lprodList2.do";
		})
	</script>
</body>
</html>