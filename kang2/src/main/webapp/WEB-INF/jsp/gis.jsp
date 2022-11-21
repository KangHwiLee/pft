<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="resources/css/main.css" />
	<script src="resources/js/jquery-3.6.0.min.js" ></script>
	<script src="resources/js/common.js" ></script>
</head>
<body>
	<div class="wrap">
		<div class="left">
			
		</div>
<div id="map" style="width:1000px;height:800px;" style="display:flex;"></div>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4149bafdb9a5a5f288ffa60a0dbfbd37&libraries=services,clusterer,drawing"></script>
<script>
var infowindow = new kakao.maps.InfoWindow({zIndex:1});

var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 

var clusterer = new kakao.maps.MarkerClusterer({
    map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체
    averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정
    minLevel: 6 // 클러스터 할 최소 지도 레벨
  });

//장소 검색 객체를 생성합니다
var ps = new kakao.maps.services.Places(); 

var mapTypeControl = new kakao.maps.MapTypeControl();

// 지도에 컨트롤을 추가해야 지도위에 표시됩니다
// kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

// 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
var zoomControl = new kakao.maps.ZoomControl();
map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

function placesearch(){
ps.keywordSearch($("#search").val(), placesSearchCB); 
}
//키워드 검색 완료 시 호출되는 콜백함수 입니다
var markers = [];

function placesSearchCB (data, status, pagination) {
 if (status === kakao.maps.services.Status.OK) {

     // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
     // LatLngBounds 객체에 좌표를 추가합니다
     var bounds = new kakao.maps.LatLngBounds();

     for (var i=0; i<data.length; i++) {
    	 var cluster = displayMarker(data[i]);
         bounds.extend(new kakao.maps.LatLng(data[i].y, data[i].x));
         markers.push(cluster);
     }       

     // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
     map.setBounds(bounds);
     clusterer.addMarkers(markers);
 } 
}
function displayMarker(place) {
    
    // 마커를 생성하고 지도에 표시합니다
    var marker = new kakao.maps.Marker({
        map: map,
        position: new kakao.maps.LatLng(place.y, place.x) 
    });

    // 마커에 클릭이벤트를 등록합니다
    kakao.maps.event.addListener(marker, 'click', function() {
        // 마커를 클릭하면 장소명이 인포윈도우에 표출됩니다
        infowindow.setContent('<div style="padding:5px;font-size:12px;">' + place.place_name + '</div>');
        infowindow.open(map, marker);
    });
    return marker;
}
</script>
<div>
	<select>
		<option>test</option>
		<option>test</option>
		<option>test</option>
		<option>test</option>
	</select>
	<br>
	<input type="text" id="search" value="이태원"/>
	<button onclick="placesearch()">검색</button>
</div>
</div>
</body>
</html>