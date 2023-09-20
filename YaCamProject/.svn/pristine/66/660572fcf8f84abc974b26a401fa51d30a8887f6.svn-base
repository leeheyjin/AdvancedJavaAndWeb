<%@page import="java.text.SimpleDateFormat"%>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="kr.or.ddit.community.vo.CommunityVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//서블릿에서 저장한 데이터 꺼내기
CommunityVO vo = (CommunityVO)request.getAttribute("selectNo");
MemberVO mvo = (MemberVO)session.getAttribute("userinfo");

SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
String formattedDate = dateFormat.format(vo.getComm_date());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>게시판 내용</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
  <script src="<%=request.getContextPath() %>/js/jquery-3.7.0.min.js"></script>
  <script src="<%=request.getContextPath() %>/js/community.js"></script>
  
  <script>
  mypath = '<%= request.getContextPath()%>';
  var vidx = <%=vo.getComm_no()%>;
  var vreply;
  var mvo = {
		  mem_id : '<%= mvo.getMem_id()%>',
		  mem_grade : '<%=mvo.getMem_grade()%>',
  };
  
  $(function() {
	  vreply = $('[name="reply"]');
	  replyListServer(mvo);
	  
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
//         	  $('#modiform').appendTo($('body'))
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
        	  reply.mt_dtl = newcont;
        	  reply.mt_no = vidx;
        	  
        	  replyUpdateServer();
        	  
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
		      rdata.comm_no = vidx;
		      rdata.mt_dtl = vtval;
		      rdata.mem_id = mem_id;

		      // 서버로 전송
		      replyInsertServer();
		    } else if (vname == "r_delete") {

		      vdelete = $(this);
		      replyDeleteServer();
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
	      rdata.comm_no = vidx;
	      rdata.mt_dtl = vtval;
	      rdata.mem_id = mem_id;

	      // 서버로 전송
	      replyInsertServer();
	    } else if (vname == "r_delete") {
	      alert(vidx + "번 댓글을 삭제합니다.");

	      vdelete = $(this);
	      replyDeleteServer();
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
    min-width: 1500px;
	min-height: 937px;    
    font-family: "TheJamsil5Bold";
    font-weight: 400;
	transform: rotate(0.03deg);
	margin:0;
	position: relative;	
}
 .bg-primary {
    --bs-bg-opacity: 1;
    background-color: #fff !important;
}
.h3, h3 {
    font-size: 1.75rem;
    color: #FF5918;
}
button, input, optgroup, select, textarea {
    margin: 0;
    font-family: inherit;
    font-size: inherit;
    line-height: inherit;    
}

button: hover{
	color: #FF6529;
	background-color: #d3d4d5;
	border-color: #FF4D07;
}
button div{
	font-family: "TheJamsil5Bold";
	font-weight: bold;
	transform: rotate(0.03deg);
	margin:0;
	font-size: 13px;
}

#card-bodys {
    width: 900px;
    resize: vertical;
    border: 2px solid #FF5918;
}
hr {
    border: 3px solid #FF6529;
    margin: 0 auto;
    color: inherit;
    opacity: .25;
    width: 100%;
}
#img {
    margin-top: 23px;
    margin-left: -1437px;
    margin-bottom: -33px;
}
#form_box{
display: inline;
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

#button{
    width: 100%;
}
 .div_button{ 
      position: absolute;  
      right: 500px;
      bottom: -20px;
}
.div_button #report {
	right : 300px;
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
        
    #modiform {
    	display: none;
    }
    .centered {
            text-align: center;
        }
  </style>
</head>
<body>

		<div id="modiform">
			<textarea rows="5" cols="10"></textarea>
			<input type="button" value="등록" id="modisend">
			<input type="button" value="취소" id="modireset">
			
		</div>
		
    <header>
        <div class="container-fluid p-2 bg-primary text-white text-center">
         <a class="navbar-brand" href="<%=request.getContextPath()%>/LHH/board.jsp">
            <img id="img" src="<%=request.getContextPath()%>/imges/btn_back.png" alt="" width="30" height="24">
         </a>
          <h3><%=vo.getComm_type() %></h3>
        </div>
      </header>
	  <hr>
      <br>
<main>
<div class="container">
    <div class="container mt-3">
        <div style="border: 2px solid #FF5918; border-radius: 10px;">
            <div class="row">
                <div class="col-md-2">
                    <div class="card" style="width:90px">
                        <img class="card-img-top" src="./imges/guest.png" alt="Card image" style="width:95%;">
                        <div class="card-body" style="height: 30px;">
                        </div>
                        <p style="text-align: center;"><%=vo.getMem_id() %></p>
                    </div>
                </div>
                <div class="col-md-9">
                    <div class="p12">
                        <p class="p1">
                            <h6 style="font-weight: bold;"><%=vo.getComm_type() %></h6>
                            <br>
                            <span class="hit"><%=vo.getComm_ttl() %></span> &nbsp;&nbsp;&nbsp;&nbsp;
                            조회수 : <span class="hit"><%=vo.getComm_hits() %></span> &nbsp;&nbsp;&nbsp;&nbsp;
                            작성일 : <span class="da"><%=formattedDate %></span>
                        </p>
                      </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container mt-4">
	<% if(vo.getComm_file() != null && !vo.getComm_file().isEmpty()) {%>
	<p class="centered"><img src="<%=request.getContextPath()%>/imageView.do?commNo=<%=vo.getComm_no()%>" style="width: 50%;"></p>
	<% } %>
    <p class="centered"><%=vo.getComm_dtl() %></p>
</div>

<div id="button">
    <div class="div_button">

		<form action="<%=request.getContextPath() %>/LHH/report/report.jsp" target="_blank" id="form_box">
			<button type="submit" class="btn btn-light report" value="신고"><div>신고</div></button>
			<input type="hidden" name="comm_no" value="<%=vo.getComm_no() %>"> <!-- comm_no 전송 -->
	    	<input type="hidden" name="mem_id" value="<%=vo.getMem_id() %>"> <!-- 작성자 mem_id 전송 -->
		</form>
		
        <button class="btn btn-light" onclick="window.location.href='<%=request.getContextPath()%>/LHH/board.jsp'"><div>글목록</div></button>
		<%if(mvo.getMem_id().equals(vo.getMem_id()) || "관리자".equals(mvo.getMem_grade())){ %>
        <button class="btn btn-light" id="btnUpdate" onclick="window.location.href='<%=request.getContextPath()%>/boardUpdate.do?commNo=<%=vo.getComm_no()%>'"><div>글수정</div></button>
		<button class="btn btn-light" type="button" onclick="window.location.href='<%=request.getContextPath()%>/boardDelete.do?num=<%=vo.getComm_no()%>'"><div>글삭제</div></button>
		<%} %>
    </div>
</div>
</main>
<br>

<footer>
    <section class="mb-1">
        <div class="card bg-light">
            <div id="card-bodys" class="card-body">
                <form class="mb-3"><textarea class="form-control" rows="3" placeholder="댓글을 입력해주세요."></textarea>
                    <button type="button" class="action" name="reply" id="rebtn" idx="<%=vo.getComm_no() %>"><div>등록</div></button>
                    </form>
            </div>
        </div>
    </section>
</footer>

</body>
</html>