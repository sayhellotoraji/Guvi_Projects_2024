package com.rajasekar_t.doctor_patient_portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

	@PostMapping({ "/{id}/cancelappointment/{aid}" })
	public String appointment_cancel(@PathVariable("id") int id, @PathVariable("aid") int aid, Model model) {
		appRepo.deleteById(aid);
		model.addAttribute("response",appRepo.findByDoctorId(id));
		return "appointment_check";
	}

	@GetMapping({ "/checkappointment/{id}" })
	public String appointment_check(@PathVariable("id") int id, Model model) {
		model.addAttribute("response",appRepo.findByDoctorId(id));
		return "appointment_check";
	}

	@GetMapping({ "checkprescription/{pid}" })
	public String prescription_check(@PathVariable("pid") int pid, Model model) {
		model.addAttribute("response", prescRepo.findByPatientId(pid));
		return "prescription_check";
	}

	@PostMapping({ "/issueprescription" })
	public String prescription_issue(Prescription prescription) {
		prescRepo.save(prescription);
		return "prescription_issue";
	}

	@PostMapping({ "/modifyprescription" })
	public String prescription_modify(@ModelAttribute("prescription") Prescription prescription) {
		prescRepo.save(prescription);
		return "prescription_modify";
	}

}
