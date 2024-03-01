package com.rajasekar_t.doctor_patient_portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// To remove HateOAS embedded property in Json Response - Not working
// Spring Data Rest Without HATEOAS - exclude RepositoryRestMvcAutoConfiguration
// @SpringBootApplication(exclude = RepositoryRestMvcAutoConfiguration.class)

@SpringBootApplication
public class DoctorPatientPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorPatientPortalApplication.class, args);
	}

}
