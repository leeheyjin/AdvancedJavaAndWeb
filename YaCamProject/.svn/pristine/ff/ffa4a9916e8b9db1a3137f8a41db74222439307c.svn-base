<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html lang="kr">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>야!!!캠핑가자~</title>
 <link id="main icon" rel="shortcut icon" type="image/x-icon" href="./ICON/camping-favicon.ico">
<link id="main icon" rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath()%>/Main_KKD/ICON/camping-favicon.ico">
<link rel="stylesheet" href="../css/reset.css"></link>
<link rel="stylesheet" href="../css/mainpage.css"></link>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.css"/>
<script src="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
<script src="../js/jquery-3.7.0.min.js"></script>
<style>
	body{
	position: relative;
	}
    .swiper{
      width: 350px; 
      height: 350px; 
      display: inline-block; 
      float: right; 
    }
    #slider_box{
    position: absolute;
    left: 1600px;
    top : 300px;
    }
</style>


</head>
	<% MemberVO vo = (MemberVO)session.getAttribute("userinfo"); %>
<body>
    <div id="header">
        <div id="top">
            <div id="top_logo">
                <a id="logo" href="./mainpage.jsp"><img id="logoimg" src="./ICON/야!!!캠핑가자~ 로고(배경X).png"></a>
        	</div>
        </div>       		
			<%if(vo == null){ %>	           
			<a id="login" class="right" href="<%=request.getContextPath()%>/pbc/login/sign.jsp"><button id="button" type="button">로그인</button></a>
			<%}else if(vo!=null && vo.getMem_grade().equals("회원")){%>
			<a id="mypage" class="right" href="<%=request.getContextPath()%>/LMW/mypage/myPage.jsp"><button id="button-my" type="button">마이페이지</button></a>
			<a id="logout" class="right" href="<%=request.getContextPath()%>/Logout.do"><button id="button-out" type="button">로그아웃</button></a>
			<%}else if(vo!=null &&"관리자".equals(vo.getMem_grade())){%>
			<a id="logout" class="right" href="<%=request.getContextPath()%>/Logout.do"><button id="button-out" type="button">로그아웃</button></a>
			<a href="<%=request.getContextPath() %>/MemberList.do"><button type="button" id="manager_button">관리자 페이지</button></a>
			<%} %>
    </div>
        <div id="nav">
            <ul>
                <li><a id="navMenu" href="<%=request.getContextPath()%>/LHH/notice/notice.jsp"></a></li>
                <li id="liBoard"><a id="notice" href="<%=request.getContextPath()%>/LHH/notice/notice.jsp">공지사항</a></li>
                <li><a id="navMenu" href="<%=request.getContextPath()%>/LHH/event/event.jsp"></a></li>
                <li id="liBoard"><a id="event" href="<%=request.getContextPath()%>/LHH/event/event.jsp">이벤트</a></li>
                <li><a id="navMenu" href="<%=request.getContextPath()%>/LHH/board.jsp"></a></li>
                <li id="liBoard"><a id="board" href="<%=request.getContextPath()%>/LHH/board.jsp">게시판</a></li>
                <li><a id="navMenu" href="<%=request.getContextPath()%>/LHH/question/question.jsp"></a></li>
                <li id="liBoard"><a id="inquiry" href="<%=request.getContextPath()%>/LHH/question/question.jsp">문의사항</a></li>
            </ul>
        </div>
        <hr>   
	<div class="banner">
        <div class="slideshow-container"> <!-- 배너 표시영역 -->
        	<div class="mySlides fade"><!-- 원본배너 -->
        			<div id="text-banner"><div id="textOne">어서오세요!!!<br><br>삼척 라이어 오토캠핑장입니다.</div><br><br>&nbsp;라이어 캠핑장은 바다가 보이는 뷰가 좋은 캠핑장 얼른 오세요...</div>
		            <a href="<%=request.getContextPath() %>/campInfoSearch.do">
		            <br> <button id="detail" type="button"> 자세히 알아보기</button>
		            	<img id="banner-img" src="./홈페이지 견본 사진/오토캠핑1(바다).png">
		     		</a>
		     	<div class="text">1/3</div>
	     	</div>	
		        <div class="mySlides fade">
        			<div id="text-banner"><div id="textOne">모두모두 모여라!!!<br><br>대전 BBQ 글램핑입니다.</div><br><br>&nbsp;BBQ 글램핑장은 바베큐 이벤트를 진행하고 있어요...</div>
		            <a href="<%=request.getContextPath() %>/campInfoSearch.do">
		            <br> <button id="detail" type="button"> 자세히 알아보기</button>
		            	<img id="banner-img" src="./홈페이지 견본 사진/바베큐사진.jpg">
		           	</a>
		        <div class="text">2/3</div>
		        </div> 
		       <div class="mySlides fade"> 
        			<div id="text-banner"><div id="textOne">어서오세요!!!<br><br>대전 배스트필드 글램핑입니다.</div><br><br>&nbsp;베스트필드 글램핑장은 가족과 친구들과 함께 오는 분들이 많아요. 마니마니 오셔서 힐링 받으세요...</div>
		            <a href="<%=request.getContextPath() %>/campInfoSearch.do">
		            <button id="detail3" type="button"> 자세히 알아보기</button>
		            	<img id="banner-img" src="./홈페이지 견본 사진/동학사 베스트 필드 글램핑장.jpeg">
		           </a>
		           <div class="text">3/3</div>   	
	           </div>
	           	<!-- <a class="prev" onclick = "plusSlides(-1)">&#10094;</a>
	           	<a class="next" onclick = "plusSlides(1)">&#10095;</a>-->
		</div>
	</div>
	<div class="button">	
        <div class="text-align:center">
        	<br><br>
  			<span onclick="currentSlide(1)" class="dot" id="dot1"></span>
  			<span onclick="currentSlide(2)" class="dot"></span>
  			<span onclick="currentSlide(3)" class="dot"></span>
		</div>
	</div>                    

		<br><br><br>
        <div id="choice">
        	<br>
            <ul>
   				<li id="icon"><a href="<%=request.getContextPath() %>/autocamping.do"><img src="./ICON/오토캠핑 아이콘.png"></a><h6 id="iconText">오토캠핑</h6></li>
                <li id="icon"><a href="<%=request.getContextPath() %>/glamping.do"><img src="./ICON/글램핑 아이콘.png"></a><h6 id="iconText">글램핑</h6></li>
                <li id="icon"><a href="<%=request.getContextPath() %>/caravan.do"><img src="./ICON/카라반 아이콘.png"></a><h6 id="iconText">카라반</h6></li>
                <li id="icon"><a href="<%=request.getContextPath() %>/pension.do"><img src="./ICON/펜션 아이콘.png"></a><h6 id="iconText">팬션</h6></li>
            </ul>
            <br><br><br><br><br>
            <ul>
                <li id="icon"><a href="<%=request.getContextPath() %>/Main_KKD/search.jsp"><img src="./ICON/검색 아이콘.png"></a><h6 id="iconText">검색</h6></li>
                <li id="icon"><a href="<%=request.getContextPath() %>/kids.do"><img src="./ICON/아이 아이콘.png"></a><h6 id="iconText">키즈</h6></li>
                <li id="icon"><a href="<%=request.getContextPath() %>/dogs.do"><img src="./ICON/애견 아이콘.png"></a><h6 id="iconText">애견</h6></li>
                <li><a href="<%=request.getContextPath()%>/wishlistpage.do"><img src="./ICON/찜목록 아이콘.png"></a><h6 id="iconText">찜목록</h6></li>
            </ul>
        </div>
        <br><br><br>
        <div id="comunity">
            <div>
            	<iframe id="scale" src="<%=request.getContextPath()%>/LHH/board.jsp"></iframe>
            </div>
        </div>
        <br><br>
        <div id="events">
        	<div>
        		<iframe id="scale2" src="<%=request.getContextPath()%>/LHH/event/event.jsp"></iframe>
        	</div>
        </div>
        <div id="footer">
			<div id="customerOne">
				<br>
				<h3 id="center">고객센터</h3>
					<br>	
				<h6 id="content">010-8602-4217</h6>
					<br>
				<h6 id="content">kkd9612@naver.com</h6>
					<br>
				<h6 id="content">평일: 09:00 ~ 18:00 (점심시간 12:50 ~ 13:50)</h6>
					<br>
			</div>
			<div id="customerTwo">
				<br>
				<h3 id="center">대덕인재개발원 402호 4조</h3>	
					<br>
				<div id="mainContent">야!!캠<div id="content">핑가자~</div></div>
					<br>
				<h6 id="content">주소: 대전광역시 중구 계룡로 945 4층</h6>
					<br>
				<h6 id="content">팀장: 임민우 | 팀원: 김승종 | 팀원: 이현학 | 팀원: 박병철 | 팀원: 권기덕</h6>
			</div>
        </div>
        <div id="zero"></div>
        
        
        
        
<!--  ------------------------------------------------------------------------------------------- -->
 	  <!-- Slider main container -->
 	 <div id="slider_box">

    <div class="swiper">
        <!-- Additional required wrapper -->
        <div class="swiper-wrapper">
            <!-- Slides -->

            <div class="swiper-slide">
                <h2>current weather(서울 현재날씨)</h2>
                <h3 class="time">현재 시간 : </h3>
                <h3 class="ctemp">현재 온도 : </h3>
                <h3 class="lowtemp">최저 온도 : </h3>
                <h3 class="heighttemp">최고 온도 : </h3>
                <h3 class="icon">
                       <!-- <img src="https://openweathermap.org/img/wn/10d.png"> -->
                </h3>
            </div>

            <div class="swiper-slide">
                <h2>current weather(대전 현재날씨)</h2>
                <h3 class="timedj">현재 시간 : </h3>
                <h3 class="ctempdj">현재 온도 : </h3>
                <h3 class="lowtempdj">최저 온도 : </h3>
                <h3 class="heighttempdj">최고 온도 : </h3>
                <h3 class="icondj">
                       <!-- <img src="https://openweathermap.org/img/wn/10d.png"> -->
                </h3>
            </div>

            <div class="swiper-slide">
                <h2>current weather(대구 현재날씨)</h2>
                <h3 class="timedg">현재 시간 : </h3>
                <h3 class="ctempdg">현재 온도 : </h3>
                <h3 class="lowtempdg">최저 온도 : </h3>
                <h3 class="heighttempdg">최고 온도 : </h3>
                <h3 class="icondg">
                       <!-- <img src="https://openweathermap.org/img/wn/10d.png"> -->
                </h3>
            </div>
            
            <div class="swiper-slide">
                <h2>current weather(청주 현재날씨)</h2>
                <h3 class="timec">현재 시간 : </h3>
                <h3 class="ctempc">현재 온도 : </h3>
                <h3 class="lowtempc">최저 온도 : </h3>
                <h3 class="heighttempc">최고 온도 : </h3>
                <h3 class="iconc">
                       <!-- <img src="https://openweathermap.org/img/wn/10d.png"> -->
                </h3>
            </div>

            <div class="swiper-slide">
                <h2>current weather(부산 현재날씨)</h2>
                <h3 class="timeb">현재 시간 : </h3>
                <h3 class="ctempb">현재 온도 : </h3>
                <h3 class="lowtempb">최저 온도 : </h3>
                <h3 class="heighttempb">최고 온도 : </h3>
                <h3 class="iconb">
                       <!-- <img src="https://openweathermap.org/img/wn/10d.png"> -->
                </h3>
            </div>
            
            <div class="swiper-slide">
                <h2>current weather(제주 현재날씨)</h2>
                <h3 class="timej">현재 시간 : </h3>
                <h3 class="ctempj">현재 온도 : </h3>
                <h3 class="lowtempj">최저 온도 : </h3>
                <h3 class="heighttempj">최고 온도 : </h3>
                <h3 class="iconj">
                       <!-- <img src="https://openweathermap.org/img/wn/10d.png"> -->
                </h3>
            </div>

        </div>
        <!-- If we need pagination -->
        <div class="swiper-pagination"></div>
    
        <!-- If we need navigation buttons -->
    
        <!-- If we need scrollbar -->
<!--         <div class="swiper-scrollbar"></div> -->
    </div>      
   	 </div>
     <script>
/*
	//버튼식 배너
	var slideIndex = 1;
	showSlides(slideIndex);
	
	function plusSlides(n) {
	  showSlides(slideIndex += n);
	}
	
	function currentSlide(n) {
	  showSlides(slideIndex = n);
	}
	
	function showSlides(n) {
	  var i;
	  var slides = document.getElementsByClassName("mySlides");
	  var dots = document.getElementsByClassName("dot");
	  if (n > slides.length) {slideIndex = 1}    
	  if (n < 1) {slideIndex = slides.length}
	  for (i = 0; i < slides.length; i++) {
	      slides[i].style.display = "none";  
	  }
	  for (i = 0; i < dots.length; i++) {
	      dots[i].className = dots[i].className.replace(" active", "");
	  }
	  slides[slideIndex-1].style.display = "block";  
	  dots[slideIndex-1].className += " active";
	}
	*/

//자동식 배너
var slideIndex = 0;
	slideIndex += 1;

	showSlides();

function showSlides(){ 
	var i;
	var slides = document.getElementsByClassName("mySlides");
	var dots = document.getElementsByClassName("dot");
	
	for(i = 0; i < slides.length; i++){
		slides[i].style.display = "none";
	}
	slideIndex++;
	if(slideIndex > slides.length) {slideIndex = 1}
	for(i = 0; i < dots.length; i++){
		dots[i].className = dots[i].className.replace("active", "");
	}
	slides[slideIndex-1].style.display = "block";  
	dots[slideIndex-1].className += " active";
	setTimeout(showSlides, 3000);
}
//---------------------------------------------------------------------------------------------

 $.getJSON('https://api.openweathermap.org/data/2.5/weather?q=Seoul&appid=5e03beaf9a463a6a18177ee740bbe6aa&units=metric',function(result){
            //현재온도
            $('.ctemp').append(result.main.temp);
            //최저온도
            $('.lowtemp').append(result.main.temp_min);
            //최고온도
            $('.heighttemp').append(result.main.temp_max);
            //icon출력
            //result.weather[0].icon
            var wiconUrl = '<img src="https://openweathermap.org/img/wn/' + result.weather[0].icon +'.png" alt="'+result.weather[0].desciption+'">'
            $('.icon').html(wiconUrl);

            var ct = result.dt
            function convertTime(t){
                var ot = new Date(t*1000);
                //Mon May 29 2023 17:39:13 GMT+0900 (한국 표준시)
                var hr = ot.getHours();
                var m = ot.getMinutes();
                var s = ot.getSeconds();
                return hr+"시"+m+"분"
            }


            var currentTime = convertTime(ct)
            $('.time').append(currentTime);
        })
        
 $.getJSON('https://api.openweathermap.org/data/2.5/weather?q=Daejeon&appid=5e03beaf9a463a6a18177ee740bbe6aa&units=metric',function(result){
            //현재온도
            $('.ctempdj').append(result.main.temp);
            //최저온도
            $('.lowtempdj').append(result.main.temp_min);
            //최고온도
            $('.heighttempdj').append(result.main.temp_max);
            //icon출력
            //result.weather[0].icon
            var wiconUrl = '<img src="https://openweathermap.org/img/wn/' + result.weather[0].icon +'.png" alt="'+result.weather[0].desciption+'">'
            $('.icondj').html(wiconUrl);

            var ct = result.dt
            function convertTime(t){
                var ot = new Date(t*1000);
                //Mon May 29 2023 17:39:13 GMT+0900 (한국 표준시)
                var hr = ot.getHours();
                var m = ot.getMinutes();
                var s = ot.getSeconds();
                return hr+"시"+m+"분"
            }


            var currentTime = convertTime(ct)
            $('.timedj').append(currentTime);
        })
        
 $.getJSON('https://api.openweathermap.org/data/2.5/weather?q=daegu&appid=5e03beaf9a463a6a18177ee740bbe6aa&units=metric',function(result){
            //현재온도
            $('.ctempdg').append(result.main.temp);
            //최저온도
            $('.lowtempdg').append(result.main.temp_min);
            //최고온도
            $('.heighttempdg').append(result.main.temp_max);
            //icon출력
            //result.weather[0].icon
            var wiconUrl = '<img src="https://openweathermap.org/img/wn/' + result.weather[0].icon +'.png" alt="'+result.weather[0].desciption+'">'
            $('.icondg').html(wiconUrl);

            var ct = result.dt
            function convertTime(t){
                var ot = new Date(t*1000);
                //Mon May 29 2023 17:39:13 GMT+0900 (한국 표준시)
                var hr = ot.getHours();
                var m = ot.getMinutes();
                var s = ot.getSeconds();
                return hr+"시"+m+"분"
            }


            var currentTime = convertTime(ct)
            $('.timedg').append(currentTime);
        })
        
 $.getJSON('https://api.openweathermap.org/data/2.5/weather?q=cheongju&appid=5e03beaf9a463a6a18177ee740bbe6aa&units=metric',function(result){
            //현재온도
            $('.ctempc').append(result.main.temp);
            //최저온도
            $('.lowtempc').append(result.main.temp_min);
            //최고온도
            $('.heighttempc').append(result.main.temp_max);
            //icon출력
            //result.weather[0].icon
            var wiconUrl = '<img src="https://openweathermap.org/img/wn/' + result.weather[0].icon +'.png" alt="'+result.weather[0].desciption+'">'
            $('.iconc').html(wiconUrl);

            var ct = result.dt
            function convertTime(t){
                var ot = new Date(t*1000);
                //Mon May 29 2023 17:39:13 GMT+0900 (한국 표준시)
                var hr = ot.getHours();
                var m = ot.getMinutes();
                var s = ot.getSeconds();
                return hr+"시"+m+"분"
            }


            var currentTime = convertTime(ct)
            $('.timec').append(currentTime);
        })
        
 $.getJSON('https://api.openweathermap.org/data/2.5/weather?q=busan&appid=5e03beaf9a463a6a18177ee740bbe6aa&units=metric',function(result){
            //현재온도
            $('.ctempb').append(result.main.temp);
            //최저온도
            $('.lowtempb').append(result.main.temp_min);
            //최고온도
            $('.heighttempb').append(result.main.temp_max);
            //icon출력
            //result.weather[0].icon
            var wiconUrl = '<img src="https://openweathermap.org/img/wn/' + result.weather[0].icon +'.png" alt="'+result.weather[0].desciption+'">'
            $('.iconb').html(wiconUrl);

            var ct = result.dt
            function convertTime(t){
                var ot = new Date(t*1000);
                //Mon May 29 2023 17:39:13 GMT+0900 (한국 표준시)
                var hr = ot.getHours();
                var m = ot.getMinutes();
                var s = ot.getSeconds();
                return hr+"시"+m+"분"
            }


            var currentTime = convertTime(ct)
            $('.timeb').append(currentTime);
        })
        
 $.getJSON('https://api.openweathermap.org/data/2.5/weather?q=Jeju&appid=5e03beaf9a463a6a18177ee740bbe6aa&units=metric',function(result){
            //현재온도
            $('.ctempj').append(result.main.temp);
            //최저온도
            $('.lowtempj').append(result.main.temp_min);
            //최고온도
            $('.heighttempj').append(result.main.temp_max);
            //icon출력
            //result.weather[0].icon
            var wiconUrl = '<img src="https://openweathermap.org/img/wn/' + result.weather[0].icon +'.png" alt="'+result.weather[0].desciption+'">'
            $('.iconj').html(wiconUrl);

            var ct = result.dt
            function convertTime(t){
                var ot = new Date(t*1000);
                //Mon May 29 2023 17:39:13 GMT+0900 (한국 표준시)
                var hr = ot.getHours();
                var m = ot.getMinutes();
                var s = ot.getSeconds();
                return hr+"시"+m+"분"
            }


            var currentTime = convertTime(ct)
            $('.timej').append(currentTime);
        })

//--------------------------------------------------------------------------------------------------
    const swiper = new Swiper('.swiper', {
      // Optional parameters
      direction: 'vertical',
      loop: true,

      // If we need pagination

      // Navigation arrows

      // And if we need scrollbar
      scrollbar: {
        el: '.swiper-scrollbar',
      },

      autoplay : {  // 자동 슬라이드 설정 , 비 활성화 시 false
      delay : 3000,   // 시간 설정
      disableOnInteraction : true,  // false로 설정하면 스와이프 후 자동 재생이 비활성화 되지 않음
      },

    });

</script>
        
</body>
</html>