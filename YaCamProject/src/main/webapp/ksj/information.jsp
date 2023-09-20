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


<style>
    
    div { }

    html, body{
        min-width:1500px;
        min-height: 1500px;
        
    }

    #wrapper {
        margin: 0px auto;
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

    /* .row {
        height:30%;
        
    } */
    .col {
         
        width : 48%;
        height : 100%;
        vertical-align: top; 
    }

    .p1{
        font-size: 20px;
        font-weight: bold;
    }

    #row1{
        height: 30%;
    }

    #row2{
        height: 20%;
    }

    #row3{
        height: 7%;
    }

    #row4{
        height: 15%;
    }

    #row5{
        height: 15%;
    }

    .p3{
        text-align: center;
        font-size: 25px;
        font-weight: bold;
    }
    
    .p2{
        padding-left: 20px;
    }

</style>
</head>

<body>
<div id="container">
    <div id="wrapper">
        
        <div id="header">예약안내<hr></div>
        <div class="row" id="row1">
            <p class="p1">예약안내</p><br><br>
            <p class="p2">예약가능&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;2023년 08월 05일까지 </p><br><br>
            <p class="p2">최대예약&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;최대 6박 / 1개까지</p><br><br>
            <p class="p2">오픈주기&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;매주 일요일 0시 오픈 (8주 단위)</p><br><br>
            <p class="p2">다음예약&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;2023년 06월 18일 0시 오픈 ~ 2023년 08월 05일까지</p><br><br>
            <hr><br>
        </div>
        <div class="row" id="row2">
            <p class="p1">이용안내</p><br><br>
            <p class="p2">이용시간&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;입실시간: 14:00 퇴실시간: 12:00</p><br><br>
            <p class="p2">이용가능&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;애견, 키즈, 화장실, 개수대, 샤워실, 매점</p><br><br>
            <hr><br>
        </div>
        <div class="row" id="row3">
            <p class="p3">공지사항</p><br>
            <hr>
        </div>
        <div class="row" id="row4">
            <p class="p1">예약 유의사항</p><br><br>
            <p class="p2">캠핑장 내 전사이트 금연구역이며 흡연구역외 흡연적발시 강제 퇴실조치됨을 알려드립니다.</p><br>
            <hr>
        </div>
        <div class="row" id="row5">
            <p class="p1">예약 전 꼭 확인 부탁드립니다.</p><br><br>
            <p class="p2">화재 위험이 너무나도 큽니다. 불 사용시 안전에 유의 부탁드립니다. 데크 파손 및 불씨 번짐으로 인한 피해 시 강제퇴실 및 피해보상 청구합니다.</p><br>
            <hr></div>
        <a href="./selectCampDate.jsp"><input type="button" class="btn btn-warning" value="예약하기"></a>
    </div>
</div>
    
</body>
</html>
