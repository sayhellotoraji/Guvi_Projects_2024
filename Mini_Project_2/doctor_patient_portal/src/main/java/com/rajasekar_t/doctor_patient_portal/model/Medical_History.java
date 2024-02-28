package com.rajasekar_t.doctor_patient_portal.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;

@JsonIgnoreProperties({ "hibernateLazyInitializer" })
@Entity
@Table
public class Medical_History {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int history_id;

	@NotEmpty
	private int history_patient_id;

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

	public int getHistory_patient_id() {
		return history_patient_id;
	}

	public void setHistory_patient_id(int history_patient_id) {
		this.history_patient_id = history_patient_id;
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
