package com.example.demo.Controller;

import antlr.Token;
import com.example.demo.entity.Member;
import com.example.demo.entity.MemberLoginRequestDto;
import com.example.demo.jwt.TokenInfo;
import com.example.demo.security.MemberRepository;
import com.example.demo.security.MemberService;
import com.sun.management.OperatingSystemMXBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.management.ManagementFactory;
import java.util.Arrays;
import java.util.HashMap;

@Controller
public class MainController {


    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    MemberRepository memberRepository;
    @Autowired private MemberService memberService;
    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/login")
    public String test(){
        return "login";
    }

    @PostMapping("/login")
    public ResponseEntity<TokenInfo> login(MemberLoginRequestDto memberLoginRequestDto) {
        String memberId = memberLoginRequestDto.getMemberId();
        String password = memberLoginRequestDto.getPassword();
        System.out.println("3");
        TokenInfo tokenInfo = memberService.login(memberId, password);
        System.out.println("4");
        System.out.println(tokenInfo);
        return ResponseEntity.ok(tokenInfo);
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
    public String register(Member member){
        System.out.println("register");
        String encodePassword = passwordEncoder.encode(member.getPassword());
        member.setPassword(encodePassword);
        member.getRoles().add("USER");
        memberRepository.save(member);
        return "redirect:/";
    }

}
