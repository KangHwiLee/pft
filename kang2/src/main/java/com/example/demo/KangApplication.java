package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@SpringBootApplication(scanBasePackages = "com.example.demo, content, common, chat, config, model")
public class KangApplication {

	public static void main(String[] args) {
		SpringApplication.run(KangApplication.class, args);
	}
	
	@Bean
	public ServerEndpointExporter serverEndpointExporter() {
		  return new ServerEndpointExporter();
		}

}
