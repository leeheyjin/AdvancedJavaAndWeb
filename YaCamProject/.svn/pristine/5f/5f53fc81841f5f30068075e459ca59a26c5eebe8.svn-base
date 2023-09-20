<%@page import="kr.or.ddit.reservation.vo.ReservationVo"%>
<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
 //   String name = (String)request.getAttribute("name");
 //   String email = (String)request.getAttribute("email");
 //  String phone = (String)request.getAttribute("phone");
 //  String address = (String)request.getAttribute("address");
  //  int totalPrice = (int)request.getAttribute("totalPrice");
     String memId = (String)request.getParameter("mem_id");
     String zoneNo = (String)request.getParameter("zone_no");
     String campNo = (String)request.getParameter("camp_no");
     String resDate = (String)request.getParameter("res_date");
     String checkin = (String)request.getParameter("checkin");
     String checkout = (String)request.getParameter("checkout");
     String resPerson = (String)request.getParameter("res_person");
     String resCarCount = (String)request.getParameter("res_car_count");
     String couponNo = (String)request.getParameter("couponno");
     String stotalPrice = (String)request.getParameter("result");
     int totalPrice = Integer.parseInt(stotalPrice);
     
     
     ReservationVo vo = new ReservationVo();
     vo.setCup_no(couponNo);
     vo.setMem_id(memId);
     vo.setZone_no(zoneNo);
     vo.setCamp_no(campNo);
     vo.setRes_date(resDate);
     vo.setRes_checkin(checkin);
     vo.setRes_checkout(checkout);
     vo.setRes_person(Integer.parseInt(resPerson));
     vo.setRes_car_count(Integer.parseInt(resCarCount));
     vo.setRes_price(Integer.parseInt(stotalPrice));

     request.getSession().setAttribute("kakao", vo);
     
     
     
     
    
     System.out.println("mem_id : " + memId);
     System.out.println("zone_no : " + zoneNo);
     System.out.println("res_person : " + resPerson);
     System.out.println("checkin : " + checkin);
     System.out.println("checkout : " + checkout);
     System.out.println("stotalPrice: " + stotalPrice);
     System.out.println("totalPrice: " + totalPrice); 
     
     /* String resPrice = (String)request.getAttribute("res_price");
     int price = Integer.parseInt(resPrice); */
 	 
     
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>kakao</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
</head>
<body>
    <script>
    $(function(){
        var IMP = window.IMP; // 생략가능
        IMP.init('imp23418340'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
        var msg;
        
        IMP.request_pay({
            pg : 'kakaopay',
            pay_method : 'card',
            merchant_uid : 'merchant_' + new Date().getTime(),
            name : '야캠 캠핑장 결제',
            amount : <%=totalPrice%>,
            buyer_id : '<%=memId%>',
            buyer_zone_no : '<%=zoneNo%>',
            buyer_res_person : '<%=resPerson%>',
            buyer_checkin : '<%=checkin%>',
            buyer_checkout : '<%=checkout%>',
            //m_redirect_url : 'http://www.naver.com'
        }, function(rsp) {
            if ( rsp.success ) {
                //[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
                jQuery.ajax({
                    url: "/payments/complete", //cross-domain error가 발생하지 않도록 주의해주세요
                    type: 'get',
                    dataType: 'json',
                    data: {
                        imp_uid : rsp.imp_uid
                        
                        //기타 필요한 데이터가 있으면 추가 전달
                    }
                }).done(function(data) {
                    //[2] 서버에서 REST API로 결제정보확인 및 서비스루틴이 정상적인 경우
                    if ( everythings_fine ) {
                        msg = '결제가 완료되었습니다.';
                        msg += '\n고유ID : ' + rsp.imp_uid;
                        msg += '\n상점 거래ID : ' + rsp.merchant_uid;
                        msg += '\결제 금액 : ' + rsp.paid_amount;
                        msg += '카드 승인번호 : ' + rsp.apply_num;
                        
                        alert(msg);
                    } else {
                    	msg="실패";
                        //[3] 아직 제대로 결제가 되지 않았습니다.
                        //[4] 결제된 금액이 요청한 금액과 달라 결제를 자동취소처리하였습니다.
                    }
                });
                //성공시 이동할 페이지
               location.href='<%=request.getContextPath()%>/payre.do?msg='+msg;
            } else {
                msg = '결제에 실패하였습니다.';
                msg += '에러내용 : ' + rsp.error_msg;
                //실패시 이동할 페이지
                location.href="<%=request.getContextPath()%>/payCoupon.do";
                alert(msg);
            }
        });
        
    });
    </script> 
 
</body>
</html>