package com.rajasekar_t.employee_management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rajasekar_t.employee_management.exceptions.CustomException;
import com.rajasekar_t.employee_management.model.Employee;
import com.rajasekar_t.employee_management.service.EmployeeService;

//import io.swagger.v3.oas.annotations.tags.Tag;
//@Tag(name = "Employee Controller", description = "Emp Controller API for Spring JPA")

@RestController
// Thymeleaf only works with Contoller, Not with RestController
// @RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@CrossOrigin("*")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("addEmployee")
	@ResponseStatus(HttpStatus.ACCEPTED) // Network Status Code

	// Remove @RequestBody with Employee emp - Gives an exception at Frontend
	public ResponseEntity<List<Employee>> addEmployee(Employee emp) {
		employeeService.addEmployee(emp);
		return ResponseEntity.ok().body(employeeService.findAllEmployees());
	}

	@CrossOrigin("*")
	@GetMapping("getEmployees")
	public ResponseEntity<List<Employee>> getEmployees() {
		return ResponseEntity.ok().body(employeeService.findAllEmployees());
	}

	/*
	 * Exception Handling in SpringBoot example:
	 * 
	 * getEmployeeById(int empId) method
	 * 
	 */

	@CrossOrigin("*")
	@GetMapping("getEmployee/{empId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
//	public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable("empId") int empId) {
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("empId") int empId) throws CustomException {
		Employee emp = employeeService.getEmployeeById(empId)
				.orElseThrow(() -> new CustomException("Requested Employee with EmpId: " + empId + ", Not Found"));

		return ResponseEntity.ok().body(emp);
	}

//	@GetMapping("getEmployee/{name}") - Results in Ambiguous handler exception.

	@CrossOrigin("*")
	@GetMapping("getEmployeeByName/{name}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Employee> getEmployeeByName(@PathVariable("name") String name) throws CustomException {
		Employee emp = employeeService.getEmployeeByName(name)
				.orElseThrow(() -> new CustomException("Requested Employee with Name: " + name + ", Not Found"));

		return ResponseEntity.ok().body(emp);
	}

	@CrossOrigin("*")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("updateEmployee")
	@ResponseStatus(HttpStatus.NO_CONTENT) // Just for Checking in Network responses
	public ResponseEntity<List<Employee>> updateEmployee(@RequestBody Employee emp) {
		employeeService.updateEmployee(emp);
		return ResponseEntity.ok().body(employeeService.findAllEmployees());
	}

	@CrossOrigin("*")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("deleteEmployee/{empId}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public ResponseEntity<List<Employee>> deleteEmployee(@PathVariable("empId") int empId) {
		employeeService.deleteEmployee(empId);
		return ResponseEntity.ok().body(employeeService.findAllEmployees());
	}

	@CrossOrigin("*")
	@GetMapping("search")
	@ResponseStatus(HttpStatus.NO_CONTENT) // Just for Checking in Network responses
	public ResponseEntity<Employee> getEmployeeQuery(@RequestParam("empId") int empId) {
		return ResponseEntity.ok().body(employeeService.findAllEmployees().get(empId));
	}

}