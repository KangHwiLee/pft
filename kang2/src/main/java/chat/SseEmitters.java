package chat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import lombok.extern.slf4j.Slf4j;

@Component  
@Slf4j  
public class SseEmitters {  
  
    private final List<SseEmitter> emitters = new ArrayList<>();  
    private static final AtomicLong counter = new AtomicLong();  
    
    public void remove_first() {
    	this.emitters.remove(0);
    }
    
    public int emitter_check() {
    	return this.emitters.size();
    }
    
    public SseEmitter add(SseEmitter emitter) {  
        this.emitters.add(emitter);  
        log.info("new emitter added: {}", emitter);  
        log.info("emitter list size: {}", emitters.size());  
        emitter.onCompletion(() -> {  
            log.info("onCompletion callback");  
            this.emitters.remove(emitter);    // 만료되면 리스트에서 삭제
        });  
        emitter.onTimeout(() -> {  
            log.info("onTimeout callback");  
            emitter.complete();  
        });  
  
        return emitter;  
    }  
  
    
    public SseEmitter emitter_test(SseEmitter emitter) {
    	
    	return this.emitters.get(0);
    	
    }
    
    public void count() {  
        long count = counter.incrementAndGet();  
        emitters.forEach(emitter -> {  
            try {  
                emitter.send(SseEmitter.event()  
                        .name("count")  
                        .data(count));  
            } catch (IOException e) {  
                throw new RuntimeException(e);  
            }  
        });  
    }
    
    public void notice_write(String text) {
    	  emitters.forEach(emitter -> {  
              try {  
            	  emitter.send(SseEmitter.event()
          				.name("notice_write")
          				.data(text));
              } catch (IOException e) {  
                  throw new RuntimeException(e);  
              }  
          });  
    }
    
}