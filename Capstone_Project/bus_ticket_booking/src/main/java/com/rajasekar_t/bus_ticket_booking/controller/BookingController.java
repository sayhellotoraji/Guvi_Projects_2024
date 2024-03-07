package com.rajasekar_t.bus_ticket_booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rajasekar_t.bus_ticket_booking.model.Booking;
import com.rajasekar_t.bus_ticket_booking.model.Bus;
import com.rajasekar_t.bus_ticket_booking.model.Passenger;
import com.rajasekar_t.bus_ticket_booking.repository.BookingRepository;
import com.rajasekar_t.bus_ticket_booking.repository.BusRepository;
import com.rajasekar_t.bus_ticket_booking.repository.PassengerRepository;

@Controller
@RequestMapping("passenger")
public class BookingController {
	
	@Autowired
	PassengerRepository passRepo;
	
	@Autowired
	BusRepository busRepo;
	
	@Autowired
	BookingRepository bookRepo;

	@GetMapping({ "{passengerId}/bookingseat/{busId}" })
	public String busSchedules(@PathVariable("passengerId") int passengerId, @PathVariable("busId") int busId, Model model) {
		// Used for updating the available seats 
		// After every successful transaction
		Bus bus = busRepo.findById(busId).get();
		
		// New Booking
		Booking booking = new Booking();

		booking.setPassengerId(passengerId);
		booking.setBusId(busId);
		
		
		model.addAttribute("bookingForm", booking);
		model.addAttribute("passengerId", passengerId);
		model.addAttribute("passengerName", passRepo.findById(passengerId).get().getPassengerName());

		model.addAttribute("busId", busId);
		model.addAttribute("busName", bus.getBusName());
		model.addAttribute("price", bus.getPrice());
		return "booking";
	}
}
