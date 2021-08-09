package miu.cs544.project.flightreservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import miu.cs544.project.flightreservation.model.Flight;
import miu.cs544.project.flightreservation.repository.FlightRepository;

@Service
@Data
public class FlightService {

	@Autowired
	private FlightRepository repository;
	
	public List<Flight> allFlights(){
		return repository.findAll();
	}
	
	public Flight saveFlight(Flight flight) {
		return repository.save(flight);
	}
}
