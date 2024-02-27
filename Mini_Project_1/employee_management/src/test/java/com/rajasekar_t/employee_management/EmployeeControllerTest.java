package com.rajasekar_t.employee_management;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rajasekar_t.employee_management.controller.EmployeeController;
import com.rajasekar_t.employee_management.model.Employee;
import com.rajasekar_t.employee_management.service.EmployeeService;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EmployeeService empService;

	// Create an Object manually
	private Employee employee = new Employee();

	private ArrayList<Employee> list_of_employees = new ArrayList<>();

	@BeforeEach
	public void setup() throws Exception {

	}

	@Test
	@WithMockUser(username = "Rajasekar", roles = { "Admin" })
	// 1. Add Security-test dependency
	// 2. Create a mock user to access via Security Test
	public void getEmployees() throws Exception {
		// mockMvc implementation
		mockMvc.perform(MockMvcRequestBuilders.get("/getEmployees")).andDo(print())
				.andExpect(MockMvcResultMatchers.status().isOk());

	}

}






//			Yet to test - For Future Use

//	// Added jackson date dependency: jackson-datatype-jsr310
//	@Test
//	@WithMockUser(username = "Rajasekar", roles = { "Admin" }) // Create a mock user to access via Security
//	public void addEmployee() throws Exception {
//
//		Employee employeeEntity = new Employee();
//		// Initialise the manually created mock object
//		LocalDate dob = LocalDate.of(1996, 11, 03);
//		LocalDate doj = LocalDate.of(2024, 02, 24);
//
//		employee.setEmployee_id(1);
//		employee.setFirst_name("Raja");
//		employee.setMiddle_name("Sekar");
//		employee.setLast_name("T");
//		employee.setDob(dob);
//		employee.setSex("Male");
//		employee.setMobile_no("9999999999");
//		employee.setEmail("rajasekar@outlook.com");
//		employee.setAddress("136 Vasantham Nagar, Polur, Tamil Nadu");
//		employee.setDoj(doj);
//		employee.setDepartment_name("Software Engineer");
//		employee.setSalary(2400000.0);
//
////		when(empService.addEmployee(employeeEntity)).thenReturn(list_of_employees);
//
//		// mockMvc implementation
//		// Add static import to csrf() & place it within the perform()
//		mockMvc.perform(
//					MockMvcRequestBuilders.post("/addEmployee")
//					.with(csrf())
//					.content(asJsonString(employee))
//					.contentType(MediaType.APPLICATION_JSON)
//					.accept(MediaType.APPLICATION_JSON)
//					)
//				.andDo(print())
//				.andExpect(MockMvcResultMatchers.status().isOk());
//	}
//
//	public static String asJsonString(final Object obj) {
//	    try {
//	        return new ObjectMapper().writeValueAsString(obj);
//	    } catch (Exception e) {
//	        throw new RuntimeException(e);        
//	    }
//	}
//	    
//} 
//
//	@Test
//	@WithMockUser(username = "Rajasekar", roles = { "Admin" }) // Create a mock user to access via Security
//	public void deleteEmployeeAPI() throws Exception {
//		Employee employeeEntity = new Employee();
//		when(empService.addEmployee(employeeEntity)).thenReturn(list_of_employees);
//		mockMvc.perform(MockMvcRequestBuilders.delete("/deleteEmployee/{id}", 1))
//				.andExpect(MockMvcResultMatchers.status().isAccepted());
//	}
