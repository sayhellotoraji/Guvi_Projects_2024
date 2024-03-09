package com.rajasekar_t.doctor_patient_portal.configuration;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.rajasekar_t.doctor_patient_portal.model.Doctor;
import com.rajasekar_t.doctor_patient_portal.model.Patient;
import com.rajasekar_t.doctor_patient_portal.repository.DoctorRepository;
import com.rajasekar_t.doctor_patient_portal.repository.PatientRepository;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	// Adding Doctor and Patient Credentials
	@Autowired
	DoctorRepository docRepo;
	
	@Autowired
	PatientRepository patRepo;
	
	
	// 1. Authentication
	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder encoder) {

		// For Testing Purpose
		
		// 1 Admin
		UserDetails admin = User.withUsername("Raja")
				.password(encoder.encode("JFSWD2"))
				.roles("ADMIN")
				.build();
		
		// 2. User
		UserDetails user = User.withUsername("Mohan")
				.password(encoder.encode("Agri"))
				.roles("USER")
				.build();
		
		
		// Actual User Credentials
		// Adding Doctor & Login Credentials
		List<Doctor> docs = docRepo.findAll();
		List<Patient> pats = patRepo.findAll();
		
		List<UserDetails> doctors = new ArrayList<>();
		List<UserDetails> patients = new ArrayList<>();
		
		// 3. Doctors	
		for(Doctor doc: docs) {
			doctors.add(User.withUsername(doc.getEmail())
			.password(encoder.encode(doc.getLogin_password()))
			.roles("USER")
			.build()
			);
		}
		
		
		// 4. Patients
		
		for(Patient pat: pats) {
			patients.add(User.withUsername(pat.getEmail())
			.password(encoder.encode(pat.getLogin_password()))
			.roles("USER")
			.build()
			);
		}
		
		// Combining doctors and patients as a single list
		// To be used as a single input InMemoryUserDetailsManager
		Collection<UserDetails> allUsers = new ArrayList<>();
		allUsers.addAll(doctors);
		allUsers.addAll(patients);
		
		
		// Check method arguments - ... operator
		// Either use this or below method for list of values
		// return new InMemoryUserDetailsManager(admin, user);
		
		return new InMemoryUserDetailsManager(allUsers);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	// 2. Authorization
	// Remember @Bean annotations is very important
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
//		 csrf() deprecated - switch to Http Lambda Syntax DSL

		
		
//		 Case 0 - Basic http build 
//		 1. csrf - disable
//		 2. formLogin - default login page
	    return http.csrf(csrf -> csrf.disable())
	    		.formLogin(withDefaults())
	    		.build();		
		
	    
	    
//		Case 1 - Permit All
//	    http.authorizeHttpRequests(authorizeRequests -> authorizeRequests.anyRequest()
//			.permitAll())
//	    	.csrf(AbstractHttpConfigurer::disable);
//	   	return http.build();
		

	   

//	    Case 2 - 
//		1. AstractHttpConfigurer
//		2. httpBasic
//		3. formLogin
//		http
//      	.authorizeHttpRequests(requests -> requests.requestMatchers("/**").permitAll())
//          .authorizeHttpRequests(requests -> requests.requestMatchers("/**").hasRole("ADMIN")
//          .anyRequest().authenticated())
//          .httpBasic(withDefaults())
//          .formLogin(withDefaults())
//          .csrf(AbstractHttpConfigurer::disable);	
//     	return http.build();
		
		

//	    In POSTMAN -> Authorisation -> Basic Auth -> Enter credentials -> Make request using POSTMAN


		


		

	}

}