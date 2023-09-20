package com.example.demo.Controller;

import com.example.demo.security.MemberRepository;
import com.example.demo.security.user;
import com.sun.management.OperatingSystemMXBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.management.ManagementFactory;
import java.util.HashMap;

@Controller
public class MainController {


    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    MemberRepository memberRepository;
    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/login")
    public String test(){
        return "login";
    }


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

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String register(user user){
        String encodePassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        user.setEnabled(true);
        user.setRole("user");
        memberRepository.save(user);
        return "redirect:/";
    }

}
