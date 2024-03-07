package com.rajasekar_t.bus_ticket_booking;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {
	// Testing RestController working
	@GetMapping("welcome")
	public String welcome() {
		return "Welcome Rajasekar T";
	}
}
