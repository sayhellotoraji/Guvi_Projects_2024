package com.rajasekar_t.doctor_patient_portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.rajasekar_t.doctor_patient_portal.model.Appointment;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Appointment History - Rest API Controllers", description = "Appointment API")
@RepositoryRestResource(collectionResourceRel = "appointment", path = "appointment")
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

	public List<Appointment> findByPatientId(@Param("id") int id);

	public List<Appointment> findByDoctorId(@Param("id") int id);

}
