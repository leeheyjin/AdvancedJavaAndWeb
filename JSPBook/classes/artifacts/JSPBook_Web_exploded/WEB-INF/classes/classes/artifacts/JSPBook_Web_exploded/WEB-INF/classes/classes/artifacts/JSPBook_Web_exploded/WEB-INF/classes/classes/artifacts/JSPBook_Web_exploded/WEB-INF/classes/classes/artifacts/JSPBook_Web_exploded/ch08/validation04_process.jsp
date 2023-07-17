<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<h3>입력에 성공했습니다</h3>
<%
request.setCharacterEncoding("utf-8");
String id = request.getParameter("id");
String password = request.getParameter("password");
%>
<p>아이디: <%=id %></p>
<p>비밀번호: <%=password %></p>