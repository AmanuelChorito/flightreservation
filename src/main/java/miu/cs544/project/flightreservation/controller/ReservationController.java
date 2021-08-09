package miu.cs544.project.flightreservation.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import miu.cs544.project.flightreservation.model.Reservation;
import miu.cs544.project.flightreservation.service.ReservationService;

@RestController
@Data
@RequestMapping("/reservations")
@Transactional
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	
	@GetMapping
	public List<Reservation> allReservations(){
		return reservationService.allReservation();
	}
	
	public Reservation saveReservation(Reservation reservation) {
		return reservationService.saveReservation(reservation);
	}
}
