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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import chat.SseEmitters;  
  
@RestController  
@Slf4j  
public class SseController {  
  
    private final SseEmitters sseEmitters;  
  
    public SseController(SseEmitters sseEmitters) {  
        this.sseEmitters = sseEmitters;  
    }  
    
    @GetMapping(value = "/first_connection")  
    @ResponseBody
    public int first_connection(HttpSession session) {
    	
    	SseEmitter emitter = (SseEmitter) session.getAttribute("sse");
    	System.out.println(emitter);
    	int num = 0;
    	if(emitter != null) {
    		num = 1;
    	}else {
    		num=0;
    	}
    	return num;  
    }
    
    @GetMapping(value = "/first", produces = MediaType.TEXT_EVENT_STREAM_VALUE)  
    @ResponseBody
    public ResponseEntity<SseEmitter> first(HttpSession session) {
    	
    	SseEmitter emitter = (SseEmitter) session.getAttribute("sse");
    	System.out.println(emitter);
    	
        	
    		HashMap<String, List<String>> server_info = new HashMap<>();
    		session.setAttribute("server_info", server_info);
    		session.setAttribute("emitter", emitter);
       	 	
    		emitter = new SseEmitter(365 * 60 * 60 * 1000L);
    		session.setAttribute("sse", emitter);
    		sseEmitters.add(emitter);
    		
    	try {  
            emitter.send(SseEmitter.event()  
                    .name("connect")  
                    .data("서버를 생성합니다."));  
        } catch (IOException e) {  
            throw new RuntimeException(e);  
        }
    	
    	return ResponseEntity.ok(emitter);  
    	
    }
    
    @RequestMapping(value="/n_first", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseBody
    public ResponseBodyEmitter handle(HttpSession session) {
              SseEmitter emitter = (SseEmitter) session.getAttribute("emitter");
              // Pass the emitter to another component...
              return sseEmitters.emitter_test(emitter);  
    }
    
    @GetMapping(value = "/room_info")  
    public ResponseEntity<Void> connect(HttpSession session, String id) {  
		System.out.println("id : " + id);
		HashMap<String, List<String>> server_info = (HashMap<String, List<String>>) session.getAttribute("server_info");
        // -------------------------
     	SseEmitter sse = (SseEmitter) session.getAttribute("sse");
       	 	HashMap<String, List<String>> room_user_list = new HashMap<>();
       	 	
       	 	sseEmitters.room_info(server_info.get("member_"+id));			//room_list : 방 목록, room_member : 방 인원, member_'id' : 회원이 들어가있는 방 목록
        
       	 return ResponseEntity.ok().build(); 
    }  
    
    @GetMapping("/send")  
    public ResponseEntity<Void> count() {  
        sseEmitters.count();  
        return ResponseEntity.ok().build();  
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
  
   
    
    @GetMapping("/send_message")
    public String send_message(String id, String message, int index_num, HttpSession session) {
    	HashMap<String, List<SseEmitter>> map = (HashMap<String, List<SseEmitter>>) session.getAttribute("list");
    	System.out.println(message);
    	System.out.println(index_num);
    	SseEmitter sse = map.get(id).get(index_num);
    	
    	return "";
    }
    
}