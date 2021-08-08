package miu.cs544.project.flightreservation.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
}
