package com.rajasekar_t.doctor_patient_portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.rajasekar_t.doctor_patient_portal.model.Patient;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Patient Record - Rest API Controllers", description = "Patient Record API")
@RepositoryRestResource(collectionResourceRel = "patient", path="patient")
public interface PatientRepository extends JpaRepository<Patient, Integer> {

}