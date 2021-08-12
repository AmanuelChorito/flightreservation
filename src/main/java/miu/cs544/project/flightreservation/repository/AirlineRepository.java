package miu.cs544.project.flightreservation.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import miu.cs544.project.flightreservation.model.Airline;
import miu.cs544.project.flightreservation.model.Airport;

import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface AirlineRepository extends JpaRepository<Airline, Integer> {

    @Query("select a from Airline a where a.code=:airlineCode")
    Airline findByAirlineCode(String airlineCode);
    
    @Query("select f.airline from Flight f where f.departureAirport.code=:airportcode")
    List<Airline> findByAiportCode(String airportcode);
}


