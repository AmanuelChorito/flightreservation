package miu.cs544.project.flightreservation.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@SecondaryTable(name="History")
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    private String name;
    @Column(table="History", length = 2000)
    private String history;
}
