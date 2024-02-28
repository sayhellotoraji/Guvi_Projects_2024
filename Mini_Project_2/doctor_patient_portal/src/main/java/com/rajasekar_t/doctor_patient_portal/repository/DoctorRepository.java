package com.rajasekar_t.doctor_patient_portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.rajasekar_t.doctor_patient_portal.model.Doctor;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Record: Doctor - Rest API Controllers", description = "Doctor Record API")
@RepositoryRestResource(collectionResourceRel = "doctor", path="doctor")
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

}
