<%--
  Created by IntelliJ IDEA.
  User: leehyejin
  Date: 2023/08/31
  Time: 12:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/ckeditor/ckeditor.js"></script>
</head>
<body>
<form action="/mail/sendMail" method="post">
    <input type="hidden" name="from" value="groovytest@daum.net"/>
    <input type="text" name="to" placeholder="받는 사람"/>
    <input type="text" name="subject" placeholder="제목" required="required"/>
    <textarea id="text" name="text"></textarea>
    <button>메일 전송하기</button>
</form>
</body>
<script type="text/javascript">
    CKEDITOR.replace("text");
</script>
</html>
