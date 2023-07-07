<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="vo.UsersVO"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("utf-8");
String id = request.getParameter("id");
String password = request.getParameter("password");
String phone1 = request.getParameter("phone1");
String phone2 = request.getParameter("phone2");
String phone3 = request.getParameter("phone3");
String email = request.getParameter("email");
String name = request.getParameter("name");

UsersVO vo = new UsersVO();
vo.setId(id);
vo.setPassword(password);
vo.setPhone(phone1, phone2, phone3);
vo.setPhone1(phone1);
vo.setPhone2(phone2);
vo.setPhone3(phone3);
vo.setEmail(email);
vo.setName(name);
out.print(vo);
%>

<c:set var="vo" value="<%=vo %>" />
<p>아이디: ${vo.id} </p>
<p>비밀번호: ${vo.password} </p>
<p>이름: ${vo.name} </p>
<p>연락처: ${vo.phone} </p>
<p>이메일: ${vo.email} </p>
