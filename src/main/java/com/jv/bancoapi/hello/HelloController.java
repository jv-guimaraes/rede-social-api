package com.jv.bancoapi.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping("/hello")
	public String sayHello() {
		return "Hello! Welcome to my API.";
	}
	
	@RequestMapping("/")
	public String sayEmpty() {
		return "Empty request...";
	}
}
