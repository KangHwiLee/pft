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
	<div class="right_wrap">
				<h2>강휘 포트폴리오</h2>
				<h1>sseemitter study</h1>
			</div>
	<div id="room_list" style="padding-left:20px;">
		<div class="room" id="admin">
			<input type="text" id="send_message">
			<button type="button" onclick="notice_write()">send_message</button>
		</div>
		<div class="room" id="user">
		
		</div>
	</div>
	<div  style="padding-left:20px;">
	<span>sse emitter라는 기능을 처음으로 접하게 되어 제 포트폴리오에서 한번 공부해보고자 했습니다.</span><br>
	<span>sse emitter는 클라이언트 - 서버 통신기능으로 클라이언트가 최초 서버에 등록을하면</span><br>
	<span>등록 후 서버에 이벤트가 생길 경우 이벤트 내용을 클라이언트에게 전송을 해주는 기능이라 이해했습니다.</span><br>
	<br><br>
	<span>먼저 브라우저가 로드가 완료되면 서버의 emitter 빈 자리가 있는지 조회합니다.</span><br>
	<span>최대 동시 접속 수는 HTTP/1.1의 경우 브라우저 당 6개이며, HTTP/2는 100개까지 가능하다고 합니다..</span><br>
	<span>제 포트폴리오의 경우 HTTP/1.1의 버전으로 적용되어 최대 6개가 가능하게 설정되어있습니다.</span><br>
	<span>emitter생성이 6개를 넘길 경우 최초 생성한 emitter를 삭제해 마지막에 접속시도 한 사용자를 접속할 수 있게 해줍니다.</span><br>
	<br><br>
	<span>input 박스에 text를 입력하고 send_message를 누르면</span><br>
	<span>이 페이지에 접속한 사용자들에게 오른쪽 공간을 통해 text를 보여줍니다.</span><br>
	<br><br>
	<span>처음 Sse Emitter를 접했을때는 사용자 여러명을 수용하고 각자 카카오톡같은 기능을 만들 수 있지 않을까 생각했습니다.</span><br>
	<span>3중 4중 해시맵을 만들어가며 이틀을 공부해본 결과 불가능하다는걸 늦게 깨닫고..</span><br>
	<span>처음 시도했던 코드에비해 아주 간단한 코드로 sse의 기능을 사용해보았습니다.</span><br>
	<span>sse 기능의 제일 기초를 공부했다 생각합니다.</span><br>
	<span></span><br>
	</div>
		</div>
</div>
</body>
<script>
$(document).ready(function(){
	
	first_connection();
})


function first_connection(){
	$.ajax({
		url : "/notice_first_connection",
		type : "get",
		success : function(data){
			let sse = new EventSource("http://localhost:8081/notice_first");
			sse.addEventListener('notice_start', e => {  
			    const { data: receivedCount } = e;  
			    console.log("count event data",receivedCount);  
			})
			sse.addEventListener('notice_write', e => {  
			    const { data: receivedCount } = e;  
			    console.log("count event data",receivedCount);  
			    view = "<span>"+receivedCount+"</span>"
			    view += "<br>"
			    console.log(receivedCount);
			    console.log(view);
			    $("#user").append(view);
			});
		}
	})
	
}

function notice_write(){
	$.ajax({
		url : "/notice_write",
		type : "get",
		data : {"text" : $("#send_message").val()},
		success : function(data){
		}
	})
}

</script>
</html>