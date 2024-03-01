package com.rajasekar_t.doctor_patient_portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


// Testing thymeleaf with hello.html file in templates folder
@Controller
public class ThymeLeafTestController {

	@GetMapping({ "/{name}"})
	public String hello(@PathVariable("name") String name, Model model) {
		
		model.addAttribute("name", name);
		return "hello";

	}

}
