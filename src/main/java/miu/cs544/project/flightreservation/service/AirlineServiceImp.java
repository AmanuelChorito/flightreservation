package miu.cs544.project.flightreservation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import miu.cs544.project.flightreservation.model.Airline;
import miu.cs544.project.flightreservation.repository.AirlineRepository;
import org.springframework.transaction.annotation.Transactional;


@Service
@Data
@Transactional
public class AirlineServiceImp implements AirlineService{

	@Autowired
	private AirlineRepository repository;
	
	public List<Airline> allAirlines(){
		return repository.findAll();
	}
	
	public Airline saveAirline(Airline airline) {
		return repository.save(airline);
	}


	public List<Airline> findByAiportCode(String airportcode) {
		return repository.findByAiportCode(airportcode);
	}


	public Airline findById(int id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Airline updateAirline(Airline airline, int id) {
		Optional<Airline> updatedairline= Optional.ofNullable(findById(id));
		Airline airline2=updatedairline.orElse(null);
		if(airline2!=null){
			airline2.setCode(airline.getCode());
			airline2.setName(airline.getName());
			airline2.setHistory(airline.getHistory());
			return repository.save(airline2);
		}
		return  null;

	}


}
