package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String main() {
		return "redirect:/menu_move?num=1";
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
	
	@GetMapping("/chat")
	public String chat() {
		return "chat";
	}
	@GetMapping("/content_write")
	public String content_write() {
		return "content/content_write";
	}
	
	@GetMapping("/chat2")
	public String chat2() {
		return "chat2";
	}
	@GetMapping("/final_chat")
	public String final_chat() {
		return "final_chat";
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
		}else {
			return null;
		}
	}
	
}
