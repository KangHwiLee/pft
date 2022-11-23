<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
        <input type="text" value='<%=session.getId().substring(0, 6)%>'
            id='chat_id1' />
    <!--     채팅창 -->
    <div id="_chatbox1">
        <fieldset style="width:500px; height:500px; border:1px solid; overflow:auto;">
            <div id="messageWindow1" ></div>
            <br /> <input id="inputMessage1" type="text" onkeyup="enterkey(1)" />
            <input type="submit" value="send" onclick="send(1)" />
            <button type="button" onclick="join(1)">join</button>
        </fieldset>
        
    </div>
    
            <input type="text" value='test1' id='chat_id2' />
    <!--     채팅창 -->
    <div id="_chatbox2">
        <fieldset style="width:500px; height:500px; border:1px solid; overflow:auto;">
            <div id="messageWindow2" ></div>
            <br /> <input id="inputMessage2" type="text" onkeyup="enterkey(2)" />
            <input type="submit" value="send" onclick="send(2)" />
            <button type="button" onclick="join(2)">join</button>
        </fieldset>
    </div>
</body>
<!-- 말풍선아이콘 클릭시 채팅창 열고 닫기 -->
<script type="text/javascript">
var num = 0;
var webSocket = null;
var inputMessage = null;
var textarea = null;
    var textarea = document.getElementById("messageWindow"+num);
    
    function join(num){
    	webSocket = new WebSocket('ws://localhost:8081/multi_chat/'+num);
    	
        inputMessage = document.getElementById('inputMessage'+num);
        webSocket.onerror = function(event) {
            onError(event)
        };
        webSocket.onopen = function(event) {
            onOpen(event)
        };
        webSocket.onmessage = function(event) {
            onMessage(event)
        };
        function onOpen(event) {
            $("#messageWindow"+num).html("<p class='chat_content'>채팅에 참여하였습니다.</p>");
        }
        function onError(event) {
            alert(event.data);
        }
        function onMessage(event) {
            var message = event.data.split("|");
            var sender = message[0];
            var content = message[1];
            if (content == "") {
                
            } else {
                if (content.match("/")) {
                    if (content.match(("/" + $("#chat_id"+num).val()))) {
                        var temp = content.replace("/" + $("#chat_id"+num).val(), "(귓속말) :").split(":");
                        if (temp[1].trim() == "") {
                        } else {
                            $("#messageWindow"+num).html($("#messageWindow"+num).html() + "<p class='whisper'>"
                                + sender + content.replace("/" + $("#chat_id").val(), "(귓속말) :") + "</p>");
                        }
                    } else {
                    }
                } else {
                    if (content.match("!")) {
                        $("#messageWindow"+num).html($("#messageWindow"+num).html()
                            + "<p class='chat_content'><b class='impress'>" + sender + " : " + content + "</b></p>");
                    } else {
                        $("#messageWindow"+num).html($("#messageWindow"+num).html()
                            + "<p class='chat_content'>" + sender + " : " + content + "</p>");
                    }
                }
            }
        }
       
        //     엔터키를 통해 send함
        window.setInterval(function() {
            var elem = document.getElementById('messageWindow'+num);
            elem.scrollTop = elem.scrollHeight;
        }, 0);
    }
    
    function send(num) {
        if (inputMessage.value == "") {
        } else {
            $("#messageWindow"+num).html($("#messageWindow"+num).html()
                + "<p class='chat_content'>나 : " + inputMessage.value + "</p>");
        }
        webSocket.send($("#chat_id"+num).val() + "|" + inputMessage.value);
        inputMessage.value = "";
    }
    
    function enterkey(num) {
        if (window.event.keyCode == 13) {
            send(num);
        }
    }
   

    
    
    
    
    //     채팅이 많아져 스크롤바가 넘어가더라도 자동적으로 스크롤바가 내려가게함
   /*      */ 
   
</script>

</html>