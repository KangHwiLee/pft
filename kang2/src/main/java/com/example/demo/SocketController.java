package com.example.demo;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import common.CommonService;

@Controller
public class SocketController {
	
	@Autowired private CommonService common;
	
	
	@GetMapping("/socket_start")
	@ResponseBody
	public String socket_start(String test, String test2) throws IOException, Exception {
		
		int num = 1;
		common.cctv_start(num);
		return "success";
	}
}
