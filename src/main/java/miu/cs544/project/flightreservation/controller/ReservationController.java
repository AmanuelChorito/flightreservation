package miu.cs544.project.flightreservation.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import lombok.Data;
import miu.cs544.project.flightreservation.model.Reservation;
import miu.cs544.project.flightreservation.service.FlightService;
import miu.cs544.project.flightreservation.service.ReservationService;

@RestController
@Data
@RequestMapping("/reservations")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private FlightService flightService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Reservation> allReservation(){
		System.out.println("here in the all reservation get");
		return reservationService.allReservations();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<Reservation> oneAirport(@PathVariable int id){
		System.out.println("here in the oneAirport get");
		return reservationService.oneReservation(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteAirport(@PathVariable int id){
		reservationService.deleteReservation(id);
		return new ResponseEntity("you are good", HttpStatus.ACCEPTED);
	}

}
