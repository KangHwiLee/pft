var header = $("meta[name='_csrf_header']").attr('content');
var token = $("meta[name='_csrf']").attr('content');
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

function addMarker(lati, longi){
    var marker = new Tmapv3.Marker({
        			position: new Tmapv3.LatLng(lati, longi),	//Marker의 중심좌표 설정.
        			map: map	//Marker가 표시될 Map 설정..
        		});
}

function setMarker(map){

    //var positions = setPosition();

    var positions = [];
                $.ajax({
                    url : "/field_list",
                    type : "post",
                    async : false,
                    beforeSend: function(xhr){
                                            xhr.setRequestHeader(header, token);
                                        },
                    success : function(data){
                        data.forEach((a) => {
                            positions.push({
                                          'title' : a.field_name,
                                          'lat' : a.field_lat,
                                          'lon' : a.field_lon,
                                          'content' : '<div class ="label"><span class="left"></span><span class="center">'+a.field_name+'</span><span class="right"></span></div>'
                                          })
                        })
                    }
                    })

    for(var i=0; i<positions.length; i++){
        var marker = new Tmapv3.Marker({
        			position: new Tmapv3.LatLng(positions[i].lat, positions[i].lon),	//Marker의 중심좌표 설정.
        			map: map	//Marker가 표시될 Map 설정..
        		});
    }


}

var s_latlng;
var e_latlng;
	function getRP(e_lat, e_lon) {
		s_latlng = new Tmapv3.LatLng (lat, lon);
		e_latlng = new Tmapv3.LatLng (e_lat, e_lon);
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
	var t_distance = 0;
    var t_time = 0;
    		console.log(this._responseData); //json으로 데이터를 받은 정보들을 콘솔창에서 확인할 수 있습니다.
            for(var i=0; i<this._responseData.features.length; i++){
            if(this._responseData.features[i].properties.distance != null){
                t_distance += this._responseData.features[i].properties.distance
                }
            if(this._responseData.features[i].properties.time != null){
                t_time += this._responseData.features[i].properties.time}
            }
            var t_s_distance = t_distance.toString().substring(0,t_distance.toString().length-3)+"."+t_distance.toString().substring(t_distance.toString().length-3)
            var h_time = Math.floor(t_time/3600);
            var m_time = Math.floor(t_time%3600/60);
            var s_time = t_time%60;
            view = "<p>거리 : "+t_s_distance+"km</p>"
            view += "<p>예상 시간 : "+h_time+"시간 "+m_time+"분</p>"
            $("#naviInfo").html(view)
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
            console.log(map)
            console.log(jsonForm)
            console.log(trafficColors)
            jsonObject.drawRouteByTraffic(map, jsonForm, trafficColors);
            var center_lat = (s_latlng._lat+e_latlng._lat)/2;
            var center_lon = (s_latlng._lng+e_latlng._lng)/2;
    		map.setCenter(new Tmapv3.LatLng(center_lat, center_lon));
    		//map.setZoom(distanceToLevel(t_distance));

    		var newData = this._responseData.features;
            			PTbounds = new Tmapv3.LatLngBounds();
            					for (var i = 0; i < newData.length; i++) {
            						var mData = newData[i];
            						var type = mData.geometry.type;
            						var pointType = mData.properties.pointType;
            						if(type == "Point"){
            							var linePt = new Tmapv3.LatLng(mData.geometry.coordinates[1],mData.geometry.coordinates[0]);
            							PTbounds.extend(linePt);
            						}
            						else{
            							var startPt,endPt;
            							for (var j = 0; j < mData.geometry.coordinates.length; j++) {
            								var linePt = new Tmapv3.LatLng(mData.geometry.coordinates[j][1],mData.geometry.coordinates[j][0]);
            								PTbounds.extend(linePt);
            							}
            					}
            				}
            				map.fitBounds(PTbounds);

    	}

        function distanceToLevel(distance){
        var level = 0;
            if(distance > 20000) level = 6;
            else if(distance > 18000) level = 7;
            else if(distance > 16000) level = 8;

            return level;
        }

    	//데이터 로드중 실행하는 함수입니다.
    	function onProgress(){

    	}

    	//데이터 로드 중 에러가 발생시 실행하는 함수입니다.
    	function onError(){
    		alert("onError");
    	}


	function setPosition(){
            var positions = [];
            $.ajax({
                url : "/field_list",
                type : "post",
                beforeSend: function(xhr){
                                        xhr.setRequestHeader(header, token);
                                    },
                success : function(data){
                    console.log(data);
                    data.forEach((a) => {
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
                    })
                    console.log(positions);
                    return positions;
                }

            })

            return positions;
    }

/*var new_polyLine = [];
var new_Click_polyLine = [];

function drawData(data){
    console.log("drawData")
    console.log(data);
	// 지도위에 선은 다 지우기
	routeData = data;
	var resultStr = "";
	var distance = 0;
	var idx = 1;
	var newData = [];
	var equalData = [];
	var pointId1 = "-1234567";
	var ar_line = [];

	for (var i = 0; i < data.features.length; i++) {
		var feature = data.features[i];
		//배열에 경로 좌표 저잘
		if(feature.geometry.type == "LineString"){
			ar_line = [];
			for (var j = 0; j < feature.geometry.coordinates.length; j++) {
				var startPt = new Tmapv3.LatLng(feature.geometry.coordinates[j][1],feature.geometry.coordinates[j][0]);
				ar_line.push(startPt);
				pointArray.push(feature.geometry.coordinates[j]);
			}
			var polyline = new Tmapv3.Polyline({
		        path: ar_line,
		        strokeColor: "#ff0000",
		        strokeWeight: 6,
		        map: map
		    });
			new_polyLine.push(polyline);
		}
		var pointId2 = feature.properties.viaPointId;
		if (pointId1 != pointId2) {
			equalData = [];
			equalData.push(feature);
			newData.push(equalData);
			pointId1 = pointId2;
		}
		else {
			equalData.push(feature);
		}
	}
	geoData = newData;
	var markerCnt = 1;
	for (var i = 0; i < newData.length; i++) {
		var mData = newData[i];
		var type = mData[0].geometry.type;
		var pointType = mData[0].properties.pointType;
		var pointTypeCheck = false; // 경유지 일때만 true
		if (mData[0].properties.pointType == "S") {
			var img = '/upload/tmap/marker/pin_r_m_s.png';
			var lon = mData[0].geometry.coordinates[0];
			var lat = mData[0].geometry.coordinates[1];
		}
		else if (mData[0].properties.pointType == "E") {
			var img = '/upload/tmap/marker/pin_r_m_e.png';
			var lon = mData[0].geometry.coordinates[0];
			var lat = mData[0].geometry.coordinates[1];
		}
		else {
			markerCnt=i;
			var lon = mData[0].geometry.coordinates[0];
			var lat = mData[0].geometry.coordinates[1];
		}
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
                var trafficColors = {
                				extractStyles:true,
                				*//* 실제 교통정보가 표출되면 아래와 같은 Color로 Line이 생성됩니다. *//*
                				trafficDefaultColor:"#636f63", //Default
                				trafficType1Color:"#19b95f", //원할
                				trafficType2Color:"#f15426", //지체
                				trafficType3Color:"#ff970e"  //정체
                			};
                var style_red = {
                				fillColor:"#FF0000",
                				fillOpacity:0.2,
                				strokeColor: "#FF0000",
                				strokeWidth: 3,
                				strokeDashstyle: "solid",
                				pointRadius: 2,
                				title: "this is a red line"
                			};
                			drawData(prtcl);
                var newData = geoData[0];
                			PTbounds = new Tmapv3.LatLngBounds();
                					for (var i = 0; i < newData.length; i++) {
                						var mData = newData[i];
                						var type = mData.geometry.type;
                						var pointType = mData.properties.pointType;
                						if(type == "Point"){
                							var linePt = new Tmapv3.LatLng(mData.geometry.coordinates[1],mData.geometry.coordinates[0]);
                							console.log(linePt);
                							PTbounds.extend(linePt);
                						}
                						else{
                							var startPt,endPt;
                							for (var j = 0; j < mData.geometry.coordinates.length; j++) {
                								var linePt = new Tmapv3.LatLng(mData.geometry.coordinates[j][1],mData.geometry.coordinates[j][0]);
                								PTbounds.extend(linePt);
                							}
                					}

                				}
                				map.fitBounds(PTbounds);
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
}*/