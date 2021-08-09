package miu.cs544.project.flightreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import miu.cs544.project.flightreservation.model.Airport;

@Repository
@Transactional
public interface AirPortRepository extends JpaRepository<Airport, Integer>{

	
}
