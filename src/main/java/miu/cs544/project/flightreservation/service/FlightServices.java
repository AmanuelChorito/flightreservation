package miu.cs544.project.flightreservation.service;

import miu.cs544.project.flightreservation.dto.FlightDTO;
import miu.cs544.project.flightreservation.model.Flight;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface FlightServices {


    List<Flight> allFlights();

    Flight saveFlight(FlightDTO flightDTO);

    List<Flight> searchFlightbyDepartureandDestination(LocalDateTime departureDate, String departureAirport, String destinationAirport);

    Flight editFlight(int id,Flight flight);


    void deleteFlight(int fid);
    
    void deleteFlightById(int fid);

    Flight getFlightById(int flightid);

     Flight updateFlight(FlightDTO flightDTO, int id);
    
    
    

}
