<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>

<script>
let url = "ws://localhost:8081/ws/chat/test";
let ws;
ws = new WebSocket(url);
var obj = {"num1":1,"num2":2,"num3":3}
ws.onopen = function(event){
	
	ws.send("test", obj)
}
</script>
</html>