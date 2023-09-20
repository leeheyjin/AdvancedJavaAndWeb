<%@page import="kr.or.ddit.community.vo.MentVO"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	//서블릿에서 저장한 데이터 가져오기
	List<MentVO> list = (List<MentVO>)request.getAttribute("list");
	
	Gson gson = new Gson();
	
	String result = gson.toJson(list);
	
	out.print(result);
	out.flush();
%>
