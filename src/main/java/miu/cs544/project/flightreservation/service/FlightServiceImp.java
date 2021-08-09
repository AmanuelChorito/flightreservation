package miu.cs544.project.flightreservation.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import miu.cs544.project.flightreservation.model.Flight;
import miu.cs544.project.flightreservation.repository.FlightRepository;

@Service
@Data
public class FlightServiceImp implements FlightServices {

    @Autowired
    private FlightRepository repository;

    public List<Flight> allFlights() {
        return repository.findAll();
    }


    public Flight saveFlight(Flight flight) {


        return repository.save(flight);
    }

    @Override
    public List<Flight> searchFlightbyDepartureandDestination(LocalDateTime departureDate, String departureAirport, String destinationAirport) {
       // return repository.searchFlightbyDepartureandDestination(departureDate, departureAirport, destinationAirport);
        return null;
    }

    @Override
    public Flight editFlight(int id,Flight flight) {
        Optional<Flight> flight1= getFlightById(id);

        Flight flight2= flight1.orElse(null);

        if (flight2 != null) {
          flight2.setFlightNumber(flight.getFlightNumber());
          flight2.setAirline(flight.getAirline());
          flight2.setCapacity(flight.getCapacity());
          flight2.setArrivalAirport(flight.getArrivalAirport());
          flight2.setAirline(flight.getAirline());
          flight2.setArrivalTime(flight.getArrivalTime());
          flight2.setDepartureAirport(flight.getDepartureAirport());
          flight2.setDepartureTime(flight.getDepartureTime());
          flight2.setPrice(flight.getPrice());

            return repository.save(flight2);
        }
        return null;
    }

    @Override
    public Optional<Flight>getFlightById (int flightid) {
        return  Optional.of(repository.getById(flightid));
    }

    @Override
    public Flight deleteFlight(Flight flight) {
        return null;
    }


}
