<%--
  Created by IntelliJ IDEA.
  User: leehyejin
  Date: 2023/08/30
  Time: 12:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/summernote/summernote-lite.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/summernote/summernote-lite.js"></script>
    <script src="${pageContext.request.contextPath}/resources/summernote/summernote-ko-KR.js"></script>
    <script src="${pageContext.request.contextPath}/resources/summernote/summernote-lite.js.map"></script>
</head>
<body>
<form action="/mail/sendMail" method="post">
    <input type="text" name="sender" placeholder="보낸이" readonly><br>
    <input type="text" name="receiver" placeholder="받는이" required><br>
    <input type="text" name="subject" placeholder="제목">
    <textarea id="summernote" name="content"></textarea>
    <button>전송</button>
</form>
<script>
    $(function() {
        $('#summernote').summernote({
            height: 450,
            lang: "ko-KR"
        });
    })
</script>
</body>
</html>
