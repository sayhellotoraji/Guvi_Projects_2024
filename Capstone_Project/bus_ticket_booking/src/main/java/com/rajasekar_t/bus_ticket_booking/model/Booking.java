package com.rajasekar_t.bus_ticket_booking.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "booking")
@Table
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "booking_id")
	private int bookingId;

	@Column(name = "passenger_id")
	private int passengerId;

	@Column(name = "bus_id")
	private int busId;

	@Column(name = "seat_qty")
	private int seatQty;

	private int amount;

	@Column(name = "booked_time")
	private LocalDateTime bookedTime;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public int getSeatQty() {
		return seatQty;
	}

	public void setSeatQty(int seatQty) {
		this.seatQty = seatQty;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public LocalDateTime getBookedTime() {
		return bookedTime;
	}

	public void setBookedTime(LocalDateTime bookedTime) {
		this.bookedTime = bookedTime;
	}
}