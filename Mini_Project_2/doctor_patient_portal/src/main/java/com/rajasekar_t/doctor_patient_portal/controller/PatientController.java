package com.rajasekar_t.doctor_patient_portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rajasekar_t.doctor_patient_portal.model.Appointment;
import com.rajasekar_t.doctor_patient_portal.repository.AppointmentRepository;
import com.rajasekar_t.doctor_patient_portal.repository.PatientRepository;
import com.rajasekar_t.doctor_patient_portal.repository.PrescriptionRepository;

@Controller
@RequestMapping("patient")
public class PatientController {

	@Autowired
	PatientRepository patientRepo;

	@Autowired
	AppointmentRepository appRepo;

	@Autowired
	PrescriptionRepository prescRepo;

	@GetMapping({ "/login" })
	public String login() {
		return "login";
	}

	@GetMapping({ "/{id}" })
	public String welcome(@PathVariable("id") int id, Model model) {
		String name = patientRepo.findById(id).get().getPatient_name();
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		return "welcome";
	}

	@GetMapping({ "/bookappointment" })
	public String getAppointmentBook() {
		return "appointment_book";
	}

	@PostMapping({ "/bookappointment" })
	public String postAppointmentBook(@ModelAttribute("appointment") Appointment appointment) {
		appRepo.save(appointment);
		return "appointment_check";
	}

	@GetMapping({ "/checkappointment/{id}" })
	public String getAppointmentCheck(@PathVariable("id") int id, Model model) {
		model.addAttribute("response", appRepo.findByPatientId(id));
		return "appointment_check";
	}

	@GetMapping({ "/checkprescription/{id}" })
	public String getPrescriptionCheck(@PathVariable("id") int id, Model model) {
		model.addAttribute("response", prescRepo.findByPatientId(id));
		return "prescription_check";
	}
}
