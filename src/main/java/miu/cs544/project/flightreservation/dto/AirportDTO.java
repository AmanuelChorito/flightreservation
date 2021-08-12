package miu.cs544.project.flightreservation.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Embedded;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import miu.cs544.project.flightreservation.model.Address;
import miu.cs544.project.flightreservation.model.Passenger;
import miu.cs544.project.flightreservation.model.ReservationStatus;

@Data
public class AirportDTO {

	 private String code;
	 private String name;
	 private String street;
	 private String city;
	 private String state;
	 private String zip;
}
