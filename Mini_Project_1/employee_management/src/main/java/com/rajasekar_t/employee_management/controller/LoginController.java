package com.rajasekar_t.employee_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/welcome")
	public String displayLogin() {
		return "login";
	}
}
