<%@page import="kr.or.ddit.wishlist.vo.WishlistVo"%>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="kr.or.ddit.campinfo.vo.CampInfoVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>야!!!캠핑가자~</title>
   <link id="main icon" rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath()%>/Main_KKD/ICON/camping-favicon.ico">
   <link rel="stylesheet" href="<%=request.getContextPath() %>/css/reset.css"></link>
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
   
   <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.0.min.js"></script>

<style>
   /* 홈페이지 아이콘 */
   #main icon{
      display: block;
      margin: auto;
      cursor: zoom-in;
      background-color: hsl(0, 0%, 90%);
      transition: background-color 300ms;
   }
    @font-face {
      font-family: 'TheJamsil5Bold';
      src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2302_01@1.0/TheJamsil5Bold.woff2') format('woff2');
      font-weight: 700;
      font-style: normal;
   }
    
    div { } /* 레이아웃 나눌땐 일단 border가 눈에 보여야 함 */
    
    html, body{
        min-width: 1500px;
        min-height: 1500px;
        text-align: center;
        font-family: "TheJamsil5Bold";
        font-weight: 400;
		transform: rotate(0.03deg);
		margin:0;
    }

    #wrapper {
        margin: 0px auto;
        width:60%;
        height:96vh;
    }
    #nav {
      width: 100%;
      height: 100px;
      padding-right: 14%;
    }
    
    #header {
        text-align: center;
        height: 10%;
        padding-top: 25px;
        font-size: 25px;
        font-weight: bold;
        color: #FF5918;
    }
    #campingList {
        height: 64%; /* %를 주면 부모기준 */    
      margin-left: 8%;
    }
    .col {
      display: block;
      width: 100.2%;
      height: auto;
      font-size: 12px;
        vertical-align: middle; /* 필요할 때가 꽤 있음! */
        margin: 0px;
        
    }
    .col2 {
      display: inline-block;
      width: 14.5%;
      height: 100%;
      padding-top: 20px;
      vertical-align: top;
      margin-right: 2%;
      border-radius: 0.375rem;
    }
    #menu{
       margin: 0px;
      position: static;
      margin-left: 17%;
       width: 101px;
       font-size: 8px;
       font-weight: bold;
       text-align: left;
   }
    #info,#info1,#info2 {
		width: 385px;
		height: 22px;
		font-size: 5px;
		text-align: left;
		margin-top: -1.5%;
		color: #888;
    }
    #info{
		margin-left: 21%;
    }
    #info1 {
        margin-left: 19.5%;
    }
    #info2 {
        margin-left: 19.5%;
    }
    #img {
	  border: 3px solid #FF6529;
      width: 575px;
      height: 370px;
      margin-right: 12%;  
    }

    .image-border{
        padding-top : 0px;
        height: 10px;
    }
    #searchInput {
        width: 200px;
       
    }
   .form-select {
      display: block;
      width: 100%;
      padding: 0.375rem 2.25rem 0.375rem 0.75rem;
      -moz-padding-start: calc(0.75rem - 3px);
      font-size: 13px;
      font-weight: 400;
      line-height: 1.5;
      color: #212529;
      background-color: #fff;
      background-image: url(data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 16 16'%3e%3cpath fill='none' stroke='%23343a40' stroke-linecap='round' stroke-linejoin='round' stroke-width='2' d='m2 5 6 6 6-6'/%3e%3c/svg%3e);
      background-repeat: no-repeat;
      background-position: right 0.75rem center;
      background-size: 16px 12px;
      border: 1px solid #ced4da;
      border-radius: 0.375rem;
      transition: border-color .15s ease-in-out,box-shadow .15s ease-in-out;
      -webkit-appearance: none;
      -moz-appearance: none;
      appearance: none;
   }
   .form-control {
      height: 33px;
      display: block;
      padding: 0.375rem 0.75rem;
      font-size: 13px;
      font-weight: 400;
      line-height: 1.5;
      color: #212529;
      background-color: #fff;
      background-clip: padding-box;
      border: 1px solid #ced4da;
      appearance: none;
      border-radius: 0.375rem;
      transition: border-color .15s ease-in-out,box-shadow .15s ease-in-out;
    }
    #search{
      font-size: 13px;
       --bs-btn-color: #FF6529;
       --bs-btn-bg: #f8f9fa;
       --bs-btn-border-color: #f8f9fa;
       --bs-btn-hover-color: #FF6529;
       --bs-btn-hover-bg: #d3d4d5;
       --bs-btn-hover-border-color: #c6c7c8;
       --bs-btn-focus-shadow-rgb: 211,212,213;
       --bs-btn-active-color: #FF6529;
       --bs-btn-active-bg: #c6c7c8;
       --bs-btn-active-border-color: #babbbc;
       --bs-btn-active-shadow: inset 0 3px 5px rgba(0, 0, 0, 0.125);
       --bs-btn-disabled-color: #FF6529;
       --bs-btn-disabled-bg: #f8f9fa;
       --bs-btn-disabled-border-color: #f8f9fa;
    }
   option {
      font-weight: normal;
      font-size: 13px;
      display: block;
      white-space-collapse: collapse;
      text-wrap: nowrap;
      min-height: 1.2em;
      padding: 0px 2px 1px;
   }
   hr{
      border: 2px solid #F54500;
   }
   #img2 {
    	margin-right: 10px;
    	margin-top: 10px;	
	}
</style>

<%
   //서블릿에서 보낸 자료 받기
   List<CampInfoVO> campInfoList = (List<CampInfoVO>) request.getAttribute("campInfoList");
	MemberVO vo = (MemberVO)request.getSession().getAttribute("userinfo");
	List<WishlistVo> wishListVo = (List<WishlistVo>) request.getAttribute("wishlist");
%>

<script>
$(function(){
	
    $(document).on('change', '#like', function(){
        const wstatusElement = $(this);
        if (wstatusElement.prop('checked')) {
            wstatus = 1;
            alert("찜목록 추가");
        } else {
            wstatus = 0;
            alert("찜목록 삭제");
        }
        
        const campno = wstatusElement.closest('form').find('input[name="campno"]').val();
        fdata = {
            status: wstatus,
            memid: $('#memid').val(),
            campno: campno
        };
        
        console.log(fdata);
        
        $.ajax({
            url: '<%= request.getContextPath()%>/Wishlist.do',
            data: fdata,
            type: 'get',
            success: function(res){
                if (res.flag == "성공") {
                    // 처리 성공 시 동작
                } else {
                    alert(res.flag);
                }
            },
            error: function(xhr){
                alert("상태 : " + xhr.status);
            },
            dataType: 'json'
        });
    });

    $(document).on('click', '#search', function(){
        var region = $('#region').val();
        var type1 = $('#type1').val();
        var type2 = $('#type2').val();
        var searchInput = $('#searchInput').val();
        var memid = $('#memid').val();

        $.ajax({
            url: '<%=request.getContextPath()%>/searchCamp.do',
            data: {
                "region": region,
                "type1": type1,
                "type2": type2,
                "search": searchInput,
                "memid" : memid
            },
            type: 'get',
            success: function(response){
                console.log("결과", response);
                console.log("배열 길이", response.length);

                var html = '';
                for (var i = 0; i < response.length; i++) {
                    var camp = response[i];
                    var isCampInWishList = false; // 여기서 isCampInWishList 값을 설정해주세요
					var memid = "<%=vo.getMem_id()%>";
                    
                    html += '<form action="<%=request.getContextPath() %>/CampZoneA001.do" method="get">';
                    html += '<div class="col">';
                    html += '<input id="img" style="display: inline;" type="image" src="' + camp.campPhoto + '" class="image-border">';
                    html += '</div>';
                    html += '<div class="col">';
                    html += '<input type="hidden" id="campno" name="campno" value="' + camp.campNo + '">';
                    html += '<input type="hidden" id="campname" name="campname" value="' + camp.campName + '">';
					html += '<input type="hidden" id="memid" name="memid" value="'+memid+'">'
                    html += '<div id="menu">이름</div>';
                    html += '<div class="info" id="info1">' + camp.campName + '</div>';
                    html += '<div id="menu">주소</div>';
                    html += '<div class="info" id="info2">' + camp.campAddr + '</div>';
                    html += '<div id="menu">예약금액</div>';
                    html += '<div class="info" id="info">' + camp.campInfo + '</div>';
                    html += '<div id="menu">찜목록 <input type="checkbox" id="like" name="like" ' + camp.wishlist + '></div>';
                    html += '</div>';
                    html += '</form>';
                    html += '<br>';
                }

                console.log("ajax결과", html);
                $('#campingList').html(html);
            },
            error: function(xhr){
                alert("상태 : " + xhr.status);
            },
            dataType: 'json'
        });
    });
});
</script>


</head>

<body>


<!-- 전체 영역 div 보통 wrapper나 container란 이름으로 많이 사용-->
<div id="container">
    <div id="wrapper">
        <div id="header">캠핑장 검색</div>
         <hr>
         <br>
        <nav id="nav">
       
            <div class="col2">
            	<a href="<%=request.getContextPath() %>/LMW/map/map.jsp"><input type="button" value="지도를이용하여 검색"></a>
            </div>
            
            <div class="col2">
                <select class="form-select" aria-label="Default select example" name="region" id="region">
                    <option id="option" value="">지역선택</option>
                    <option id="option" value="경기" >경기</option>
                    <option id="option" value="강원">강원</option>
                    <option id="option" value="충청">충청</option>
                    <option id="option" value="대전">대전</option>
                    <option id="option" value="전라">전라</option>
                    <option id="option" value="경상">경상</option>
                    <option id="option" value="제주">제주</option>
                  </select>
            </div>

            <div class="col2">
                <select class="form-select" aria-label="Default select example" name="type1" id="type1">
                    <option value="">숙소구분</option>
                    <option value="오토캠핑">오토캠핑</option>
                    <option value="글램핑">글램핑</option>
                    <option value="카라반">카라반</option>
                    <option value="펜션">펜션</option>
                </select>
            </div>
            <div class="col2">
                <select class="form-select" aria-label="Default select example" name="type2" id="type2">
                    <option value="">검색구분</option>        
                    <option value="일반">일반</option>
                    <option value="애견">애견</option>
                    <option value="유아">키즈</option>
                </select>
            </div>
            <div class="col2">
                <div class="d-flex">
                    <input class="form-control me-2" type="text" placeholder="캠핑장 검색" name="searchInput" id="searchInput">
                    <button class="btn btn-primary" type="button" id="search">검색</button>
                  </div>
            </div>
            
        </nav>
        <div id="campingList">
<%
for(CampInfoVO cvo : campInfoList) {
    boolean isCampInWishList = false;
    for (WishlistVo wvo : wishListVo) {
        if (wvo.getCamp_no().equals(cvo.getCamp_no())) {
            isCampInWishList = true;
            break;
        }
    }
%>
            <form action="<%=request.getContextPath() %>/CampZoneA001.do" method="get">
               <div class="col">
               <input id="img" style="display: inline;" type="image" src="<%=request.getContextPath() %><%=cvo.getCamp_poto() %>" class="image-border">
               </div>
               <div class="col">
                  <input type="hidden" id="campno" name="campno" value="<%= cvo.getCamp_no()%>">
                  <input type="hidden" id="campname" name="campname" value="<%=cvo.getCamp_name() %>">
               
               <input type="hidden" id="wstatus" name="wstatus" value="">
               <input type="hidden" id="memid" name="memid" value="<%=vo.getMem_id()%>">
               <div id="menu">이름: </div>
               <div class="info" id="info1" ><%=cvo.getCamp_name() %></div>           
               <div id="menu">주소: </div>
               <div class="info" id="info2"><%=cvo.getCamp_addr() %></div>
               <div id="menu">예약금액: </div>
               <div class="info" id="info"><%=cvo.getCamp_info() %></div>
               
                <div id="menu">찜목록 <input  type="checkbox" id="like" name="like" <%= isCampInWishList ? "checked" : "" %>></div>
                    <br><br>  
               </div>
               </form>
           <br>
<%
}
%>
      </div>
   </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>