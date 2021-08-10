package miu.cs544.project.flightreservation.controller;

import java.net.URI;
import java.util.List;

import miu.cs544.project.flightreservation.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.Data;
import miu.cs544.project.flightreservation.model.Airline;
import miu.cs544.project.flightreservation.service.AirlineServiceImp;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@Data
@RequestMapping("/airlines")
public class AirlineController {

    @Autowired
    private AirlineService airlineService;

    @GetMapping
    public List<Airline> allAirlines() {
        return airlineService.allAirlines();
    }

    @GetMapping("/{airportcode}")
    public ResponseEntity<?>  findByAiportCode(@PathVariable String airportcode) {
        List<Airline> airlines=airlineService.findByAiportCode(airportcode);
        if(airlines==null)
            return new ResponseEntity<>("airlines not found by the given airportcode",HttpStatus.NOT_FOUND);
        else return new ResponseEntity<>(airlines,HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<Airline> saveAirline(@RequestBody Airline airline) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/airlines/create").toUriString());
        return ResponseEntity.created(uri).body(airlineService.saveAirline(airline));
    }

    @PutMapping("/{id}")
    ResponseEntity<?> updateAirline(@RequestBody Airline newAirline, @PathVariable int id) {

        Airline airline1 = airlineService.updateAirline(newAirline, id);
        if (airline1 == null)
            return new ResponseEntity<>("Id not found",HttpStatus.BAD_REQUEST);
        else return new ResponseEntity<>(airline1, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    void deleteAirline(@PathVariable int id) {
        airlineService.deleteAirline(id);
    }

}
