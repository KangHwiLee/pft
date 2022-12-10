package com.example.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import common.KOSPI;

@Controller
public class NewHomeController {
	
	private KOSPI kospiController;
	
	public NewHomeController(KOSPI kospiController) {
		this.kospiController = kospiController;
	}
	
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
			return "base/gis";
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
	
	@GetMapping("/chartData")
	@ResponseBody
	public List<String> chartData(String kospi, String kosdaq){
		List<String> list = new ArrayList<>();
		List<JSONObject> list1 = null;
		List<JSONObject> list2 = null;
		try {
			list1 = kospiController.chart_data(kospi);
			list2 = kospiController.chart_data(kosdaq);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String test1 = list1.toString().substring(1, list1.toString().length()-1);
		list.add(test1);
		System.out.println(test1);
		System.out.println(list.toString());
		return list;
	}
}
