<%@page import="kr.or.ddit.campinfo.vo.CampInfoVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.0.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/reset.css"></link>

<style>
    
    div { } /* 레이아웃 나눌땐 일단 border가 눈에 보여야 함 */
    
    html, body{
        min-width:1500px;
        min-height: 1500px;
        text-align: center;
        
    }

    #wrapper {
        margin: 0px auto;
        width:60%;
        height:96vh;
    }
    #nav {
        width: 100%;
        height:100px;
    }
    
    #header {
        text-align: center;
        height: 10%;
        padding-top: 25px;
        font-size: 25px;
        font-weight: bold;
    }
    .row {
        height:39% /* %를 주면 부모기준 */
    }
    .col {
        display: inline-block; /* 옆에 누가 오는 걸 허락해야 함 */
        width : 49.2%;
        height : 100%;
        
        vertical-align: top; /* 필요할 때가 꽤 있음! */
    }
    .col2 {
        display: inline-block;
        width: 14.5%;
        height : 100%;
        padding-top: 20px;
        vertical-align: top;
    }
    .info {
        height: 32%;
        padding-top: 40px;
        border : 1px solid orange;
    }
    .img {
        width: 400px;
        height: 300px;
        padding-top: 30px;
        
    }

    .image-border{
        padding-top : 0px;
        border: 4px solid orange;
    }
    #search {
        width:200px;
       
    }
   
   /* The Modal (background) */
        .modal {
	        min-width:1500px;
	        min-height: 1500px;
            display: none; /* Hidden by default */
            position: fixed; /* Stay in place */
            z-index: 1; /* Sit on top */
            left: 0;
            top: 0;
            width: 100%; /* Full width */
            height: 100%; /* Full height */
            overflow: auto; /* Enable scroll if needed */
            background-color: rgb(0,0,0); /* Fallback color */
            background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
            
            
        }
    
        /* Modal Content/Box */
        .modal-content {
            background-color: #fefefe;
            margin: 30px auto; /* 15% from the top and centered */
            padding: 20px;
            border: 1px solid #888;
            width: 70%; /* Could be more or less, depending on screen size */
            overflow-y: scroll;
            max-height: 100vh;                          
        }
   
</style>


</head>



<body>

<!-- The Modal -->
    <div id="myModal" class="modal">
 
      <!-- Modal content -->
        <div class="modal-content">
      
      		<img src="<%=request.getContextPath() %>/ksj/images/베스트필드 예약안내.png">
        	<div style="cursor:pointer;background-color:#DDDDDD;text-align: center;padding-bottom: 10px;padding-top: 10px;" onClick="close_pop();">
                <span class="pop_bt" style="font-size: 13pt;" >
                    닫기
                </span>
            </div>
            <br>
    	</div>
	</div>
    <!--End Modal-->
 
    <script type="text/javascript">
      
        jQuery(document).ready(function() {
                $('#myModal').show();
        });
        //팝업 Close 기능
        function close_pop(flag) {
             $('#myModal').hide();
        };
        
    </script>

<div id="container">
    <div id="wrapper">
        <div id="header">캠핑장 검색 <hr></div>
        <nav id="nav">
            <div class="col2">
                <select class="form-select" aria-label="Default select example" name="region" id="region">
                    <option selected>지역 선택</option>
                    <option value="kk" >경기</option>
                    <option value="kw">강원</option>
                    <option value="ch">충청</option>
                    <option value="dj">대전</option>
                    <option value="jr">전라</option>
                    <option value="ks">경상</option>
                    <option value="jj">제주</option>
                  </select>
            </div>
            <div class="col2">
                <select class="form-select" aria-label="Default select example" name="type1" id="type1">
                    <option selected>숙소구분</option>
                    <option value="auto">오토캠핑</option>
                    <option value="glamping">글램핑</option>
                    <option value="caravan">카라반</option>
                    <option value="pension">펜션</option>
                </select>
            </div>
            <div class="col2">
                <select class="form-select" aria-label="Default select example" name="type2" id="type2">
                    <option selected>검색구분</option>        
                    <option value="nomal">일반</option>
                    <option value="dog">애견</option>
                    <option value="kids">키즈</option>
                </select>
            </div>
            <div class="col2" id="search">
                <form class="d-flex">
                    <input class="form-control me-2" type="text" placeholder="캠핑장 검색" name="search" id="search">
                    <button class="btn btn-primary" type="button">Search</button>
                  </form>
            </div>
        </nav>

	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>

