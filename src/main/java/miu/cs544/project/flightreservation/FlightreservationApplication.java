package miu.cs544.project.flightreservation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import miu.cs544.project.flightreservation.controller.AirlineController;
//import miu.cs544.project.flightreservation.controller.AirportController;
//import miu.cs544.project.flightreservation.controller.FlightController;
//import miu.cs544.project.flightreservation.controller.PassangerController;
//import miu.cs544.project.flightreservation.controller.ReservationController;
//import miu.cs544.project.flightreservation.controller.TicketController;
//import miu.cs544.project.flightreservation.controller.UserController;
import miu.cs544.project.flightreservation.model.Address;
import miu.cs544.project.flightreservation.model.Airline;
import miu.cs544.project.flightreservation.model.Airport;
import miu.cs544.project.flightreservation.model.Flight;
import miu.cs544.project.flightreservation.model.Passenger;
import miu.cs544.project.flightreservation.model.Reservation;
import miu.cs544.project.flightreservation.model.ReservationStatus;
import miu.cs544.project.flightreservation.model.Role;
import miu.cs544.project.flightreservation.model.Ticket;
import miu.cs544.project.flightreservation.model.User;

@SpringBootApplication
public class FlightreservationApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(FlightreservationApplication.class, args);

//		FlightController flightController = context.getBean(FlightController.class);
//		TicketController ticketController = context.getBean(TicketController.class);
//		ReservationController reservationController = context.getBean(ReservationController.class);
//		AirportController airportController = context.getBean(AirportController.class);
//		AirlineController airlineController = context.getBean(AirlineController.class);
//		PassangerController passangerController = context.getBean(PassangerController.class);
//		UserController userController = context.getBean(UserController.class);
//
//		Address a1 = new Address("a3", "b3", "c3", "d3");
//		Address a2 = new Address("a2", "b2", "c2", "d2");
//		Address a3 = new Address("a1", "b1", "c1", "d1");//address for the person
//		Airport ap1 = new Airport("ADD", "Addis", a1);
//		Airport ap2 = new Airport("CID", "Iwoa", a2);
//		Airport ap3 = new Airport("IAD", "Dc", a2);
//		Airport ap4 = new Airport("BDR", "Bahirdar", a2);
//		Airline al1 = new Airline("ET", "Ethiopia", "one of the top 20 in the world");
//		Airline al2 = new Airline("UA", "USA", "maybe good");
//		Airline al3 = new Airline("AA", "USA", "maybe");
//		Flight f1 = new Flight("ET1", 20, LocalDateTime.of(2022, 10, 10, 10, 12), LocalDateTime.of(2022, 10, 10, 10, 10), 1000, al1, ap1, ap2);
//		Flight f2 = new Flight("ET2", 30, LocalDateTime.of(2022, 11, 11, 11, 11), LocalDateTime.of(2022, 11, 11, 11, 11), 2000, al2, ap3, ap4);
//		//Flight f3 = new Flight("ET3", 40, LocalDateTime.of(2022, 12, 12, 12, 12), LocalDateTime.of(2022, 12, 12,12,12), 3000, al3,ap3,ap4);
//
//		Passenger p1 = new Passenger("AA", "BB", LocalDate.of(1995, 10, 10), "email address", a1);
//		Passenger p2 = new Passenger("CC", "DD", LocalDate.of(1996, 10, 10), "email address", a2);
//		Passenger p3 = new Passenger("EE", "FF", LocalDate.of(1997, 10, 10), "email address", a2);
//		User u1 = new User("ZZ", "password1", true, Role.CUSTOMER);
//		User u2 = new User("YY", "password1", true, Role.CUSTOMER);
//		User u3 = new User("XX", "password1", true, Role.CUSTOMER);
//
//		// take the reserved date from the flights the date first flight in the list is the reserved date
//		Reservation r1 = new Reservation("ABCD", LocalDate.of(2022, 1, 1), ReservationStatus.PENDING, Arrays.asList(f1), p1, u1);
//		//Reservation r2 = new Reservation("ABCD", LocalDate.of(2022, 2, 2), ReservationStatus.PENDING, Arrays.asList(f2), p2, u1);
//		//Reservation r3 = new Reservation("ABCD", LocalDate.of(2022, 3, 3), ReservationStatus.PENDING,Arrays.asList(f3),p3,u3);
//
//		reservationController.saveReservation(r1);
//		//reservationController.saveReservation(r2);
////		reservationController.saveReservation(r3);
//
//		System.out.println("-------------------------------------------");
//
//		reservationController.allReservations().forEach(System.out::println);
//


	}

}
