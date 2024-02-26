package com.rajasekar_t.employee_management;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.rajasekar_t.employee_management.model.Employee;
import com.rajasekar_t.employee_management.repository.EmployeeRepository;
import com.rajasekar_t.employee_management.service.EmployeeService;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

	/*
	 * EmployeeServiceTest class checks if the Service layer uses the Repository
	 * layer to retrieve the Employee records which are fetched from the database
	 */
	@InjectMocks
	private EmployeeService empService;

	// If @Mock is used, then it is mandatory to use openMocks
	@Mock
	private EmployeeRepository empRepo;

	@BeforeEach
	public void init() {
		// To enable Mockito annotations
		MockitoAnnotations.openMocks(this);

//		Create an Employee object and initialise the fields
//		when - then Return works on Optional
//		Optional<Employee> emp_optional = Optional.of(employee);
//		when(empRepo.findById(1)).thenReturn(emp_optional);
	}

	@Test
	public void getEmployees() {

		// It only checks if both the objects have returned non null values
		// Invokations on findById(1) - 3
		// Invokations on findById(2) - 1

		assertEquals(empRepo.findById(1), empRepo.findById(1));
		assertEquals(empRepo.findById(1), empRepo.findById(2));

		// System.out.println(empRepo.findById(1));

		verify(empRepo, times(3)).findById(1);
		verify(empRepo, times(1)).findById(2);

		// When the Service layer does not use the Repository layer
		// to fetch from the database
		// verifyNoInteractions(empService, empRepo);

	}

}
