package miu.cs544.project.flightreservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import miu.cs544.project.flightreservation.model.Airport;
import miu.cs544.project.flightreservation.service.AirportService;

@RestController
@Data
@RequestMapping("/airports")
public class AirportController {

	@Autowired
	private AirportService airportService;

	@GetMapping
	public List<Airport> allCountry(){
		return airportService.allAirports();
	}

	public Airport saveAirport(Airport airport) {
		return airportService.saveAirport(airport);
	}
}
