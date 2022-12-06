package com.example.demo;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import common.Criteria;
import common.PageVO;
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
	
	@GetMapping("/paging_table")
	public String paging_talbe(int num, int amount, Model model) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("amount", amount);
		num = num*amount;
		int end = num+amount-1;
		map.put("num", num);
		int total = content.content_total();
		List<ContentVO> list = content.paging_table(map);
		if(num +amount-1 >= total) end=total-1;
		System.out.println("end : " + end);
		model.addAttribute("start",num);
		model.addAttribute("end", end);
		model.addAttribute("list", list);
		return "paging/paging_table";
	}
	
	@ResponseBody @GetMapping("/paging")
	public PageVO authority_paging_one(Criteria cri) {
		int total = content.content_total();
		if(cri.getPageNum() == 0) {
			cri.setPageNum((int) Math.ceil((total * 1.0) / cri.getAmount()));
		}
		PageVO vo = new PageVO(cri, total);
		return vo;
	}
}
