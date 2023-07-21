<%--
  Created by IntelliJ IDEA.
  User: leehyejin
  Date: 2023/07/20
  Time: 10:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>도서 목록</title>
</head>
<body>
<h1>책 목록</h1>
<p>
<form>
    <input type="text" placeholder="검색어를 입력하세요." name="keyword" value="${param.keyword}">
    <input type="submit" value="검색">
</form>
</p>
<table border="1">
    <thead>
    <tr>
        <th>번호</th>
        <th>제목</th>
        <th>카테고리</th>
        <th>가격</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach varStatus="stat" items="${list}" var="vo">
        <tr>
            <td>${stat.count}</td>
            <td><a href="/detail?bookId=${vo.bookId}">${vo.title}</a></td>
            <td>${vo.category}</td>
            <td><fmt:formatNumber type="number" value="${vo.price}" pattern="#,###"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/create">책 등록</a>
</body>
</html>
