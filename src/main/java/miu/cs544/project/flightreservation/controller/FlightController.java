package miu.cs544.project.flightreservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import miu.cs544.project.flightreservation.model.Flight;
import miu.cs544.project.flightreservation.service.FlightService;

@RestController
@Data
@RequestMapping("/flights")
public class FlightController {

	@Autowired
	private FlightService flightService;
	
	@GetMapping
	public List<Flight> allCountry(){
		return flightService.allFlights();
	}
	
	public Flight saveFlight(Flight flight) {
		return flightService.saveFlight(flight);
	}
}
