<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>야!!!캠핑가자~</title>
<link id="main icon" rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath()%>/Main_KKD/ICON/camping-favicon.ico">
<link rel="stylesheet" href="http://localhost/YaCamProject/css/reset.css"></link>
<link rel="stylesheet" href="http://localhost/YaCamProject/css/Mypage.css"></link>
<script type="text/javascript" src="../../js/jquery-3.7.0.min.js"></script>
<script type="text/javascript">
<%MemberVO vo = (MemberVO)session.getAttribute("userinfo");%>
$(function(){
	$('#deleteuser').on('click',function(){
		var txt;
		var id = '<%=vo.getMem_id()%>'
		var r = confirm("정말로 삭제 하시겠습니까?");
		if (r == true) {
		  $.ajax({
			 url : "<%=request.getContextPath()%>/DeleteUserInfo.do" ,
			 type : 'post',
			 data : {"id":id},
			 success : function(res){
				 alert("삭제"+res.cnt);
				 if(res.cnt=="성공"){
				 	$(location).attr('href', '<%=request.getContextPath()%>/pbc/login/sign.jsp');
				 }
			 },
			 dataType:'json'
		  });
		} else {
			txt = "삭제 취소"
		  	alert(txt)
		}
		
	});
});


</script>

</head>
<body>
 <div id="main_contaner">
		<br>
        <div id="header">
            <header id="head_box">마이페이지<a class="navbar-brand" href="<%=request.getContextPath()%>/Main_KKD/mainpage.jsp">
            	<img id="img2" src="<%=request.getContextPath()%>/imges/btn_back.png" alt="" width="30" height="24">
            </a></header>
            <hr>
            <br>
            <nav id="nav">
                <div id="nav_myinfo">
                    <div><a href="#"><img id="user_img" src="<%=request.getContextPath()%>/imges/user.png" alt="사람"></a></div>
                    <div id="nav_text">
                        <div id="user">&nbsp;등급:&nbsp;</div>
                        	<br>
                        <div id="user">&nbsp;이름:&nbsp;</div>
                    </div>
                    <div id="nav_user">
                   		<div id="insert1"><%=vo.getMem_grade() %></div>  
                        	 <br>                     
						<div id="insert"><%=vo.getMem_id() %></div>                               
                    </div>
                </div>
                <div id="nav_manu">
                    <div><a href="<%=request.getContextPath() %>/SelectAlarm.do"><img id="clock" src="<%=request.getContextPath()%>/imges/시계.png" alt="시계"></a></div>
                </div>
                <div id="nav_report">
                	<div id="report">빈자리알림</div>
                </div>
            </nav>
        </div>
        <br>
        <div id="body">
            <table border="1">
                <tr>
                    <td id="my">내정보</td>
                    <td>
                        <a href="<%=request.getContextPath() %>/SelectUserInfo.do"><input class="mypaage_button_one" type="button" value="정보 보기"></a>
                        <a href="<%=request.getContextPath() %>/UpdateUserInfo.do"><input class="mypaage_button_one" type="button" value="정보 수정"></a>
                        <a><input class="mypaage_button_one" type="button" value="회원 탈퇴" id=deleteuser></a>
                    </td>
                </tr>
                <tr>
                    <td id="reser">예약내역</td>
                    <td><a href="<%=request.getContextPath()%>/SelectMyResuervation.do"><input class="mypaage_button" type="button" value="상세 예약 내역"></a></td>
                </tr>
                <tr>
                    <td id="coupon">쿠폰함</td>
                    <td><a href="<%=request.getContextPath()%>/SelectCoupon.do"><input class="mypaage_button" type="button" value="쿠폰조회" id="couponbox"></a></td>
                </tr>
                <tr>
                    <td id="board">문의게시판</td>
                    <td><a href="<%=request.getContextPath()%>/LMW/mypage/myquestionboard.jsp"><input class="mypaage_button" type="button" value="내가 문의한 내용"></a></td>
                </tr>
                <tr>
                    <td id="save">찜목록</td>
                    <td><a href="<%=request.getContextPath()%>/wishlistpage.do"><input class="mypaage_button" type="button" value="찜목록"></a></td>
                </tr>
            </table>
        </div>
    </div> 
	<br><br><br>
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
</body>
</html>