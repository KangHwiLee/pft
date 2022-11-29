package com.example.demo;
import java.io.IOException;
import java.util.HashMap;

import lombok.extern.slf4j.Slf4j;  
import org.springframework.http.MediaType;  
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
  
    @GetMapping(value = "/connect/{num}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)  
    public ResponseEntity<SseEmitter> connect(@PathVariable int num) {  
        SseEmitter emitter = new SseEmitter();  
        HashMap<Integer, emitter> map = new HashMap<Integer, emitter>();
        sseEmitters.add(emitter);
        try {  
            emitter.send(SseEmitter.event()  
                    .name("connect")  
                    .data("connected!"));  
        } catch (IOException e) {  
            throw new RuntimeException(e);  
        }  
        return ResponseEntity.ok(emitter);  
    }  
    
    @PostMapping("/count")  
    public ResponseEntity<Void> count(String test) {  
        sseEmitters.count(test);  
        return ResponseEntity.ok().build();  
    }  
}