package com.rajasekar_t.bus_ticket_booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.rajasekar_t.bus_ticket_booking.model.Bus;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Bus - Rest API Controllers", description = "Bus schedules API")
@RepositoryRestResource(collectionResourceRel = "bus", path="bus")
public interface BusRepository extends JpaRepository<Bus, Integer> {

}
