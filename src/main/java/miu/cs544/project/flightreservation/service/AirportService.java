package miu.cs544.project.flightreservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import miu.cs544.project.flightreservation.model.Airport;
import miu.cs544.project.flightreservation.repository.AirPortRepository;

@Service
@Data
public class AirportService {

	@Autowired
	private AirPortRepository repository;
	
	public List<Airport> allAirports(){
		return repository.findAll();
	}
	
	public Airport saveAirport(Airport airport) {
		return repository.save(airport);
	}
}
