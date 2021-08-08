package miu.cs544.project.flightreservation.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Reservation {
    @Id
    @GeneratedValue
    private int id;
    private String reservationCode;
    private LocalDate reservationDate;
    private double totalPrice;
    private ReservationStatus status;
    @ManyToMany
    private List<Flight> flightList= new ArrayList<>();
    @ManyToOne(cascade = CascadeType.ALL)
    private Passenger passenger;
}
