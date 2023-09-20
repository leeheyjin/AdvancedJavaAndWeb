<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="tmp.jsp" %>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
<script>

//성별
$(function(){
	$('#gender').on('click',function(){
	    $("#chart_boxg").toggleClass("on");
			$.ajax({
				url :"<%=request.getContextPath() %>/ChartGender.do",
					type : 'get',
					success : function(res){

						  cgender =[];
						  ccount =[];
						  $.each(res, function(i,v){
							 cgender.push(v.gender)
							 ccount.push(v.count)
						  })
						  
						  
						    var context = document
					        .getElementById('myChartg')
					        .getContext('2d');
					  		var myChart = new Chart(context, {
					        type: 'pie', // 차트의 형태 line pie bar
					        
					        
					        data: { // 차트에 들어갈 데이터
					           /* labels: [
					              //x 축
					                '10대','20대','30대','40대','50대','60대','70대'
					            ], */
					            labels : cgender,
					            datasets: [
					                { //데이터
					                    label: '성별 고객수', //차트 제목
					                    fill: false, // line 형태일 때, 선 안쪽을 채우는지 안채우는지
//		 			                    data: [
//		 			                        100,19,25,20,23,26,25 //x축 label에 대응되는 데이터 값
//		 			                    ],
					                    data: ccount,
					                    backgroundColor: [
					                        //색상
					                        'rgba(255, 99, 132, 0.2)',
					                        'rgba(54, 162, 235, 0.2)',
					                        'rgba(255, 206, 86, 0.2)',
					                        'rgba(75, 192, 192, 0.2)',
					                        'rgba(153, 102, 255, 0.2)',
					                        'rgba(255, 159, 64, 0.2)'
					                    ],
					                    borderColor: [
					                        //경계선 색상
					                        'rgba(255, 99, 132, 1)',
					                        'rgba(54, 162, 235, 1)',
					                        'rgba(255, 206, 86, 1)',
					                        'rgba(75, 192, 192, 1)',
					                        'rgba(153, 102, 255, 1)',
					                        'rgba(255, 159, 64, 1)'
					                    ],
					                    borderWidth: 1 //경계선 굵기
					                }
					                
					                /* ,
					                {
					                    label: 'test2',
					                    fill: false,
					                    data: [
					                        8, 34, 12, 24
					                    ],
					                    backgroundColor: 'rgb(157, 109, 12)',
					                    borderColor: 'rgb(157, 109, 12)'
					                } */
					            ]
					        },
					        options: {
					            scales: {
					                yAxes: [
					                    {
					                        ticks: {
					                            beginAtZero: true
					                        }
					                    }
					                ]
					            }
					        }
					        
					    });
					},
					error : function(xhr){
						alert(xhr.status)
					},
					dataType : 'json'
				});
				
			});//gnder
			
		
		
	
	//나이별
	$('#age').on('click',function(){
		$("#chart_box").toggleClass("on");
		$.ajax({
			url :"<%=request.getContextPath() %>/ChartAge.do",
			type : 'get',
			success : function(res){

				  cage =[];
				  ccount =[];
				  $.each(res, function(i,v){
					 switch(v.age){
					 case 0 : 
					 case 1 : v.age=10; break;
					 case 2 : v.age=20; break;
					 case 3 : v.age=30; break;
					 case 4 : v.age=40; break;
					 case 5 : v.age=50; break;
					 case 6 : v.age=60; break;
					 case 7 : v.age=70; break;
					 case 8 : v.age=80; break;
					 case 9 : v.age=90; break;
					 }
					 cage.push(v.age)
					 ccount.push(v.count)
				  })
				    var context = document
			        .getElementById('myChart')
			        .getContext('2d');
			  		var myChart = new Chart(context, {
			        type: 'bar', // 차트의 형태 line pie bar
			        
			        
			        data: { // 차트에 들어갈 데이터
			           /* labels: [
			              //x 축
			                '10대','20대','30대','40대','50대','60대','70대'
			            ], */
			            labels : cage,
			            datasets: [
			                { //데이터
			                    label: '연령별 고객수', //차트 제목
			                    fill: false, // line 형태일 때, 선 안쪽을 채우는지 안채우는지
// 			                    data: [
// 			                        100,19,25,20,23,26,25 //x축 label에 대응되는 데이터 값
// 			                    ],
			                    data: ccount,
			                    backgroundColor: [
			                        //색상
			                        'rgba(255, 99, 132, 0.2)',
			                        'rgba(54, 162, 235, 0.2)',
			                        'rgba(255, 206, 86, 0.2)',
			                        'rgba(75, 192, 192, 0.2)',
			                        'rgba(153, 102, 255, 0.2)',
			                        'rgba(255, 159, 64, 0.2)'
			                    ],
			                    borderColor: [
			                        //경계선 색상
			                        'rgba(255, 99, 132, 1)',
			                        'rgba(54, 162, 235, 1)',
			                        'rgba(255, 206, 86, 1)',
			                        'rgba(75, 192, 192, 1)',
			                        'rgba(153, 102, 255, 1)',
			                        'rgba(255, 159, 64, 1)'
			                    ],
			                    borderWidth: 1 //경계선 굵기
			                }
			                
			                /* ,
			                {
			                    label: 'test2',
			                    fill: false,
			                    data: [
			                        8, 34, 12, 24
			                    ],
			                    backgroundColor: 'rgb(157, 109, 12)',
			                    borderColor: 'rgb(157, 109, 12)'
			                } */
			            ]
			        },
			        options: {
			            scales: {
			                yAxes: [
			                    {
			                        ticks: {
			                            beginAtZero: true
			                        }
			                    }
			                ]
			            }
			        }
			        
			    });
			},
			error : function(xhr){
				alert(xhr.status)
			},
			dataType : 'json'
		});
	});//age
	
	
	//캠프
	$('#camp').on('click',function(){
		$("#chart_boxc").toggleClass("on");
		$.ajax({
			url :"<%=request.getContextPath() %>/ChatCamp.do",
			type : 'get',
			success : function(res){
				ccode ="<table>"
					ccode +="<tr>"
						ccode +="<td>캠핑장 이름</td>";
						ccode +="<td>캠핑장 주소</td>";
						ccode +="<td>총 판매수익</td>";
					ccode +="</tr>";
					
				  cname = [];
				  camount =[];
				  $.each(res, function(i,v){
					cname.push(v.name);
					camount.push(v.amount)
					ccode += "<tr>"
						ccode +="<td>"+v.name+"</td>"
						ccode +="<td>"+v.addr+"</td>"
						ccode +="<td>"+v.amount+"</td>"
						ccode +="</tr>";
				  })
				  ccode += "</table>"
				  
				  $('#chart_text').html(ccode);
				  
				    var context = document
			        .getElementById('myChartc')
			        .getContext('2d');
			  		var myChart = new Chart(context, {
			        type: 'line', // 차트의 형태 line pie bar
			        
			        
			        data: { // 차트에 들어갈 데이터
			           /* labels: [
			              //x 축
			                '10대','20대','30대','40대','50대','60대','70대'
			            ], */
			            labels : cname,
			            datasets: [
			                { //데이터
			                    label: '캠핑장별 판매 수익', //차트 제목
			                    fill: true, // line 형태일 때, 선 안쪽을 채우는지 안채우는지
// 			                    data: [
// 			                        100,19,25,20,23,26,25 //x축 label에 대응되는 데이터 값
// 			                    ],
			                    data: camount,
			                    backgroundColor: [
			                        //색상
			                        'rgba(255, 99, 132, 0.2)',
			                        'rgba(54, 162, 235, 0.2)',
			                        'rgba(255, 206, 86, 0.2)',
			                        'rgba(75, 192, 192, 0.2)',
			                        'rgba(153, 102, 255, 0.2)',
			                        'rgba(255, 159, 64, 0.2)'
			                    ],
			                    borderColor: [
			                        //경계선 색상
			                        'rgba(255, 99, 132, 1)',
			                        'rgba(54, 162, 235, 1)',
			                        'rgba(255, 206, 86, 1)',
			                        'rgba(75, 192, 192, 1)',
			                        'rgba(153, 102, 255, 1)',
			                        'rgba(255, 159, 64, 1)'
			                    ],
			                    borderWidth: 1 //경계선 굵기
			                }
			                
			                /* ,
			                {
			                    label: 'test2',
			                    fill: false,
			                    data: [
			                        8, 34, 12, 24
			                    ],
			                    backgroundColor: 'rgb(157, 109, 12)',
			                    borderColor: 'rgb(157, 109, 12)'
			                } */
			            ]
			        },
			        options: {
			            scales: {
			                yAxes: [
			                    {
			                        ticks: {
			                            beginAtZero: true
			                        }
			                    }
			                ]
			            }
			        }
			        
			    });
			},
			error : function(xhr){
				alert(xhr.status)
			},
			dataType : 'json'
		
		});
		
	});//camp
	
})//ajax


</script>

<style>
#charts{
display: flex;
}
.chat_camp{ 
border : 3px solid red;
width : 33%;
margin: 50px auto;
}
.this_chart{
margin: auto;
}
/* 성별 */
#chart_boxg{
	display: none;
}
#chart_boxg.on{
	display: block;
}

/* 나이별 */
#chart_box{
	display: none;
}
#chart_box.on{
	display: block;
}

/* 캠프 */
#chart_boxc{
	display: none;
}
#chart_boxc.on{
	display: block;
	width: 80%;
}

ul{
display: flex;
height: 100px;
line-height: 100px;
}
li{
display: inline;
margin: 0px auto;
}
/* 버튼 */
.boutton_style{
display : inline-block;
border-radius: 10px;
width: 200px;
height: 40px;
}


/* 추가*/
	@font-face {
    font-family: 'TheJamsil5Bold';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2302_01@1.0/TheJamsil5Bold.woff2') format('woff2');
    font-weight: 700;
    font-style: normal;
	}
	
	table{
		border: 2px solid black;
	}
	tbody{
		border: 0px;
	}
	tr{
		border: 0px;
	}
	td{
		text-align: center;
		align-items: center;
		vertical-align: middle;
		padding: 3px;
		border: 2px solid red;
	}
	
	th{
		text-align: center;
		vertical-align: middle;
		padding: 3px;
		border: 2px solid black; 
	}
	
	#main icon{
	display: block;
    margin: auto;
    cursor: zoom-in;
    background-color: hsl(0, 0%, 90%);
    transition: background-color 300ms;
	}
	
	body{
	background-color: #f6f6f6;
	font-family: "TheJamsil5Bold";
	font-weight: 400;
	transform: rotate(0.03deg);
	margin:0;
	position: relative;	
	
	}
	
	hr {
    border: 2px solid #E44000;
    margin: 0 auto;
    color: inherit;
    opacity: .25;
	}
	
	
	
	#head_box{
		height: 30px;
	    float: none;
	    padding-top: 50px;
	    border: 0px;
	}
	#body{
		margin-top: 30px;
		border: 2px solid black;
	}
	#header, #nav_text, #nav_myinfo, #nav{
		border: 0px;
	}
	#nav_myinfo{
		width: 600px;
	}
	.tag{
		padding: 3px;	
	}
	.th{
		background: #f8cfbf;
	}
	#nav_myinfo{
		padding-top: 65px;
		padding-left: 100px;
	}
	#ul{
		padding-top: 65px;
	}
	#charts,chart_boxc{
		padding-top: 65px;
		
	}
</style>

</head>

<%MemberVO vo = (MemberVO)session.getAttribute("userinfo"); %>
<body>
<div id="main_contaner">
	<div id="header">
	    <header id="head_box" style="font-size: xx-large;">회원 통계<br><br><hr></header>
		<nav id="nav">
		    <div id="nav_myinfo">
		    <div>
			    <a href="#"><img id="user_img" src="<%=request.getContextPath()%>/imges/user.png" alt="사람"></a>
	       </div>
		    <div id="nav_text">
		        <div>관리자</div>
		        <div><%=vo.getMem_name() %></div>
		    </div>
			</div>
		</nav>
			<ul id="ul">
				<li><input type="button" value="연령별 회원수" id="age" class="boutton_style"></li>
				<li><input type="button" value="성별 회원수" id="gender" class="boutton_style"></li>
				<li><input type="button" value="캠핑장별 판매수익" id="camp" class="boutton_style"></li>
			</ul>
	</div>
	<hr> <br><br><br><br><br><hr>
	<div id="charts">
		<div  id="chart_box" class="chat_camp" >
		      <!--차트가 그려질 부분-->
		       <canvas id="myChart" class="this_chart"></canvas>
		</div>
		<div  id="chart_boxg" class="chat_camp">
		      <!--차트가 그려질 부분-->
		       <canvas id="myChartg" class="this_chart"></canvas>
		</div>
	</div>	
	<div id="chart_boxc" class="chat_camp">
	      <!--차트가 그려질 부분-->
	       <canvas id="myChartc" class="this_chart"></canvas>
			<div id="chart_text"></div>
	</div>
</div>
</body>
</html>