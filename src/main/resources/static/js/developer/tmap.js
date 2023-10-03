var lat = 35.1378295;
var lon = 126.903827;
const key = "k6XYZqE6ELXn6iKEBpTD5NnEvOR6rOw8Y1C8VPpa";
nowGps();

$(document).ready(function(){
initTmap()
//setTimeout(() => getRP(), 5000);

})

function nowGps(){
    navigator.geolocation.getCurrentPosition((position) => {
    lat = position.coords.latitude
    lon = position.coords.longitude
    });
}

var map;

	function initTmap(){
	if(map != null){map.destroy();}
		// map 생성
		// Tmapv3.Map을 이용하여, 지도가 들어갈 div, 넓이, 높이를 설정합니다.
		map = new Tmapv3.Map("map", { // 지도가 생성될 div
			center : new Tmapv3.LatLng(lat, lon),
			width : "100%",	// 지도의 넓이
			height : "400px",	// 지도의 높이
			zoom : 14	// 지도 줌레벨
		});
		var marker = new Tmapv3.Marker({
                			position: new Tmapv3.LatLng(lat, lon),	//Marker의 중심좌표 설정.
                			map: map	//Marker가 표시될 Map 설정..
                		});
			setMarker(map);
	}

function setMarker(map){

    var positions = setPosition();

    for(var i=0; i<positions.length; i++){
        var marker = new Tmapv3.Marker({
        			position: new Tmapv3.LatLng(positions[i].lat, positions[i].lon),	//Marker의 중심좌표 설정.
        			map: map	//Marker가 표시될 Map 설정..
        		});
    }


}

var markerList = [];
var pointArray = [];

function navigation(e_lat, e_lon){
    console.log(markerList)
    addMarker("llStart",lon,lat,1);
    	// 도착
    addMarker("llEnd",e_lon,e_lat,2);

    naviApi(lon,lat,e_lon,e_lat);
}

function naviApi(s_x, s_y, e_x,e_y){
    var startX = s_x;
	var startY = s_y;
	var endX = e_x;
	var endY = e_y;
	var passList = "";
	var prtcl;
    var headers = {};
    headers["appKey"]=key;
    	$.ajax({
    			method:"POST",
    			headers : headers,
    			url:"https://apis.openapi.sk.com/tmap/routes?version=1&format=json",//
    			async:false,
    			data:{
    				startX : startX,
    				startY : startY,
    				endX : endX,
    				endY : endY,
    				passList : passList,
    				reqCoordType : "WGS84GEO",
    				resCoordType : "WGS84GEO",
    				angle : "172",
    				searchOption : "0",
    				trafficInfo : "Y"
    			},
    			success:function(response){
    			prtcl = response;


    			},
    			error:function(request,status,error){
    			console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
    		}
    	});
}

function addMarker(status, lon, lat, tag) {
	//출도착경유구분
	//이미지 파일 변경.
	var markerLayer;
	switch (status) {
		case "llStart":
			imgURL = 'http://tmapapi.sktelecom.com/upload/tmap/marker/pin_r_m_s.png';
			break;
		case "llPass":
			imgURL = 'http://tmapapi.sktelecom.com/upload/tmap/marker/pin_b_m_p.png';
			break;
		case "llEnd":
			imgURL = 'http://tmapapi.sktelecom.com/upload/tmap/marker/pin_r_m_e.png';
			break;
		default:
	};
	var marker = new Tmapv3.Marker({
		position: new Tmapv3.LatLng(lat,lon),
		icon: imgURL,
		map: map
	});
	// 마커 드래그 설정
	marker.tag = tag;
	marker.addListener("dragend", function (evt) {
	markerListenerEvent(evt);
    });
    marker.addListener("drag", function (evt) {
    	markerObject = markerList[tag];
    });
    markerList[tag] = marker;
	return marker;
}

/*var s_latlng;
var e_latlng;
	function getRP(e_lat, e_lon) {
		s_latlng = new Tmapv3.LatLng (lat, lon);
		e_latlng = new Tmapv3.LatLng (e_lat, e_lon);
        console.log(s_latlng)
        console.log(s_latlng._lat)
		var optionObj = {
			reqCoordType:"WGS84GEO", //요청 좌표계 옵셥 설정입니다.
			resCoordType:"WGS84GEO",  //응답 좌표계 옵셥 설정입니다.
			trafficInfo:"Y"
		};

		var params = {
			onComplete:onComplete,
			onProgress:onProgress,
			onError:onError
		};

		// TData 객체 생성
		var tData = new Tmapv3.extension.TData();

		// TData 객체의 경로요청 함수
		tData.getRoutePlanJson(s_latlng, e_latlng, optionObj, params);
	}

	function onComplete() {
    		console.log(this._responseData); //json으로 데이터를 받은 정보들을 콘솔창에서 확인할 수 있습니다.

    		var jsonObject = new Tmapv3.extension.GeoJSON();
    		var jsonForm = jsonObject.rpTrafficRead(this._responseData);

    		//교통정보 표출시 생성되는 LineColor 입니다.
            var trafficColors = {

                // 사용자가 임의로 색상을 설정할 수 있습니다.
                // 교통정보 옵션 - 라인색상
                trafficDefaultColor:"#000000", //교통 정보가 없을 때
                trafficType1Color:"#009900", //원할
                trafficType2Color:"#7A8E0A", //서행
                trafficType3Color:"#8E8111",  //정체
                trafficType4Color:"#FF0000"  //정체
            };
            jsonObject.drawRouteByTraffic(map, jsonForm, trafficColors);
            var center_lat = (s_latlng._lat+e_latlng._lat)/2;
            var center_lon = (s_latlng._lng+e_latlng._lng)/2;
            console.log(center_lat)
            console.log(center_lon)
    		map.setCenter(new Tmapv3.LatLng(center_lat, center_lon));
    		map.setZoom(10);
    	}

    	//데이터 로드중 실행하는 함수입니다.
    	function onProgress(){

    	}

    	//데이터 로드 중 에러가 발생시 실행하는 함수입니다.
    	function onError(){
    		alert("onError");
    	}*/


	function setPosition(){
            var positions = [];
                    positions.push({
                    'title' : '우리집',
                    'lat' : 35.1378295,
                    'lon' : 126.903827,
                    'content' : '<div class ="label"><span class="left"></span><span class="center">우리집</span><span class="right"></span></div>'
                    })
                    positions.push({
                    'title' : '회사',
                    'lat' : 35.1342741,
                    'lon' : 126.9081547,
                    'content' : '<div class ="label"><span class="left"></span><span class="center">회사</span><span class="right"></span></div>'
                    })
            return positions;
    }
