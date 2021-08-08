package miu.cs544.project.flightreservation.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Ticket {
    @Id
    @GeneratedValue
    private int id;
    private String ticketNumber;

}
