package miu.cs544.project.flightreservation.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ReactiveAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import miu.cs544.project.flightreservation.dto.ReservationAdapter;
import miu.cs544.project.flightreservation.dto.ReservationDTO;
import miu.cs544.project.flightreservation.model.Reservation;
import miu.cs544.project.flightreservation.model.Ticket;
import miu.cs544.project.flightreservation.service.ReservationService;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private ReservationAdapter reactiveAdapter;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Reservation> allReservations(){
		return reservationService.allReservations();
	}
	
	@RequestMapping(value = "/{pid}", method = RequestMethod.GET)
	public Reservation allReservations(@PathVariable int pid){
		return reservationService.oneReservation(pid).orElse(null);
	}
	

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<Reservation> savePassanger(@RequestBody ReservationDTO reservationDTO) {
		System.out.println("=======================");
		System.out.println(reservationDTO);
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/passangers/create").toUriString());
		Reservation reservation = reactiveAdapter.DTOtoEntity(reservationDTO);
		System.out.println("--------------------------");
		System.out.println("==>"+reservation);
		return ResponseEntity.created(uri).body(reservationService.saveReservation(reservation));
	}
	
	@RequestMapping(value = "/byPassanger/{pid}", method = RequestMethod.GET)
	public List<Reservation> getReservationsByPassanger(@PathVariable int pid) {
		return reservationService.getAllReservationsByPassanger(pid);
	}
	
	@RequestMapping(value = "/byPassanger/{pid}/{rid}", method = RequestMethod.GET)
	public Reservation getOneReservationByPassanger(@PathVariable int pid,@PathVariable int rid) {
		return reservationService.getOneReservationByPassanger(pid, rid);
	}
	
	@RequestMapping(value = "/{rid}", method = RequestMethod.DELETE)
	public Reservation cancelReservation(@PathVariable int rid) {
		return reservationService.cancelReservation(rid);
	}
	
	@RequestMapping(value = "/{rid}/pay", method = RequestMethod.GET)
	public List<Ticket> payReservation(@PathVariable int rid) {
		return reservationService.payReservation(rid);
	}
}
