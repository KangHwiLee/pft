//package com.example.demo.Service;
//
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Service;
//import com.sun.management.OperatingSystemMXBean;
//import java.lang.management.ManagementFactory;
//
//
//@Service
//public class CPUMonitorService {
//    private final SimpMessagingTemplate messagingTemplate;
//
//    public CPUMonitorService(SimpMessagingTemplate messagingTemplate) {
//        this.messagingTemplate = messagingTemplate;
//    }
//
//    @Scheduled(fixedRate = 1000)
//    public void sendCPUUsage() {
//        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
//        double cpuUsage = osBean.getSystemCpuLoad() * 100;
//        messagingTemplate.convertAndSend("/topic/cpu", cpuUsage);
//    }
//}
