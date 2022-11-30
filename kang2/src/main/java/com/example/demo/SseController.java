package com.example.demo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import lombok.extern.slf4j.Slf4j;  
import org.springframework.http.MediaType;  
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;  
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import chat.SseEmitters;  
  
@RestController  
@Slf4j  
public class SseController {  
  
    private final SseEmitters sseEmitters;  
  
    public SseController(SseEmitters sseEmitters) {  
        this.sseEmitters = sseEmitters;  
    }  
    
    @GetMapping("/sse_login")
    @ResponseBody
    public List<SseEmitter> sse_test(HttpSession session, String id) {
    	HashMap<String, List<SseEmitter>> map = new HashMap<String, List<SseEmitter>>();
    	if((HashMap<String, List<SseEmitter>>) session.getAttribute("list") != null) {
    		map = (HashMap<String, List<SseEmitter>>) session.getAttribute("list");
    	}
    	map.put(id, new ArrayList<SseEmitter>());
    	session.setAttribute("list", map);
    	System.out.println(map.toString());
    	return map.get(id);
    }
  
    @GetMapping(value = "/connect/{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)  
    public ResponseEntity<SseEmitter> connect(HttpSession session, @PathVariable("id") String id) {  
    	HashMap<String, List<SseEmitter>> map = (HashMap<String, List<SseEmitter>>) session.getAttribute("list");
    	System.out.println(map.toString());
    	
    	List<SseEmitter> room = map.get(id);
        SseEmitter emitter = new SseEmitter(365 * 60 * 60 * 1000L);  
        room.add(emitter);
        int num = room.size();
        System.out.println(num);
        map.put(id, room);
        System.out.println(emitter);
        //String em = emitter.toString();		//emitter 주소 반화
        sseEmitters.add(emitter);
        System.out.println(map.get(id).toString());
        try {  
            emitter.send(SseEmitter.event()  
                    .name("connect")  
                    .data(num-1));  
        } catch (IOException e) {  
            throw new RuntimeException(e);  
        }  
        session.setAttribute("list", map);
        return ResponseEntity.ok(emitter);  
    }  
    
    @GetMapping("/send")  
    public ResponseEntity<Void> count() {  
        sseEmitters.count();  
        return ResponseEntity.ok().build();  
    }  
    
    @GetMapping("/send_message")
    public String send_message(String id, String message, int index_num, HttpSession session) {
    	HashMap<String, List<SseEmitter>> map = (HashMap<String, List<SseEmitter>>) session.getAttribute("list");
    	System.out.println(message);
    	System.out.println(index_num);
    	SseEmitter sse = map.get(id).get(index_num);
    	
    	return "";
    }
    
}