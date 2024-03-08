package com.rajasekar_t.bus_ticket_booking.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	
	@GetMapping({ "busschedules" })
	public String busSchedulesSearch(@RequestParam("sDate") LocalDate sDate, @RequestParam("fromLoc") String fromLoc, @RequestParam("toLoc") String toLoc,  Model model) {
		List<Bus> buses = busRepo.findByFromLocAndToLocAndStartDate(fromLoc, toLoc, sDate);
		model.addAttribute("buses", buses);
		
		return "bus_schedules";
	}

}
