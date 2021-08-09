package miu.cs544.project.flightreservation.service;

import miu.cs544.project.flightreservation.model.Flight;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface FlightServices {


    List<Flight> allFlights();

    Flight saveFlight(Flight flight);

    List<Flight> searchFlightbyDepartureandDestination(LocalDateTime departureDate, String departureAirport, String destinationAirport);
        //TODO
    Flight editFlight(int id,Flight flight);


    Flight deleteFlight(Flight flight);

    Optional<Flight> getFlightById(int flightid);



}
