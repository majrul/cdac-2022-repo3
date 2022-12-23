package com.cdac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.entity.Flight;
import com.cdac.service.FlightService;

@RestController
public class FlightController {

	@Autowired
	private FlightService flightService;
	
	//URL : http://localhost:8080/all-flights
	@GetMapping("/all-flights")
	public List<Flight> getAll() {
		return flightService.getAvailableFlights();
	}
	
	//URL : http://localhost:8080/flights-route?source=Mumbai&destination=Delhi
	@GetMapping("/flights-route")
	public List<Flight> getFlights(@RequestParam("source")String source, @RequestParam("destination") String destination) {
		return flightService.getAvailableFlights(source, destination);
	}
	
	//URL : http://localhost:8080/add-flight
	//While testing from Postman or any tool, you need to
	//send the flight data in the body as JSON like this:
	/* 
	 	{"carrier" : "Indigo", "source" : "Mumbai", "destination" : "Delhi", "departureTime" : "7:30", "arivalTime" : "9:30" }
	*/ 	
	@PostMapping("/add-flight")
	public String addFlight(@RequestBody Flight flight) {
		flightService.addFlight(flight, 30);
		return "Flight added!";
	}
	
}
