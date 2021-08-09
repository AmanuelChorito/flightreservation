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

	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private FlightRepository flightRepository;
	@Autowired
	private PassangerRepository passangerRepository;
	@Autowired
	private UserRepository userRepository;
	

	@Override
	public List<Reservation> allReservations() {
		// TODO Auto-generated method stub
		return reservationRepository.findAll();
	}

	@Override
	public Optional<Reservation> oneReservation(int id) {
		// TODO Auto-generated method stub
		return reservationRepository.findById(id);
	}

	@Override
	public void deleteReservation(int id) {
		// TODO Auto-generated method stub
		reservationRepository.deleteById(id);
	}

	@Override
	public Reservation saveReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		return reservationRepository.save(reservation);
	}

	@Override
	public Reservation updateReservation(int id, Reservation updatedReservation) {
		Optional<Reservation> reservation= oneReservation(id);
		Reservation reservation1 = reservation.orElse(null);
		if(reservation1!=null) {
			reservation1.setReservationCode(updatedReservation.getReservationCode());
			reservation1.setStatus(updatedReservation.getStatus());
			reservation1.setFlightList(updatedReservation.getFlightList());
			reservation1.setPassenger(updatedReservation.getPassenger());
			reservation1.setTickets(updatedReservation.getTickets());
			reservation1.setUser(updatedReservation.getUser());
			return reservation1;
		}
		return null;
		
	}
}
