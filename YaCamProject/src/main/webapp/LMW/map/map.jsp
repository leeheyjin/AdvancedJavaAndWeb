<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
   <title>간단한 지도 표시하기</title>
    <script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=zi849v0byb"></script>
</head>
<body>
<div id="map" style="width:100%;height:1000px;"></div>


<script>
// var HOME_PATH = window.HOME_PATH || '.';

// var cityhall = new naver.maps.LatLng(36.324974, 127.408732),
//     map = new naver.maps.Map('map', {
//         center: cityhall.destinationPoint(0, 500),
//         zoom: 9
//     }),
//     marker = new naver.maps.Marker({
//         map: map,
//         position: cityhall
//     });


// var contentString = [
//         '<div class="iw_inner">',
//         '   <h3>대덕인재개발원</h3>',
//         '   <p>대덕대덕대덕 |<br />',
//         '       <img src="./imges/이현학.png" width="55" height="55" alt="이현학" class="thumb" /><br />',
//         '       402호 &gt; 교육생<br />',
//         '       <a href="http://www.naver.co.kr" target="_blank">www.naver.com/</a>',
//         '   </p>',
//         '</div>'
//     ].join('');

// var infowindow = new naver.maps.InfoWindow({
//     content: contentString
// });

// naver.maps.Event.addListener(marker, "click", function(e) {
//     if (infowindow.getMap()) {
//         infowindow.close();
//     } else {
//         infowindow.open(map, marker);
//     }
// });

// infowindow.open(map, marker);
var HOME_PATH = window.HOME_PATH || '.';


map = new naver.maps.Map('map', {
    center: new naver.maps.LatLng(36.324974, 127.408732),
    zoom: 8
})

// 동해 카라반 펜션                    경상남도 울산 울주군 온산읍 강양길 162
var don = new naver.maps.LatLng(35.3945, 129.3456);
// 베스트필드 글램핑장                 충청남도 공주시 반포면 동학사1로 65
var best = new naver.maps.LatLng(36.3648, 127.257);
// 제이하우스 펜션                     충청북도 청주시 상당구 미원면 쌍이운교로 285
var jhouse = new naver.maps.LatLng(36.6724, 127.6673);
// 화악산캠핑장                        경상남도 밀양시 부북면 대항길 321
var san = new naver.maps.LatLng(35.5539, 128.6784);
// 가평랜드 캠핑카라반                 경기도 가평군 조종면 대보간선로611번길 479 (마일리)
var gapeng = new naver.maps.LatLng(37.8265, 127.4064);
// 모짜르트 캠핑장                     경기도 양평군 단월면 윗고북길 33-21 (산음리)
var mozza = new naver.maps.LatLng(37.5877, 127.5876);
// 글램인스타                          강원도 정선군 고한읍 고한리 208
var glem = new naver.maps.LatLng(37.2191, 128.858);
// 제주올레캠핑장                      제주도 제주시 애월읍 평화로 2032-18 (소길리)
var jeju = new naver.maps.LatLng(33.4328, 126.378);
// 포시즌 애견전용 울타리캠핑장        전라북도 완주군 상당구 동상면 송광수만로 1079-12
var forsizzen = new naver.maps.LatLng(35.9299, 127.2689);
// 대덕인재 캠핑장                     대전 중구 계룡로 846
var ddit = new naver.maps.LatLng(36.324974, 127.408732);












var markers = [];
var infowindows = [];

// 동해 카라반 펜션                    경상남도 울산 울주군 온산읍 강양길 162
markers.push(new naver.maps.Marker({
    map: map,
    position: don
}));

infowindows.push(new naver.maps.InfoWindow({
    content: [
        '<div class="iw_inner">',
        '   <h3>동해 카라반 펜션</h3>',
        '   <p> 경상남도 울산 울주군 온산읍 강양길 162 |<br />',
        '       <img src="<%=request.getContextPath()%>/ksj/images/동해 카라반 펜션.jpg" width="200" height="200" alt="이현학" class="thumb" /><br />',
        '       <form action="<%=request.getContextPath()%>/CampZoneA001.do">', 
        '       <input type="hidden" value="A006" name="campno">',
        '       <input type="hidden" value="동해 카라반 펜션" name="campname">',
        '       <input type="submit" value="예약하기" class="button_style">',
        '       </form>',
        '   </p>',
        '</div>'
    ].join('')
}));

// 베스트필드 글램핑장                 충청남도 공주시 반포면 동학사1로 65
markers.push(new naver.maps.Marker({
    map: map,
    position: best
}));

infowindows.push(new naver.maps.InfoWindow({
    content: [
    '<div class="iw_inner">',
        '   <h3>베스트필드 글램핑장 </h3>',
        '   <p>충청남도 공주시 반포면 동학사1로 65 |<br />',
        '       <img src="<%=request.getContextPath()%>/ksj/images/동학사 베스트 필드 글램핑장.jpeg" width="200" height="200" alt="이현학" class="thumb" /><br />',
        '       <form action="<%=request.getContextPath()%>/CampZoneA001.do">', 
        '       <input type="hidden" value="A001" name="campno">',
        '       <input type="hidden" value="베스트필드 글램핑장" name="campname">',
        '       <input type="submit" value="예약하기" class="button_style">',
        '       </form>',        
        '   </p>',
        '</div>'
    ].join('')
}));

// 제이하우스 펜션                     충청북도 청주시 상당구 미원면 쌍이운교로 285
markers.push(new naver.maps.Marker({
    map: map,
    position: jhouse
}));

infowindows.push(new naver.maps.InfoWindow({
    content: [
    '<div class="iw_inner">',
        '   <h3>제이하우스 펜션  </h3>',
        '   <p>충청북도 청주시 상당구 미원면 쌍이운교로 285 |<br />',
        '       <img src="<%=request.getContextPath()%>/ksj/images/청주 제이펜션.jpeg" width="200" height="200" alt="이현학" class="thumb" /><br />',
        '       <form action="<%=request.getContextPath()%>/CampZoneA001.do">', 
        '       <input type="hidden" value="A002" name="campno">',
        '       <input type="hidden" value="제이하우스 펜션" name="campname">',
        '       <input type="submit" value="예약하기" class="button_style">',
        '       </form>',
        '   </p>',
        '</div>'
    ].join('')
}));
// 화악산캠핑장                        경상남도 밀양시 부북면 대항길 321
markers.push(new naver.maps.Marker({
    map: map,
    position: san
}));

infowindows.push(new naver.maps.InfoWindow({
    content: [
    '<div class="iw_inner">',
        '   <h3>화악산캠핑장</h3>',
        '   <p>경상남도 밀양시 부북면 대항길 321 |<br />',
        '       <img src="<%=request.getContextPath()%>/ksj/images/화악산캠핑장.jpg" width="200" height="200" alt="이현학" class="thumb" /><br />',
        '       <form action="<%=request.getContextPath()%>/CampZoneA001.do">', 
        '       <input type="hidden" value="A005" name="campno">',
        '       <input type="hidden" value="화악산캠핑장" name="campname">',
        '       <input type="submit" value="예약하기" class="button_style">',
        '       </form>',
        '   </p>',
        '</div>'
    ].join('')
}));
// 가평랜드 캠핑카라반                 경기도 가평군 조종면 대보간선로611번길 479 (마일리)
markers.push(new naver.maps.Marker({
    map: map,
    position: gapeng
}));

infowindows.push(new naver.maps.InfoWindow({
    content: [
    '<div class="iw_inner">',
        '   <h3>가평랜드 캠핑카라반 </h3>',
        '   <p>경기도 가평군 조종면 대보간선로611번길 479 (마일리) |<br />',
        '       <img src="<%=request.getContextPath()%>/ksj/images/가평랜드 캠핑장.jpg" width="200" height="200" alt="이현학" class="thumb" /><br />',
        '       <form action="<%=request.getContextPath()%>/CampZoneA001.do">', 
        '       <input type="hidden" value="A007" name="campno">',
        '       <input type="hidden" value="가평랜드 캠핑카라반" name="campname">',
        '       <input type="submit" value="예약하기" class="button_style">',
        '       </form>',
        '   </p>',
        '</div>'
    ].join('')
}));
// 모짜르트 캠핑장                     경기도 양평군 단월면 윗고북길 33-21 (산음리)
markers.push(new naver.maps.Marker({
    map: map,
    position: mozza
}));

infowindows.push(new naver.maps.InfoWindow({
    content: [
    '<div class="iw_inner">',
        '   <h3>모짜르트 캠핑장 </h3>',
        '   <p> 경기도 양평군 단월면 윗고북길 33-21 (산음리) |<br />',
        '       <img src="<%=request.getContextPath()%>/ksj/images/모짜르트 캠핑장.jpg" width="200" height="200" alt="이현학" class="thumb" /><br />',
        '       <form action="<%=request.getContextPath()%>/CampZoneA001.do">', 
        '       <input type="hidden" value="A008" name="campno">',
        '       <input type="hidden" value="모짜르트 캠핑장" name="campname">',
        '       <input type="submit" value="예약하기" class="button_style">',
        '       </form>',
        '   </p>',
        '</div>'
    ].join('')
}));
// 글램인스타                          강원도 정선군 고한읍 고한리 208
markers.push(new naver.maps.Marker({
    map: map,
    position: glem
}));

infowindows.push(new naver.maps.InfoWindow({
    content: [
    '<div class="iw_inner">',
        '   <h3>글램인스타  </h3>',
        '   <p>강원도 정선군 고한읍 고한리 208 |<br />',
        '       <img src="<%=request.getContextPath()%>/ksj/images/글램인스타.jpg" width="200" height="200" alt="이현학" class="thumb" /><br />',
        '       <form action="<%=request.getContextPath()%>/CampZoneA001.do">', 
        '       <input type="hidden" value="A009" name="campno">',
        '       <input type="hidden" value="글램인스타" name="campname">',
        '       <input type="submit" value="예약하기" class="button_style">',
        '       </form>',
        '   </p>',
        '</div>'
    ].join('')
}));
// 제주올레캠핑장                      제주도 제주시 애월읍 평화로 2032-18 (소길리)
markers.push(new naver.maps.Marker({
    map: map,
    position: jeju
}));

infowindows.push(new naver.maps.InfoWindow({
    content: [
    '<div class="iw_inner">',
        '   <h3>제주올레캠핑장</h3>',
        '   <p>제주도 제주시 애월읍 평화로 2032-18 (소길리) |<br />',
        '       <img src="<%=request.getContextPath()%>/ksj/images/제주올레캠핑장.jpg" width="200" height="200" alt="이현학" class="thumb" /><br />',
        '      <form action="<%=request.getContextPath()%>/CampZoneA001.do">', 
        '       <input type="hidden" value="A010" name="campno">',
        '       <input type="hidden" value="제주올레캠핑장" name="campname">',
        '       <input type="submit" value="예약하기" class="button_style">',
        '       </form>',
        '   </p>',
        '</div>'
    ].join('')
}));
// 포시즌 애견전용 울타리캠핑장        전라북도 완주군 상당구 동상면 송광수만로 1079-12
markers.push(new naver.maps.Marker({
    map: map,
    position: forsizzen
}));

infowindows.push(new naver.maps.InfoWindow({
    content: [
    '<div class="iw_inner">',
        '   <h3>포시즌 애견전용 울타리캠핑장  </h3>',
        '   <p>전라북도 완주군 상당구 동상면 송광수만로 1079-12 |<br />',
        '       <img src="<%=request.getContextPath()%>/ksj/images/포시즌 애견전용 울타리캠핑장.jpeg" width="200" height="200" alt="이현학" class="thumb" /><br />',
        '       <form action="<%=request.getContextPath()%>/CampZoneA001.do">', 
        '       <input type="hidden" value="A003" name="campno">',
        '       <input type="hidden" value="포시즌 애견전용 울타리캠핑장" name="campname">',
        '       <input type="submit" value="예약하기" class="button_style">',
        '       </form>',
        '   </p>',
        '</div>'
    ].join('')
}));
// 대덕인재 캠핑장                     대전 중구 계룡로 846
markers.push(new naver.maps.Marker({
    map: map,
    position: ddit
}));

infowindows.push(new naver.maps.InfoWindow({
    content: [
    '<div class="iw_inner">',
        '   <h3>대덕인재 캠핑장</h3>',
        '   <p> 대전 중구 계룡로 846 |<br />',
        '       <img src="<%=request.getContextPath()%>/ksj/images/대덕인재 캠핑장.jpg" width="200" height="200" alt="이현학" class="thumb" /><br />',
        '       <form action="<%=request.getContextPath()%>/CampZoneA001.do">', 
        '       <input type="hidden" value="A004" name="campno">',
        '       <input type="hidden" value="대덕인재 캠핑장" name="campname">',
        '       <input type="submit" value="예약하기" class="button_style">',
        '       </form>',
        '   </p>',
        '</div>'
    ].join('')
}));





for(let i=0; i<markers.length; i++){
    naver.maps.Event.addListener(markers[i], "click", function(e) {
        if (infowindows[i].getMap()) {
            infowindows[i].close();
        } else {
            infowindows[i].open(map, markers[i]);
        }
    });
}

infowindows[0].open(map, markers[0]);


</script>
</body>
</html>