<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
String id = request.getParameter("id");
String password = request.getParameter("password");
%>
<p>아이디: <%out.print(id);%></p>
<p>비밀번호: <%out.print(password);%></p>