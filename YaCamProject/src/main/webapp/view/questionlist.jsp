<%@page import="kr.or.ddit.questionboard.vo.QuestionVO"%>
<%@page import="com.google.gson.JsonElement"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="kr.or.ddit.community.vo.PageVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
//서블릿에서 저장한 데이터 꺼내기
List<QuestionVO> list = (List<QuestionVO>)request.getAttribute("list");
PageVO pvo = (PageVO)request.getAttribute("pvo");

	JsonObject obj = new JsonObject();
	obj.addProperty("sp", pvo.getStartPage());
	obj.addProperty("ep", pvo.getEndPage());
	obj.addProperty("tp", pvo.getTotalPage());
	
	Gson gson = new Gson();
	
	JsonElement ele = gson.toJsonTree(list);
	
	obj.add("datas", ele);
	out.print(obj);
	out.flush();
%>