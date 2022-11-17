<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="resources/css/main.css" rel="stylesheet"></link>
<link href="resources/css/test.css" rel="stylesheet"></link>
<script src="resources/js/jquery-3.6.0.min.js"></script>
</head>
<body>
<!-- <div class="mat">
	<div class="mat-left">
	</div>
	 <div class="mat-right">
	 
	 </div>
</div> -->
<div class="wrap">
<div class="left">
<div class="side-1">

	<h1>강휘 포트폴리오</h1>
	<p>Back-End Developer</p>
	<div class="menu">
		<nav>
		<ul>
			<li>
				<a href="#" onclick="test(1)">1</a>
			</li>
			<li>
				<a href="#">1</a>
			</li>
			<li>
				<a href="#">1</a>
			</li>
			<li>
				<a href="#">1</a>
			</li>
			<li>
				<a href="#">1</a>
			</li>
		</ul>
		</nav>
	</div>
</div>

</div>
<div class="right">
<div class="main">
	<div class="main_cont">
		<div class="section">
			<h3 class="sub_title"> test </h3>
			<h1 class="contant_title">test2</h1>
		
			<div class="container">
				<div class="contant">
					<div class="title_img"></div>
					<span class="title">test</span>
				</div>
				<div class="contant">
					<div class="title_img"></div>
					<span class="title">test</span>
				</div>
				<div class="contant">
					<div class="title_img"></div>
					<span class="title">test</span>
				</div>
				<div class="contant">
					<div class="title_img"></div>
					<span class="title">test</span>
				</div>
				<div class="contant">
					<div class="title_img"></div>
					<span class="title">test</span>
				</div>
				<div class="contant">
					<div class="title_img"></div>
					<span class="title">test</span>
				</div>
			</div>
				
		</div>
	</div>
</div>
	<div style="float:right; width:100%;height:200px;">
	<div style="float:right;">
	<button id="contant_modify" onclick="ppt_write()">test</button>
	</div>
	</div>
</div>

<div class="footer">
	<span style="color:white;">footer</span>
</div> 

</div>
</body>

<script>

function ppt_write(){
	$.ajax({
		url : "/ppt_write",
		Type : "get",
		dataType : "html",
		success : function(data){
			$(".container").html(data);
		}
	})
}

function test(num){
	$.ajax({
		url : "/main_contant",
		Type : "get",
		dataType : "html",
		success : function(data){
			console.log(data);
			$(".main").html(data);
		}
	})
}
</script>
</html>