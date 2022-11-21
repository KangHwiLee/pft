package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String main() {
		return "main";
	}
	
	@GetMapping("/side_include")
	public String side_include() {
		return "common/side_menu";
	}
	
	@GetMapping("/content_list")
	public String content_list() {
		return "content/content_list";
	}
	
	@GetMapping("/content")
	public String content() {
		return "content_";
	}
	
	@GetMapping("/gis")
	public String gis() {
		return "gis";
	}
	
}
