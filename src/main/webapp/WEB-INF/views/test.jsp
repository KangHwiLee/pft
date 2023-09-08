<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="/WEB-INF/views/include/head.jsp"/>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.5.2/sockjs.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
<body>

</body>
<script>
var socket = new SockJS('/users');
stompClient = Stomp.over(socket);
stompClient.connect({}, function(frame){
    console.log('connected: ' + frame);
    stompClient.send("/app/user", {}, JSON.stringify({name : "test"}));
    stompClient.subscribe('/topic/cpu', function(response){
        console.log(response);
        console.log(JSON.parse(response.body));
    })
})
</script>
</html>