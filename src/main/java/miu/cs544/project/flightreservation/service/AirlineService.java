package miu.cs544.project.flightreservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import miu.cs544.project.flightreservation.model.Airline;
import miu.cs544.project.flightreservation.repository.AirlineRepository;


@Service
@Data
public class AirlineService {

	@Autowired
	private AirlineRepository repository;
	
	public List<Airline> allAirlines(){
		return repository.findAll();
	}
	
	public Airline saveAirline(Airline airline) {
		return repository.save(airline);
	}
}
