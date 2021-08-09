package miu.cs544.project.flightreservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import miu.cs544.project.flightreservation.model.Passenger;
import miu.cs544.project.flightreservation.repository.PassangerRepository;

@Service
@Data
public class PassangerService {

	@Autowired
	private PassangerRepository repository;
	
	public List<Passenger> allPassangers(){
		return repository.findAll();
	}
	
	public Passenger savePassanger(Passenger passanger) {
		return repository.save(passanger);
	}
}
