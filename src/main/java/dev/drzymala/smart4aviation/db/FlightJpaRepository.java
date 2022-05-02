package dev.drzymala.smart4aviation.db;

import dev.drzymala.smart4aviation.domain.Flight;
import dev.drzymala.smart4aviation.domain.Iata;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.Optional;

public interface FlightJpaRepository extends JpaRepository<Flight, Long> {

    Optional<Flight> findByFlightIdAndDepartureDate(Long flightId, Instant departureDate);

    Optional<Flight> findByIataAndDepartureDate(Iata iata, Instant departureDate);
}
