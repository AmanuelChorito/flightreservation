package miu.cs544.project.flightreservation.controller;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import miu.cs544.project.flightreservation.service.FlightDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.Data;
import miu.cs544.project.flightreservation.model.Flight;
import miu.cs544.project.flightreservation.service.FlightServiceImp;
import miu.cs544.project.flightreservation.service.FlightServices;

@RestController
@Data
@RequestMapping("/flights")
public class FlightController {

	@Autowired
	private FlightServices flightServiceImp;
	

	@PostMapping()
	public ResponseEntity<?> saveFlight(FlightDTO flightDTO) {

		Flight flight1=flightServiceImp.saveFlight(flightDTO);
		if(flight1!=null){
			return  new ResponseEntity<>(HttpStatus.OK);
		}
		else
			return  new ResponseEntity<>("Not valid flight to save",HttpStatus.NOT_FOUND);
	}

	@GetMapping()
	public ResponseEntity<?> searchflightbydepartue(@RequestParam(name = "departureDate") LocalDateTime departureDate, @RequestParam(name = "departureAirport") String departureAirport, @RequestParam(name = "destinationAirport") String destinationAirport) {
	Collection<Flight> flightslist= flightServiceImp.searchFlightbyDepartureandDestination(departureDate,departureAirport,destinationAirport);
	 	if(flightslist!=null)
	 		return new ResponseEntity<>(flightslist.stream().collect(Collectors.toList()), HttpStatus.OK);
			else
				return new ResponseEntity<>("NO Flight Found", HttpStatus.NOT_FOUND);

	}
	@PutMapping()
	public ResponseEntity<?>editFlight(@RequestParam(name = "id",required = false) int id,@RequestBody Flight flight){
		Flight flight1= flightServiceImp.editFlight(id,flight);
		if(flight1!=null){
			return  new ResponseEntity<>(HttpStatus.OK);
		}
		else
			return  new ResponseEntity<>("Not valid flight to edit",HttpStatus.NOT_FOUND);


	}


}
