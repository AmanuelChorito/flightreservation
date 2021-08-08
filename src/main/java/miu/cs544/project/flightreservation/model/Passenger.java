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

    // According to report passenger has two addresses so multiplicity should be
    // one or many and we need to change in class diagram


    @Embedded
    @AttributeOverrides( {
            @AttributeOverride(name="street", column=@Column(name="email_street")),
            @AttributeOverride(name="city", column=@Column(name="email_city")),
            @AttributeOverride(name="state", column=@Column(name="email_state")),
            @AttributeOverride(name="zip", column=@Column(name="email_zip"))
    })

    private Address emailAddress;

    @Embedded
    @AttributeOverrides( {
            @AttributeOverride(name="street", column=@Column(name="residence_street")),
            @AttributeOverride(name="city", column=@Column(name="residence_city")),
            @AttributeOverride(name="state", column=@Column(name="residence_state")),
            @AttributeOverride(name="zip", column=@Column(name="residence_zip"))
    })

    private Address residenceAddress;
}
