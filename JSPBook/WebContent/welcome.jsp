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
				<p>
					<%
				Date day = new Date();
				String am_pm;
				int hour = day.getHours();
				int minute = day.getMinutes();
				int second = day.getSeconds();
				if (hour / 12 == 0) {
					am_pm = "AM";
				} else {
					am_pm = "PM";
					hour -= 12;
				}
				String currentTime = hour + ":" + minute + ":" + second + " " + am_pm;
				// jsp의 내장 객체 중 화면에 출력하는 객체: out
				out.print("현재 접속 시간: " + currentTime + "<br>");
				%>
				</p>
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
</body>
</html>