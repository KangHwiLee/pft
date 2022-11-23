package chat;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import ch.qos.logback.classic.Logger;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class WebSocketChatHandler extends TextWebSocketHandler {


    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String input = message.getPayload();
        log.info(input);
        TextMessage textMessage = new TextMessage("Hello, 영진일지입니다. \n 웹소켓 테스트입니다.");
        session.sendMessage(textMessage);
        log.info(textMessage);
    }
}

	

