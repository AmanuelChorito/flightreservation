package miu.cs544.project.flightreservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import miu.cs544.project.flightreservation.model.Passenger;
import miu.cs544.project.flightreservation.service.PassangerService;

@RestController
@Data
@RequestMapping("/passangers")
public class PassangerController {

	@Autowired
	private PassangerService passangerService;
	
	@GetMapping
	public List<Passenger> allPassangers(){
		return passangerService.allPassangers();
	}
	
	public Passenger savePassanger(Passenger passanger) {
		return passangerService.savePassanger(passanger);
	}
}
