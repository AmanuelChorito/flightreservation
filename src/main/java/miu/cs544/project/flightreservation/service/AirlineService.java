package miu.cs544.project.flightreservation.service;

import miu.cs544.project.flightreservation.model.Airline;
import miu.cs544.project.flightreservation.model.Airport;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public interface AirlineService {
    List<Airline> allAirlines();
    Airline saveAirline(Airline airline);
    Airline findByAirlineCode(String airlinecode);
    List<Airline> findByAirportCode(String airportcode);
    Airline findById(int id);
    Airline updateAirline(Airline newAirline,int id);
    void deleteAirline(int id);
}
