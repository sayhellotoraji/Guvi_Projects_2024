package com.rajasekar_t.doctor_patient_portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.rajasekar_t.doctor_patient_portal.model.Doctor;
import com.rajasekar_t.doctor_patient_portal.model.Patient;
import com.rajasekar_t.doctor_patient_portal.repository.DoctorRepository;
import com.rajasekar_t.doctor_patient_portal.repository.PatientRepository;

@Controller
public class LoginController {

	@Autowired
	DoctorRepository docRepo;

	@Autowired
	PatientRepository patRepo;

	@GetMapping({ "/" })
	public String loggedIn(@AuthenticationPrincipal User user, Model model) {

		String username = user.getUsername();
		// System.out.println(username);

		String url = "";
		if (docRepo.findByEmail(username) != null) {
			Doctor doc = docRepo.findByEmail(username);
			int docId = doc.getDoctor_id();
			url = "redirect:/doctor/" + docId;
		}

		else if (patRepo.findByEmail(username) != null) {
			Patient pat = patRepo.findByEmail(username); 
			int patId = pat.getPatient_id();
			url = "redirect:/patient/" + patId;
		}

		return url;
	}
	


}
