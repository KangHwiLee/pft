package com.example.demo;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import content.ContentServiceImpl;
import content.ContentVO;

@Controller
public class ContentController {
		
	@Autowired ContentServiceImpl content;
	
	@PostMapping(value="content_form.do")
	public String content_form(ContentVO vo) {
		System.out.println(vo);
		content.content_form(vo);
		return "redirect:/menu_move?num=2";
	}
	
	@GetMapping("/content_list")
	public String content_list(int num, Model model) {
		List<ContentVO> list = content.content_list(num);
		model.addAttribute("list", list);
		return "content/content_list";
	}
	
	@GetMapping("/content_total")
	@ResponseBody
	public int content_total() {
		int total = content.content_total();
		return total;
	}
}
