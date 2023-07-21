<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    // data: BookVO vo

%>
<!DOCTYPE html>
<html>
<head>
    <title>책 상세</title>
    <script src="/resources/js/jquery.min.js"></script>
    <script src="/resources/ckeditor/ckeditor.js"></script>
</head>
<body>
<h1>책 상세</h1>
<form action="/create" method="post">
    <!-- 폼데이터 -->
    <input type="hidden" name="bookId" value="${vo.bookId}"/>
    <p>제목 : <input type="text" name="title" class="formData" value="${vo.title}" readonly/></p>
    <p>카테고리 : <input type="text" name="category" class="formData" value="${vo.category}" readonly/></p>
    <p>가격 : <input type="text" name="price" class="formData" maxLength="10" value=
            '<fmt:formatNumber value="${vo.price}" type="number" pattern="#,###"/>' readonly/></p>
    <p>설명: <textarea name="content" cols="5" rows="10" class="formData" readonly>${vo.content}</textarea></p>
    <%-- 일반모드 --%>
    <p id="p1">
        <input type="button" id="edit" value="수정"/>
        <input type="button" id="delete" value="삭제"/>
        <input type="button" id="list" value="목록"/>
    </p>
    <%-- 수정모드 --%>
    <p id="p2" style="display: none;">
        <input type="submit" value="확인" id="confirm"/>
        <input type="button" value="취소" id="cancel"/>
    </p>
</form>

<script>
    $(function () {
        // 수정 버튼 클릭 시 수정 모드로 전환
        $("#edit").on("click", function () {
            $("#p1").css("display", "none");
            $("#p2").css("display", "block")
            $(".formData").removeAttr("readonly");

            let objPrice = $("input[name='price']");
            let price = objPrice.val().replaceAll(",", "");
            objPrice.val(price);
            objPrice.attr("type", "number");

            CKEDITOR.replace("content");

            $("form").attr("action", "/updatePost");
        });

        $("#cancel").on("click", function () {
            location.href = "/detail?bookId=${param.bookId}";
        })

        $("#delete").on("click", function () {
            $("form").attr("action", "/deletePost");
            let result = confirm("삭제하시겠습니까?");
            if (result > 0) { // 삭제함
                $("form").submit();
            } else { // 삭제 안함
                alert("삭제가 취소되었습니다.");
            }
        });

    });
</script>
</body>
</html>