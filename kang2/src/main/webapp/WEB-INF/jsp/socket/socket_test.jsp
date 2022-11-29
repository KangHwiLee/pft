<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/main.css" />
	<script src="resources/js/jquery-3.6.0.min.js" ></script>
	<script src="resources/js/common.js" ></script>
</head>
<body>

<div class="wrap">
	<div class="left">
			
	</div>
		
	<div class="right">
	<span>socket_test</span>
	<input id="test">
	<button type="button" onclick="count()">button</button>
	<button type="button" onclick="login(1)">button</button>
	<button type="button" onclick="login(2)">button</button>
	<button type="button" onclick="login(3)">button</button>
	<button type="button" onclick="login(4)">button</button>
	</div>
		
</div>


</body>
<script>
/* $(document).ready(function(){
	var data = {"test" : "test", "test2" : "test2"}
	$.ajax({
		url : "socket_start",
		dataType : "get",
		data : data,
		success : function(result){
			console.log("성공");
		}
	})
}) */

function count(){
	console.log($("#test").val());
	$.ajax({
		url:"/count",
		type : "POST",
		data : {"test" : $("#test").val()},
		success : function(){
			console.log("??");
		}
	})
}

function login(num){

const sse = new EventSource("http://localhost:8081/connect/"+num);

sse.addEventListener('connect', (e) => {
	const { data: receivedConnectData } = e;
	console.log('connect event data: ',receivedConnectData);  // "connected!"
});

sse.addEventListener('count', e => {  
    const { data: receivedCount } = e;  
    console.log("count event data",receivedCount);  
});
}
</script>
</html>