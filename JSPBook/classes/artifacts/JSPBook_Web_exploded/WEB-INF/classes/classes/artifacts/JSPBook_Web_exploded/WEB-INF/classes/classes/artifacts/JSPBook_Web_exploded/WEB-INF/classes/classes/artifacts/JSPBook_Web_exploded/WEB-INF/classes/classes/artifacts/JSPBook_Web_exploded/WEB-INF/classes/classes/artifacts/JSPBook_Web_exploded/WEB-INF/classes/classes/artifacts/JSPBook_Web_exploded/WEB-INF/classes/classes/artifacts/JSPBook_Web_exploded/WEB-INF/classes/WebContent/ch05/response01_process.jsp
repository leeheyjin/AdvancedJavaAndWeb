<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
String id = request.getParameter("id");
String password = request.getParameter("password");

if (id.equals("a001") && password.equals("java")) {
	response.sendRedirect("response01_success.jsp");
} else {
	response.sendRedirect("response01_failed.jsp");
}
%>