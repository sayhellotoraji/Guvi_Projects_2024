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

	@GetMapping({ "/{id}" })
	public String welcome(@PathVariable("id") int id, Model model) {
		String name = docRepo.findById(id).get().getDoctor_name();
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		return "welcome";
	}

	/*****************************************************************/
	// Appointment controllers

	@GetMapping({ "/checkappointment/{id}" })
	public String getAppointmentCheck(@PathVariable("id") int id, Model model) {
		model.addAttribute("response", appRepo.findByDoctorId(id));
		return "appointment_check";
	}

	@GetMapping({ "/cancelappointment/{aid}" })
	public String getAppointmentCancel(@PathVariable("aid") int aid, Model model) {
		model.addAttribute("response", appRepo.findById(aid));
		return "appointment_cancel";
	}

	@PostMapping({ "/cancelappointment" })
	public String postAppointmentCancel(@ModelAttribute("appointment") Appointment appointment) {
		appRepo.delete(appointment);
		return "appointment_check";
	}

	/*****************************************************************/
	// Prescription Controllers

	@GetMapping({ "/checkprescription/{pid}" })
	public String getPrescriptionCheck(@PathVariable("pid") int pid, Model model) {
		model.addAttribute("response", prescRepo.findByPatientId(pid));
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

	@GetMapping({ "/modifyprescription/{presc_id}" })
	public String getPrescriptionModify(@PathVariable("presc_id") int presc_id, Model model) {
		model.addAttribute("response", prescRepo.findById(presc_id));
		return "prescription_modify";
	}

	@PostMapping({ "/modifyprescription" })
	public String postPrescriptionModify(@ModelAttribute("prescription") Prescription prescription) {
		prescRepo.save(prescription);
		return "prescription_check";
	}

}
