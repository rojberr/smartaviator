package dev.drzymala.smart4aviation.cargo.db;

import dev.drzymala.smart4aviation.cargo.domain.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.Optional;

public interface FlightJpaRepository extends JpaRepository<Flight, Long> {

    Optional<Flight> findByFlightIdAndDepartureDate(Long flightId, Instant departureDate);

    Optional<Flight> findByFlightId(Long flightId);

    Optional<Flight> findByDepartureDate(Instant departureDate);

    Optional<Flight> findByDepartureAirportIATACodeAndDepartureDate(String iata, Instant departureDate);
}
