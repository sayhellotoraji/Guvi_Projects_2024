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
import com.rajasekar_t.doctor_patient_portal.model.Prescription;
import com.rajasekar_t.doctor_patient_portal.repository.AppointmentRepository;
import com.rajasekar_t.doctor_patient_portal.repository.DoctorRepository;
import com.rajasekar_t.doctor_patient_portal.repository.PrescriptionRepository;

@Controller
@RequestMapping("doctor")
public class DoctorController {

	@Autowired
	DoctorRepository docRepo;
	@Autowired
	AppointmentRepository appRepo;
	@Autowired
	PrescriptionRepository prescRepo;

	/*****************************************************************/
	// Login & Welcome Controllers
	@GetMapping({ "/login" })
	public String login() {
		return "login";
	}

	@GetMapping({ "/{docId}" })
	public String welcome(@PathVariable("docId") int docId, Model model) {
		String name = docRepo.findById(docId).get().getDoctor_name();
		model.addAttribute("id", docId);
		model.addAttribute("name", name);
		return "welcome";
	}

	/*****************************************************************/
	// Appointment controllers

	@GetMapping({ "/checkappointment/{docId}" })
	public String getAppointmentCheck(@PathVariable("docId") int docId, Model model) {
		model.addAttribute("response", appRepo.findByDoctorId(docId));
		return "appointment_check";
	}

	@GetMapping({ "/cancelappointment/{appId}" })
	public String getAppointmentCancel(@PathVariable("appId") int appId, Model model) {
		model.addAttribute("response", appRepo.findById(appId));
		return "appointment_cancel";
	}

	@PostMapping({ "/cancelappointment" })
	public String postAppointmentCancel(@ModelAttribute("appointment") Appointment appointment) {
		appRepo.delete(appointment);
		return "appointment_check";
	}

	/*****************************************************************/
	// Prescription Controllers

	@GetMapping({ "/checkprescription/{patientId}" })
	public String getPrescriptionCheck(@PathVariable("patientId") int patientId, Model model) {
		model.addAttribute("response", prescRepo.findByPatientId(patientId));
		return "prescription_check";
	}

	@GetMapping({ "/issueprescription" })
	public String getPrescriptionIssue() {
		return "prescription_issue";
	}

	@PostMapping({ "/issueprescription" })
	public String postPrescriptionIssue(Prescription prescription) {
		prescRepo.save(prescription);
		return "prescription_check";
	}

	@GetMapping({ "/modifyprescription/{prescId}" })
	public String getPrescriptionModify(@PathVariable("prescId") int prescId, Model model) {
		model.addAttribute("response", prescRepo.findById(prescId));
		return "prescription_modify";
	}

	@PostMapping({ "/modifyprescription" })
	public String postPrescriptionModify(@ModelAttribute("prescription") Prescription prescription) {
		prescRepo.save(prescription);
		return "prescription_check";
	}
}
