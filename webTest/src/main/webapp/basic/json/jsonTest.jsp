<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.0.min.js"></script>
<style type="text/css">
	div {
		border: 2px solid olive;
		padding: 5px;
	}
</style>
</head>
<body>
	<h2>Ajax를 이용한 예제</h2>
	<form action="">
		<input type="button" id="startButton" value="문자열"> 
		<input type="button" id="arrayButton" value="배열"> 
		<input type="button" id="objectButton" value="객체"> 
		<input type="button" id="listButton" value="리스트"> 
		<input type="button" id="mapButton" value="맵">
	</form><br>
	<h3>응답 결과 출력</h3>
	<div id="result"></div>
	
	<script type="text/javascript">
		$("#startButton").on("click", function() {
			$.ajax({
				url: "<%=request.getContextPath()%>/jsonDataTest.do",
				type: "post",
				data: "choice=string", // request 데이터 정의: "이름1=자료형&이름2=자료형", {"이름1": 자료형, "이름2": 자료형}
				// 위는 request에 사용, 아래는 response에 사용
				success: function(data) {
					$("#result").html(data);
				},
				error: function(xhr) {
					alert("상태: " + xhr.status);
				},
				dataType: 'json' // response 데이터의 데이터 타입 지정
			})
		});
		$("#arrayButton").on("click", function() {
			$.ajax({
				url: "<%=request.getContextPath()%>/jsonDataTest.do",
				type: "post",
				data: "choice=array", // request 데이터 정의: "이름1=자료형&이름2=자료형", {"이름1": 자료형, "이름2": 자료형}
				// 위는 request에 사용, 아래는 response에 사용
				success: function(data) {
					code = "";
					$.each(data, function(i, v) {
						code += i+"번째 자료: " + v +"<br>";
					})
					$("#result").html(code);
				},
				error: function(xhr) {
					alert("상태: " + xhr.status);
				},
				dataType: 'json' // response 데이터의 데이터 타입 지정
			})
		});
		$("#objectButton").on("click", function() {
			$.ajax({
				url: "<%=request.getContextPath()%>/jsonDataTest.do",
				type: "post",
				data: "choice=object", // request 데이터 정의: "이름1=자료형&이름2=자료형", {"이름1": 자료형, "이름2": 자료형}
				// 위는 request에 사용, 아래는 response에 사용
				success: function(data) {
					code = "번호: " + data.num + "<br>이름: " + data.name;
					$("#result").html(code);
				},
				error: function(xhr) {
					alert("상태: " + xhr.status);
				},
				dataType: 'json' // response 데이터의 데이터 타입 지정
			})
		});
		$("#listButton").on("click", function() {
			$.ajax({
				url: "<%=request.getContextPath()%>/jsonDataTest.do",
				type: "post",
				data: "choice=list", // request 데이터 정의: "이름1=자료형&이름2=자료형", {"이름1": 자료형, "이름2": 자료형}
				// 위는 request에 사용, 아래는 response에 사용
				success: function(data) {
					code = "";
					$.each(data, function(i, v) {
						code += v.num + "번째 이름: " + v.name +"<br>";
					})
					$("#result").html(code);
				},
				error: function(xhr) {
					alert("상태: " + xhr.status);
				},
				dataType: 'json' // response 데이터의 데이터 타입 지정
			})
		});
		$("#mapButton").on("click", function() {
			$.ajax({
				url: "<%=request.getContextPath()%>/jsonDataTest.do",
				type: "post",
				data: "choice=map", // request 데이터 정의: "이름1=자료형&이름2=자료형", {"이름1": 자료형, "이름2": 자료형}
				// 위는 request에 사용, 아래는 response에 사용
				success: function(data) {
					code = "";
					code += "이름: " + data.name + "<br>";
					code += "번호: " + data.tel + "<br>";
					code += "주소: " + data.addr + "<br>";
					$("#result").html(code);
				},
				error: function(xhr) {
					alert("상태: " + xhr.status);
				},
				dataType: 'json' // response 데이터의 데이터 타입 지정
			})
		});
	</script>
</body>
</html>