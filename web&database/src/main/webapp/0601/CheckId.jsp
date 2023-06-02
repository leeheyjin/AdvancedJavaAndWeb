<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String selectResult = (String) request.getAttribute("isExists");
if (selectResult == null) {
%>
{ "flag": "사용 가능한 ID입니다." }
<%
} else {
%>
{ "flag": "이미 존재하는 ID입니다." }
<%
}
%>