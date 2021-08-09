package miu.cs544.project.flightreservation.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.Data;
import miu.cs544.project.flightreservation.model.Reservation;
import miu.cs544.project.flightreservation.repository.FlightRepository;
import miu.cs544.project.flightreservation.repository.PassangerRepository;
import miu.cs544.project.flightreservation.repository.ReservationRepository;
import miu.cs544.project.flightreservation.repository.UserRepository;

@Service
@Data
@Transactional
public class ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private FlightRepository flightRepository;
	@Autowired
	private PassangerRepository passangerRepository;
	@Autowired
	private UserRepository userRepository;
	
	public List<Reservation> allReservation(){
		return reservationRepository.findAll();
	}
	
	public Reservation saveReservation(Reservation reservation) {
		return reservationRepository.save(reservation);
	}
}
