package com.rajasekar_t.doctor_patient_portal.controller;

import java.time.LocalDate;
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

	// ************************************************************
	// Login & Home Controllers
	@GetMapping({ "login" })
	public String login() {
		return "login";
	}

	// Home page - Doctor
	@GetMapping({ "{docId}" })
	public String welcome(@PathVariable("docId") int docId, Model model) {

		String name = docRepo.findById(docId).get().getDoctor_name();
		model.addAttribute("id", docId);
		model.addAttribute("name", name);

		return "doc_welcome";
	}

	// ************************************************************
	// Appointment controllers

	@GetMapping({ "checkappointment/{docId}" })
	public String getAppointmentCheck(@PathVariable("docId") int docId, Model model) {

		String name = docRepo.findById(docId).get().getDoctor_name();
		model.addAttribute("id", docId);
		model.addAttribute("name", name);

		List<Appointment> appointments = appRepo.findByDoctorId(docId);
		model.addAttribute("appointments", appointments);

		return "doc_appointment_check";
	}

	@GetMapping({ "cancelappointment/{appId}" })
	public String getAppointmentCancel(@PathVariable("appId") int appId, Model model) {

		Appointment appointment = appRepo.findById(appId).get();
		model.addAttribute("appointment", appointment);

		return "doc_appointment_cancel";
	}

	@PostMapping({ "cancelappointment/{appId}" })
	public String postAppointmentCancel(@PathVariable("appId") int appId) {

		int docId = appRepo.findById(appId).get().getDoctorId();
		appRepo.deleteById(appId);

		return "redirect:/doctor/" + docId;
	}

	// ************************************************************
	// Prescription controllers

	@GetMapping({ "issueprescription/{appId}" })
	public String getPrescriptionIssue(@PathVariable("appId") int appId, Model model) {
		Appointment app = appRepo.findById(appId).get();
		Prescription prescription = new Prescription();

		prescription.setDoctorId(app.getDoctorId());
		prescription.setPatientId(appId);
		prescription.setIssuedDateTime(LocalDateTime.now());
		model.addAttribute("prescriptionForm", prescription);

		int patientId = app.getPatientId();
		String name = patientRepo.findById(patientId).get().getPatient_name();
		model.addAttribute("id", patientId);
		model.addAttribute("name", name);

		return "doc_prescription_issue";
	}

	@PostMapping({ "issueprescription/save" })
	public String postPrescriptionIssue(@ModelAttribute Prescription prescription) {

		prescRepo.save(prescription);
		return "redirect:/doctor/" + prescription.getDoctorId();
	}

	@GetMapping({ "issuedprescription/{patientId}" })
	public String getPrescriptionIssued(@PathVariable("patientId") int patientId, Model model) {
		String name = patientRepo.findById(patientId).get().getPatient_name();
		model.addAttribute("id", patientId);
		model.addAttribute("name", name);

		List<Prescription> prescriptions = prescRepo.findByPatientId(patientId);
		model.addAttribute("prescriptions", prescriptions);

		return "doc_prescription_check";
	}

	@GetMapping({ "modifyprescription/{prescId}" })
	public String getPrescriptionModify(@PathVariable("prescId") int prescId, Model model) {
		int patientId = prescRepo.findById(prescId).get().getPatientId();
		String name = patientRepo.findById(patientId).get().getPatient_name();
		model.addAttribute("id", patientId);
		model.addAttribute("name", name);

		Prescription prescription = prescRepo.findById(prescId).get();
		prescription.setPrescription_id(prescId);
		prescription.setIssuedDateTime(LocalDateTime.now());
		model.addAttribute("modifyPrescriptionForm", prescription);

		return "doc_prescription_modify";
	}

	@PostMapping({ "modifyprescription/save" })
	public String postPrescriptionModify(@ModelAttribute("prescription") Prescription prescription) {

		prescRepo.save(prescription);

		return "redirect:/doctor/" + prescription.getDoctorId();
	}

	@GetMapping({ "deleteprescription/{prescId}" })
	public String getPrescriptionRemove(@PathVariable("prescId") int prescId, Model model) {

		model.addAttribute("prescription", prescRepo.findById(prescId).get());

		return "doc_prescription_remove";
	}

	@PostMapping({ "deleteprescription/{prescId}" })
	public String postPrescriptionRemove(@PathVariable("prescId") int prescId) {
		int docId = prescRepo.findById(prescId).get().getDoctorId();
		prescRepo.deleteById(prescId);

		return "redirect:/doctor/" + docId;
	}
	// ************************************************************
	// Medical History - Controllers

	@GetMapping({ "medicalhistory/{patientId}" })
	public String getDocMedicalHistory(@PathVariable("patientId") int patientId, Model model) {

		Patient patient = patientRepo.findById(patientId).get();
		model.addAttribute("patient", patient);

		List<Medical_History> medHistory = histRepo.findByPatientId(patientId);
		model.addAttribute("history", medHistory);

		return "medical_history";
	}

	@GetMapping({ "updatemedicalhistory/{appId}" })
	public String getMedicalHistory(@PathVariable("appId") int appId, Model model) {

		Appointment app = appRepo.findById(appId).get();
		int patientId = app.getPatientId();
		String name = patientRepo.findById(patientId).get().getPatient_name();

		model.addAttribute("id", patientId);
		model.addAttribute("name", name);

		Medical_History hist = new Medical_History();
		hist.setPatientId(patientId);
		model.addAttribute("history", hist);

		return "doc_medical_history";
	}

	@PostMapping({ "updatemedicalhistory/save" })
	public String updateMedicalHistory(@ModelAttribute Medical_History medHis) {
		medHis.setDiagnosis_date(LocalDate.now());
		histRepo.save(medHis);

		int patientId = medHis.getPatientId();
		return "redirect:/doctor/" + patientId;
	}
}
