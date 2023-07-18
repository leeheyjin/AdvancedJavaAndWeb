<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Cookie</title>
</head>
<body>
<%
    //   요청시 함께 툭툭 던져지는 request객체 안에 있는 쿠키 확인
    //   Cookie cookieId = new Cookie("userId", userId);
    //   Cookie cookiePw = new Cookie("userPw",userPw);
    // + JSESSIONID
    Cookie[] cookies = request.getCookies();

    //   현재 쿠키 저장소에 들어있는 쿠키의 개수
    out.print("현재 설정된 쿠키의 개수 : " + cookies.length + "<br />");
    out.print("<hr />");
    for(int i = 0; i < cookies.length; i++){
        out.print("쿠키{" +i+ "] : " +cookies[i] + "<br />");
        out.print("쿠키 속성 명[" + i + "] : " + cookies[i].getValue() + "<br />");
        out.print("---------------------------------------- <br />");
    }

    out.print("세션ID : " + session.getId() + "<br />");
%>
<a href="cookie03.jsp">모든 쿠키 삭제</a>
</body>
</html>