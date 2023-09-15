package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping("/board")
    public String board(){
        return "board";
    }
    @GetMapping("/board/write")
    public String write(){
        return "board/write";
    }
}
