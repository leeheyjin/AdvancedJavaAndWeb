<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="kr.or.ddit.campinfo.vo.CampInfoVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.wishlist.vo.WishlistVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
      border: 2px solid #f8cfbf;
      width: 50%;
      
   }
</style>

<script>
$(function(){
	

	$(document).on('change', '#like', function(){
		const wstatusElement = $(this); // 수정된 부분
		if (wstatusElement.prop('checked')) { // 수정된 부분
		  wstatus = 1;
		  alert("찜목록 추가")
		} else {
			wstatus = 0; 
			alert("찜목록 삭제")
		}
		
		
		const campno = wstatusElement.closest('form').find('input[name="campno"]').val()
		fdata = {
				status : wstatus ,
				memid: $('#memid').val(),
				campno: campno
			};
		console.log(fdata);
		$.ajax({
			 url: '<%= request.getContextPath()%>/Wishlist.do',
			 data : fdata,
			 type : 'get',
			 success : function(res){
				 if(res.flag  == "성공"){
						
					 } else{
						alert(res.flag) 
					 }
			 },
			 error : function(xhr){
				 alert("상태 : " + xhr.status);
			 },
			 dataType : 'json'
		})
	});
	
	
})// function 끝
</script>

</head>
<%List<WishlistVo> wishlist = (List<WishlistVo>) request.getAttribute("wishlist"); 
List<CampInfoVO> campinfolist = (List<CampInfoVO>) request.getAttribute("campinfolist"); 
MemberVO vo = (MemberVO)request.getSession().getAttribute("userinfo");%>
<body>

<div id="container"><br>
		<div id="header">찜목록 리스트 <br><br><hr><br><br></div>
	<div id="wrapper">
		<div id="campingList">

<% for(int i=0; i<campinfolist.size(); i++){ 
	  boolean isCampInWishList = false;
	    for (WishlistVo wvo : wishlist) {
	        if (wvo.getCamp_no().equals(campinfolist.get(0).getCamp_no())) {
	            isCampInWishList = true;
	            break;
	        }
	    }
%>
	<form action="<%=request.getContextPath() %>/CampZoneA001.do" method="get">
               <div class="col">
               <input id="img" style="display: inline;" type="image" src="<%=request.getContextPath() %><%=campinfolist.get(i).getCamp_poto() %>" class="image-border">
               </div>
               <div class="col">
                  <input type="hidden" id="campno" name="campno" value="<%= campinfolist.get(i).getCamp_no()%>">
                  <input type="hidden" id="campname" name="campname" value="<%=campinfolist.get(i).getCamp_name() %>">
               
               <input type="hidden" id="wstatus" name="wstatus" value="">
               <input type="hidden" id="memid" name="memid" value="<%=vo.getMem_id()%>">
               <div id="menu">이름: </div>
               <div class="info" id="info1" ><%=campinfolist.get(i).getCamp_name() %></div>           
               <div id="menu">주소: </div>
               <div class="info" id="info2"><%=campinfolist.get(i).getCamp_addr() %></div>
               <div id="menu">예약금액: </div>
               <div class="info" id="info"><%=campinfolist.get(i).getCamp_info() %></div>
               
                <div id="menu">찜목록 <input  type="checkbox" id="like" name="like" <%= isCampInWishList ? "checked" : "" %>></div>
               
                    <br><br>  
               </div>
               </form>
           <br>
<%} %>
		</div>
	</div>
</div>
</body>
</html>