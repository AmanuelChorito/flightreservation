package miu.cs544.project.flightreservation.service;

import java.util.List;
import java.util.Optional;

import miu.cs544.project.flightreservation.model.Flight;



public interface FlightService {

	
	public List<Flight> allFlights();
	
	public Flight saveFlight(Flight flight);
	
	public Optional<Flight> getFlightById(int id);
}
