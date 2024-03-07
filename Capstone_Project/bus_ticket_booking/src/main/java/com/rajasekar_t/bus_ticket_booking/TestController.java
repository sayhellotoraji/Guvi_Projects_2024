package com.rajasekar_t.bus_ticket_booking;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TestController {
	// Testing Controller working
	@GetMapping("test")
	public String testingPage(Model model) {
		model.addAttribute("name", "Raj");
		return "test";
	}

}
