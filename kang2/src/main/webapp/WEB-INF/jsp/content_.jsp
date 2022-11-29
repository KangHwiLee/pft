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
	<link rel="stylesheet" href="resources/css/main.css" />
	<script src="resources/js/jquery-3.6.0.min.js" ></script>
	<script src="resources/js/common.js" ></script>
	</head>
	
	<body>
	<div class="wrap">
		<div class="left">
			
		</div>
		
		
		
		<div class="right">
			<div class="right_wrap">
				<h2>강휘 포트폴리오</h2>
				<h1>자기소개서</h1>
			</div>
			<div class="contant_list">
				
				
				
			</div>
			<div class="footer">
				<button class="write" onclick="content_write()"> 글쓰기 </button>
				<a onclick="content_list_load()" id="add_list">목록 더보기</a>
			</div>
		</div>
	</div>
	
	</body>
	<script>
	$(document).ready(function(){
		sessionStorage.setItem("content", 0);
		$.ajax({
			url : "content_total",
			type : "get",
			success : function(data){
				sessionStorage.setItem("total", data);
			}
		})
		content_list_load();
	})
	
	function content_list_load(){
		var num = parseInt(sessionStorage.getItem("content"));
		var total = parseInt(sessionStorage.getItem("total"));
		if(num+5 > total){
			console.log("이거동작")
			$('#add_list').css('display', 'none');
		}else{
		}	
		$.ajax({
			url:"/content_list",
			type:"get",
			data : {"num" : num},
			dataType:"html",
			success:function(data){
				$(".contant_list").append(data);
				var num = parseInt(sessionStorage.getItem("content"))+5;
				console.log(num);
				sessionStorage.setItem("content", num);
			}
		})
	}
	
	function content_write(){
		location.href="/content_write";
	}
	</script>
</html>