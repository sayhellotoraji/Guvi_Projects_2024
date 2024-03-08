package com.rajasekar_t.bus_ticket_booking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.rajasekar_t.bus_ticket_booking.model.Booking;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Booking - Rest API Controllers", description = "Booking API")
@RepositoryRestResource(collectionResourceRel = "booking", path="booking")
public interface BookingRepository extends JpaRepository<Booking, Integer> {

	List<Booking> findByPassengerId(@Param("passengerId") int passengerId);
}
