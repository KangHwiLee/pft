package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.demo, contant, common")
public class KangApplication {

	public static void main(String[] args) {
		SpringApplication.run(KangApplication.class, args);
	}

}
