package miu.cs544.project.flightreservation.service;

import miu.cs544.project.flightreservation.model.Airline;

import java.util.List;

public interface AirlineService {
    List<Airline> allAirlines();
    Airline saveAirline(Airline airline);
    List<Airline> findByAiportCode(String airportcode);
    Airline findById(int id);
    Airline updateAirline(Airline newAirline,int id);

}
