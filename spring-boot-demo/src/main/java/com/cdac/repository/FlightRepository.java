package com.cdac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cdac.entity.Flight;

public interface FlightRepository 
					extends JpaRepository<Flight, Integer> {
	
	@Query("select f from Flight f where f.source = ?1 and f.destination = ?2")
	public List<Flight> findAvailableFlights(String source, String destination);
	
}
