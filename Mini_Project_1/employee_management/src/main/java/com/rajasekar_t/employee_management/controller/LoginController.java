package com.rajasekar_t.employee_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/log")
	public String displayLogin() {
		return "login";
	}
	
	@GetMapping("/index")
	public String welcome() {
		return "index";
	}
	
	@GetMapping("/add_employee")
	public String addEmployeePage() {
		return "add_employee";
	}
	
	@GetMapping("/update_employee")
	public String updateEmployeePage() {
		return "update_employee";
	}
}
