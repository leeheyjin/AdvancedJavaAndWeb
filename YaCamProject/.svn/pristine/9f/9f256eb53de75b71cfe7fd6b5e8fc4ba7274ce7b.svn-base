<%@page import="kr.or.ddit.campzone.vo.CampzoneVo"%>
<%@page import="kr.or.ddit.campinfo.vo.CampInfoVO"%>
<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@page import="kr.or.ddit.coupon.vo.CouponVO"%>
<%@page import="java.util.List"%>
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
<%
ReservationVo reservationvo = (ReservationVo)  session.getAttribute("Reservationvo");
CampInfoVO cvo = (CampInfoVO)session.getAttribute("campinfoVo");
CampzoneVo zvo = (CampzoneVo)session.getAttribute("Campzonevo");
%>

<style>
	/* div { border : 2px solid orange;} */ /* 레이아웃 나눌땐 일단 border가 눈에 보여야 함 */
    
    @font-face {
      font-family: 'TheJamsil5Bold';
      src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2302_01@1.0/TheJamsil5Bold.woff2') format('woff2');
      font-weight: 700;
      font-style: normal;
    }
    
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
    	height : 30%;
    }
    
    .col {
        display: inline-block; /* 옆에 누가 오는 걸 허락해야 함 */
        width : 49.2%;
        height : 100%;
        vertical-align: top; /* 필요할 때가 꽤 있음! */
        
    }
    
    .info {
        height: 32%;
        padding-top: 40px;
        border : 1px solid orange;
    }
    .photo {
        width: 350px;
        height: 220px;
        padding-top: 0px; 
        border : 2px solid #FF5918;
    }

    .image-border{
        padding-top : 0px;
        border: 4px solid orange;
    }
    #kakao {
       width:50px;
       height: 20px;
    }
    .form-select {
       margin-top : 15px;
       margin-left : 180px;
       width: 220px;
       text-align: center;
       height: 35px;
       
       
    }
    #result {
       width : 55px;
       margin-left : 0px;
       border : none;
    }
    #kakao {
       margin-top : 23px;
    }
    .button {
       background-color : #f8f9fa;
    }
    
    
</style>

</head>


<script>
$(function() {
	  $(document).on('change', '#coupon', function() {
		  const resultElement = document.getElementById('result');
		    const selectedIndex = this.selectedIndex; 
		    const couponsale = this.options[selectedIndex].value;
	    
	    const couponnoElement = document.getElementById('couponno');
	    const couponno = couponsale.substring(0, 19);
	    couponnoElement.value=couponno;
	    
	    let sale = "";
	    let totalPrice = 0;
	    
	    if (couponsale.substring(19,22) === "이벤트") {
		      sale = "0.95";
		    } else if (couponsale.substring(19,23) === "생일축하") {
		      sale = "0.9";
		    } else if (couponsale.substring(19,23) === "신규가입") {
		      sale = "0.85";
		    } else {
	      sale = "1";
	    }
	    
	    totalPrice = <%= reservationvo.getRes_price() %> * parseFloat(sale);
	    
	    resultElement.value = totalPrice;
	    
	    console.log(totalPrice);
	  });
	});
</script>



<body>


<form action="<%=request.getContextPath() %>/ksj/kakao.jsp">
<div id="container">
    <div id="wrapper">
        <div id="header">예약 결제 <hr></div>
        <br>
        <div class="row">
	        <div class="col">
	          <img class="photo" src="<%=request.getContextPath() %><%=cvo.getCamp_poto()%>">
	        </div>
	        <div class="col">
	        <br><br><br><br>
	          <h5><%=cvo.getCamp_name() %></h5>
	        </div>
        </div>
        
        <div class="row">
	        <div class="col">
	           <img class="photo" src="<%=request.getContextPath() %>/ksj/images/<%=cvo.getCamp_no()%>/<%=zvo.getZone_type() %>.jpg">
	        </div>
	        <div class="col">
	        <br><br><br>
	          <%=zvo.getZone_type() %><br><br>
	          자리번호 : <%=reservationvo.getZone_no()%>
	        </div>
        </div>
        <br><br><h5>예약신청 정보</h5><hr><br>
        <div class="row">
	        <div class="col">
	           캠핑장<br><br>
	           캠핑종류<br><br>
	           자리번호<br><br>
	           기간<br><br>
	           예약인원<br><br>
	           예약차량<br><br>
	        </div>
	        <div class="col">
	           <%=cvo.getCamp_name() %><br><br>
	           <%=zvo.getZone_type() %><br><br>
	           <%=reservationvo.getZone_no()%><br><br>
	           <%=reservationvo.getRes_checkin()%> ~ <%=reservationvo.getRes_checkout()%><br><br>
	           <%=reservationvo.getRes_person()%><br><br>
	           <%=reservationvo.getRes_car_count()%><br><br>
	        </div>
        </div>
        <br><br><br><h5>결제정보</h5><hr><br>
        <div class="row">
	        <div class="col">
	           총 결제금액<br><br>
	           쿠폰사용<br><br>
	           결제수단<br><br>
	           현재상태
	        </div>
	        <div class="col">
	           <input type="text" id="result" name="result" value="<%=reservationvo.getRes_price()%>" readonly>원<br> <!-- 결제금액 -->
	           
	          <select class="form-select" aria-label="Default select example" name="coupon" id="coupon">
			       <option value="">선택없음</option>
			       <% List<CouponVO> list = (List<CouponVO>)request.getAttribute("list"); %>
					 <%if(list != null){ %>
					   <%for(CouponVO vo : list){ %> 
			             <option class="couponno" value="<%=vo.getCup_no() %><%=vo.getCup_name() %>"><%=vo.getCup_name() %> 만료기간 : <%=vo.getCup_edate() %></option>
			           <% }%>
			         <% }%>
		     </select>
			   
	           <img src="<%=request.getContextPath() %>/ksj/images/카카오페이(소).png" id=kakao><br><br>
	           결제대기<br><br>
	        </div>
        </div>
        <div class="row">
	        <div class="col" id="lcol"><a href="<%= request.getContextPath()%>/Main_KKD/mainpage.jsp"><input type="button" value="예약취소" class="button"></a></div>
	        <div class="col" id="rcol">
				   <input type="hidden" name="mem_id" value="<%=reservationvo.getMem_id()%>"> <!-- 사용자 아이디 -->
				   <input type="hidden" name="zone_no"  value="<%=reservationvo.getZone_no()%>"><!-- 캠핑장 자리 번호 -->
				   <input type="hidden" name="camp_no"  value="<%=reservationvo.getCamp_no()%>"><!-- 캠핑장 번호 -->
				   <input type="hidden" name="res_date"  value="<%=reservationvo.getRes_date()%>"><!-- 예약한 날짜 -->
				   <input type="hidden" name="checkin"  value="<%=reservationvo.getRes_checkin()%>"><!-- 체크인 날짜 -->
				   <input type="hidden" name="checkout"  value="<%=reservationvo.getRes_checkout()%>"><!-- 체크아웃 날짜 -->
				   <input type="hidden" name="res_person"  value="<%=reservationvo.getRes_person()%>"><!-- 총 인원 -->
				   <input type="hidden" name="res_car_count"  value="<%=reservationvo.getRes_car_count()%>"><!-- 예약 차량 -->
				   <input type="hidden" name="res_price"  value="<%=reservationvo.getRes_price()%>"><!-- 총 합계 -->
				   <input type="hidden" id="couponno" name="couponno"  value=""><!-- 쿠폰넘버 -->
				   <input type="submit" name="pay" value="결제하기" class="button">
	        </div>
        </div>
    </div>
</div>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>