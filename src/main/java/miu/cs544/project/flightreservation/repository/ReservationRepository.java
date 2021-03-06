package miu.cs544.project.flightreservation.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import miu.cs544.project.flightreservation.model.Flight;
import miu.cs544.project.flightreservation.model.Reservation;

@Repository
@Transactional
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

	/*
	 * 
	 *  @Query("select f from Flight  f where f.departureAirport.name=:departureAirport and f.arrivalAirport.name=:arrivalAirport and f.departureTime=:departureDate")
  List<Flight> searchFlightbyDepartureandDestination(LocalDateTime departureDate, String arrivalAirport, String departureAirport);

	 */
	@Query("select r from Reservation r where r.id=:rid and r.passenger.id=:pid")
	Reservation getOneReservationByPassanger(int pid, int rid);
	
	@Query("select r from Reservation r where r.passenger.id=:pid")
	List<Reservation> getAllReservationsByPassanger(int pid);
	
	@Query("select r from Reservation r where r.user.id=:uid")
	List<Reservation> getAllReservationsByAgent(int uid);
	
}
