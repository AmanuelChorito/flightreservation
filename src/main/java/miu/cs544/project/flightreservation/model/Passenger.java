package miu.cs544.project.flightreservation.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Entity
@Data
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    @Past
    private LocalDate dateOfBirth;
    private String email;
    private String emailAddress;

    @Embedded
    private Address residenceAddress;
}
