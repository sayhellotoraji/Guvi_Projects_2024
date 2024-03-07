package com.rajasekar_t.bus_ticket_booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rajasekar_t.bus_ticket_booking.model.Bus;
import com.rajasekar_t.bus_ticket_booking.repository.BusRepository;


@Controller
@RequestMapping("passenger")
public class BusController {

	@Autowired
	BusRepository busRepo;

	@GetMapping({ "busschedules/{passengerId}" })
	public String busSchedules(@PathVariable("passengerId") int id, Model model) {
		List<Bus> buses = busRepo.findAll();
		model.addAttribute("buses", buses);
		
		model.addAttribute("pid", id);
		return "bus_schedules";
	}

}
