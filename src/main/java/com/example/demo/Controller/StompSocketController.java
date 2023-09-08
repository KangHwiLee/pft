//package com.example.demo.Controller;
//
//import com.sun.management.OperatingSystemMXBean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.messaging.simp.broker.SimpleBrokerMessageHandler;
//import org.springframework.stereotype.Controller;
//
//import java.lang.management.ManagementFactory;
//import java.util.HashMap;
//
//@Controller
//public class StompSocketController {
//
//    @Autowired
//    private SimpMessagingTemplate simpMessagingTemplate;
//
//    @MessageMapping("/user")
//    public void test(String msg){
//        System.out.println("msg : " + msg);
//        HashMap<String, Object> payload = new HashMap<>();
//        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
//        double cpuUsage = osBean.getSystemCpuLoad() * 100;
//        payload.put("test", cpuUsage);
//        simpMessagingTemplate.convertAndSend("/topic/cpu", payload);
//    }
//}
