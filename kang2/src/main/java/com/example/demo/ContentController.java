package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import content.ContentVO;

@Controller
public class ContentController {
		
	@GetMapping(value="content_form.do")
	public String content_form(ContentVO vo) {
		System.out.println(vo);
		return "";
	}
	
}
