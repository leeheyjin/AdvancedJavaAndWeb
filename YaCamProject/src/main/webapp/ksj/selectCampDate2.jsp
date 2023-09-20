<%@page import="oracle.net.aso.r"%>
<%@page import="kr.or.ddit.campzone.vo.CampzoneVo"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.campinfo.vo.CampInfoVO"%>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>날짜선택</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet" href="/css/reset.css"></link>
    <!-- <link rel="stylesheet" href="/css/datepicker.css"></link> -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js" integrity="sha512-uto9mlQzrs59VwILcLiRYeLKPPbS/bT71da/OEBYEwcdNUk8jYIy+D176RYoop1Da+f9mvkYrmj5MCLZWEtQuA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.css" integrity="sha512-aOG0c6nPNzGk+5zjwyJaoRUgCdOrfSDhmMID2u4+OIslr0GjpLKo7Xm0Ao3xmpM4T8AmIouRkqwj1nrdVsLKEQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
  <link id="main icon" rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath() %>/Main_KKD/ICON/camping-favicon.ico">
  <style>
  @font-face {
    font-family: 'TheJamsil5Bold';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2302_01@1.0/TheJamsil5Bold.woff2') format('woff2');
    font-weight: 700;
    font-style: normal;
}

#main icon{
	display: block;
    margin: auto;
    cursor: zoom-in;
    background-color: hsl(0, 0%, 90%);
    transition: background-color 300ms;
}
    
    div {
    	margin: 0px;
    	padding: 0px;
     } 

    html, body{
        min-width:1500px;
        font-family: "TheJamsil5Bold";
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
        height: 334px;
        padding: 0px;
    }
    #type {
        width: 330px;
        height: 330px;
        border: 2px solid #f8cfbf;
    }
    
 
    .col {
        display: inline-block; 
        box-sizing : border-box;
        width : 400px;
        height : 100%;
        flex : none;
        vertical-align: top;
        margin: 0px;
        padding: 0px; 
    }
   
    
    .info {
    	width : 100%;
        height: 75px;
        padding-top: 10px;
        margin: 10px;
       
    }
    
    
    .datepicker{
    	display : flex;
    	justify-content : center;
        width:1000px;
        height:450px;
        font-size:30px;
       	margin : auto;
/*         margin-left: 300px; */
        text-align : center;
       	align-content: center;
       	
    }
   
    .row{
        border: 3px solid #f8cfbf;
        margin: 10px;
        padding: 0px;
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
            margin: 30px auto; /* 30px from the top and centered */
            padding: 20px;
            border: 1px solid #888;
            width: 70%; /* Could be mre or less, depending on screen size */
            overflow-y: scroll;
            max-height: 100vh;                       
        }
        #check{
        text-align: center;
        }
        
        #inout{
        	margin: 10px;
        }
        .inout{
        	display: inline;
        	width : 130px;
        	border: 0px;
        }
        
        hr{
		border: 2px solid #E44000;
		opacity: 1;
		}
        #hr{
		border: 2px solid #E44000;
		opacity: 0.25;
		}
     
        
      
    
</style>
 
 
<%
	List<CampzoneVo> campzoneselect = (List<CampzoneVo>) request.getAttribute("campzoneselectlist"); // 내가 선택한 캠핑장 방번호
	List<CampInfoVO> campinfoselect = (List<CampInfoVO>) request.getAttribute("campinfoVo"); // 내가 선택한 캠핑장 방번호
	List<CampzoneVo> campzoneallselect = (List<CampzoneVo>) request.getAttribute("campzonelist"); // 모든 캠핑장 방번호
	CampInfoVO campinfovo = (CampInfoVO) request.getAttribute("campinfoVo2");
	MemberVO vo = (MemberVO)request.getSession().getAttribute("userinfo");
%>
<script>
 

  
	$.datepicker.setDefaults({ //달려
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
	}); //달력끝

//function
	
	
	
    $(function(){
    	
    	
    	//알람 신청
    	
   		$(document).on('click','.alarm',function(){
    		if(confirm("알림신청을 하시겠습니까?")){
    			var zoneNo = $(this).attr('name');
    			var campNo = $(this).attr('id');
    			console.log(zoneNo,campNo )//콘솔 확s
    			
    			$.ajax({
    				url : "<%=request.getContextPath()%>/insertAlarm.do",
    				data : {
    					"zone" : zoneNo,
    					"camp" : campNo
    				},
    				type : "post",
    				success : function(res){
    					alert("빈자리 알람이 신청되었습니다. 빈자리 발생시 문자로 알려드립니다.")
    				},
    				error : function(xhr){
    					alert("실패")
    				},
    				dataType:"json"
    			})//ajax
    			
    			
    		}//if
    		
    	})//click
    	
    	//알람 신청
    	
    	
    	//다시 선택
    	$('#reset').on('click',function(){
    		$('#in').val("");
    		$('#out').val("");
    		
    	})//다시 선택
    	

    	
    	//선택하기
		$('#pic').on('click',function(){
		    indate = $('#in').val();
		    outdate =$('#out').val();
		    icampno = '<%=campzoneselect.get(1).getCamp_no()%>';
		    console.log(indate, outdate);
		    $.ajax({
		        url : "<%=request.getContextPath()%>/seleteDate.do",
		        type : "get",
		        data : {
		            "indate" : indate,
		            "outdate" : outdate,
		            "icampno" : icampno
		        },
		        success : function(res){
		        	zoneCode=[];
		        	campCode=[];
		        	htmlCode="";
		        	cindexof=[];
	        		$.each(res, function(i,v){
	        			console.log(v.zone_no,v.camp_no)
	        			zoneCode.push(v.zone_no);
	        			campCode.push(v.camp_no);
	        		})//each
	        		$('#zone_box').html("");
	        		
<%-- 	        	   	캠핑장이름<%=campinfovo.getCamp_name() %><br> --%>
<%-- 	               	캠핑장주소<%=campinfovo.getCamp_addr()%><br> --%>
<%-- 	               	캠핑장번호<%=campinfovo.getCamp_tel()%><br> --%>
<%-- 	               	캠핑장환불정책<%=campinfovo.getCamp_refund()%><br> --%>
<%-- 	               	캠핑장이용타입<%=campinfovo.getCamp_facility_info()%><br> --%>
<%-- 	               	캠핑장이용매너<%=campinfovo.getCamp_policy()%><br> --%>
<%-- 	               	캠핑장이용매너<%=campinfovo.getCamp_policy()%><br> --%>
<%-- 	               	캠핑장예약가능일<%=campinfovo.getCamp_res_info()%><br> --%>
<%-- 	               	<%=campinfovo.getCamp_instructions()%><br> --%>
	        		
       				for(let j=0; j<zoneCode.length; j++){
        			<% for(int i=0; i<campzoneselect.size( 	); i++){ %>
	        				if (zoneCode[j] == '<%=campzoneselect.get(i).getZone_no() %>' ) {
	        					cindexof.push(<%=i%>);
			        			htmlCode+='<div class="row" id="regioninfo">';
			        			htmlCode+='<div class="col"><img src="<%=request.getContextPath()%>/ksj/images/<%=campzoneselect.get(i).getCamp_no() %>/<%=campzoneselect.get(i).getZone_type()%>.jpg" id=type></div>';
			        			htmlCode+='<div class="col" style="width : 60%;">';
			        			htmlCode+='<input type="hidden" id="no" name="no" value="<%=campzoneselect.get(i).getZone_no()%>">';
			        			htmlCode+='<input type="hidden" id="price" name="price" value="<%=campzoneselect.get(i).getZone_price() %>">';
			        			htmlCode+='<input type="hidden" id="zonetype" name="zonetype" value="<%=campzoneselect.get(i).getZone_type()%>">';
			        			htmlCode+='<div class="info" ><%=campinfovo.getCamp_name() %><br>방 번호 : <%=campzoneselect.get(i).getZone_no() %></div>'  ;
			        			htmlCode+='<div class="info" >1박 이용 가격 : <%=campzoneselect.get(i).getZone_price() %><br>환불 규정 : <%=campinfovo.getCamp_refund()%></div>';
			        			htmlCode+='<div class="info" style="padding-top : 0;"><%=campzoneselect.get(i).getZone_type() %> 정원 <%=campzoneselect.get(i).getZone_standard() %>인 최대 <%=campzoneselect.get(i).getZone_maximum() %>인 이며 <br>주의사항 : <%=campinfovo.getCamp_policy()%><br><%=campinfovo.getCamp_precautions()%></div>';
			        			htmlCode+='<div class="info"><button  class="dPdir" type="button" class="btn btn-warning">예약하기</button></div>';
			        			htmlCode+='</div>';
			        			htmlCode+='</div>';
			        			htmlCode+='<hr class="hr">';
							}
       				<%} %>
        				}
	        			htmlCode+='<input type="button" value="예약중인 방 보기" id="reservation_check" name="reservation_check">';
       					console.log(htmlCode);
	        			$('#zone_box').html(htmlCode);
	        			
		        },//success
		        
		        error : function(xhr){
		            alert(xhr.status)
		        },
		        dataType : "json"
		    })//ajax
    	})//선택하기
    	
    	//빈자리 선택
    	$(document).on('click','#reservation_check',function(){
		    var indate = $('#in').val();
		    var outdate =$('#out').val();
		    var icampno = '<%=campzoneselect.get(0).getCamp_no()%>';
    		$.ajax({	
    			url : '<%=request.getContextPath()%>/seleteDate.do',
    			data : {
 		            "indate" : indate,
 		            "outdate" : outdate,
 		            "icampno" : icampno
 		        },
    			type : 'post',
    			success : function(res){
    				var czoneCode=[];
		        	var ccampCode=[];
		        	var chtmlCode="";
	        		$.each(res, function(i,v){
	        			console.log(v.zone_no,v.camp_no)
	        			czoneCode.push(v.zone_no);
	        			campCode.push(v.camp_no);
	        		})//each
       				for(let j=0; j<czoneCode.length; j++){
        			<% for(int i=0; i<campzoneselect.size(); i++){ %>
	        				if (czoneCode[j] == '<%=campzoneselect.get(i).getZone_no() %>' ) {
	        					
	        					chtmlCode+='<div class="row" id="regioninfo">';
			        			chtmlCode+='<div class="col"><img src="<%=request.getContextPath()%>/ksj/images/<%=campzoneselect.get(i).getCamp_no() %>/<%=campzoneselect.get(i).getZone_type()%>.jpg" id=type></div>';
			        			chtmlCode+='<div class="col" style="width : 60%;">';
			        			chtmlCode+='<input type="hidden" id="no" name="no" value="<%=campzoneselect.get(i).getZone_no()%>">';
			        			chtmlCode+='<input type="hidden" id="price" name="price" value="<%=campzoneselect.get(i).getZone_price() %>">';
			        			chtmlCode+='<input type="hidden" id="zonetype" name="zonetype" value="<%=campzoneselect.get(i).getZone_type()%>">';
			        			chtmlCode+='<div class="info" ><%=campinfovo.getCamp_name() %><br>방 번호 : <%=campzoneselect.get(i).getZone_no() %></div>'  ;
			        			chtmlCode+='<div class="info" >1박 이용 가격 : <%=campzoneselect.get(i).getZone_price() %><br>환불 규정 : <%=campinfovo.getCamp_refund()%></div>';
			        			chtmlCode+='<div class="info" style="padding-top : 0;"><%=campzoneselect.get(i).getZone_type() %> 정원 <%=campzoneselect.get(i).getZone_standard() %>인 최대 <%=campzoneselect.get(i).getZone_maximum() %>인 이며 <br>주의사항 : <%=campinfovo.getCamp_policy()%><br><%=campinfovo.getCamp_precautions()%></div>';
			        			chtmlCode+='<div class="info">예약불가 <input type="button" value="빈자리알람 신청" class="alarm"id="<%=campzoneselect.get(i).getCamp_no() %>" name="<%=campzoneselect.get(i).getZone_no() %>"></div>';
			        			chtmlCode+='</div>';
			        			chtmlCode+='</div>';
							}
       				<%} %>
					}
	        		console.log(chtmlCode)
	        		$('#resurvation_box').html(chtmlCode);
    			},
    			error : function(xhr){
    				alert("상태 : " + xhr.status);
    			},
    			dataType : 'json'
    		})
    	})
    	//빈자리 선택
    	
    	
    	//달력 선택
    	dcode = "";
    	  $('.datepicker').datepicker({
    	    minDate: 0,
    	    onSelect: function(dateText, inst) {
    	      var selectedDate = new Date(dateText);
    	      var inDate = new Date($("#in").val());

    	      // 선택된 날짜를 "in" 또는 "out" 입력 필드에 넣어줍니다.
    	      if ($("#in").val() === "") {
    	        $("#in").val(dateText);
    	      } else if ($("#out").val() === "") {
    	        // 퇴실 날짜가 입실 날짜보다 이전인 경우 경고 메시지를 출력합니다.
    	        if (selectedDate < inDate) {
    	          alert("퇴실 날짜는 입실 날짜보다 이전 날짜일 수 없습니다.");
    	          return; // 선택한 날짜를 적용하지 않고 종료합니다.
    	        }
    	        $("#out").val(dateText);
    	      }
    	      
    	    }
    	  });

    	  $(".datepicker").focus();  //달력선택
    	
    	  
    	  
    	 $(document).on('click','.dPdir', function(){ // 예약하기 누르기
    		 
    		 if($('#in').val() && $('#out').val() !=null){
    		checkin = $('#in').val();
    		checkout = $('#out').val();
    		zoneno = $(this).parents('.col').find('#no').val();
			campprice = $(this).parents('.col').find('#price').val();
			campno = $('#campno').val();
			id = $("#id").val();
			zonetype = $(this).parents('.col').find('#zonetype').val();
    		
    		
    		fdata={
    				"in" : checkin,
    				"out" :checkout,
    				"zoneno" : zoneno,
    				"campno" : campno,
    				"price" : campprice,
    				"id" : id,
    				"zonetype" : zonetype
    		}
    		console.log(fdata);
    		
    		$.ajax({	
    			url : '<%= request.getContextPath()%>/reservationA001.do',
    			data : fdata,
    			type : 'get',
    			success : function(res){
    				if(res.flag=="성공"){
    					location.href='<%=request.getContextPath()%>/ksj/Reservation.jsp';
    				}else{
    					
    				}
    			},
    			error : function(xhr){
    				alert("상태 : " + xhr.status);
    			},
    			dataType : 'json'
    		})
    		
    	 }else{
    		 alert("날짜를 선택해주세요")
    	 }
    		 
    	 }) // 예약하기 종료
    	  
   	})// function 끝
    
    
    
    
  </script>


</head>


<body>


    <div id="myModal" class="modal">
 
      
        <div class="modal-content">
      
      		<img src="<%=request.getContextPath() %>/ksj/images/베스트필드 예약안내.png">
        	<div style="cursor:pointer;background-color:orange;text-align: center;padding-bottom: 10px;padding-top: 10px;" onClick="close_pop();">
                <span class="pop_bt" style="font-size: 13pt;" >
                    닫기
                </span>
            </div>
            <br>
    	</div>
	</div>
    
 
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
        <div id="header">날짜 선택 <hr id="hr" ></div>
        
        <div  id="selectdate">
            <div class="datepicker"></div>
            
        </div>
        <br><br>
        <div id="check">
        
        <input type="hidden" id="campno" name="campno" value="<%=campzoneselect.get(0).getCamp_no()%>">
        <input type="hidden" id="id" name="id" value="<%=vo.getMem_id()%>">
        입실 : <input class="inout" type="text" id="in" name="in" readonly> 
        퇴실 : <input class="inout" type="text" id="out" name="out" readonly>
        <input  type="button"  id="reset" name="reset" value="다시선택">
        <input  type="button"  id="pic" name="pic" value="선택하기">
       
        </div>
        
        
        <br><br>
      
       	
        <div id="zone_box">
<%-- 	        <% for(int i=0; i<campzoneselect.size(); i++){ %> --%>
<%-- 	        <input type="hidden" id="zonetype" name="zonetype" value="<%=campzoneselect.get(i).getZone_type()%>"> --%>
<!-- 	         <div class="row" id="regioninfo"> -->
<%-- 	            <div class="col"><img src="<%=request.getContextPath()%>/ksj/images/<%=campzoneselect.get(i).getCamp_no() %>/<%=campzoneselect.get(i).getZone_type()%>.jpg" id=type></div> --%>
<!-- 	            <div class="col"> -->
<%-- 	        		<div class="info" name="no"><%=campzoneselect.get(i).getZone_no() %></div>     --%>
<%-- 	                <div class="info" name="price"><%=campzoneselect.get(i).getZone_price() %></div> --%>
<%-- 	                <div class="info"><%=campzoneselect.get(i).getZone_type() %> 정원 <%=campzoneselect.get(i).getZone_standard() %>인 최대 <%=campzoneselect.get(i).getZone_maximum() %>인</div> --%>
<!-- 	                <div class="info"><button  class="dPdir" type="button" class="btn btn-warning">예약하기</button></div>      -->
<!-- 	            </div> -->
<!-- 	        </div> -->
<%-- 	        <%} %> --%>
        </div>
        <div id="resurvation_box">
        </div>
        
        
    </div>
</div>
    
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>
