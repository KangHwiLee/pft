package chat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

import config.ServerEndpointConfigurator;
import lombok.extern.java.Log;

@Log
@Component
@ServerEndpoint(value="/multi_chat/{num}", configurator = ServerEndpointConfigurator.class)
public class multi_chat {

		
	  private static int onlineCount = 0;
	  private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());
	  private static List<Map<Integer, Session>> list = new ArrayList<Map<Integer,Session>>();
	  @OnOpen
	  public void onOpen(Session session) {
	    onlineCount++;
	    clients.add(session);
	    log.info("OnOpen:" + onlineCount);
	    log.info("?? : " + session);
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
                    log.info("?? : " + session);
                }
            }
        }
	    
	  }
	}
	

