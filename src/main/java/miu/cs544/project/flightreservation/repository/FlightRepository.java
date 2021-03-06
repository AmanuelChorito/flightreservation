package miu.cs544.project.flightreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import miu.cs544.project.flightreservation.model.Flight;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional
public interface FlightRepository extends JpaRepository<Flight, Integer> {
	
  @Query("select f from Flight f where f.departureAirport.code=:departureAirport and f.arrivalAirport.code=:arrivalAirport and f.departureTime=:departureDate")
  List<Flight> searchFlightbyDepartureandDestination(LocalDateTime departureDate, String departureAirport, String arrivalAirport);

  
  @Query("select f from Flight f where f.departureTime=:departureDate and f.departureAirport.name=:departureAirport")
  List<Flight> searchByTime(LocalDateTime departureDate, String departureAirport);
  
  @Query("delete from Flight f where f.id=:id")
  void deleteFlightById(int id);
}



