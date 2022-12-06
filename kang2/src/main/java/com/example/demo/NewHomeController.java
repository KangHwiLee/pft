package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewHomeController {

	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/header")
	public String header() {
		return "new_pft/header";
	}
	
	@GetMapping("/test_include")
	public String body_sample() {
		return "new_pft/body_sample";
	}
	@GetMapping("/accordion")
	public String accordion() {
		return "base/accordion";
	}
	
}
