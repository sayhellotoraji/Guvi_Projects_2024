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
import com.rajasekar_t.doctor_patient_portal.repository.DoctorRepository;

@ExtendWith(MockitoExtension.class)
public class DoctorRepositoryTest {

	@Mock
	private DoctorRepository docRepo;

	Doctor doc = new Doctor();

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);

		doc.setDoctor_name("Rajasekar T");
		doc.setDob(LocalDate.of(1996, 11, 03));
		doc.setSpecialization("Neurosurgeon");
		doc.setSex("Male");
		doc.setMobile_no("7861111369");
		doc.setAddress("136 J1");
		doc.setEmail("raj@outlook.com");
		doc.setLogin_password("JFSWD2");

		docRepo.save(doc);
	}

	@Test
	public void getByName() {
		// Check if the searched doctor name is same as the doctor record that is
		// saved
		String search_doctor_name_1 = "Rajasekar T";
		Assertions.assertEquals(search_doctor_name_1, doc.getDoctor_name());

		// Check if the searched doctor name is not same as the doctor record that
		// is saved
		String search_doctor_name_2 = "Raja";
		Assertions.assertNotEquals(search_doctor_name_2, doc.getDoctor_name());
	}

}
