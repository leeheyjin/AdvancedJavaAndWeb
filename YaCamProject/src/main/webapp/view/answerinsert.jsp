<%@page import="kr.or.ddit.answerboard.vo.AnswerVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
AnswerVO insert = (AnswerVO) request.getAttribute("insert");

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