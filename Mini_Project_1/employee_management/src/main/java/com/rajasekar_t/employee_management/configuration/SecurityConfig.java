package com.rajasekar_t.employee_management.configuration;

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
