package com.rajasekar_t.doctor_patient_portal;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.rajasekar_t.doctor_patient_portal.model.Doctor;
import com.rajasekar_t.doctor_patient_portal.model.Patient;
import com.rajasekar_t.doctor_patient_portal.repository.PatientRepository;

@ExtendWith(MockitoExtension.class)
public class PatientRepositoryTest {

	@Mock
	private PatientRepository patRepo;

	Patient pat = new Patient();

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);

		pat.setPatient_name("Rajasekar T");
		pat.setDob(LocalDate.of(1996, 11, 03));
		pat.setSex("Male");
		pat.setMobile_no("7861111369");
		pat.setAddress("136 J1");
		pat.setEmail("raj@outlook.com");
		pat.setLogin_password("JFSWD2");

		patRepo.save(pat);
	}

	@Test
	public void getByName() {
		// Check if the searched patient name is same as the patient record that is
		// saved
		String search_patient_name_1 = "Rajasekar T";
		Assertions.assertEquals(search_patient_name_1, pat.getPatient_name());

		// Check if the searched patient name is not same as the patient record that
		// is saved
		String search_patient_name_2 = "Raja";
		Assertions.assertNotEquals(search_patient_name_2, pat.getPatient_name());
	}

}
