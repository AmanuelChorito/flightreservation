package miu.cs544.project.flightreservation.service;

import java.util.List;
import java.util.Optional;

import miu.cs544.project.flightreservation.model.Airline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import miu.cs544.project.flightreservation.model.Passenger;
import miu.cs544.project.flightreservation.repository.PassangerRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Data
@Transactional
public class PassangerServiceImp implements PassengerService {

    @Autowired
    private PassangerRepository repository;

    public List<Passenger> allPassangers() {
        return repository.findAll();
    }

    public Passenger savePassanger(Passenger passanger) {
        return repository.save(passanger);
    }


    public Optional<Passenger> findById(int id) {
        return repository.findById(id);
    }


    public Passenger updatePassenger(Passenger passenger, int id) {

        Optional<Passenger> updatedpassenger= findById(id);
        Passenger passenger2=updatedpassenger.orElse(null);
        if(passenger2!=null){
            passenger2.setFirstName(passenger.getFirstName());
            passenger2.setLastName(passenger.getLastName());
            passenger2.setDateOfBirth(passenger.getDateOfBirth());
            passenger2.setResidenceAddress(passenger.getResidenceAddress());
            return repository.save(passenger2);
        }
        return  null;
    }
}
