package com.rajasekar_t.employee_management.configuration;

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

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

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
		
		return new InMemoryUserDetailsManager(admin, user);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	// 2. Authorization
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		// csrf() method has been deprecated from version 6.1 - For Reference
		// Switch to Http Lambda Syntax DSL
		
		return http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(requests -> requests.requestMatchers("/employee/welcome").permitAll())
                .authorizeHttpRequests(requests -> requests.requestMatchers("/employee/**").hasRole("ADMIN")
                .anyRequest().authenticated())
                .formLogin(withDefaults())
                .build();
	}

}
