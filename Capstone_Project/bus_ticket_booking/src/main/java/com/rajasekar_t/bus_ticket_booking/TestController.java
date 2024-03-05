package com.rajasekar_t.bus_ticket_booking;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	// Testing controller working
	@GetMapping("welcome")
	public String welcome() {
		return "welcome Rajasekar T";
	}
}
