<%--
  Created by IntelliJ IDEA.
  User: leehyejin
  Date: 2023/08/29
  Time: 11:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>아기천사햠스터</h1>
<form action="/logout" method="post">
    <sec:csrfInput/>
    <button>로그아웃갈겨~</button>
</form>
<input type="text" id="ham" value="">
<button onclick="fAjax()">아작스전ㄴ송</button>
<script>
    const header = '${_csrf.headerName}';
    var token = '${_csrf.token}';
    var myHam = document.querySelector("#ham")

    function fAjax() {
        let xhr = new XMLHttpRequest();
        xhr.open("post", "/angel/seoju", true);
        xhr.setRequestHeader(header, token);
        xhr.setRequestHeader("ContentType", "application/json;charset=utf-8")
        xhr.onreadystatechange = function () {
            if (xhr.status == 200 && xhr.readyState == 4) {
                console.log(xhr.responseText);
            }
        }
        xhr.send("mName=" + myHam.value);
    }
</script>
</body>
</html>
