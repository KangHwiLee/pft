<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<!--
	Prologue by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
	<head>
		<title>Prologue by HTML5 UP</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="resources/assets/css/main.css" />
		<script src="resources/assets/js/jquery.min.js"></script>
			<script src="resources/assets/js/common.js"></script>
			
<style>
#pagination{
text-align:center;
}

#pagination ul li {
display:inline-block;
}

</style>
	</head>
	<body class="is-preload">

		<!-- Header -->
			<div id="header">

				<div class="top">

					<!-- Logo -->
						<div id="logo">
							<span class="image avatar48"><img src="resources/images/avatar.jpg" alt="" /></span>
							<h1 id="title">이 강 휘</h1>
							<p>Back-End Engineer</p>
						</div>

					<!-- Nav -->`
						<nav id="nav">
							<ul>
								<li><a href="#top" id="top-link"><span class="icon solid fa-home">자기소개</span></a></li>
								<li><a href="#portfolio" id="portfolio-link"><span class="icon solid fa-th">contant</span></a></li>
								<li><a href="#about" id="about-link"><span class="icon solid fa-user">paging</span></a></li>
								<li><a href="#contact" id="contact-link"><span class="icon solid fa-envelope">MySQL</span></a></li>
								<li><a href="#test" id="test-link"><span class="icon solid fa-envelope">test</span></a></li>
							</ul>
						</nav>

				</div>

				<div class="bottom">

					<!-- Social Icons -->
						<ul class="icons">
							<li><a href="#" class="icon brands fa-twitter"><span class="label">Twitter</span></a></li>
							<li><a href="#" class="icon brands fa-facebook-f"><span class="label">Facebook</span></a></li>
							<li><a href="#" class="icon brands fa-github"><span class="label">Github</span></a></li>
							<li><a href="#" class="icon brands fa-dribbble"><span class="label">Dribbble</span></a></li>
							<li><a href="#" class="icon solid fa-envelope"><span class="label">Email</span></a></li>
						</ul>

				</div>

			</div>

		<!-- Main -->
			<div id="main">

				<!-- Intro -->
					<section id="top" class="one dark cover">
						<div class="container">

							<header>
								<h2 class="alt">이강휘 포트폴리오입니다!</h2>
								<p>쓸수있는 기술, 그동안 배워온 것들에 대해 기록해놓은 포트폴리오입니다</p>
							</header>

							<footer>
								<a href="#portfolio" class="button scrolly">Magna Aliquam</a>
							</footer>

						</div>
					</section>

				<!-- Portfolio -->
					<section id="portfolio" class="two">
						<div class="container" id="con1">

							<header>
								<h2>Contant</h2>
							</header>

							<p>기술 수록 공간입니다.</p>

							<div class="row">
								<div class="col-4 col-12-mobile">	<!-- 1열 -->
								<header>test</header>
								<div id="java_contant">
									<article class="item" onclick="contant1()">
										<header>
											<h3>1. java</h3>
										</header>
									</article>
									<article class="item">
										<header>
											<h3>Rhoncus Semper</h3>
										</header>
									</article>
									<article class="item">
										<header>
											<h3>Ipsum Feugiat</h3>
										</header>
									</article>
									<article class="item">
										<header>
											<h3>Rhoncus Semper</h3>
										</header>
									</article>
								</div>
								</div>
								<!-- --------------------------------------------------------------------- -->
								<!-- ---------------------------- 2열 ------------------------- -->
								<div class="col-4 col-12-mobile">
								<header> test2 </header>
								<div id="javascript_contant">
									<article class="item" id="con2">
										<header>
											<h3>Magna Nullam</h3>
										</header>
									</article>
									<article class="item">
										<header>
											<h3>Natoque Vitae</h3>
										</header>
									</article>
								</div>
								</div>
									<!-- ------------------------------------------------------------------------- -->
								<!-- ----------------------------------- 3열 --------------------------------------- -->
								<div class="col-4 col-12-mobile">
									<header>mysql</header>
									<div id="mysql_contant">
									<article class="item">
										<header>
											<h3>Dolor Penatibus</h3>
										</header>
									</article>
									<article class="item">
										<!-- <a href="#" class="image fit"><img src="resources/images/pic07.jpg" alt="" /></a> -->
										<header>
											<h3>Orci Convallis</h3>
										</header>
									</article>
									</div>
								</div>
									<!-- ------------------------------------------------------------------------- -->
							</div>

						</div>
						
						<button id="button1" style="float: right; margin-right:10%;" onclick="write_move()"> 글쓰기 </button>
					</section>

				<!-- About Me -->
					<section id="about" class="three">
						<div class="container">

							<header>
								<h2>페이징 기술</h2>
							</header>

							<p>테스트</p>
							
							<div>
									<table class='table'>
										<thead>
										<tr>
											<th>번호</th>
											<th>제목</th>
											<th>내용</th>
											</tr>
										</thead>
										<tbody id="paging-area">

										</tbody>
									</table>
									
									<div id="pagination">
									</div>
									
									<button onclick="add_paging_contant()"> 내용추가</button>
							</div>

						</div>
					</section>

				<!-- Contact -->
					<section id="contact" class="four">
						<div class="container">

							<header>
								<h2>Contact</h2>
							</header>

							<p>Elementum sem parturient nulla quam placerat viverra
							mauris non cum elit tempus ullamcorper dolor. Libero rutrum ut lacinia
							donec curae mus. Eleifend id porttitor ac ultricies lobortis sem nunc
							orci ridiculus faucibus a consectetur. Porttitor curae mauris urna mi dolor.</p>

							<form method="post" action="#">
								<div class="row">
									<div class="col-6 col-12-mobile"><input type="text" name="name" placeholder="Name" /></div>
									<div class="col-6 col-12-mobile"><input type="text" name="email" placeholder="Email" /></div>
									<div class="col-12">
										<textarea name="message" placeholder="Message"></textarea>
									</div>
									<div class="col-12">
										<input type="submit" value="Send Message" />
									</div>
								</div>
							</form>

						</div>
					</section>

					<section id="test" class="five">
						<div class="container">

							<header>
								<h2>Contact</h2>
							</header>

							<p>Elementum sem parturient nulla quam placerat viverra
							mauris non cum elit tempus ullamcorper dolor. Libero rutrum ut lacinia
							donec curae mus. Eleifend id porttitor ac ultricies lobortis sem nunc
							orci ridiculus faucibus a consectetur. Porttitor curae mauris urna mi dolor.</p>

							<form method="post" action="#">
								<div class="row">
									<div class="col-6 col-12-mobile"><input type="text" name="name" placeholder="Name" /></div>
									<div class="col-6 col-12-mobile"><input type="text" name="email" placeholder="Email" /></div>
									<div class="col-12">
										<textarea name="message" placeholder="Message"></textarea>
									</div>
									<div class="col-12">
										<input type="submit" value="Send Message" />
									</div>
								</div>
							</form>

						</div>
					</section>

			</div>

		<!-- Footer -->
			<div id="footer">

				<!-- Copyright -->
					<ul class="copyright">
						<li>&copy; Untitled. All rights reserved.</li><li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
					</ul>

			</div>

<div id="contant_detail" style="display:hide;">

</div>

		<!-- Scripts -->
			<script src="resources/assets/js/jquery.scrolly.min.js"></script>
			<script src="resources/assets/js/jquery.scrollex.min.js"></script>
			<script src="resources/assets/js/browser.min.js"></script>
			<script src="resources/assets/js/breakpoints.min.js"></script>
			<script src="resources/assets/js/util.js"></script>
			<script src="resources/assets/js/main.js"></script>

	</body>
	<script>
	$(document).ready(function(){
		sessionStorage.setItem("paging", 1);
		paging_test(1);
	})
	$(function(){
		$.ajax({
			url : "/contant_list.do",
			type : "get",
			success : function(data){
				java = "";
				var java_c = 1;
				js = "";
				var js_c = 1;
				mysql = "";
				var sql_c = 1;
				$(data).each(function(){
					if(this.category == 1){
						java += "<article class='item' onclick='contant_detail("+this.idx+")'>";
						java += "<header>"
						java += "<h3>"+java_c+". "+this.title+"</h3>"
						java += "</header>"
						java += "</article>"
						java_c ++;
					}else if(this.category == 2){
						js += "<article class='item' onclick='contant_detail("+this.idx+")'>";
						js += "<header>"
						js += "<h3>"+js_c+". "+this.title+"</h3>"
						js += "</header>"
						js += "</article>"
						js_c ++;
					}else{
						mysql += "<article class='item' onclick='contant_detail("+this.idx+")'>";
						mysql += "<header>"
						mysql += "<h3>"+sql_c+". "+this.title+"</h3>"
						mysql += "</header>"
						mysql += "</article>"
						sql_c ++;
					}
					})
					$("#java_contant").html(java);
					$("#javascript_contant").html(js);
					$("#mysql_contant").html(mysql);
					
					
			}
		})
	})
	
	</script>
</html>