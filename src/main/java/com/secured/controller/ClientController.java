package com.secured.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientController {

	@GetMapping("/loginform")
	public String admin() {
		return "adminLogin";
	}

//	@GetMapping("user1")
//	public String user() {
//		return clientService.user();
//	}
}
