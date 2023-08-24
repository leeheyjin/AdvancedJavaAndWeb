<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>company-notice</title>
</head>
<style>
    .container {
        display: flex;
        flex-direction: column;
        width: 1476px;
    }

    .container > * {
        border : 1px solid black;
    }

</style>
<body>
<div class="container">
    <div class="title">
        <div class="title"><p>출·퇴근 현황</p></div>
        <div class="common"></div>
    </div>

    <div class="middle-div">
        <div class="img"></div>
        <div class="commute-time-and-bar">
            <div class="commute-time">
                <div class="attendence-time">
                    <p>출근 <span>08:54</span></p>
                </div>
                <div class="left-time">
                    <p>퇴근 <span>18:00</span></p>
                </div>
                <div class="total-time-today">
                    <p>오늘 근무 시간</p>
                    <p>05시간 30분</p>
                </div>
                <div class="total-time-week">
                    <p>이번주 총 근무 시간</p>
                    <p>34시간 30분</p>
                </div>
            </div>
            <div class="commute-bar">
                <div class="bar-text">
                    <span class="min-time">0h</span>
                    <span class="max-time">72h</span>
                </div>
                <div class="bar"></div>
            </div>
        </div>
        <div class="commute-table"></div>
    </div>

    <div class="small-title">

    </div>
    <div class="month-grid">
        <c:forEach var="eachMonth" begin="1" end="12">
            <input type="button" class="month" value="<c:out value="${eachMonth}" />">
        </c:forEach>
    </div>
</div>
</body>
</html>
