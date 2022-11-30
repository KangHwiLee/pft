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
<style>
#room_list{
height:33%;
display:flex;
flex-wrap: wrap;
}
.room{
width:33%;
height:100%;
border:1px solid;
}
</style>
<body>

<div class="wrap">
	<div class="left">
			
	</div>
		
	<div class="right">
	<span>socket_test</span>
	<input id="test" value='<%=session.getId().substring(0, 6)%>' placeholder="id입력">
	<!-- <button type="button" onclick="sse_login()">login</button> -->
	<button type="button" onclick="add_room()">add_room</button>
	<button type="button" onclick="test()">test</button>
	<div id="room_list">
	
	</div>
	</div>
		
</div>


</body>
<script>
$(document).ready(function(){
	sessionStorage.setItem("login", 0);
	first_connection();
})
var test_num = 0;
var data = [];
var id = [];
function test(){
	$("#room_list").empty();
	
	data.push(test_num++);
	console.log(data)
	
}

let sse = "";
var id = "";

function first_connection(){
	let sse = null;
	$.ajax({
		url : "/first_connection",
		type : "get",
		success : function(data){
			if(data == 0){
				console.log("최초접속 첫회원입니다.")
				sse = new EventSource("http://localhost:8081/first");
			}else {
				sse = new EventSource("http://localhost:8081/n_first")
				console.log("최초가 아닙니다")
				room_info();
			}
			/* sse.addEventListener('connect', (e) => {
				const { data: receivedConnectData } = e;
				console.log('connect event data: ',receivedConnectData);  // "connected!"
				
				
				view = '<div class="room" id="room_'+i+'">'
					view += '<input type="text" id="send_message">'
					view += '<button type="button" onclick="send('+receivedConnectData+')">send_message</button>'
					view += '</div>'
					console.log(view);
					$("#room_list").append(view);
					console.log("??")
			}); */

			sse.addEventListener('room_info', e => {  
			    const { data: receivedCount } = e;  
			    console.log("count event data",receivedCount);  
			});
		}
	})
}

/* function sse_login(){
	id = $("#test").val();
	$.ajax({
		url : "/sse_login?id="+id,
		type : "get",
		success : function(data){
			
			console.log(data);
			sessionStorage.setItem("login", 1);
			view = "";
			for(i=0; i<data.length; i++){
				let test = data[i].toString
				view += '<div class="room" id="room_'+i+'">'
				view += '<input type="text" id="send_message">'
				view += '<button type="button" onclick="send('+i+')">send_message</button>'
				view += '</div>'
			}
			$("#room_list").empty();
					$("#room_list").html(view)
					console.log(view);
		}
	}) 
} */


function add_room(){
	if(sessionStorage.getItem("login") == 0){
		console.log("로그인먼저")
		return;
	}
	
}


function room_info(num){
	$.ajax({
		url : "/room_info",
		type : "get",
		data : {"id" : $("#test").val()},
		success : function(data){
			console.log("성공");
		}
	})
}

</script>
</html>