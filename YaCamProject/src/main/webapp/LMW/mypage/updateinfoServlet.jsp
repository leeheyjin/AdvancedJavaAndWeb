<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int cnt = (int)request.getAttribute("cnt");
if(cnt>0){
%>
	{"cnt" : "성공"}
<%}else{%>
	{"cnt" : "실패"}
<%}%>