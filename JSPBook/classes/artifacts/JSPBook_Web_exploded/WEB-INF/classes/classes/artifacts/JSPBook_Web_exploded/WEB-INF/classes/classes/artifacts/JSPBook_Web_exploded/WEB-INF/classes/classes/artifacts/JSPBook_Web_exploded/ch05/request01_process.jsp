<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
String id = request.getParameter("id");
String password = request.getParameter("password");

// 헤더에 있는 host라는 name에 매핑되어 있는 값 가져오기
String hostValue = request.getHeader("host");
// 헤더에 있는 accept-language라는 name에 매핑되어 있는 값 가져오기
String alValue = request.getHeader("accept-language");
%>
<p>아이디: <%=id %></p>
<p>비밀번호: <%=password %></p>
<p>host: <%=hostValue %></p>
<p>accept-language: <%=alValue %></p>
<a href="request02.jsp">이동</a>