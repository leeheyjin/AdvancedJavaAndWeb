<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
int count = (Integer) request.getAttribute("resultCount");
if (count > 0) {
%>
{ "flag": "회원가입이 성공적으로 완료되었습니다." } 
<%
} else {
%>
{ "flag": "회원가입을 실패했습니다." }
<%
}
%>