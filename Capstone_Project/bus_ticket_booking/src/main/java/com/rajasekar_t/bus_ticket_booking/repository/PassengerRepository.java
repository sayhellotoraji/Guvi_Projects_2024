package com.rajasekar_t.bus_ticket_booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.rajasekar_t.bus_ticket_booking.model.Passenger;

import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "Passenger - Rest API Controllers", description = "Passenger API")
@RepositoryRestResource(collectionResourceRel = "passenger", path="passenger")
public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

}
