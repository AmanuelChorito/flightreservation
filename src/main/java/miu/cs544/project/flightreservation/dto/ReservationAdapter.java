package miu.cs544.project.flightreservation.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import miu.cs544.project.flightreservation.model.Address;
import miu.cs544.project.flightreservation.model.Airline;
import miu.cs544.project.flightreservation.model.Airport;
import miu.cs544.project.flightreservation.model.Flight;
import miu.cs544.project.flightreservation.model.Passenger;
import miu.cs544.project.flightreservation.model.Reservation;
import miu.cs544.project.flightreservation.model.Role;
import miu.cs544.project.flightreservation.model.User;
import miu.cs544.project.flightreservation.repository.PassangerRepository;
import miu.cs544.project.flightreservation.service.FlightServices;
import miu.cs544.project.flightreservation.service.PassengerService;
import miu.cs544.project.flightreservation.service.UserService;

@Component
public class ReservationAdapter {

	@Autowired
	private FlightServices flightServices;
	@Autowired
	private UserService userService;
	@Autowired
	private PassengerService passengerService;
	
	public Reservation DTOtoEntity(ReservationDTO reservationDTO) {
    	Reservation reservation = new Reservation();
    	reservation.setReservationCode(reservationDTO.getReservationCode());
    	reservation.setReservedDate(reservationDTO.getReservedDate());
    	reservation.setStatus(reservationDTO.getStatus());
    	List<Flight> flights = getFlightObjectList(reservationDTO.getFlightIds());
    	reservation.setFlightList(flights);
    	reservation.setReservedDate(flights.get(0).getDepartureTime().toLocalDate());
    	reservation.setUser(getUserObject(reservationDTO.getUserId()));
    	
    	
    	if(reservationDTO.getPassenger()==null) {
    		reservation.setPassenger(getPassangetObject(reservationDTO.getPassangerId()));
    	}
    	else {
    		reservation.setPassenger(reservationDTO.getPassenger());
    	}
    	
    	return reservation;
		}
	
	public List<Flight> getFlightObjectList(List<Integer> flightIds){
		Address a1 = new Address("a3","b3","c3","d3");
		Airport ap3 = new Airport("IAD","Dc", a1);
		Airport ap4 = new Airport("BDR","Bahirdar", a1);
		Airline al1 = new Airline("ET","Ethiopia", "one of the top 20 in the world");
		Flight f1 = new Flight("ET1", 20, LocalDateTime.of(2022, 10, 10, 10, 12), LocalDateTime.of(2022, 10, 10,10,10), 1000, al1,ap3,ap4);
		Flight f2 = new Flight("ET1", 20, LocalDateTime.of(2022, 10, 10, 9, 12), LocalDateTime.of(2022, 10, 10,10,10), 1000, al1,ap3,ap4);
		f1.setFlightNumber(flightIds.toString());
		List<Flight> flightss = new ArrayList<>();
		flightss.add(f1);
		flightss.add(f2);
		System.out.println("f1==>"+flightss.toString());
		Collections.sort(flightss);
		System.out.println("f1==>"+flightss.toString());
		return flightss;
		//return flightIds.stream().map(id -> flightServices.getFlightById(id).orElse(null)).collect(Collectors.toList());		
	}
	
	public User getUserObject(int id) {
		User u1 = new User("ZZ","password1",true, Role.CUSTOMER);
		return u1;
		//return userService.getUserById(id);
	}
	
	public Passenger getPassangetObject(int id) {
		Address a1 = new Address("a3","b3","c3","d3");
		Passenger p1 = new Passenger("AA","BB", LocalDate.of(1995, 10, 10),"email address", a1);
		return p1;
		//return passengerService.findById(id);
	}
	
    
}
