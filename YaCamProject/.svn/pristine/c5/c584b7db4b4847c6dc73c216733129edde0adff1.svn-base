<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
// comm_no와 mem_id를 가져옴
int comm_no = Integer.parseInt(request.getParameter("comm_no"));
String mem_id = request.getParameter("mem_id");
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" charset="utf-8">
<title>야!!!캠핑가자~</title>
<link id="main icon" rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath()%>/Main_KKD/ICON/camping-favicon.ico">
<link rel="stylesheet" href="../css/mystyle.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="../../js/jquery-3.7.0.min.js"></script>
<script src="../../js/jquery.serializejson.min.js"></script>
<script src="../../js/community.js"></script>
  


  <style>
    .test {
      border-radius: 10px;
    }

    .btn-group {
      display: flex;
      justify-content: center;
    }

    .btn-group .btn {
      flex-grow: 1;
    }
  </style>
</head>
<body>
  <div id="t1">
    <div class="container mt-3">
      <nav class="navbar navbar-light bg-danger test">
        <div class="container">
          <h4 class="text-center flex-grow-1" style="color: white; padding-top: 10px; padding-right: 40px;">
            <img src="../../imges/siren.png" style="width: 30px;">&nbsp;
            신고
        </h4>
        </div>
      </nav>
    </div>
  </div>
<div class="container mt-3">
  <form action="<%=request.getContextPath()%>/reportInsert.do" class="test2" method="post">
  <input type="hidden" name="comm_no" value= "<%= comm_no %>">
  <input type="hidden" name="mem_id" value="<%= mem_id %>">
    <div class="form-check">
      <input type="radio" class="form-check-input" id="radio1" name="optradio" value="스팸 / 불법사이트 홍보 / 도배행위" checked>
      <label class="form-check-label" for="radio1">스팸 / 불법사이트 홍보 / 도배행위</label>
    </div>
    <div class="form-check">
      <input type="radio" class="form-check-input" id="radio2" name="optradio" value="음란물 / 청소년 유해">
      <label class="form-check-label" for="radio2">음란물 / 청소년 유해</label>
    </div>
    <div class="form-check">
      <input type="radio" class="form-check-input" id="radio3" name="optradio" value="욕설 / 차별 / 혐오발언">
      <label class="form-check-label" for="radio3">욕설 / 차별 / 혐오발언</label>
    </div>
    <div class="form-check">
      <input type="radio" class="form-check-input" id="radio4" name="optradio" value="명예훼손 또는 저작권 침해">
      <label class="form-check-label" for="radio4">명예훼손 또는 저작권 침해</label>
    </div>
    <div class="form-check">
      <input type="radio" class="form-check-input" id="radio5" name="optradio" value="기타">
      <label class="form-check-label" for="radio5">기타</label>
    </div>
    <div class="mb-3 mt-3">
      <textarea class="form-control" rows="5" id="comment" name="text" placeholder="신고내용"></textarea>
    </div>
    <div class="btn-group">
      <button type="submit" class="btn btn-danger" id="btn">등록</button>
      &nbsp;&nbsp;&nbsp;&nbsp;
      <button type="reset" class="btn btn-danger" onclick="window.close();">취소</button>
    </div>
  </form>
</div>

</body>
  <script>
  $('#btn').on('click', function(){
  alert("신고등록 완료");
  })
  </script>
</html>
