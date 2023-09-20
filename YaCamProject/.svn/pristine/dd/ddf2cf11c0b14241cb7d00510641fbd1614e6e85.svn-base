<!--<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>-->
   <!DOCTYPE html>
   <%@page import="java.time.LocalDate"%>
<%@page import="java.time.Period"%>
<%@page import="java.util.Map"%>
<%@page import="kr.or.ddit.reservation.vo.ReservationVo"%>
<%@page import="kr.or.ddit.campinfo.vo.CampInfoVO"%>
<%@page import="kr.or.ddit.campzone.vo.CampzoneVo"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<html>
   <head>
   <meta charset="UTF-8">
   <title>Insert title here</title>
   <script src="<%=request.getContextPath() %>/js/jquery-3.7.0.min.js"></script>
   
   <link id="main icon" rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath() %>/Main_KKD/ICON/camping-favicon.ico">
   
   <style>
     @font-face {
			    font-family: 'TheJamsil5Bold';
			    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2302_01@1.0/TheJamsil5Bold.woff2') format('woff2');
			    font-weight: 700;
			    font-style: normal;
				}
		body{
			background-color: #f6f6f6;
			font-family: "TheJamsil5Bold";
			font-weight: 400;
			transform: rotate(0.03deg);
			margin:0;
			position: relative;	
			}
   
		   #main icon{
			display: block;
		    margin: auto;
		    cursor: zoom-in;
		    background-color: hsl(0, 0%, 90%);
		    transition: background-color 300ms;
			}
       
       div {
           box-sizing: border-box;
           margin: 2px;
       }
       #no1 {
           width: 60%;
           height: auto;
           margin: 0px auto;
        }
        #header, #footer{
            height: 120px;
            flex-direction: column;
            text-align: center;
           text-align: center;
       }
       #footer{
       	height: 150px;
       	margin-top: 30px;
       }
   
       #body {
           display: flex;
       flex-direction: row;
       height: 600px;
       border: 3px solid #f8cfbf;
       }
       #right {
           display: flex;
       flex-direction: column;
       height: 500px;
       }
   
       #left{
           flex: 70%;
           height: 100%;
           text-align: right;
       }
       #right{
           flex: 30%;
            height: 80%;
            text-align: left;
           
           
       }
   
       img{
               width: 100%;
			    height: 100%;
			    margin: 0px auto;
			    padding: 10px 0px 12px 10px;
			    box-sizing: border-box;
           
           
       }
       .dlsdnjs {
           width: 50px;
       }
   
       .right_top{
           flex: 33%;
           text-align: center;
/*            line-height: 200%;  글사이간격*/
       }
       #v,#v2{
           width: 50px;
       }
       #carnum{
       	width: 50px;
       }
        hr{
			border: 2px solid #f8cfbf;
			}
       
   
   </style>

<%
   	List<CampzoneVo> list = (List<CampzoneVo>)session.getAttribute("list");
	ReservationVo reservationvo = (ReservationVo)  session.getAttribute("Reservationvo");
	CampzoneVo campzonevo = (CampzoneVo) session.getAttribute("Campzonevo");
	CampInfoVO campinfovo = (CampInfoVO) session.getAttribute("campinfoVo");
	Map<String, Object> campmap = (Map<String,Object>) session.getAttribute("campinfomap");
	String campname = (String) campmap.get("campname");
	String campno = (String) campmap.get("campno");
%>   
      <script>
//function 시작
$(function(){
	$(document).on('click', '#reservation' , function(){
		var personText = $("#person").text();
		var campStandard = <%=campzonevo.getZone_standard()%>;
		var person = parseInt(personText) + campStandard;
		var car = $('#carnum').text();
		var total = $('#result').val();
		console.log(person, car, total);
		
		var fdata = {
			"person": person,
			"car": car,
			"total": total
		};
		console.log(fdata);
		
		$.ajax({
			url: '<%=request.getContextPath()%>/Pay.do',
			data: fdata,
			type: 'get',
			success: function(res){
				if(res.flag == "성공"){
					var vpage = "<%= request.getContextPath()%>/payCoupon.do";
					location.href = vpage;
				}else{
					alert(res.flag);
				}
			},
			error: function(xhr){
				alert("상태: " + xhr.status);
			},
			dataType: 'json'
		});
	});
	
	//  바베큐 옵션 처리
	    $("input[name='bbq']").change(function() {
	      var test = $("input[name='bbq']:checked").val();
	      updatePrice(test);
	    });
	    
	
});
 
  
   
  
  function updatePrice(value) {
    const resultElement = document.getElementById('result');
    let price = parseInt(resultElement.value);
    price += parseInt(value);
    resultElement.value = price;
  }
  //인원추가
  function count(type) {
    const resultElement = document.getElementById('result');
    const personElement = document.getElementById('person');
    	
    let number = parseInt(personElement.innerText);
    let price = parseInt(resultElement.value);
    
    if (type === 'plus') {
    	
      if (number < <%=campzonevo.getZone_maximum() - campzonevo.getZone_standard()%>) {
        number = Math.min(number + 1, 7);
        price += <%=campzonevo.getZone_add_price()%>;
      }
    } else if (type === 'minus') {
      if (number > 0) {
        number = Math.max(number - 1, 0);
        price -= <%=campzonevo.getZone_add_price()%>;
      }
    }
    
    personElement.innerText = number;
    resultElement.value = price;
  }// 인원추가
  
  
  //차량 추가
   function count2(type) {
    const carnumElement = document.getElementById('carnum');
    
    let carnumber = parseInt(carnumElement.innerText);
    
    if (type === 'pluscar') {
    	
      if (carnumber < 9) {
        carnumber = Math.min(carnumber + 1, 9);

      }
    } else if (type === 'minuscar') {
      if (carnumber > 0) {
        carnumber = Math.max(carnumber - 1, 0);
      }
    }
    
   	carnumElement.innerText = carnumber;
  }// 차량 추가
  
  


  
  
</script>
   
   
   </head>

   
   <style>
/*         div {  */
/*             border : 2px solid red;  */
/*         }  */
	#person ,#carnum{
		display: inline;
	}
   </style>

  
   
<script>
//추가 인원 수 구하기
	$(function(){

	})
</script>
   
   <body>
   <div>
   	<form action="" method="get">
       <div id="no1">
           <div id="header">
					<h1><%=campinfovo.getCamp_name() %> <hr> </h1>
           </div>
   
           <div id="body">
   
               <div id="left">
                   <img src="<%=request.getContextPath() %>/ksj/images/<%=campinfovo.getCamp_no()%>/<%=campzonevo.getZone_type() %>.jpg" alt=""><br>
                   <%
					    Period period = Period.between(LocalDate.parse(reservationvo.getRes_checkin()), LocalDate.parse(reservationvo.getRes_checkout()));
					%>
					
<!-- 				<ul> -->
<%-- 					<%for(CampzoneVo vo : list){ %> --%>
<%-- 						<li><input type="button" value="<%=vo.getZone_no()%>" id="zone_no" name="<%=vo.getZone_no()%>"></li> --%>
<%-- 					<%}%> --%>
					
<!-- 				</ul> -->
					
				
				
					       
					   
               </div>
   
   
               <div id="right">
                   <div class="right_top">
						<br><br>방 번호 : <%=campinfovo.getCamp_no()%>
                    <h2><%=campzonevo.getZone_type() %></h2>
                       기준 인원 : <%=campzonevo.getZone_standard()%> <br>
                       최대 인원 : <%=campzonevo.getZone_maximum() %> <br>
                       1박 가격 : <%=campzonevo.getZone_price() %><br>
                   </div>
                   <div class="right_top">
                  	<br>
                    추가 인원<br>
                       <input id="m" type="button" onclick='count("minus")' value="-">
                       <div id='person' name="person">0</div>
                       <input id="p" type="button" onclick='count("plus")' value="+">
                       
                   <br>예약 차량<br>
                   <input id="mm" type="button" onclick='count2("minuscar")' value="-">
                   <div id='carnum' name="carnum">0</div>
                   <input id="pp" type="button" onclick='count2("pluscar")' value="+">
                       
                    
                   </div>
                   <div class="right_top"><br>
                    바베큐 옵션<br>	
                       <label><input type="radio"  name="bbq" value="20000" >Yes</label>
                       <label><input type="radio"  name="bbq" value="-20000" checked="checked">No</label>
                       <br><br>
                            <span>입실 : <%= LocalDate.parse(reservationvo.getRes_checkin()) %></span><br>
					        <span>퇴실 : <%= LocalDate.parse(reservationvo.getRes_checkout()) %></span><br>
					        <span><%= period.getDays() %> 박</span><br><br><br><br><br><br>
         				   합계<input  type="text" id="result" name="result" value ="<%= reservationvo.getRes_price() * period.getDays() %>" >
                      <br><br><input  type="button" id="reservation" name="reservation" value="예약하기">
                    
                   </div>
               </div>
   
           </div>
   
           <div id="footer">

           </div>
           	
           
       </div>
       
       </form>
   </div>
   

       
   
   </body>
   </html>