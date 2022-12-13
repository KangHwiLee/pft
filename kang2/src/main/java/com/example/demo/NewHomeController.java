package com.example.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@GetMapping("/new_main")
	public String new_main() {
		return "new_main";
	}
	
	@GetMapping("/code_mirror_area")
	public String code_mirror_area(String data, Model model) {
		model.addAttribute("data", data);
		return "base/codemirror_area";
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
			return "chartjs/kospi_chart";
		}else if(num == 4) {
			
		}else if(num == 5) {
			
		}else if(num == 6) {
			
		}
		return "";
	}

	@PostMapping("/chart_menu_move")
	public String chart_text_get(int num) {
		System.out.println(num);
		if(num == 1) {
			return "chartjs/bar_chart";
		}else if(num == 2) {
			return "chartjs/line_chart";
		}else if(num == 3) {
			return "chartjs/kospi_chart";
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
	public List<HashMap<String, String>> chartData(String name){
		List<HashMap<String, String>> list = new ArrayList<>();
		List<JSONObject> list1 = null;
		try {
			list1 = kospiController.chart_data(name);
			for(int i=0; i<list1.size(); i++) {
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("clpr", list1.get(i).getString("clpr"));
				map.put("baseDt", list1.get(i).getString("baseDt"));
				map.put("fltRt", list1.get(i).getString("fltRt"));
				map.put("vs", list1.get(i).getString("vs"));
				list.add(map);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//String test1 = list1.toString().substring(1, list1.toString().length()-1);
		//String test2 = list2.toString().substring(1, list2.toString().length()-1);
		//System.out.println(test1);
		return list;
	}
}
