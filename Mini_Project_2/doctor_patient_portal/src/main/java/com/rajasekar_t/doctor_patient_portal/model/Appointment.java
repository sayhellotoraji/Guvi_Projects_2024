package com.rajasekar_t.doctor_patient_portal.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.PastOrPresent;

@Entity(name = "appointment")
@Table
@NamedQuery(name = "Appointment.PatientId", query = "from appointment where patientId =:id")
@NamedQuery(name = "Appointment.DoctorId", query = "from appointment where doctorId =:id")
@NamedQuery(name = "Appointment.DateSlot", query = "from appointment where visitDate =:vdate and booked=:booked")
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int appointment_id;

	@Column(name = "appointment_doctor_id")
	private int doctorId;

	@Column(name = "appointment_patient_id")
	private int patientId;

	@PastOrPresent
	@Column(name = "visit_date")
	private LocalDate visitDate;

	private int slot;

	private boolean booked;

	public int getAppointment_id() {
		return appointment_id;
	}

	public void setAppointment_id(int appointment_id) {
		this.appointment_id = appointment_id;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public LocalDate getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(LocalDate visitDate) {
		this.visitDate = visitDate;
	}

	public int getSlot() {
		return slot;
	}

	public void setSlot(int slot) {
		this.slot = slot;
	}

	public boolean isBooked() {
		return booked;
	}

	public void setBooked(boolean booked) {
		this.booked = booked;
	}

}
