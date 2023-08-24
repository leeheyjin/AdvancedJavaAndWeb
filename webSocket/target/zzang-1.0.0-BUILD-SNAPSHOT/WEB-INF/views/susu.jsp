<%--
  Created by IntelliJ IDEA.
  User: leehyejin
  Date: 2023/08/23
  Time: 9:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>수수 restful 클라이언트</title>
</head>
<body>
<div id="disp"></div>
<hr>
<form action="">
    타이틀 <input type="text" name="title"><br>
    이름 <input type="text" name="sname"><br>
    내용 <textarea name="scont"></textarea><br>
    <button onclick="fsearch()" type="button">조회</button>
    <button onclick="fmodify()" type="button">수정</button>
    <button onclick="fdelete()" type="button">삭제</button>
    <button onclick="finsert()" type="button">입력</button>
</form>
<script>
    const myList = document.querySelector("#disp");
    const myTitle = document.querySelector("input[name=title]");
    const myName = document.querySelector("input[name=sname]");
    const myCont = document.querySelector("textarea[name=scont]");

    const getList = () => {
        let xhr = new XMLHttpRequest();
        xhr.open("get", "/rest/susus", true);
        xhr.onreadystatechange = function () {
            if (xhr.status == 200 && xhr.readyState == 4) {
                let result = JSON.parse(xhr.responseText);

                let tblStr = `<table border=1>`;
                tblStr += `<tr><th>타이틀</th><th>이름</th><th>내용</th></tr>`;
                for (let i = 0; i < result.length; i++) {
                    tblStr += `<tr onmouseover = fmover(this) onmouseout=fmout(this) onclick="fclick(this)">`;
                    tblStr += `<td>\${result[i].title}</td>`;
                    tblStr += `<td>\${result[i].sname}</td>`;
                    tblStr += `<td>\${result[i].scont}</td>`;
                    tblStr += `</tr>`;
                }
                tblStr += `</table>`;
                myList.innerHTML = tblStr;
            }
        }
        xhr.send();
    }

    function fmover(pthis) {
        pthis.style.backgroundColor = "black";
        pthis.style.color = "yellow";
    }

    function fmout(pthis) {
        pthis.style.backgroundColor = "white";
        pthis.style.color = "black";
    }

    function fclick(pthis) {
        myTitle.value = pthis.children[0].innerHTML;
        myName.value = pthis.children[1].innerHTML;
        myCont.value = pthis.children[2].innerHTML;
    }

    function fmodify() {
        let susuVO = {
            title: myTitle.value,
            sname: myName.value,
            scont: myCont.value
        }
        let xhr = new XMLHttpRequest();
        xhr.open("put", "/rest/susu", true);
        xhr.setRequestHeader("Content-Type", "application/json;charset=utf-8")
        xhr.onreadystatechange = function () {
            if (xhr.status == 200 && xhr.readyState == 4) {
                console.log(xhr.responseText);
                getList();
            }
        }
        xhr.send(JSON.stringify(susuVO));
    }

    function fdelete() {
        let xhr = new XMLHttpRequest();
        let delUrl = `/rest/susu/\${myTitle.value}`;
        xhr.open("delete", delUrl, true);
        xhr.onreadystatechange = function () {
            if (xhr.status == 200 && xhr.readyState == 4) {
                console.log(xhr.responseText);
                myTitle.value = "";
                myName.value = "";
                myCont.value = "";
                getList();
            }
        }
        xhr.send();
    }

    function fsearch() {
        let xhr = new XMLHttpRequest();
        let searchUrl = `/rest/susu/\${myTitle.value}`;
        xhr.open("get", searchUrl, true);
        xhr.onreadystatechange = function () {
            if (xhr.status == 200 && xhr.readyState == 4) {
                console.log(xhr.responseText);
                let susuVO = xhr.responseText;
                if (susuVO) {
                    susuVO = JSON.parse(susuVO);
                    myName.value = susuVO.sname;
                    myCont.value = susuVO.scont;
                } else {
                    myName.value = "";
                    myCont.value = "";
                    alert("찾는 타이틀이 없습니다");
                }
            }
        }
        xhr.send();
    }

    function finsert() {
        let susuVO = {
            title: myTitle.value,
            sname: myName.value,
            scont: myCont.value
        }
        let xhr = new XMLHttpRequest();
        xhr.open("post", "/rest/susu", true);
        xhr.setRequestHeader("Content-Type", "application/json;charset=utf-8");
        xhr.onreadystatechange = function () {
            if (xhr.status == 200 && xhr.readyState == 4) {
                if (xhr.responseText) {
                    getList();
                } else {
                    alert("정확한 값을 입력해주세요.");
                }
            }
        }
        xhr.send(JSON.stringify(susuVO));
    }

    getList();
</script>
</body>
</html>
