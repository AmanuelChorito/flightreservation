package miu.cs544.project.flightreservation.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import miu.cs544.project.flightreservation.dto.FlightDTO;
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
        Flight flight = new Flight();
        System.out.println("dto recived" + flightDTO);
        if (flightDTO != null) {

            Airline airline = (Airline) airlineService.findByAirlineCode(flightDTO.getAirlineCode());

            Optional<Airport> arrivalAirport = airportService.oneAirport(flightDTO.getArrivalAirport());

            Optional<Airport> departureAirport = airportService.oneAirport(flightDTO.getDepartureAirport());

            if (arrivalAirport != null && departureAirport != null && airline != null) {

                return getFlightAdapter(flightDTO, flight, airline, arrivalAirport, departureAirport);
            }


        }
        return null;
    }

    @Override
    public List<Flight> searchFlightbyDepartureandDestination(LocalDateTime departureDate, String departureAirport, String arivalAirport) {
        return repository.searchFlightbyDepartureandDestination(departureDate, departureAirport, arivalAirport);
    }

    @Override
    public Flight editFlight(int id, Flight flight) {

        Flight flight2 = getFlightById(id);

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
    public Flight updateFlight(FlightDTO flightDTO, int id) {
        Flight flight = getFlightById(id);

        System.out.println("dto recived" + flightDTO);
        if (flightDTO != null && flight != null) {

            Airline airline = (Airline) airlineService.findByAirlineCode(flightDTO.getAirlineCode());

            Optional<Airport> arrivalAirport = airportService.oneAirport(flightDTO.getArrivalAirport());

            Optional<Airport> departureAirport = airportService.oneAirport(flightDTO.getDepartureAirport());

            if (arrivalAirport.isPresent() && departureAirport.isPresent() && airline != null) {

                return getFlightAdapter(flightDTO, flight, airline, arrivalAirport, departureAirport);
            }


        }
        return null;
    }

    private Flight getFlightAdapter(FlightDTO flightDTO, Flight flight, Airline airline, Optional<Airport> arrivalAirport, Optional<Airport> departureAirport) {
        flight.setCapacity(flightDTO.getCapacity());
        flight.setPrice(flightDTO.getPrice());
        flight.setFlightNumber(flightDTO.getFlightNumber());
        flight.setAvailableSeat(flightDTO.getAvailableSeat());
        flight.setDepartureTime(flightDTO.getDepartureTime());
        flight.setArrivalTime(flightDTO.getArrivalTime());
        flight.setDepartureAirport(departureAirport.get());
        flight.setArrivalAirport(arrivalAirport.get());
        flight.setAirline(airline);

        System.out.println("flight sent is" + flight);

        return repository.save(flight);
    }

    @Override
    public Flight getFlightById(int flightid) {
        return repository.findById(flightid).orElse(null);
    }

    @Override
    public void deleteFlight(int fid) {
        repository.deleteById(fid);
    }


    @Override
    public void deleteFlightById(int fid) {
        repository.deleteFlightById(fid);
    }


}
