<%@page import="kr.or.ddit.community.vo.MentVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
MentVO insert = (MentVO) request.getAttribute("insert");

if (insert != null) { // 성공
%>
    {
        "flag": "완료"
    }
<% } else { // 실패 %>
    {
        "flag": "실패"
    }
<% } %>