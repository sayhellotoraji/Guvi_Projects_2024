package com.rajasekar_t.bus_ticket_booking.configuration;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.rajasekar_t.bus_ticket_booking.model.Passenger;
import com.rajasekar_t.bus_ticket_booking.repository.PassengerRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	// Adding Doctor and Patient Credentials
	@Autowired
	PassengerRepository passRepo;

	// 1. Authentication
	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder encoder) {

		// For Testing Purpose

		// 1 Admin
		UserDetails admin = User.withUsername("Raja").password(encoder.encode("JFSWD2")).roles("ADMIN").build();

		// 2. User
		UserDetails user = User.withUsername("Mohan").password(encoder.encode("Agri")).roles("USER").build();

		// Actual User Credentials
		// Adding Passengers
		List<Passenger> passengers = passRepo.findAll();

		// List to store UserDetails
		List<UserDetails> allUsers = new ArrayList<>();

		// 3. Passengers
		// Adding passengers email & password to UserDetails - allUsers
		for (Passenger p : passengers) {
			allUsers.add(User.withUsername(p.getEmail()).password(encoder.encode(p.getLogin_password())).roles("USER")
					.build());
		}

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
		return http.csrf(csrf -> csrf.disable()).formLogin(withDefaults()).build();

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