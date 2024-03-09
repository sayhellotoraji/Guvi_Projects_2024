package com.rajasekar_t.bus_ticket_booking.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	public String busSchedules(@PathVariable("passengerId") int passengerId, @PathVariable("busId") int busId,
			Model model) {
		// Used for updating the available seats
		// After every successful transaction
		Passenger p = passRepo.findById(passengerId).get();
		String passengerName = p.getPassengerName();

		Bus bus = busRepo.findById(busId).get();
		String busName = bus.getBusName();
		int price = bus.getPrice();
		int seatsAvailable = bus.getAvailableSeats();

		// New Booking - Prepopulate form data
		Booking booking = new Booking();
		booking.setPassengerId(passengerId);
		booking.setPassengerName(passengerName);
		booking.setBusId(busId);
		booking.setBusName(busName);
		booking.setPrice(price);

		// Model Attributes
		model.addAttribute("bookingForm", booking);
		model.addAttribute("passengerId", passengerId);
		model.addAttribute("passengerName", passengerName);
		model.addAttribute("seatsAvailable", seatsAvailable);
		return "booking";
	}

	@PostMapping({ "booking/save" })
	public String postRegister(@ModelAttribute Booking booking, Model model) {
		Bus bus = busRepo.findById(booking.getBusId()).get();

		// Time of booking
		booking.setBookedTime(LocalDateTime.now());

		// Get price and no of seats booked
		int seats = booking.getSeatQty();
		int available_seats = bus.getAvailableSeats();

		if (seats <= available_seats) {
			bookRepo.save(booking);

			// Update available seats in bus table
			bus.setAvailableSeats(available_seats - seats);

			// Save the data in BusRepository
			busRepo.save(bus);

			model.addAttribute("message", "Booking Confirmed");
		}

		else {

			model.addAttribute("message", "Booking Failed");
		}

		return "redirect:/passenger/welcome/" + booking.getPassengerId();
	}

	// Booking History
	@GetMapping({ "booking/{passengerId}" })
	public String busSchedules(@PathVariable("passengerId") int passengerId, Model model) {

		// Find latest booking & display it in welcome page
		// Currently we are considering the last booking by user
		int size = bookRepo.findByPassengerId(passengerId).size();

		if (size >= 1) {
			Booking busbooked = bookRepo.findByPassengerId(passengerId).get(size - 1);
			model.addAttribute("booked", busbooked);
			model.addAttribute("bookings", bookRepo.findByPassengerId(passengerId));

		} else {
			// Single Latest Booking
			model.addAttribute("booked", null);

			// All Bookings done by the Passenger
			model.addAttribute("bookings", null);
		}

		return "booking_history";
	}
}
