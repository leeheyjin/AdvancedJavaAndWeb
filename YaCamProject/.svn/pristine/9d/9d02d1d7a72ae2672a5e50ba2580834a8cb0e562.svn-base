<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet" href="/css/reset.css"></link>
    <!-- <link rel="stylesheet" href="/css/datepicker.css"></link> -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js" integrity="sha512-uto9mlQzrs59VwILcLiRYeLKPPbS/bT71da/OEBYEwcdNUk8jYIy+D176RYoop1Da+f9mvkYrmj5MCLZWEtQuA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.css" integrity="sha512-aOG0c6nPNzGk+5zjwyJaoRUgCdOrfSDhmMID2u4+OIslr0GjpLKo7Xm0Ao3xmpM4T8AmIouRkqwj1nrdVsLKEQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
  <script>
  <%MemberVO vo = (MemberVO)session.getAttribute("userinfo");%>
  
    $.datepicker.setDefaults({
        dateFormat: 'yy-mm-dd',
        prevText: '이전 달',
        nextText: '다음 달',
        monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
        monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
        dayNames: ['일', '월', '화', '수', '목', '금', '토'],
        dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
        dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
        showMonthAfterYear: true,
        yearSuffix: '년'
    });

    $(function(){
    	
      $('.datepicker').datepicker({minDate:0});
      $(".datepicker").focus();
    });
    /* window.onload =function () {
    window.open("../ksj/images/베스트필드 예약안내.png","width=300, height=360");
    } */
  </script>

<style>
    
    
    div { } 

    html, body{
        min-width:1500px;
        min-height: 1500px;
    }

    #wrapper {
        margin : 0px auto;
        width:60%;
        height:96vh;
    }
    #header {
        text-align: center;
        height: 10%;
        padding-top: 25px;
        font-size: 25px;
        font-weight: bold;
    }
    #selectdate{
        height: 50%;
    }
    #regioninfo{
        height: 40%;
        padding: 10px;
    }
    img {
        width: 400px;
        height: 300px;
        border: 2px solid orange;
    }
    .col {
        display: inline-block; 
        width : 48%;
        height : 100%;
        vertical-align: top; 
    }
    .info {
        height: 19%;
        padding-top: 10px;
        border : 1px solid orange;
    }
    .datepicker{
        width:1000px;
        height:400px;
        font-size:30px;
        margin-left: 200px;
    }
    

    
</style>
</head>

<body>

<div id="container">
    <div id="wrapper">
        <div id="header">날짜 선택 <hr></div>
        <div class="row" id="selectdate">
            <div class="datepicker"></div>
            
        </div>
        <div class="row" id="regioninfo">
            <div class="col"><img src="./images/A텐트 구역.jpeg"></div>
            <div class="col">
                <div class="info">A텐트 구역</div>    
                <div class="info">2인 침구류 작은 에어컨, 나머지 침구류, 취사도구 준비하셔야 합니다</div>    
                <div class="info">60,000 원</div>
                <div class="info">글램핑 성인2인, 미성년 2인</div>
                <div class="info"><button type="button" class="btn btn-warning">예약하기</button></div>     
            </div>
        </div>
    </div>
</div>
    
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>
