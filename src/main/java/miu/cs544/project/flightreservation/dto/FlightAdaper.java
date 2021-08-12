package miu.cs544.project.flightreservation.dto;

import miu.cs544.project.flightreservation.model.Airline;
import miu.cs544.project.flightreservation.model.Airport;
import miu.cs544.project.flightreservation.model.Flight;
import miu.cs544.project.flightreservation.service.AirlineService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.List;
@Component
public class FlightAdaper {
    @Autowired
    AirlineService airlineService;
    public static Flight getFlight(FlightDTO flightDTO){
//        Flight flight= new Flight();
//        if(flightDTO!=null){
//             Airline airline= airlineService.findByAiportCode(flightDTO.getAirlineCode());
//
//            Airport arrivalAirport;
//
//             Airport departureAirport;
//        }
        return null;

    }
    public static FlightDTO getflightDTO(){
        return null;
    }
    public static List<FlightDTO> getflightDTOList(){
        return null;
    }

}
