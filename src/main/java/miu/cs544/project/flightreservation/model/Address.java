package miu.cs544.project.flightreservation.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    //private int id;   // no need of id

    private String street;
    private String city;
    private String state;
    private String zip;


}
