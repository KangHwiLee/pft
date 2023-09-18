package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PftController {
    @GetMapping("/pft/{project}")
    public String project(@PathVariable String project){
        return "pft/"+project;
    }
}
