package miu.cs544.project.flightreservation.controller;

import java.net.URI;
import java.util.List;


import miu.cs544.project.flightreservation.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.Data;
import miu.cs544.project.flightreservation.model.Passenger;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@Data
@RequestMapping("/passangers")
public class PassangerController {

	@Autowired
	private PassengerService passengerService;

	@GetMapping
	public List<Passenger> allPassangers(){
		return passengerService.allPassangers();
	}
	@GetMapping("/{id}")
	public Passenger findById(@PathVariable int id){
		return passengerService.findById(id);
	}

	@PostMapping("/create")
	public ResponseEntity<Passenger> savePassanger(@RequestBody Passenger passanger) {
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/passangers/create").toUriString());
		return ResponseEntity.created(uri).body(passengerService.savePassanger(passanger));
	}

	@PutMapping("/{id}")
	ResponseEntity<?> updatePassenger(@RequestBody Passenger newPassenger, @PathVariable int id) {

		Passenger p1 = passengerService.updatePassenger(newPassenger,id);
		if (p1 == null)
			return new ResponseEntity<>("Id not found", HttpStatus.BAD_REQUEST);
		else return new ResponseEntity<>(p1, HttpStatus.OK);

	}
}
