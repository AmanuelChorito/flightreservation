package miu.cs544.project.flightreservation.service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import miu.cs544.project.flightreservation.model.Airport;
import miu.cs544.project.flightreservation.model.Flight;
import miu.cs544.project.flightreservation.model.Passenger;
import miu.cs544.project.flightreservation.model.Reservation;
import miu.cs544.project.flightreservation.model.ReservationStatus;
import miu.cs544.project.flightreservation.model.Role;
import miu.cs544.project.flightreservation.model.Ticket;
import miu.cs544.project.flightreservation.model.User;
import miu.cs544.project.flightreservation.repository.FlightRepository;
import miu.cs544.project.flightreservation.repository.PassangerRepository;
import miu.cs544.project.flightreservation.repository.ReservationRepository;
import miu.cs544.project.flightreservation.repository.UserRepository;

@Service
public class ReservationImp implements ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private UserService userService;
	
	@Override
	public List<Reservation> allReservations() {
		// TODO Auto-generated method stub
		return reservationRepository.findAll();
	}

	@Override
	public Optional<Reservation> oneReservation(int id) {
		return reservationRepository.findById(id);
	}

	@Override
	public void deleteReservation(int id) {
		reservationRepository.deleteById(id);
	}

	@Override
	public Reservation saveReservation(Reservation reservation) {
		return reservationRepository.save(reservation);
	}

	@Override
	public Reservation updateReservation(int id, Reservation reservation) {
		Reservation reservation2 = oneReservation(id).orElse(null);
		if(reservation2!=null) {
			reservation2.setReservationCode(reservation.getReservationCode());
			reservation2.setReservedDate(reservation.getReservedDate());
			reservation2.setTotalPrice(reservation.getTotalPrice());
			reservation2.setStatus(reservation.getStatus());
			reservation2.setFlightList(reservation.getFlightList());
			reservation2.setPassenger(reservation.getPassenger());
			reservation2.setTickets(reservation.getTickets());
			reservation2.setUser(reservation.getUser());
			//reservation2.setFlightList(reservation.getFlightList());
			saveReservation(reservation2);
			return reservation2;
		}
		return null;
	}

	@Override
	public Reservation getOneReservationByPassanger(int pid, int rid) {
		// TODO Auto-generated method stub
		return reservationRepository.getOneReservationByPassanger(pid, rid);
	}

	@Override
	public List<Reservation> getAllReservationsByPassanger(int pid) {
		// TODO Auto-generated method stub
		return reservationRepository.getAllReservationsByPassanger(pid);
	}

	@Override
	public Reservation cancelReservation(int rid) {
		Reservation reservation  = oneReservation(rid).orElse(null);
		if(reservation!=null) {reservation.setStatus(ReservationStatus.CANCELLED);
		return saveReservation(reservation);
		}
		return null;
		
	}

	@Override
	public List<Ticket> payReservation(int id) {
		Reservation reservation = oneReservation(id).orElse(null);
		if(reservation!=null) {
			List<Ticket> tickets = new ArrayList<>();
			
			List<Flight> flights = reservation.getFlightList();
			Passenger passenger = reservation.getPassenger();
			reservation.setStatus(ReservationStatus.CONFIRMED);
			//double totalPayment = 0.0;
			for(Flight f: flights) {
				Ticket ticket = new Ticket();
				ticket.setTicketNumber(randomString());
				ticket.setFlightId(f.getId());
				ticket.setPassangerId(passenger.getId());
				ticket.setReservationCode(reservation.getReservationCode());
				tickets.add(ticket);
				ticketService.saveTicket(ticket);
				//totalPayment+=f.getPrice();
			}
			//System.out.println("totl price is"+totalPayment);
			//reservation.setTotalPrice(totalPayment);
			reservation.setTickets(tickets);
			saveReservation(reservation);
			return tickets;
		}
		return null;
	}
	
	
	private String randomString() {
		char[] CHARSET_AZ_09 = "0123456789".toCharArray();
		int length = 20;
	    Random random = new SecureRandom();
	    char[] result = new char[length];
	    for (int i = 0; i < result.length; i++) {
	        int randomCharIndex = random.nextInt(CHARSET_AZ_09.length);
	        result[i] = CHARSET_AZ_09[randomCharIndex];
	    }
	    return new String(result);
	}

	@Override
	public List<Reservation> allReservationsByagent() {
		User loggedInUser = userService.getLoggedInUser();
		
		System.out.println("from reservation service loegged in user"+loggedInUser);
		List<Role> roles = (List<Role>) loggedInUser.getRoles();
		List<Role> agentRole = roles.stream().filter(r -> r.getName().equals("Role_Agent")).collect(Collectors.toList());
		if(loggedInUser!=null && !agentRole.isEmpty()) {
			System.out.println("here---++");
			return reservationRepository.getAllReservationsByAgent(loggedInUser.getId());
		}
		return null;
	}

//	
}
