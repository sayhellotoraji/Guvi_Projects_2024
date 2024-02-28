package com.rajasekar_t.doctor_patient_portal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.rajasekar_t.doctor_patient_portal.model.Medical_History;
import com.rajasekar_t.doctor_patient_portal.model.Patient;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Medical History - Rest API Controllers", description = "Medical History API")
@RepositoryRestResource(collectionResourceRel = "medical_history", path = "medical-history")
public interface MedicalHistoryRepository extends JpaRepository<Medical_History, Integer> {

	// Does not work - Due to Spring Data Rest might not be customizable
	// Please check

	// To collect all history of a particular Patient using patient_id
//	@Query("from medical_history where history_patient_id =:history_patient_id")
//	public List<Medical_History> getHistory(@Param("history_patient_id") int history_patient_id);

}