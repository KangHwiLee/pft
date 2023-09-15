package com.example.demo.Controller;

import com.sun.management.OperatingSystemMXBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.management.ManagementFactory;
import java.util.HashMap;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(){
        System.out.println("test1");
        return "index";
    }

//    @GetMapping("/")
//    public String home(){
//        System.out.println("test");
//        return "index";
//    }

    @ResponseBody
    @PostMapping("/chart_data")
    public HashMap<String, Object> chart_data(){
        HashMap<String, Object> map = new HashMap<>();
        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
        double cpuUsage = osBean.getSystemCpuLoad() * 100;
        Runtime.getRuntime().gc();
        long usedMemory = Runtime.getRuntime().freeMemory() * 100 / Runtime.getRuntime().totalMemory();
        map.put("chart1" , (int) cpuUsage);
        map.put("chart2" , usedMemory);
        return map;
    }



}
