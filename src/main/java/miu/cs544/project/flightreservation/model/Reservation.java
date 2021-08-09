package miu.cs544.project.flightreservation.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String reservationCode;
    private LocalDate reservedDate;
    private double totalPrice;
    private ReservationStatus status;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Flight> flightList= new ArrayList<>();
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Passenger passenger;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Ticket> tickets;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User user;
    
   // /reservations/ body of list of flightIds POST
    
    // /flights/ body passanges
    
    //if there is no available seats for all the flight list are full then no reservation is allowed
	public Reservation(String reservationCode, LocalDate reservationDate, ReservationStatus status,
			List<Flight> flightList, Passenger passenger, User user) {
		this.reservationCode = reservationCode;
		this.reservedDate = reservationDate;
		this.totalPrice = getTotalPrice(flightList);
		this.status = status;
		this.flightList = flightList;
		this.passenger = passenger;
		this.user = user;
	}
	
	public double getTotalPrice(List<Flight> flightList) {
		double total = 0.0;
		for(Flight f:flightList) {
			total+=f.getPrice();
		}
		return total;
	}
    
    
}
