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

import common.CommonService;
import common.Criteria;
import common.PageVO;
import contant.ContantServiceImpl;
import contant.ContantVO;

@Controller
public class ContantController {

	@Autowired private ContantServiceImpl contant;
	@Autowired private CommonService common;
	
	@RequestMapping("/test_submit")
	public String test_submit(ContantVO vo) {
		contant.contant_update(vo);
		return "redirect:/";
	}
	
	@ResponseBody @GetMapping("/contant_list.do")
	public List<ContantVO> contant_list(){
		List<ContantVO> vo = contant.contant_list();
		return vo;
	}
	
	@RequestMapping("/contant_detail")
	public String contant_detail(int num, Model model) {
		System.out.println("contant_detail 컨트롤러 접속");
		ContantVO vo = contant.contant_detail(num);
		model.addAttribute("vo", vo);
		return "contant/contant1";
	}
	
	@GetMapping("pg_table_load")
	public String pg_table_load(Model model) {
		return "paging_test/paging_table";
	}
	
	@ResponseBody @PostMapping("add_paging_contant")
	public String add_paging_contant(Model model) {
		contant.add_paging_contant();
		return "success";
	}
	
	@ResponseBody @GetMapping("/paging_button")
	public HashMap<String, Integer> paging_button(int now_page, int status) {
			int total = contant.paging_total();
			int count = 5;
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			HashMap<String, Integer> page = new HashMap<String, Integer>();
			map.put("total", total);
			map.put("count", count);
			map.put("now_page", now_page);
			map.put("status", status);
			page = common.paging(map);
			System.out.println(" ?? " + page.get("end"));
			return page;
	}
	
	@ResponseBody @GetMapping("/paging_test")
	public PageVO paging_test(Criteria cri) {
		int total = contant.paging_total();
		if(cri.getPageNum() == 0) {
			cri.setPageNum((int) Math.ceil((total * 1.0) / cri.getAmount()));
		}
		PageVO vo = new PageVO(cri, total);
		return vo;
	}
	
	@GetMapping("paging_contant_load")
	public String paging_contant_load(int num, Model model) {
		num = num * 5;
		List<ContantVO> list = contant.paging_contant_load(num);
		model.addAttribute("list", list);
		return "paging_test/paging_table";
	}
}
