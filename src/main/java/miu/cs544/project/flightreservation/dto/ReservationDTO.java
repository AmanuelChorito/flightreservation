package miu.cs544.project.flightreservation.dto;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import miu.cs544.project.flightreservation.model.Flight;
import miu.cs544.project.flightreservation.model.Passenger;
import miu.cs544.project.flightreservation.model.Reservation;
import miu.cs544.project.flightreservation.model.ReservationStatus;

@Data
public class ReservationDTO {

	private String reservationCode;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate reservedDate;
    private ReservationStatus status;
    private List<Integer> flightIds;
    private int passangerId;
    private Passenger passenger;
    private int userId;
    
}
