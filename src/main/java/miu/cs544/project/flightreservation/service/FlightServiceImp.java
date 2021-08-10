package miu.cs544.project.flightreservation.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import miu.cs544.project.flightreservation.model.Airline;
import miu.cs544.project.flightreservation.model.Airport;
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
    @Autowired
    private AirlineService airlineService;
@Autowired
private AirportService airportService;
    public List<Flight> allFlights() {
        return repository.findAll();
    }


    public Flight saveFlight(FlightDTO flightDTO) {
        Flight flight= new Flight();

        if(flightDTO!=null) {
            Airline airline = (Airline) airlineService.findByAiportCode(flightDTO.getAirlineCode());

            Optional<Airport> arrivalAirport = airportService.oneAirport(flightDTO.getArrivalAirport());

            Optional<Airport> departureAirport = airportService.oneAirport(flightDTO.getDepartureAirport());

            if (arrivalAirport != null && departureAirport != null && airline!=null) {

                flight.setCapacity(flightDTO.getCapacity());
                flight.setPrice(flightDTO.getPrice());
                flight.setFlightNumber(flightDTO.getFlightNumber());
                flight.setAvailableSeat(flightDTO.getAvailableSeat());
                flight.setDepartureTime(flightDTO.getDepartureTime());
                flight.setArrivalTime(flightDTO.getArrivalTime());
                flight.setDepartureAirport(departureAirport.get());
                flight.setArrivalAirport(arrivalAirport.get());
                flight.setAirline(airline);
                return repository.save(flight);
            }
            //todo need airport by code now it oworks by ID

        }
        return null;
    }

    @Override
    public List<Flight> searchFlightbyDepartureandDestination(LocalDateTime departureDate, String departureAirport, String destinationAirport) {
        return repository.searchFlightbyDepartureandDestination(departureDate, departureAirport, destinationAirport);
       // return null;
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
