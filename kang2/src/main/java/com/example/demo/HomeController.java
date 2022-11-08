package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/jsp")
	public String home() {
		System.out.println("되나");
		return "index";
	}
	
	
	@RequestMapping("/")
	public String main() {
		return "main";
	}
	
	@RequestMapping("/write_move")
	public String write_move() {
		return "common/write";
	}
	
	@GetMapping("/test")
	public String test() {
		return "test";
	}
	
	@GetMapping("/ppt")
	public String ppt() {
		return "ppt";
	}
	
	@GetMapping("/ppt_contant_test")
	public String ppt_contant_test() {
		return "ppt_contant/contant_list";
	}
	
}
