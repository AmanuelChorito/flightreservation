package miu.cs544.project.flightreservation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import miu.cs544.project.flightreservation.model.Airport;
import miu.cs544.project.flightreservation.model.Reservation;
import miu.cs544.project.flightreservation.repository.FlightRepository;
import miu.cs544.project.flightreservation.repository.PassangerRepository;
import miu.cs544.project.flightreservation.repository.ReservationRepository;
import miu.cs544.project.flightreservation.repository.UserRepository;

public class ReservationImp implements ReservationService {

	@Override
	public List<Reservation> allReservations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Reservation> oneReservation(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteReservation(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Reservation saveReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation updateReservation(int id, Reservation reservation) {
		// TODO Auto-generated method stub
		return null;
	}

//	
}
