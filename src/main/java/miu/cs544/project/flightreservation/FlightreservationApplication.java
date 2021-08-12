package miu.cs544.project.flightreservation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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
import miu.cs544.project.flightreservation.service.UserService;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class FlightreservationApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(FlightreservationApplication.class, args);
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {return new BCryptPasswordEncoder();}

    //@Bean
    CommandLineRunner run (UserService userService){
        return args -> {
            userService.saveRole(new Role(null, "Role_Customer"));
            userService.saveRole(new Role(null, "Role_Agent"));
            userService.saveRole(new Role(null, "Role_Admin"));

            userService.saveUser(new User( "John", "pass", true, new ArrayList<>()));
            userService.saveUser(new User("Smith", "pass", true, new ArrayList<>()));
            userService.saveUser(new User( "Jim", "pass", true, new ArrayList<>()));
            userService.saveUser(new User( "admin", "123", true, new ArrayList<>()));
            userService.saveUser(new User( "agent", "123", true, new ArrayList<>()));


            userService.addRole("john", "Role_User");
            userService.addRole("smith", "Role_Agent");
            userService.addRole("jim", "Role_Admin");
            userService.addRole("jim", "Role_Agent");
            userService.addRole("admin", "Role_Admin");
            userService.addRole("admin", "Role_User");
            userService.addRole("agent", "Role_Agent");
        };
    }
 }
