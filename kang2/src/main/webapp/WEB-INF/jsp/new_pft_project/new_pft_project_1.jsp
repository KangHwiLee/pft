<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강휘 포트폴리오</title>
<link href="resources/css/pft_css.css" rel="stylesheet">
<link href="resources/css/pft_main.css" rel="stylesheet">
<link href="resources/css/pft_root.css" rel="stylesheet">
<link href="resources/css/event.css" rel="stylesheet">
<link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css">
<style data-styled="active" data-styled-version="5.3.5"></style>
<style>
.swiper-button-prev{
top:75%;
left:35%;
}
.swiper-button-next{
top:75%;
left:65%;
}
</style>
</head>
<body>
	<div id="root">
		<div class="sc-iTONeN jPxA-Dt">
			<div class="sc-iAvgwm dEnbyX">
				<header class="sc-efBctP hkHCTn"><img src="resources/css/img/common/back.png" alt="Back" onclick="javascript:history.back()"></header>
				<h1 class="sc-cTQhss fqllBl">CCTV 스트리밍 서비스</h1>
				<h3 class="sc-jOrMOR cMenps">설치된 CCTV가 보내주는 RTSP 프로토콜을 이용해 <br>웹 페이지에서 CCTV 스트리밍 지원</h3>
				<div class="sc-bBXxYQ boINT"></div>
				<div class="sc-cOFTSb goNwMg">
					<h2>✅ 주요 기능</h2>
					<ul>
						<li class="sc-dPyBCJ itocFK">인터넷만 연결되어있으면 RTSP프로토콜을 받아 스트림 가능</li>
						<li class="sc-dPyBCJ itocFK">인터넷 방송과 비슷한 개념으로 영상 송출</li>
						<li class="sc-dPyBCJ itocFK">스트림 지원하는 프로그램 오류로 스트림이 일시정지할 경우 자동으로 오류 감지 후 재 스트림</li>
					</ul>
					<p>&nbsp;&nbsp; 사용자가 웹사이트에 CCTV RTSP주소를 입력합니다. CCTV 서버에 TCP Socket으로 연결되어 CCTV 정보를 전달받고,
					CCTV 정보를 전달받은 자바 프로그램은 이 정보들을 통해 CMD명령어를 백그라운드에서 입력해 FFMPEG라는 프로그램을 통해 CCTV스트림을 시작합니다.
					만약 자바프로그램 또는 스트림을 지원해주는 FFMPEG의 자체적인 오류로 스트림이 중지될 경우 자바프로그램에서 오류를 감지해
					자동으로 스트림을 재시작 합니다.
					</p>
					   <br>
				</div>
				<div class="sc-bBXxYQ boINT"></div>
				<div class="sc-cOFTSb goNwMg">
					<h2>👀 프로젝트 개요</h2>
					<p>
						<img src="resources/css/img/common/img1.png">
						 참가 인원:1인
					</p>
					<p>
						<img src="resources/css/img/common/img2.png">
						 담당 작업:백엔드 개발, 서버구축
					</p>
					<p>
						<img src="resources/css/img/common/img3.png">
						 개발 기간: 2022년 08월 ~ 2022년 09월
					</p>
					<p>
						<img src="resources/css/img/common/img4.png">
						 기술 스택:JAVA
					</p>
				</div>
				<div class="sc-bBXxYQ boINT"></div>
				<div class="sc-cOFTSb goNwMg">
					<h2>개발 동기</h2>
					<p>&nbsp;&nbsp; 저에게 프로젝트를 진행해볼 생각 있냐는 말을 들었을때, 심장이 두근거렸습니다. 스노우멜트 서비스 웹 개발이
					마무리 단계에 들어가고 있어, 개발자로서 성장이 멈춘 상태였다는 생각이 들어있었습니다. 회사에서 제가 만든 웹 프로젝트에
					정이 들어있었고 더 완벽하게 만들 수 있으며, 저 자신을 한단계 성장시킬 기회라 생각이 들었습니다. 이 CCTV 스트리밍의 경우
					스노우멜트 모니터링 서비스의 IOT기능 뿐만 아니라 실제 현장에서 눈이 녹고있는지, 장비가 정상 작동하는지를 실시간으로 확인할 수 있는
					좋은 기능이라 생각이 들어 프로젝트를 진행하게 되었습니다.
					</p>
				</div>
				<div class="sc-bBXxYQ boINT"></div>
				<div class="sc-cOFTSb goNwMg">
					<h2>느낀 점</h2>
					<p>&nbsp;&nbsp; CCTV 웹페이지 스트리밍 기능을 만들고자 했을때 저는 아는게 아무것도 없었습니다.
					구글링을 통해 하나 둘씩 지식을 접하며 RTSP통신, 서버구축의 기본, TCP Socket과 멀티쓰레드의 개념 등
					다양한 지식을 접할 수 있는 계기가 되었습니다. 제가만든 이 자바 프로그램이 동작을하며 웹페이지에 CCTV영상이 나오기 시작할 때
					저는 말로 이룰수 없는 성취감을 느낄 수 있었고 개발자로서 자신감또한 얻게 되었습니다.
					</p>
				</div>
				<div class="sc-bBXxYQ boINT"></div>
				
		</div>
	
	</div>
	
</body>
</html>