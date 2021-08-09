package miu.cs544.project.flightreservation.service;

import miu.cs544.project.flightreservation.model.Passenger;

import java.util.List;

public interface PassengerService {
    List<Passenger> allPassangers();

    Passenger savePassanger(Passenger passanger);

    Passenger findById(int id);

    Passenger updatePassenger(Passenger passenger, int id);


}
