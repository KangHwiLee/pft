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
        return "index";
    }
    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @ResponseBody
    @PostMapping("/chart_data")
    public HashMap<String, Object> chart_data(){
        HashMap<String, Object> map = new HashMap<>();
        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
        double cpuUsage = osBean.getSystemCpuLoad() * 100;
        map.put("chart1" , cpuUsage);
        return map;
    }

}
