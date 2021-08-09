package miu.cs544.project.flightreservation.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Data
@Entity
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="ticketNumber", length = 20, nullable = false)
    private String ticketNumber; //List<String> TicketNumbers
    private int flightId;
    //@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //private Passenger passenger;

    //private Flight flight;
    
    private String ReservationCode;
}
