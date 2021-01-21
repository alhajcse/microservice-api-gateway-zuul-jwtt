package com.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@GetMapping("/user")
	public String hello() {
      System.out.println("Hello User");
		return "Hello Dude !! Its User Service ";
	}
}
