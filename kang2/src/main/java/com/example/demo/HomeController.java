package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String main() {
		return "new_portfolio";
	}
	
	@GetMapping("/side_include")
	public String side_include() {
		return "common/side_menu";
	}
	
	@GetMapping("/content")
	public String content() {
		return "content_";
	}
	
	@GetMapping("/gis")
	public String gis() {
		return "gis";
	}
	
	@GetMapping("/chat")
	public String chat() {
		return "chat";
	}
	@GetMapping("/content_write")
	public String content_write() {
		return "content/content_write";
	}
	
	@GetMapping("/menu_move")
	public String menu_move(int num) {
		if(num == 1) {
			return "main";
		}else if(num == 2) {
			return "content_";
		}else if(num == 3) {
			return "gis";
		}else if(num == 4) {
			return "chat";
		}else if(num == 5) {
			return "socket/socket_test";
		}else if(num == 6) {
			return "sse_test";
		}else if(num == 7){
			return "paging";
		}else{
			return null;
		}
	}
	
	@GetMapping("/new_portfolio")
	public String new_portfolio() {
		return "new_portfolio";
	}
	@GetMapping("/new_pft_project")
	public String new_pft_project() {
		return "new_pft_project/new_pft_project";
	}
	
}
