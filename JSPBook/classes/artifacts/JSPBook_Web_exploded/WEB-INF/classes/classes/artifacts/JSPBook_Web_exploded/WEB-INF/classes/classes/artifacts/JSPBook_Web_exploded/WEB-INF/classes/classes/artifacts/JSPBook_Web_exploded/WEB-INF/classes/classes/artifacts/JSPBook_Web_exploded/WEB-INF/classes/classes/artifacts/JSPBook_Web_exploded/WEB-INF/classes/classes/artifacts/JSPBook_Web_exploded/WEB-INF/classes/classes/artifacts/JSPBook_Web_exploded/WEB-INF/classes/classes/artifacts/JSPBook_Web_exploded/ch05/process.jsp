<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("utf-8");
String name = request.getParameter("name");
%>
<p> 이름: <%=name%> </p>
<c:set var="name" value="<%=name%>" />
<p>이름(JSTL): ${name}</p>

<script type="text/javascript">
	let name = "${name}";
	console.log("name: " + name);
</script>