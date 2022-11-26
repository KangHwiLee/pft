package chat;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

import config.ServerEndpointConfigurator;
import lombok.extern.java.Log;



@Log
@Component
@ServerEndpoint(value="/notify", configurator = ServerEndpointConfigurator.class)		//참고 https://velog.io/@fivewinds/spring-boot%EC%97%90%EC%84%9C-WebSocket%EA%B0%9C%EB%B0%9C-1
public class BroadSocket {
	
	  private static int onlineCount = 0;
	  private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());
	  @OnOpen
	  public void onOpen(Session session) {
	    onlineCount++;
	    clients.add(session);
	    log.info("OnOpen:" + onlineCount);
	  }

	  @OnClose
	  public void OnClose(Session session) {
	    onlineCount--;
	    clients.remove(session);
	    log.info("OnClose:" + onlineCount);
	  }

	  @OnMessage
	  public void onMessage(String message, Session session) throws IOException  {
	    log.info("OnMessage:" + message);
	    synchronized(clients) {
            for(Session client : clients) {
                if(!client.equals(session)) {
                    client.getBasicRemote().sendText(message);
                }
            }
        }
	    
	  }

}