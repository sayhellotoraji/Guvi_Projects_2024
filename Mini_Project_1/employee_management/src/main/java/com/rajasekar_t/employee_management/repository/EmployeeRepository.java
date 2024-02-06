package com.rajasekar_t.employee_management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rajasekar_t.employee_management.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// Custom query needs to be specifed here.

	@Query("from Employee where first_name =:first_name")
	public Optional<Employee> getEmployeeByName(@Param("first_name") String first_name);
}
