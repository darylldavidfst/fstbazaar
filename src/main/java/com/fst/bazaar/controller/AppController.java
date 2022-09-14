package com.fst.bazaar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

	@GetMapping("/")
	public String root() {
		return "home";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
}
