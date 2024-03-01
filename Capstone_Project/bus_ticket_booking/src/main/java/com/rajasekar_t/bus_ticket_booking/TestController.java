package com.rajasekar_t.bus_ticket_booking;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("welcome")
	public String welcome() {
		return "welcome";
	}
}
