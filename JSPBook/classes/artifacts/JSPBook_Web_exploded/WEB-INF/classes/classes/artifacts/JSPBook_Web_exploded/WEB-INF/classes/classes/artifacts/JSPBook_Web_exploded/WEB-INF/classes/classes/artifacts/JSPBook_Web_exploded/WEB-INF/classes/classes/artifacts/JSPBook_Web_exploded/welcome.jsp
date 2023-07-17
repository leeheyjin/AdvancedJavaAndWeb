<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.Date"%>
<%
// out.print(greeting);
// out.print(test);	// 문제발생!
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
	<!-- 헤더 -> menu.jsp -->
	<%@include file="menu.jsp"%>
	<!-- 헤더 -->
	<%!// 선언문(전역변수)
	String greeting = "Welcome to 이소연 World";
	String tagline = "Welcome to 소연이 Market!";%>
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">
				<%=greeting%>

			</h1>
		</div>
	</div>
	<div class="container">
		<div class="text-center">
			<h3>
				<%=tagline%>
				<p class="time"></p>
			</h3>
		</div>
	</div>
	<!-- footer -->
	<%@include file="footer.jsp"%>
	<!-- footer -->
	<%
	String test = "개똥이";
	%>
	<%-- 	<h1><%= greeting %></h1>
	<h3><%= tagline %></h3> --%>
	
	<script type="text/javascript">
	function gogo() {
		let today = new Date();
		
		let year = today.getFullYear();
		let month = ('0' + (today.getMonth() + 1)).slice(-2);
		let day = ('0' + today.getDate()).slice(-2);
		let dateString = year + "-" + month + "-" + day;
		
		let hours = ('0' + today.getHours()).slice(-2);
		let minutes = ('0' + today.getMinutes()).slice(-2);
		let seconds = ('0' + today.getSeconds()).slice(-2);
		let timeString = hours + ":" + minutes + ":" + seconds;
		
		document.querySelector(".time").innerHTML = "현재 접속 시간: " + dateString + " " + timeString;
		
	}
	setInterval(gogo, 1000);
	</script>
</body>
</html>