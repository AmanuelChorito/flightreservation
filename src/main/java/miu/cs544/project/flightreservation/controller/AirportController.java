package miu.cs544.project.flightreservation.controller;

import java.util.List;
import java.util.Optional;

import javax.json.Json;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;

import lombok.Data;
import miu.cs544.project.flightreservation.dto.AirportAdapter;
import miu.cs544.project.flightreservation.dto.AirportDTO;
import miu.cs544.project.flightreservation.model.Address;
import miu.cs544.project.flightreservation.model.Airport;
import miu.cs544.project.flightreservation.service.AirportService;

@RestController
@Data
@RequestMapping("/airports")
public class AirportController {

	@Autowired
	private AirportService airportService;

	@Autowired
	private AirportAdapter airportAdapter;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Airport> allAirports(){
		System.out.println("here in the all airport get");
		return airportService.allAirports();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<Airport> oneAirport(@PathVariable int id){
		return airportService.oneAirport(id);
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteAirport(@PathVariable int id){
		airportService.deleteAirport(id);
		return new ResponseEntity("you are good", HttpStatus.ACCEPTED);
	}
	
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Airport saveAirport(@RequestBody AirportDTO airportDTO) {
		System.out.println("==>"+ airportDTO);
		Airport airport = airportAdapter.DTOtoAirport(airportDTO);
		return airportService.saveAirport(airport);
	}
	
	@RequestMapping(value = "/airports/{id}", method = RequestMethod.PUT)
	public Airport updateAirport(@PathVariable int id,Airport udpdatedAirport) {
		return airportService.updateAirport(id, udpdatedAirport);
	}
}
