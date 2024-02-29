package com.rajasekar_t.doctor_patient_portal.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;

@JsonIgnoreProperties()

// Mandatory to add when naming convention is not followed
// As _ is reserved, & class name is not a single word
@Entity(name = "medical_history")
@Table
@NamedQuery(name = "Medical_History.PatientId", query = "from medical_history where patientId =:id")
public class Medical_History {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int history_id;

	@NotEmpty
	@Column(name = "history_patient_id")
	private int patientId;

	@NotEmpty
	@PastOrPresent
	private LocalDate diagnosis_date;

	private String medical_condition;

	public int getHistory_id() {
		return history_id;
	}

	public void setHistory_id(int history_id) {
		this.history_id = history_id;
	}

//	public int getHistory_patient_id() {
//		return history_patient_id;
//	}
//
//	public void setHistory_patient_id(int history_patient_id) {
//		this.history_patient_id = history_patient_id;
//	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public LocalDate getDiagnosis_date() {
		return diagnosis_date;
	}

	public void setDiagnosis_date(LocalDate diagnosis_date) {
		this.diagnosis_date = diagnosis_date;
	}

	public String getMedical_condition() {
		return medical_condition;
	}

	public void setMedical_condition(String medical_condition) {
		this.medical_condition = medical_condition;
	}

}
