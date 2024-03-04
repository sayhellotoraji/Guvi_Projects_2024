package com.rajasekar_t.doctor_patient_portal.controller;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rajasekar_t.doctor_patient_portal.model.Appointment;
import com.rajasekar_t.doctor_patient_portal.model.Medical_History;
import com.rajasekar_t.doctor_patient_portal.model.Patient;
import com.rajasekar_t.doctor_patient_portal.model.Prescription;
import com.rajasekar_t.doctor_patient_portal.repository.AppointmentRepository;
import com.rajasekar_t.doctor_patient_portal.repository.DoctorRepository;
import com.rajasekar_t.doctor_patient_portal.repository.MedicalHistoryRepository;
import com.rajasekar_t.doctor_patient_portal.repository.PatientRepository;
import com.rajasekar_t.doctor_patient_portal.repository.PrescriptionRepository;

@Controller
@RequestMapping("doctor")
public class DoctorController {

	@Autowired
	DoctorRepository docRepo;
	
	@Autowired
	PatientRepository patientRepo;
	@Autowired
	AppointmentRepository appRepo;
	@Autowired
	PrescriptionRepository prescRepo;
	@Autowired
	MedicalHistoryRepository histRepo;
	

	/*****************************************************************/
	// Login & Welcome Controllers
	@GetMapping({ "login" })
	public String login() {
		return "login";
	}

	@GetMapping({ "{docId}" })
	public String welcome(@PathVariable("docId") int docId, Model model) {
		String name = docRepo.findById(docId).get().getDoctor_name();
		model.addAttribute("id", docId);
		model.addAttribute("name", name);
		return "doc_welcome";
	}

	/*****************************************************************/
	// Appointment controllers

	@GetMapping({ "checkappointment/{docId}" })
	public String getAppointmentCheck(@PathVariable("docId") int docId, Model model) {
		model.addAttribute("appointments", appRepo.findByDoctorId(docId));
		
		String name = docRepo.findById(docId).get().getDoctor_name();
		model.addAttribute("id", docId);
		model.addAttribute("name", name);
		
		return "doc_appointment_check";
	}

	@GetMapping({ "cancelappointment/{appId}" })
	public String getAppointmentCancel(@PathVariable("appId") int appId, Model model) {
		model.addAttribute("appointment", appRepo.findById(appId).get());
		return "doc_appointment_cancel";
	}

	// Redirect either from the controller on successful request
	// or from thymeleaf 
	// Dont do both - will cause error
	@PostMapping({ "cancelappointment/{appId}" })
	public String postAppointmentCancel(@PathVariable("appId") int appId) {
		int docId = appRepo.findById(appId).get().getDoctorId();
		appRepo.deleteById(appId);
		return "redirect:/doctor/"+docId;

	}

	/*****************************************************************/
	// Prescription Controllers
// Not required at Doctor' s view
//	@GetMapping({ "checkprescription/{patientId}" })
//	public String getPrescriptionCheck(@PathVariable("patientId") int patientId, Model model) {
//		model.addAttribute("response", prescRepo.findByPatientId(patientId));
//		return "prescription_check";
//	}

	@GetMapping({ "issueprescription/{appId}" })
	public String getPrescriptionIssue(@PathVariable("appId") int appId, Model model) {
		Prescription prescription = new Prescription();
		Appointment app = appRepo.findById(appId).get();
		prescription.setDoctorId(app.getDoctorId());
		prescription.setPatientId(appId);
		prescription.setIssuedDateTime(LocalDateTime.now());
		model.addAttribute("prescriptionForm", prescription);
		
		int patientId = app.getPatientId();
		model.addAttribute("id", patientId);
		String name = patientRepo.findById(patientId).get().getPatient_name();
		model.addAttribute("name", name);
		return "doc_prescription_issue";
	}

	@PostMapping({ "issueprescription/save" })
	public String postPrescriptionIssue(@ModelAttribute Prescription prescription) {
		prescRepo.save(prescription);
		return "redirect:/doctor/"+prescription.getDoctorId();
	}
	
	@GetMapping({ "issuedprescription/{patientId}" })
	public String getPrescriptionIssued(@PathVariable("patientId") int patientId, Model model) {
		String name = patientRepo.findById(patientId).get().getPatient_name();
		List<Prescription> prescriptions = prescRepo.findByPatientId(patientId);
		
		model.addAttribute("id", patientId);
		model.addAttribute("name", name);
		
		model.addAttribute("prescriptions", prescriptions);
		
		return "doc_prescription_check";
	}

	/*****************************************************************/
	
	@GetMapping({ "modifyprescription/{prescId}" })
	public String getPrescriptionModify(@PathVariable("prescId") int prescId, Model model) {
		model.addAttribute("response", prescRepo.findById(prescId));
		return "prescription_modify";
	}

	@PostMapping({ "modifyprescription/save" })
	public String postPrescriptionModify(@ModelAttribute("prescription") Prescription prescription) {
		prescRepo.save(prescription);
		return "prescription_check";
	}

//****************************************************************
	@GetMapping({ "medicalhistory/{patientId}" })
	public String getDocMedicalHistory(@PathVariable("patientId") int patientId, Model model) {
		model.addAttribute("patient", patientRepo.findById(patientId).get());

		Medical_History medHistory = histRepo.findById(patientId).get();
		model.addAttribute("history", medHistory);

		return "medical_history";
	}
}
