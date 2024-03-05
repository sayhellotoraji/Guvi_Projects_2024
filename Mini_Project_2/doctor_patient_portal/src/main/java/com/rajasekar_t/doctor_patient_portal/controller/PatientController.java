package com.rajasekar_t.doctor_patient_portal.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rajasekar_t.doctor_patient_portal.model.Appointment;
import com.rajasekar_t.doctor_patient_portal.model.Doctor;
import com.rajasekar_t.doctor_patient_portal.model.Medical_History;
import com.rajasekar_t.doctor_patient_portal.model.Patient;
import com.rajasekar_t.doctor_patient_portal.model.Prescription;
import com.rajasekar_t.doctor_patient_portal.repository.AppointmentRepository;
import com.rajasekar_t.doctor_patient_portal.repository.DoctorRepository;
import com.rajasekar_t.doctor_patient_portal.repository.MedicalHistoryRepository;
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

	@Autowired
	DoctorRepository docRepo;

	@Autowired
	MedicalHistoryRepository histRepo;

	// **************************************************************
	// Registration controllers

	@GetMapping({ "register" })
	public String register(Model model) {
		model.addAttribute("patientForm", new Patient());
		return "register";
	}

	@PostMapping({ "register/save" })
	public String postRegister(@ModelAttribute Patient patient, Model model) {
		patientRepo.save(patient);
		return "redirect:/patient/login";
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
	@GetMapping({ "{patientId}" })
	public String welcome(@PathVariable("patientId") int patientId, Model model) {
		String name = patientRepo.findById(patientId).get().getPatient_name();
		model.addAttribute("id", patientId);
		model.addAttribute("name", name);
		return "welcome";
	}

	@GetMapping({ "doctordetails" })
	public String getDoctorDetails(Model model) {
		List<Doctor> doctors = docRepo.findAll();
		model.addAttribute("doctors", doctors);

		return "doctor_details";
	}

	// **********************************************************
	// Appointment controller

	@GetMapping({ "bookappointment/{patientId}" })
	public String getPatientAppointmentBook(@PathVariable("patientId") int patientId, Model model) {
		Appointment appointment = new Appointment();
		appointment.setPatientId(patientId);

		Patient patient = patientRepo.findById(patientId).get();

		List<Doctor> doctors = docRepo.findAll();

		model.addAttribute("appointmentForm", appointment);
		model.addAttribute("doctors", doctors);
		model.addAttribute("patient", patient);

		// ****************************************************

		return "appointment_book";
	}

	@PostMapping({ "bookappointment/save" })
	public String postAppointmentBook(@ModelAttribute Appointment appointment, Model model) {

		appRepo.save(appointment);

		int id = appointment.getPatientId();
		return "redirect:/patient/" + id;
	}

	@GetMapping({ "checkappointment/{patientId}" })
	public String getAppointmentCheck(@PathVariable("patientId") int patientId, Model model) {

		List<Appointment> appointments = appRepo.findByPatientId(patientId);
		model.addAttribute("appointments", appointments);
		String name = patientRepo.findById(patientId).get().getPatient_name();
		model.addAttribute("id", patientId);
		model.addAttribute("name", name);

		// Doctor Names
//		List<String> doctors = new ArrayList<>();
//		for(Appointment a: appointments) {
//			doctors.add(docRepo.findById(a.getDoctorId()).get().getDoctor_name());
//		}
//		model.addAttribute("doctors",doctors);

		return "appointment_check";
	}

	// **********************************************************
	// Prescription controller

	@GetMapping({ "checkprescription/{patientId}" })
	public String getPrescriptionCheck(@PathVariable("patientId") int patientId, Model model) {
		List<Prescription> prescriptions = prescRepo.findByPatientId(patientId);
		model.addAttribute("prescriptions", prescriptions);

		String name = patientRepo.findById(patientId).get().getPatient_name();
		model.addAttribute("id", patientId);
		model.addAttribute("name", name);
		return "prescription_check";
	}

	// **********************************************************
	// Medical History controller

	@GetMapping({ "medicalhistory/{patientId}" })
	public String getMedicalHistory(@PathVariable("patientId") int patientId, Model model) {
		model.addAttribute("patient", patientRepo.findById(patientId).get());

		List<Medical_History> medHistory = histRepo.findByPatientId(patientId);
		model.addAttribute("history", medHistory);

		return "medical_history";
	}

}
