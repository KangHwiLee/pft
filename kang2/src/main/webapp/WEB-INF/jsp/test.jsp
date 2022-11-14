<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="resources/assets/js/jquery.min.js"></script>

<style>
	html,
	body
	{
	width:100%;
	height:100%;
	 margin: 0;
    padding: 0;
	}
	html, body{overflow:hidden;min-height: 100%;}
	div .left{width:22%;height:95%;float:left;}
	div .right{width:78%;height:95%;float:left;overflow:scroll; overflow-x:hidden;}
	.wrap{width:100%;height:100%;padding:0;margin:0;padding-bottom:80px;}
	.side-1{float:left;width:380px;height:100%; background-color:#F2F1F7; text-align:center;position:absolute;}
	.side-1 nav{position:relative; top:8%; width:320px; align:center;}
	.side-1 ul{vertical-align: middle; list-style: none;}
	.side-1 ul li{margin:12%; font-size:22px;}
	.side-2{float:left; background-color:#F1F1F1; left:380px;width:38.4px;height:100%;position:absolute;}
	
	.main{float:left; width:100%;height:100%;padding-left:4%;background-color:#FFFFFF;positions:relative;flex:1;z-index:-1;}
	
	.main_cont{height:100%; width:100%;background-color:#FFFFFF;}
	
	.sub_title{margin:0;padding-top:2%;color:#B7B7B7;}
	.section{padding-right:4%;width:94%;height:100%;}
	.container{margin-top:50px;width:100%;height:100%;}
	.container_contant{width:100%;height:400px;}
	.contant{background-color:black; width:150px; height:200px;float:left;margin-left:20px;margin-right:20px;margin-bottom:120px;}
	
	.title_img{background-color:white;border:solid 1px; width:100%;height:70%;}
	.title{color:white;font-size:22px;}
	
	.footer {
    width: 100%;
    height: 48px; /* footer의 높이 */
    position: absolute;  
    bottom: 0;
    left: 0;
    background-color:black;
    z-index:0;
}
</style>
</head>
<body>
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


<div class="side-2"></div>
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
			$(".main").html(data);
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