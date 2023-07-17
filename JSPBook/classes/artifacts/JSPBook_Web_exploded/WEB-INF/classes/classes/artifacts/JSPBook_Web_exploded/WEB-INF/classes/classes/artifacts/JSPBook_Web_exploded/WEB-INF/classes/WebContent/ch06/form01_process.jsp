<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("utf-8");
String id = request.getParameter("id");
String password = request.getParameter("password");
String name = request.getParameter("name");
String phone1 = request.getParameter("phone1");
String phone2 = request.getParameter("phone2");
String phone3 = request.getParameter("phone3");
String gender = request.getParameter("gender");
String[] hobbies = request.getParameterValues("hobby");
String comment = request.getParameter("comment");
%>

<p> 아이디: <%=id%> </p>
<p> 비밀번호: <%=password%> </p>
<p> 이름: <%=name%> </p>
<p> 연락처: <%=phone1%>-<%=phone2%>-<%=phone3%> </p>
<p> 성별: <%=gender%> </p>
<p> 취미:
	<%
// 체크박스 특성상 체크를 않으면 실행하지 않음
if (hobbies != null) {
	for (String hobby : hobbies) {
		out.print(" " + hobby);
	}
}
%>
</p>
<p> 가입인사: <%=comment %> </p>