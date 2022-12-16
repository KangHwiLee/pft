<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="resources/css/pft_css.css" rel="stylesheet">
<link href="resources/css/pft_main.css" rel="stylesheet">
<link href="resources/css/pft_root.css" rel="stylesheet">
<link href="resources/css/event.css" rel="stylesheet">
<link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css">
<style data-styled="active" data-styled-version="5.3.5"></style>
</head>
<body>
	<div id="root">
		<div class="sc-iTONeN jPxA-Dt">
			<div class="sc-iAvgwm dEnbyX">
				<header class="sc-efBctP hkHCTn"><img src="resources/css/img/common/back.png" alt="Back"></header>
				<h1 class="sc-cTQhss fqllBl">SPECIAL.FUNCTION</h1>
				<h3 class="sc-jOrMOR cMenps">준비된 컴퓨팅 리소스에서 코드를 실행하고 용량을<br>관리하는 서버리스 컴퓨팅 서비스 템플릿</h3>
				<div class="sc-bBXxYQ boINT"></div>
				<div class="sc-cOFTSb goNwMg">
					<h2>✅ 주요 기능</h2>
					<ul>
						<li class="sc-dPyBCJ itocFK">독립된 공간에서 사용자의 코드를 실행</li>
						<li class="sc-dPyBCJ itocFK">도커 컨테이너를 실행 주기에 따라 자동으로 관리</li>
						<li class="sc-dPyBCJ itocFK">HTTP 요청으로 코드를 실행시킬 수 있어 서버리스 앱 구현 가능</li>
						<li class="sc-dPyBCJ itocFK">코드가 오픈되어 있어 상황에 맞게 fork 하여 커스텀 서버 구현 가능</li>
					</ul>
					<p>&nbsp;&nbsp;Special Function의 주요 기능은 '독립된 공간에서 사용자의 코드를 실행시키는 것' 입니다.
					 사용자는 자신의 코드를 ZIP 형태의 압축 파일로 올리고,
					  서버는 이 코드를 바탕으로 HTTP 요청을 받을 수 있는 형태의 Docker Image로 빌드 합니다.
					   빌드가 완료되면 미리 설정된 HTTP Endpoint를 호출하여 함수를 실행하고, 응답 값을 받을 수 있습니다.</p>
					   <br>
					 <div class="swiper-container">
				        <div class="swiper-wrapper">
				            <div class="swiper-slide"><img src="resources/css/img/common/back.png" alt="Back"></div>
				            <div class="swiper-slide"><img src="resources/css/img/common/gitpng.png" alt="Github"></div>
				            <div class="swiper-slide"><img src="resources/css/img/common/gitpng.png" alt="Github"></div>
				        </div>
				        <div class="swiper-pagination"></div>
				        <div class="swiper-prev"></div>
				        <div class="swiper-next"></div>
				
				        <div class="swiper-scrollbar"></div>
				    </div>
				</div>
			</div>
		</div>
	
	</div>
</body>
<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
<script>
        const swiper = new Swiper('.swiper-container', {
                loop: true,
                pagination: {
                    el: '.swiper-pagination'
                },
                navigation: {
                    nextEl: '.swiper-next',
                    prevEl: '.swiper-prev'
                }
            })
    </script>
</html>