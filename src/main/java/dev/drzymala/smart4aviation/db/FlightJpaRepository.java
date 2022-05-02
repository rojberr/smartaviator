package dev.drzymala.smart4aviation.db;

import dev.drzymala.smart4aviation.domain.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightJpaRepository extends JpaRepository<Flight, Long> {

}
