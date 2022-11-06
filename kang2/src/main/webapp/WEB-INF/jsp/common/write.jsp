<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="resources/assets/css/main.css" />
<script src="resources/assets/js/jquery.min.js"></script>
			<script src="resources/assets/js/jquery.scrolly.min.js"></script>
			<script src="resources/assets/js/jquery.scrollex.min.js"></script>
			<script src="resources/assets/js/browser.min.js"></script>
			<script src="resources/assets/js/breakpoints.min.js"></script>
			<script src="resources/assets/js/util.js"></script>
			<script src="resources/assets/js/main.js"></script>
			
</head>
<body style="background-color:#f5fafa;"	>

<section id="portfolio" class="two" >
						<div class="container" style="margin-top:50px;">
						<form id="test" action="/test_submit" method="post">
							<select name="category">
								<option value="1">Java</option>
								<option value="2">JAVASCRIPT</option>
								<option value="3">MySQL</option>
							</select>
							<header>
								<input placeholder="제목을 입력하세요" style="width:100%;" name="title">
							</header>


							<textarea style="width:100%; height:500px; resize:none;" name="contant"></textarea>
						</form>
						</div>
						<button id="button1" type="submit" form="test" style="float: right; margin-right:20%; margin-top:1%;"> 글쓰기 </button>
					</section>

</body>
</html>