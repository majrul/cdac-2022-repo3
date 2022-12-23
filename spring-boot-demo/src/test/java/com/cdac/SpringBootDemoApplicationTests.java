package com.cdac;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cdac.entity.Flight;
import com.cdac.repository.FlightRepository;

@SpringBootTest
class SpringBootDemoApplicationTests {

	@Autowired
	private FlightRepository flightRepository;
	
	@Test
	void addFlight() {
		Flight f = new Flight();
		f.setCarrier("Vistara");
		f.setSource("Mumbai");
		f.setDestination("Delhi");
		f.setDepartureTime(LocalTime.of(13, 40));
		f.setArrivalTime(LocalTime.of(15, 40));
		
		flightRepository.save(f);
	}

}
