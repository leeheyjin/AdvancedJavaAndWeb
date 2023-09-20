<%@page import="kr.or.ddit.questionboard.vo.QuestionVO"%>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" charset="utf-8">
<title>야!!!캠핑가자~</title>
	<link id="main icon" rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath()%>/Main_KKD/ICON/camping-favicon.ico">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
  <script>
  
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
    min-height: 1500px;
    text-align: center;
    font-family: "TheJamsil5Bold";
}
.bg-primary {
    --bs-bg-opacity: 1;
    background-color: #FF6529 !important;
}
.text-white {
    --bs-text-opacity: 1;
    color: #fff !important;
}
.text-center {
    text-align: center!important;
}
.p-2 {
    padding: 0.5rem!important;
}
.h5, h5 {
    font-size: 20px;
}
.btn-secondary {
    --bs-btn-color: #FF5918 !important;
    --bs-btn-bg: #fff !important;
    --bs-btn-border-color: #fff !important;
    --bs-btn-hover-color: #FF5918 !important;
    --bs-btn-hover-bg: #DDD !important;
    --bs-btn-hover-border-color: #fff !important;
    --bs-btn-focus-shadow-rgb: 49,132,253 !important;
    --bs-btn-active-color: #fff !important;
    --bs-btn-active-bg: #fff !important;
    --bs-btn-active-border-color: #fff !important;
    --bs-btn-active-shadow: inset 0 3px 5px rgba(0, 0, 0, 0.125) !important;
    --bs-btn-disabled-color: #fff !important;
    --bs-btn-disabled-bg: #fff !important;
    --bs-btn-disabled-border-color: #fff !important;
}
.form-select {
    display: block;
    width: 100%;
    padding: 0.375rem 2.25rem 0.375rem 0.75rem;
    -moz-padding-start: calc(0.75rem - 3px);
    font-size: 1rem;
    font-weight: 400;
    line-height: 1.5;
    color: #212529;
    background-color: #fff;
    background-image: url(data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 16 16'%3e%3cpath fill='none' stroke='%23343a40' stroke-linecap='round' stroke-linejoin='round' stroke-width='2' d='m2 5 6 6 6-6'/%3e%3c/svg%3e);
    background-repeat: no-repeat;
    background-position: right 0.75rem center;
    background-size: 16px 12px;
    border: 1px solid #FF6529;
    border-radius: 0.375rem;
    transition: border-color .15s ease-in-out,box-shadow .15s ease-in-out;
    -webkit-appearance: none;
    -moz-appearance: none;
    appearance: none;
}
#subject,#content,#file{
	border: 1px solid #FF6529;
}
hr{
	border: 3px solid #FF6529;
}
.navbar-brand {
    padding-top: var(--bs-navbar-brand-padding-y);
    padding-bottom: var(--bs-navbar-brand-padding-y);
    margin-right: var(--bs-navbar-brand-margin-end);
    font-size: var(--bs-navbar-brand-font-size);
    color: var(--bs-navbar-brand-color);
    text-decoration: none;
    white-space: nowrap;
    align-items: center;
	justify-content: space-between;
	display: flex;
	flex-wrap: inherit;
	height: 0px;
}
#imges{
	margin-left: -92%;
	margin-bottom: -80px;
}
#send {
    margin-left: 595px;
}
</style> 
</head>
<body>
<%
	QuestionVO vo = (QuestionVO)request.getAttribute("QueVo");
%>
        <div class="container mt-3">
        <a class="backbtn" href="<%=request.getContextPath() %>/LHH/question/question.jsp">
            <img id="imges" src="<%=request.getContextPath() %>/imges/btn_back.png" alt="" width="30" height="24">
          </a>
            <h3 style="text-align: center;"><img src="./imges/promotion.png" style="width: 50px;">&nbsp;문의사항 수정</h3>
            <form method="post" enctype="multipart/form-data" action="<%=request.getContextPath()%>/questionUpdate.do">
              <input type="hidden" name="que_no" value="<%=vo.getQue_no()%>">
              <div class="mb-3 mt-2" id="datesel">
                <label for="sel1" class="form-label">문의유형</label>
                <select class="form-select" id="sel1" name="type">
                  <option>예약관련</option>
                  <option>기타문의</option>
                </select>
              </div>
              <div class="mb-3">
                <label for="subject">제목</label>
                <input type="text" class="form-control" id="subject" placeholder="제목을 입력해주세요" name="ttl" value="<%=vo.getQue_ttl()%>">
              </div>
                <div class="mb-3 mt-3">
                  <label for="comment">내용</label>
                  <textarea class="form-control" rows="5" id="content" name="dtl" placeholder="내용을 입력해주세요"><%=vo.getQue_dtl()%></textarea>
                </div>
              <div class="mb-3">
                <label for="file">첨부파일</label>
                <input type="file" class="form-control" id="file" name="file">
              </div>
                <button id="send" type="submit" class="btn btn-secondary">등록</button>
                <button type="reset" class="btn btn-secondary" onclick="location.href='<%=request.getContextPath()%>/questionInfo.do?num=<%=vo.getQue_no()%>'">취소</button>
              </form>
            </div>

</body>
</html>