package miu.cs544.project.flightreservation.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Data
public class Flight {
    @Id
    @GeneratedValue
    private int id;
    private String flightNumber;
    private int capacity;
    private int availableSeat;
    private LocalDate departureTime;
    private LocalDate arrivalTime;
    private double price;
    @ManyToOne
    private Airline airline;
    @ManyToOne
    private Airport arrivalAirport;
    @ManyToOne
    private Airport departureAirport;

}
