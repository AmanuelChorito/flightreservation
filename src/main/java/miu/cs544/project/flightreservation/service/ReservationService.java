package miu.cs544.project.flightreservation.service;

import java.util.List;
import java.util.Optional;

import miu.cs544.project.flightreservation.model.Reservation;


public interface ReservationService {

	
public List<Reservation> allReservations();
	
	public Optional<Reservation> oneReservation(int id);
	
	public void deleteReservation(int id);
	
	public Reservation saveReservation(Reservation reservation);
	
	public Reservation updateReservation(int id, Reservation reservation);
}
