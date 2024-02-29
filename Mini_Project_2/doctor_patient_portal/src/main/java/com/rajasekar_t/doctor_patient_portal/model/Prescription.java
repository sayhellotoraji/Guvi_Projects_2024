package com.rajasekar_t.doctor_patient_portal.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import io.swagger.v3.core.util.Json;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.PastOrPresent;

@Entity(name = "prescription")
@Table
@NamedQuery(name = "Prescription.PatientId", query = "from prescription where patientId =:id")
@NamedQuery(name = "Prescription.DoctorId", query = "from prescription where doctorId =:id")
public class Prescription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int prescription_id;

	@Column(name = "prescription_doctor_id")
	private int doctorId;

	@Column(name = "prescription_patient_id")
	private int patientId;

	@PastOrPresent
	@Column(name = "issued_date_time")
	private LocalDateTime issuedDateTime;
	
	private String findings;
	
    @Type(JsonType.class)
    @Column(columnDefinition = "json")
	private String medicines;
}
