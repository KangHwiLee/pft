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
    
    @GetMapping(value = "/notice_first_connection")  
    @ResponseBody
    public int notice_first_connection(HttpSession session) {
    	
    	int count = sseEmitters.emitter_check();
    	if(count > 5){
    		sseEmitters.remove_first();
    	}
    	int num = 0;
    	return num;  
    }
    
    @GetMapping(value = "/notice_first", produces = MediaType.TEXT_EVENT_STREAM_VALUE)  
    @ResponseBody
    public ResponseEntity<SseEmitter> notice(HttpSession session) {
    	
    	SseEmitter emitter = (SseEmitter) session.getAttribute("emitter");
    	System.out.println(emitter);
    	
    		emitter = new SseEmitter(60 * 1000L);
    		session.setAttribute("emitter", emitter);
    		sseEmitters.add(emitter);
    		
    	try {  
            emitter.send(SseEmitter.event()  
                    .name("notice_start")  
                    .data("sse_test start."));  
        } catch (IOException e) {  
            throw new RuntimeException(e);  
        }
    	return ResponseEntity.ok(emitter);  
    }
    
    @RequestMapping(value="/n_notice", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseBody
    public ResponseBodyEmitter n_notice(HttpSession session) {
              SseEmitter emitter = (SseEmitter) session.getAttribute("emitter");
              // Pass the emitter to another component...
              return sseEmitters.emitter_test(emitter);  
    }
    
    @GetMapping("/notice_write")
    public String notice_write(String text) {
    	sseEmitters.notice_write(text);
    	return null;
    }
    
    
    
}