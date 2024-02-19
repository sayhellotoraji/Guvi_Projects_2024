package com.rajasekar_t.employee_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.rajasekar_t.employee_management.service.EmployeeService;

@Controller
public class LoginController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/log")
	public String displayLogin() {
		return "login";
	}
	
	@GetMapping("/index")
	public String welcome(Model model) {
		model.addAttribute("listEmployees", employeeService.findAllEmployees());
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
