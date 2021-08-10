package miu.cs544.project.flightreservation.service;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import miu.cs544.project.flightreservation.model.Airline;
import miu.cs544.project.flightreservation.model.Airport;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import java.time.LocalDateTime;
@Data@AllArgsConstructor
public class FlightDTO {


    private String flightNumber;
    private int capacity;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd H:m:s")
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private double price;
    private int availableSeat;
    private String airlineCode;
    private int arrivalAirport;
    private int departureAirport;



}
