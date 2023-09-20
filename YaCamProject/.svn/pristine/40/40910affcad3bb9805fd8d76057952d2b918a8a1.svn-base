<%@page import="kr.or.ddit.questionboard.vo.QuestionVO"%>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="kr.or.ddit.notice.vo.NoticeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 서블릿에서 저장한 데이터 꺼내기
QuestionVO vo = (QuestionVO)request.getAttribute("selectNo");
MemberVO mvo = (MemberVO)session.getAttribute("userinfo");
//SimpleDateFormat 객체 생성
java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");

//날짜를 원하는 형식으로 변환하여 문자열로 저장
String formattedDate = vo.getQue_date();
String formattedDate2 = vo.getQue_redate();
%>
<!DOCTYPE html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>문의내용</title>
<link id="main icon" rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath()%>/Main_KKD/ICON/camping-favicon.ico">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
  <script src="<%=request.getContextPath() %>/js/jquery-3.7.0.min.js"></script>
  <script src="<%=request.getContextPath() %>/js/community.js"></script>
      <script>
      mypath = '<%= request.getContextPath()%>';
      var vidx = <%=vo.getQue_no()%>;
      var vreply;
      
      var mvo = {
    		  mem_id : '<%= mvo.getMem_id()%>',
    		  mem_grade : '<%=mvo.getMem_grade()%>'
      };
      
      $(function() {
    	  vreply = $('[name="reply"]');
    	  answerListServer(mvo);
    	  
    	  $(document).on('click', '[name="r_modify"]', function(){
    		  	vname = $(this).attr('name');
    		    vidx = $(this).attr('idx');
    		    console.log(vname, vidx);
    		    
    		    if(vname=="r_modify"){
    		    	if( $('#modiform').css('display') != "none") {
                		//열려있다
                		replyReset(); // 이미열려 있는 modiform을 body안으로 이동
    		    	}
    		    	
    		    	//vp3 = $(this).parents('.p12').next()
                	vp3 = $(this).parents('.reply-body').find('.p1');
    		    	
                	//원래 내용을 가져온다
                	rcont = $(vp3).html().trim(); // <br>태그가 포함
                	
                	//원래 내용에서 <br>태그를 \n으로 변경
                	cont = rcont.replace(/<br>/g, "\n");
                	
                	// \n으로 변경한 내용을 수정창에 출력
                	$('#modiform textarea').val(cont);
                	$(vp3).empty().append($('#modiform'));
                	
                	//$('#modiform').css('display', "block"); css방식 // ↓jquery방식
                	$('#modiform').show();
    		    	
    		    }
    	  })
    	  
    	  replyReset = function() {
            	  
            	  //현재 열려있는 modiform을 기준으로 p1을 찾는다
            	  p1 = $('#modiform').parent();
            	  
            	  //#modiform을 body로 이동
//             	  $('#modiform').appendTo($('body'))
            	  $('body').append($('#modiform'));
            	  
            	  //modiform을 안보이게 설정
            	  $('#modiform').hide();
    			  //$('#modiform').css('display', 'none');
    			  
    			  //원래내용을 p3으로 보이게 한다
    			  $(p1).html(rcont);
              }
    	  
    	//modiform - 댓글수정에서 취소버튼 클릭이벤트
          $('#modireset').on('click', function(){
        	  replyReset();
          })
          
          //modiform - 댓글수정에서 등록버튼 클릭이벤트
              $('#modisend').on('click', function(){
            	  
            	  //새롭게 입력한 값을 가져온다
            	  newcont = $('#modiform textarea').val(); //엔터기호 포함
            	  
            	  //엔터기호를 <br>태그로 변경
            	  cont = newcont.replace(/\n/g, "<br>");
            	  
            	  //p1을 찾는다 - modiform을 기준으로
            	  p1 = $('#modiform').parent();
            	  
            	  //modiform을 body로 이동 - 안보이게 설정
            	  $('#modiform').appendTo($('body'));
            	  $('#modiform').hide();
            	  
            	  //서버로 전송 db수정 - newcont, vidx
            	  reply = { };
            	  reply.ans_dtl = newcont;
            	  reply.ans_no = vidx;
            	  
            	  answerUpdateServer();
            	  
            	  //<br>로 변경한 새로 입력한 내용을 p3에 출력 - db수정 성공 후
            	  
              })
    	  
    	  $(document).on('click', '[name="r_delete"]', function() {
    		    vname = $(this).attr('name');
    		    vidx = $(this).attr('idx');
    		    console.log(vname, vidx);

    		    if (vname == "reply") {

    		      vreply = $(this);

    		      vtval = $(this).prev().val(); // 값 가져오기
    		      $(this).prev().val(""); // 입력한 값 초기화

    		      var mem_id = '<%=mvo.getMem_id()%>';

    		      // 저장데이터를 객체로 생성
    		      rdata = {};
    		      rdata.que_no = vidx;
    		      rdata.ans_dtl = vtval;
    		      rdata.mem_id = mem_id;

    		      // 서버로 전송
    		      answerListServer();
    		    } else if (vname == "r_delete") {

    		      vdelete = $(this);
    		      answerDeleteServer();
    		    }
    		  });
    	  
    	  $('#rebtn').on('click', function() {
    	    vname = $(this).attr('name');
    	    vidx = $(this).attr('idx');
    	    console.log(vname, vidx);

    	    if (vname == "reply") {

    	      vreply = $(this);

    	      vtval = $(this).prev().val(); // 값 가져오기
    	      $(this).prev().val(""); // 입력한 값 초기화

    	      var mem_id = '<%=mvo.getMem_id()%>';

    	      // 저장데이터를 객체로 생성
    	      rdata = {};
    	      rdata.que_no = vidx;
    	      rdata.ans_dtl = vtval;
    	      rdata.mem_id = mem_id;

    	      // 서버로 전송
    	      answerInsertServer();
    	    } else if (vname == "r_delete") {
    	      alert(vidx + "번 댓글을 삭제합니다.");

    	      vdelete = $(this);
    	      answerDeleteServer();
    	    }
    	  });
    	});
    	  
      </script>
<style>
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
html, body{
    min-width: 800px;
    min-height: 500px;
    font-family: "TheJamsil5Bold";
}
.nav {
    --bs-nav-link-padding-x: 1rem;
    --bs-nav-link-padding-y: 0.5rem;
    --bs-nav-link-font-weight: ;
	--bs-nav-link-color: #FF6529;
    --bs-nav-link-hover-color: #000;
    --bs-nav-link-disabled-color: #6c757d;
    display: flex;
    flex-wrap: wrap;
    padding-left: 0;
    margin-bottom: 0;
    list-style: none;
}
.navbar {
    --bs-navbar-padding-x: 0;
    --bs-navbar-padding-y: 0.5rem;
    --bs-navbar-color: rgba(0, 0, 0, 0.55);
    --bs-navbar-hover-color: rgba(0, 0, 0, 0.7);
    --bs-navbar-disabled-color: rgba(0, 0, 0, 0.3);
    --bs-navbar-active-color: rgba(0, 0, 0, 0.9);
    --bs-navbar-brand-padding-y: 0.3125rem;
    --bs-navbar-brand-margin-end: 1rem;
    --bs-navbar-brand-font-size: 1.25rem;
    --bs-navbar-brand-color: rgba(0, 0, 0, 0.9);
    --bs-navbar-brand-hover-color: rgba(0, 0, 0, 0.9);
    --bs-navbar-nav-link-padding-x: 0.5rem;
    --bs-navbar-toggler-padding-y: 0.25rem;
    --bs-navbar-toggler-padding-x: 0.75rem;
    --bs-navbar-toggler-font-size: 1.25rem;
    --bs-navbar-toggler-icon-bg: url(data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 30 30'%3e%3cpath stroke='rgba%280, 0, 0, 0.55%29' stroke-linecap='round' stroke-miterlimit='10' stroke-width='2' d='M4 7h22M4 15h22M4 23h22'/%3e%3c/svg%3e);
    --bs-navbar-toggler-border-color: rgba(0, 0, 0, 0.1);
    --bs-navbar-toggler-border-radius: 0.375rem;
    --bs-navbar-toggler-focus-width: 0.25rem;
    --bs-navbar-toggler-transition: box-shadow 0.15s ease-in-out;
    position: relative;
    display: flex;
    flex-wrap: wrap;
    align-items: center;
    justify-content: space-between;
    padding: var(--bs-navbar-padding-y) var(--bs-navbar-padding-x);
    font-size: 13px;
}
hr{
	border: 2px solid #F54500;
}
.pagination {
    --bs-pagination-padding-x: 0.75rem;
    --bs-pagination-padding-y: 0.375rem;
    --bs-pagination-font-size: 13px;
    --bs-pagination-color: #FF6529;
    --bs-pagination-bg: #fff;
    --bs-pagination-border-width: 1px;
    --bs-pagination-border-color: #dee2e6;
    --bs-pagination-border-radius: 0.375rem;
    --bs-pagination-hover-color: #FF6529;
    --bs-pagination-hover-bg: #e9ecef;
    --bs-pagination-hover-border-color: #dee2e6;
    --bs-pagination-focus-color: #FF6529;
    --bs-pagination-focus-bg: #e9ecef;
    --bs-pagination-focus-box-shadow: 0 0 0 0.25rem rgba(13, 110, 253, 0.25);
    --bs-pagination-active-color: #fff;
    --bs-pagination-active-bg: #FF6529;
    --bs-pagination-active-border-color: #FF6529;
    --bs-pagination-disabled-color: #6c757d;
    --bs-pagination-disabled-bg: #fff;
    --bs-pagination-disabled-border-color: #dee2e6;
    display: flex;
    padding-left: 0;
    list-style: none;
}
.nav-pills {
    --bs-nav-pills-border-radius: 0.375rem;
    --bs-nav-pills-link-active-color: #fff;
    --bs-nav-pills-link-active-bg: #FF6529;
}
.navbar>.container, .navbar>.container-lg, .navbar>.container-md, .navbar>.container-sm, .navbar>.container-xl, .navbar>.container-xxl {
    display: flex;
    flex-wrap: inherit;
    align-items: center;
    justify-content: space-between;
    color: #000;
    font-weight: bold;
    height: 10%;
}
h4 {
	text-align: center;
	font-size: 20px;
}
#result{
font-size: 13px;
}
.btn btn-dark {
	margin-left: auto; /* 왼쪽 여백을 자동으로 설정하여 오른쪽으로 보냅니다 */
}
#stype{
	margin-right: 2%;
	border: 1px solid #ced4da;
	border-radius: 0.375rem;
}
#search {
	display: flex;
}

.container-fluid {
	max-width: 380px; /* Adjust the width as needed */
	text-align: center;
}
.btn-dark {
    --bs-btn-color: #fff;
    --bs-btn-bg: #FF6529;
    --bs-btn-border-color: #FF5918;
    --bs-btn-hover-color: #fff;
    --bs-btn-hover-bg: #FF713A;
    --bs-btn-hover-border-color: #FF6529;
    --bs-btn-focus-shadow-rgb: 66,70,73;
    --bs-btn-active-color: #fff;
    --bs-btn-active-bg: #FF713A;
    --bs-btn-active-border-color: #FF5918;
    --bs-btn-active-shadow: inset 0 3px 5px rgba(0, 0, 0, 0.125);
    --bs-btn-disabled-color: #fff;
    --bs-btn-disabled-bg: #FF6529;
    --bs-btn-disabled-border-color: #FF5918;
}
.btn-light {
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
    html, body {
  height: 100%;
}

body {
  display: flex;
  flex-direction: column;
}

main {
  flex-grow: 1;
  position: relative;
}
footer {
  max-width: 100%; /* 가로폭을 조절할 값으로 변경하세요 */
  margin: 0 auto; /* 중앙 정렬을 위해 사용 */
}
.card-body {
  width: 900px; /* 너비 조정 */
  resize: vertical; /* 사용자가 수직으로 크기 조정할 수 있도록 함 */
}
textarea{
   width: 800px;
}
ul {
   padding: 0px;
}
li {
   list-style-type: none;
   display: inline;
}
.centered {
   text-align: center;
}
.dtlimg {
	width: 30%;
	height: 30%;
}
.card-body {
    width: 900px; /* 너비 조정 */
    resize: vertical; /* 사용자가 수직으로 크기 조정할 수 있도록 함 */
}
#modiform {
    display: none;
}
</style>

</head>
<body>

		<div id="modiform">
			<textarea rows="5" cols="10"></textarea>
			<input type="button" value="등록" id="modisend">
			<input type="button" value="취소" id="modireset">
		</div>
		
	<div class="container mt-3">
    <nav class="navbar navbar-light bg-light">
        <div class="container">
          <a class="backbtn" href="<%=request.getContextPath() %>/LHH/question/question.jsp">
            <img src="<%=request.getContextPath() %>/imges/btn_back.png" alt="" width="30" height="24">
          </a>
          <h4 class="text-center flex-grow-1">문의사항</h4>
        </div>
      </nav>
      </div>
<main>
      <div class="container mt-3">
       <div class="notice_con">
        <div class="notice_view">
          <p style="font-weight: bold;"><%=vo.getQue_ttl() %></p>
          <div class="notice_top">
            <ul>
              <li><%=formattedDate %></li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <li>유형 : <%=vo.getQue_typ() %></li>
            </ul>
             <div id="button">
             <%if(mvo.getMem_id().equals(vo.getMem_id()) || "관리자".equals(mvo.getMem_grade())){ %>
    <div class="div_button">
        <button class="btn btn-light" id="btnUpdate" onclick="window.location.href='<%=request.getContextPath()%>/questionUpdate.do?queNo=<%=vo.getQue_no()%>'">수정</button>
		<input class="btn btn-light" type="button" value="삭제" onclick="window.location.href='<%=request.getContextPath()%>/questionDelete.do?num=<%=vo.getQue_no()%>'">
    </div>
    <%} %>
</div>
          </div>
        </div>
      </div>
      <hr>
      <div class="notice_btom">
      <% if(vo.getQue_file() != null && !vo.getQue_file().isEmpty()) { %>
        <p class="centered"><img src="<%=request.getContextPath()%>/questionImageView.do?queNo=<%=vo.getQue_no()%>" class="dtlimg"></p>
      <% } %>
        <p class="centered"><%=vo.getQue_dtl() %></p>
      </div>
    </div>
    </main>
    
<footer>
    <section class="mb-1">
        <div class="card bg-light">
            <div class="card-body">
                <form class="mb-3"><textarea class="form-control" rows="3" placeholder="댓글을 입력해주세요."></textarea>
                <%if("관리자".equals(mvo.getMem_grade())){%>
                    <input type="button" class="action" name="reply" value="등록" id="rebtn" idx="<%=vo.getQue_no()%>">
                <%} else {%>
                 <input type="button" class="action" name="reply" value="등록" id="rebtn" idx="<%=vo.getQue_no()%>" disabled>
                 <%} %>
                    </form>
            </div>
        </div>
    </section>
</footer>
   

</body>
</html>