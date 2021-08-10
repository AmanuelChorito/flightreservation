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
 @Query("select f from Flight  f where f.departureAirport.name=:departureAirport and f.arrivalAirport.name=:arrivalAirport and f.departureTime=:departureDate")
  List<Flight> searchFlightbyDepartureandDestination(LocalDateTime departureDate, String arrivalAirport, String departureAirport);

  // find by flight number


}



