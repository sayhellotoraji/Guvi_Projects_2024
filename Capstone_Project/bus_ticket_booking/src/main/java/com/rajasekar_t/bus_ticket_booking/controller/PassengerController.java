package com.rajasekar_t.bus_ticket_booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rajasekar_t.bus_ticket_booking.model.Passenger;
import com.rajasekar_t.bus_ticket_booking.repository.PassengerRepository;

@Controller
@RequestMapping("passenger")
public class PassengerController {

	@Autowired
	PassengerRepository passRepo;

	// **************************************************************
	// Registration controllers

	@GetMapping({ "register" })
	public String register(Model model) {
		model.addAttribute("passengerForm", new Passenger());
		return "register";
	}

	@PostMapping({ "register/save" })
	public String postRegister(@ModelAttribute Passenger passenger, Model model) {
		passRepo.save(passenger);
		return "redirect:/passenger/login";
	}

	// **********************************************************
	// Login Controllers

	// Need to implement login features
	@GetMapping({ "login" })
	public String login() {
		return "login";
	}

	// Post mapping for submitting login credentials
	// Implement Here

	// Home page - Patient
	@GetMapping({ "welcome/{passengerId}" })
	public String welcome(@PathVariable("passengerId") int passengerId, Model model) {
		String name = passRepo.findById(passengerId).get().getPassengerName();
		model.addAttribute("id", passengerId);
		model.addAttribute("name", name);
		return "welcome";
	}

	// **********************************************************
	// Profile Update Controllers

	@GetMapping({ "modifyprofile/{passengerId}" })
	public String getPrescriptionModify(@PathVariable("passengerId") int passengerId, Model model) {
		// int id = passRepo.findById(passengerId).get().getPassengerId();
		String name = passRepo.findById(passengerId).get().getPassengerName();
		model.addAttribute("id", passengerId);
		model.addAttribute("name", name);

		Passenger passenger = passRepo.findById(passengerId).get();
		passenger.setPassengerName(passenger.getPassengerName());
		passenger.setMobile_no(passenger.getMobile_no());
		passenger.setEmail(passenger.getEmail());
		passenger.setLogin_password(passenger.getLogin_password());

		model.addAttribute("modifyPassengerForm", passenger);

		return "profile";
	}

	@PostMapping({ "modifyprofile/save" })
	public String postPrescriptionModify(@ModelAttribute("passenger") Passenger passenger) {

		passRepo.save(passenger);

		return "redirect:/passenger/welcome/" + passenger.getPassengerId();
	}

}
