<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.Enumeration"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Enumeration enumeration = request.getHeaderNames();
// hasMoreElements(): 값이 있을 때에만 반복
while(enumeration.hasMoreElements()) {
	// 현재 헤더 이름을 Object로 가져옴
	String headerName = (String) enumeration.nextElement();
	String headerValue = request.getHeader(headerName);
	out.print("<h3>" + headerName + ": " + headerValue + "<br>");
}
%>
<p>요청 정보 길이: <%=request.getContentLength() %></p>
<p>클라이언트 전송 방식: <%=request.getMethod() %></p>
<p>요청URI: <%=request.getRequestURI() %></p>
<p>서버 이름: <%=request.getServerName() %></p>
<p>서버 포트: <%=request.getServerPort() %></p>
</body>
</html>