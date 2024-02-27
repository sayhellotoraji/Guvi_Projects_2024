package com.rajasekar_t.employee_management.model;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.web.util.pattern.PatternParseException.PatternMessage;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

// Useful in request on demand scenario
@JsonIgnoreProperties({ "hibernateLazyInitializer" })
@Entity
@Table

//@Data
public class Employee implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employee_id;

	@NotEmpty
	@Size(min = 2, max = 20, message = "First name can have 2 or more characters")
	private String first_name;

	private String middle_name;

	@NotEmpty
	@Size(min = 1, max = 1, message = "Last Name - Initial can have only 1 character")
	private String last_name;

	// Very important to overcome Unit test compilation error
//	@JsonProperty("dob")
//	@JsonFormat(pattern = "dd/MM/yyyy")
	@NotEmpty
	@Past
	private LocalDate dob;

	@NotEmpty
	private String sex;

	@NotEmpty
	@Pattern(regexp = "[6-9]{1}[0-9]{9}")
	private String mobile_no;

	@NotEmpty

	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
	private String email;

	@NotEmpty
	@Size(min = 15, max = 100, message = "Door No, Street, Area, City, State")
	private String address;

	// Very important to overcome Unit test compilation error
//	@JsonProperty("doj")
//	@JsonFormat(pattern = "dd/MM/yyyy")
	@NotEmpty
	@PastOrPresent
	private LocalDate doj;

	@NotEmpty
	private String department_name;

	@NotEmpty
	@Min(value = 300000, message = "Min Salary")
	@Max(value = 5000000, message = "Max Salary")
	private Double salary;

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getMiddle_name() {
		return middle_name;
	}

	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", first_name=" + first_name + "]";
	}

}
