package com.rajasekar_t.employee_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rajasekar_t.employee_management.model.Employee;
import com.rajasekar_t.employee_management.service.EmployeeService;

// Use Controller before REST Controllers 
@Controller
public class LoginController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/log")
	public String displayLogin() {
		return "login";
	}

	
	@GetMapping("/")
	public String welcome(Model model) {
		// Transferring control from backend to frontend
		return "redirect:http://127.0.0.1:5500/html/";
	}


// Only useful for Server side rendering
//	@GetMapping("/add_employee")
//	public String addEmployeePage() {
//		return "add_employee";
//	}
//
//	@GetMapping("/update_employee")
//	public String updateEmployeePage() {
//		return "update_employee";
//	}
	
	
	/*		Important to understand working behind the scenes
	 
	 HTML form action - contains POST endpoint - http://localhost:8081/addEmployee
	 Instead of navigating to Landing page after form submission via HTML which is tedious, 

	 Better to redirect from Spring Controller
	 By Using employeeService to add the employee without unwanted url navigations
	*/
	@PostMapping("/saveEmployee")
	public String saveEmployee(Employee employee) {		
		employeeService.addEmployee(employee);

		// after saving the employee data to database, redirect to "/" - index.html
		return "redirect:http://127.0.0.1:5500/html/";
	}

	@PostMapping("/modifyEmployee")
	public String updateEmployee(@ModelAttribute("employee") Employee employee) {		
		employeeService.updateEmployee(employee);

		// after updating the employee data to database, redirect to "/" - index.html
		return "redirect:http://127.0.0.1:5500/html/";
	}
	
	@PostMapping("/delete/{empId}")
	public String deleteEmployee(@PathVariable("empId") int empId) {		
		employeeService.deleteEmployee(empId);


		// after updating the employee data to database, redirect to "/" - index.html
		return "redirect:http://127.0.0.1:5500/html/";
	}
}
