package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@GetMapping("/main_body")
	public String body_sample() {
		return "base/main_body";
	}

	@GetMapping("/stack_menu_move")
	public String stack_menu_move(int num) {
		if(num == 1) {
			return "base/accordion";
		}else if(num == 2) {
			return "stack/paging";
		}else if(num == 3) {
			
		}else if(num == 4) {
			
		}else if(num == 5) {
			
		}else if(num == 6) {
			
		}else if(num == 7) {
			
		}else if(num == 8) {
			
		}else if(num == 9) {
			
		}else if(num == 10) {
			
		}else if(num == 11) {
			
		}
		return "";
	}
	
	@GetMapping("/chart_menu_move")
	public String chart_menu_move(int num) {
		if(num == 1) {
			return "chartjs/bar_chart";
		}else if(num == 2) {
			return "chartjs/line_chart";
		}else if(num == 3) {
			
		}else if(num == 4) {
			
		}else if(num == 5) {
			
		}else if(num == 6) {
			
		}
		return "";
	}

	@PostMapping("/chart_menu_move")
	public String chart_text_get(int num) {
		if(num == 1) {
			return "chartjs/bar_chart";
		}else if(num == 2) {
			return "chartjs/line_chart";
		}else if(num == 3) {
			
		}else if(num == 4) {
			
		}else if(num == 5) {
			
		}else if(num == 6) {
			
		}
		return "";
	}
	
	@GetMapping("/tistory")
	public String tistory() {
		return "base/tistory";
	}
	
}
