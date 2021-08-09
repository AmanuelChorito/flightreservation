package miu.cs544.project.flightreservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import miu.cs544.project.flightreservation.model.Airline;
import miu.cs544.project.flightreservation.service.AirlineService;

@RestController
@Data
@RequestMapping("/airlines")
public class AirlineController {

	@Autowired
	private AirlineService airlineService;
	
	@GetMapping
	public List<Airline> allAirlines(){
		return airlineService.allAirlines();
	}
	
	public Airline saveAirline(Airline airline) {
		return airlineService.saveAirline(airline);
	}
	
}
