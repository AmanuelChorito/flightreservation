package miu.cs544.project.flightreservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import miu.cs544.project.flightreservation.model.Airport;

@Repository
@Transactional
public interface AirPortRepository extends JpaRepository<Airport, Integer>{

	@Query("select distinct a from Airline a join Flight  f where f.departureAirport.code =:airportcode")
    List<Airport> findByAiportCode(String airportcode);
	
	
}
