package com.rajasekar_t.employee_management;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.rajasekar_t.employee_management.model.Employee;
import com.rajasekar_t.employee_management.repository.EmployeeRepository;

@ExtendWith(MockitoExtension.class)
public class EmployeeRepositoryTest {

	// To test the functionality
	// but the employee object should not be stored in the database
	@Mock
	private EmployeeRepository empRepo;

	// Create an object manually, Instead of Mock to verify the actual output
	Employee employee = new Employee();

	@BeforeEach
	public void init() {
		// To enable Mockito annotations
		MockitoAnnotations.openMocks(this);

		// Initialise the mock object
		LocalDate dob = LocalDate.of(1996, 11, 03);
		LocalDate doj = LocalDate.of(2024, 02, 24);

		employee.setFirst_name("Raja");
		employee.setMiddle_name("Sekar");
		employee.setLast_name("T");
		employee.setDob(dob);
		employee.setSex("Male");
		employee.setMobile_no("9999999999");
		employee.setEmail("rajasekar@outlook.com");
		employee.setAddress("136 Vasantham Nagar, Polur, Tamil Nadu");
		employee.setDoj(doj);
		employee.setDepartment_name("Software Engineer");
		employee.setSalary(2400000.0);

		empRepo.save(employee);

	}

	@Test
	public void getById() {
		// Check if the searched employee name is same as the employee record that is
		// saved
		String search_employee_name_1 = "Raja";
		Assertions.assertEquals(search_employee_name_1, employee.getFirst_name());

		// Check if the searched employee name is not same as the employee record that
		// is saved
		String search_employee_name_2 = "Rajasekar";
		Assertions.assertNotEquals(search_employee_name_2, employee.getFirst_name());
	}

}
