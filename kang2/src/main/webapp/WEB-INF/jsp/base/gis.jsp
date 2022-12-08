<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<div id="map" style="width:500px;height:500px; display:flex;"></div>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4149bafdb9a5a5f288ffa60a0dbfbd37&libraries=services,clusterer,drawing"></script>
<script>
var infowindow = new kakao.maps.InfoWindow({zIndex:1});

var mapContainer = document.getElementById('map'), // ������ ǥ���� div 
    mapOption = {
        center: new kakao.maps.LatLng(37.566826, 126.9786567), // ������ �߽���ǥ
        level: 3 // ������ Ȯ�� ����
    };  

// ������ �����մϴ�    
var map = new kakao.maps.Map(mapContainer, mapOption); 

var clusterer = new kakao.maps.MarkerClusterer({
    map: map, // ��Ŀ���� Ŭ�����ͷ� �����ϰ� ǥ���� ���� ��ü
    averageCenter: true, // Ŭ�����Ϳ� ���Ե� ��Ŀ���� ��� ��ġ�� Ŭ������ ��Ŀ ��ġ�� ����
    minLevel: 6 // Ŭ������ �� �ּ� ���� ����
  });

//��� �˻� ��ü�� �����մϴ�
var ps = new kakao.maps.services.Places(); 

var mapTypeControl = new kakao.maps.MapTypeControl();

// ������ ��Ʈ���� �߰��ؾ� �������� ǥ�õ˴ϴ�
// kakao.maps.ControlPosition�� ��Ʈ���� ǥ�õ� ��ġ�� �����ϴµ� TOPRIGHT�� ������ ���� �ǹ��մϴ�
map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

// ���� Ȯ�� ��Ҹ� ������ �� �ִ�  �� ��Ʈ���� �����մϴ�
var zoomControl = new kakao.maps.ZoomControl();
map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

function placesearch(){
ps.keywordSearch($("#search").val(), placesSearchCB); 
}
//Ű���� �˻� �Ϸ� �� ȣ��Ǵ� �ݹ��Լ� �Դϴ�
var markers = [];

function placesSearchCB (data, status, pagination) {
 if (status === kakao.maps.services.Status.OK) {

     // �˻��� ��� ��ġ�� �������� ���� ������ �缳���ϱ�����
     // LatLngBounds ��ü�� ��ǥ�� �߰��մϴ�
     var bounds = new kakao.maps.LatLngBounds();

     for (var i=0; i<data.length; i++) {
    	 var cluster = displayMarker(data[i]);
         bounds.extend(new kakao.maps.LatLng(data[i].y, data[i].x));
         markers.push(cluster);
     }       

     // �˻��� ��� ��ġ�� �������� ���� ������ �缳���մϴ�
     map.setBounds(bounds);
     clusterer.addMarkers(markers);
 } 
}
function displayMarker(place) {
    
    // ��Ŀ�� �����ϰ� ������ ǥ���մϴ�
    var marker = new kakao.maps.Marker({
        map: map,
        position: new kakao.maps.LatLng(place.y, place.x) 
    });

    // ��Ŀ�� Ŭ���̺�Ʈ�� ����մϴ�
    kakao.maps.event.addListener(marker, 'click', function() {
        // ��Ŀ�� Ŭ���ϸ� ��Ҹ��� ���������쿡 ǥ��˴ϴ�
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
	<input type="text" id="search" value="���¿�"/>
	<button onclick="placesearch()">�˻�</button>
</div>