package com.rajasekar_t.doctor_patient_portal.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

//Useful in request on demand scenario
@JsonIgnoreProperties({ "hibernateLazyInitializer" })
@Entity
@Table
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int doctor_id;

	@NotEmpty
	@Size(min = 2, max = 24, message = "Doctor name can have 2 or more characters")
	private String doctor_name;

	@NotEmpty
	@Past
	private LocalDate dob;

	@NotEmpty
	private String specialization;
	
	@NotEmpty
	private String sex;

	@NotEmpty
	@Pattern(regexp = "[6-9]{1}[0-9]{9}")
	private String mobile_no;

	@NotEmpty
	@Size(min = 15, max = 100, message = "Door No, Street, Area, City, State")
	private String address;

	@NotEmpty
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
	private String email;

	@NotEmpty
	private String login_password;
}
