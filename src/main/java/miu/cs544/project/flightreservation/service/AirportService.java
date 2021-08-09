package miu.cs544.project.flightreservation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import miu.cs544.project.flightreservation.model.Airport;
import miu.cs544.project.flightreservation.repository.AirPortRepository;

public interface AirportService {
	
	public List<Airport> allAirports();
	
	public Optional<Airport> oneAirport(int id);
	
	public void deleteAirport(int id);
	
	public Airport saveAirport(Airport airport);
	
	public Airport updateAirport(int id, Airport airport);
}
