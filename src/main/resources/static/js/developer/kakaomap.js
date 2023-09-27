              var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
              var options = { //지도를 생성할 때 필요한 기본 옵션
                  center: new kakao.maps.LatLng(35.1378295,126.903827), //지도의 중심좌표.
                  level: 5 //지도의 레벨(확대, 축소 정도)
              };
              var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

              var mapTypeControl = new kakao.maps.MapTypeControl();

                            // 지도에 컨트롤을 추가해야 지도위에 표시됩니다
                            // kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
                            map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

                            // 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
                            var zoomControl = new kakao.maps.ZoomControl();
                            map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

              var positions = [];

                setPosition();

               for(var i=0; i<positions.length; i++){
               var marker = new kakao.maps.Marker({
                    map : map,
                    position : new kakao.maps.LatLng(positions[i].lat, positions[i].lon),
                    title : positions[i].title
                })

                console.log(positions[i].lon)
                console.log(positions[i].lon+0.1)
                var customOverlay = new kakao.maps.CustomOverlay({
                    position: new kakao.maps.LatLng(positions[i].lat, positions[i].lon),
                    content: positions[i].content
                });
                customOverlay.setMap(map);
               }
               console.log(positions[0].latlng)

function setPosition(){

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

}

