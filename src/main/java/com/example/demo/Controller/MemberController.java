package com.example.demo.Controller;

import com.example.demo.entity.MemberLoginRequestDto;
import com.example.demo.jwt.TokenInfo;
import com.example.demo.security.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberController {


    @ResponseBody
    @PostMapping("/test")
    public String test() {
        return "success";
    }
}