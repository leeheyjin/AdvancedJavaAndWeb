<%@page import="kr.or.ddit.reservation.vo.ReservationVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/reset.css"></link>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.0.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<%ReservationVo vo = (ReservationVo) request.getSession().getAttribute("kakao"); %>
<%String today = (String)request.getAttribute("today"); %>
<style>

	@font-face {
      font-family: 'TheJamsil5Bold';
      src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2302_01@1.0/TheJamsil5Bold.woff2') format('woff2');
      font-weight: 700;
      font-style: normal;
    }
	
	 /* div { border : 2px solid orange;}   */
    
    html, body{
        min-width:1500px;
        min-height: 1500px;
        text-align: center;
        font-family: "TheJamsil5Bold";
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
    .row {
    	height : 200px;
    }
    
    .col {
        display: inline-block; /* 옆에 누가 오는 걸 허락해야 함 */
        width : 49.2%;
        background-color: rgb(252, 244, 231);
        vertical-align: top; /* 필요할 때가 꽤 있음! */
        height : 220px;
        border : 3px solid #FF5918;
        border-radius: 10px;
    }
   
    
    .info {
        height: 32%;
        padding-top: 40px;
        border : 1px solid orange;
    }
    #img {
        width: 400px;
        height: 300px;
        padding-top: 30px; 
    }

    .image-border{
        padding-top : 0px;
        border: 4px solid orange;
    }
    #kakao {
       width:50px;
       height: 20px;
    }
    #home {
      margin-right : 50px;
    }
    #reserv {
      margin-left : 70px;
    }
    #content {
      
      height : 200px;
    }
    .button {
       background-color : #f8f9fa;
    }
   
    
</style>

</head>


<body>

<div id="container">
   <div id="wrapper">
      <div class="row">
         
      </div>
      <h3>예약이 완료되었습니다</h3>
      <br><br><br>
      <div class="row" id="content">
         <div class="col" id="col1">
         <br><br>
            예약아이디 : <%=vo.getMem_id()%><br><br>
            예약완료일 : <%=today %><br><br>
            숙박일 : <%=vo.getRes_checkin()%> ~ <%=vo.getRes_checkout()%><br><br>
         </div>
         <div class="col" id="col2">
         <br><br>
            예약인원 : <%=vo.getRes_person() %>명<br><br> 
            예약차량 : <%=vo.getRes_car_count() %>대<br><br>
            결제금액 : <%=vo.getRes_price() %>원<br><br>
         </div>
      </div>
      <br><br><br><br>
            <a href="<%= request.getContextPath()%>/Main_KKD/mainpage.jsp"><input type="button" id="home" value=" 홈으로 " class="button"></a>
            <a href="<%= request.getContextPath()%>/SelectMyResuervation.do"><input type="button" id="reserv" value="예약내역" class="button"></a>
   </div>
</div>


</body>
</html>