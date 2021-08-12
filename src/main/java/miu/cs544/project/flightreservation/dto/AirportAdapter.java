package miu.cs544.project.flightreservation.dto;

import org.springframework.stereotype.Component;


import miu.cs544.project.flightreservation.model.Address;
import miu.cs544.project.flightreservation.model.Airport;
@Component
public class AirportAdapter {

	
	public Airport DTOtoAirport(AirportDTO addressDTO) {
		Airport airport = new Airport();
		Address address = new Address();
		airport.setCode(addressDTO.getCode());
		airport.setName(addressDTO.getName());
		address.setCity(addressDTO.getCity());
		address.setStreet(addressDTO.getStreet());
		address.setZip(addressDTO.getZip());
		address.setState(addressDTO.getState());
		airport.setAddress(address);
		return airport;
	}
}
