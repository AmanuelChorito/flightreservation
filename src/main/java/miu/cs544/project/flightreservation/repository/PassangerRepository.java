package miu.cs544.project.flightreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import miu.cs544.project.flightreservation.model.Passenger;

@Repository
@Transactional
public interface PassangerRepository extends JpaRepository<Passenger, Integer> {

}
