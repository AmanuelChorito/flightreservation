package miu.cs544.project.flightreservation.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ReactiveAdapter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import miu.cs544.project.flightreservation.dto.ReservationAdapter;
import miu.cs544.project.flightreservation.dto.ReservationDTO;
import miu.cs544.project.flightreservation.model.Flight;
import miu.cs544.project.flightreservation.model.Passenger;
import miu.cs544.project.flightreservation.model.Reservation;
import miu.cs544.project.flightreservation.model.Ticket;
import miu.cs544.project.flightreservation.service.ReservationService;
import miu.cs544.project.flightreservation.service.UserService;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private ReservationAdapter reactiveAdapter;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	@PreAuthorize("hasAnyAuthority('Role_Admin')")
	public List<Reservation> allReservations(){
		return reservationService.allReservations();
	}
	
	@RequestMapping(value = "/{reservationId}", method = RequestMethod.GET)
	public Reservation oneReservations(@PathVariable int reservationId){
		return reservationService.oneReservation(reservationId).orElse(null);
	}
	

	@RequestMapping(value = "", method = RequestMethod.POST)
	@PreAuthorize("hasAnyAuthority('Role_Admin','Role_Customer','Role_Agent')")
	public ResponseEntity<?> saveReservation(@RequestBody ReservationDTO reservationDTO) {
		System.out.println("=======================");
		System.out.println(reservationDTO);
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/passangers/create").toUriString());
		Reservation reservation = reactiveAdapter.DTOtoEntity(reservationDTO);
		System.out.println("--------------------------");
		System.out.println("==>"+reservation);
		Reservation savedReservation= reservationService.saveReservation(reservation);
		System.out.println("+++++"+savedReservation);
		return new ResponseEntity<Reservation>(savedReservation, HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value = "/{rid}", method = RequestMethod.PUT)
	@PreAuthorize("hasAnyAuthority('Role_Admin','Role_Customer','Role_Agent')")
	public ResponseEntity<?> updateREservation(@PathVariable int rid, @RequestBody ReservationDTO updatedReservationDTO) {
		Reservation reservation1 = oneReservations(rid);
		
		
		if(reservation1!=null && reservation1.getUser().getId() == userService.getLoggedInUser().getId()) {
			System.out.println("=======================");
			System.out.println(updatedReservationDTO);
			Reservation reservation = reactiveAdapter.DTOtoEntity(updatedReservationDTO);
			System.out.println("--------------------------");
			System.out.println("==>"+reservation);
			Reservation updateReservation= reservationService.updateReservation(rid,reservation);
			System.out.println("+++++"+updateReservation);
			
			return new ResponseEntity<Reservation>(updateReservation, HttpStatus.ACCEPTED);
			
			
		}
		return new ResponseEntity<>("your are attempting wrong update", HttpStatus.CONFLICT);
		
		
	}
	
	@RequestMapping(value = "/byPassanger/{pid}", method = RequestMethod.GET)
	public List<Reservation> getReservationsByPassanger(@PathVariable int pid) {
		return reservationService.getAllReservationsByPassanger(pid);
	}
	
	@RequestMapping(value = "/byPassanger/{pid}/{rid}", method = RequestMethod.GET)
	public Reservation getOneReservationByPassanger(@PathVariable int pid,@PathVariable int rid) {
		return reservationService.getOneReservationByPassanger(pid, rid);
	}
	
	@RequestMapping(value = "/{id}/cancel", method = RequestMethod.DELETE)
	public Reservation cancelReservation(@PathVariable int rid) {
		return reservationService.cancelReservation(rid);
	}
	
	@RequestMapping(value = "/{rid}", method = RequestMethod.DELETE)
	public void deleteReservation(@PathVariable int rid) {
		reservationService.deleteReservation(rid);
	}
	
	@RequestMapping(value = "/{rid}/pay", method = RequestMethod.POST)
	public List<Ticket> payReservation(@PathVariable int rid) {
		return reservationService.payReservation(rid);
	}
	
	@RequestMapping(value = "/agent", method = RequestMethod.GET)
	public List<Reservation> getReservationsByAgent() {
		return reservationService.allReservationsByagent();
	}
}
