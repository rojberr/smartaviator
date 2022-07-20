package dev.drzymala.smartaviator.cargo.db;

import dev.drzymala.smartaviator.cargo.domain.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface FlightJpaRepository extends JpaRepository<Flight, Long> {

    Optional<Flight> findByFlightNumberAndDepartureDate(Long flightNumber, Instant departureDate);

    List<Flight> findByDepartureAirportIATACode(String iata);

    List<Flight> findByArrivalAirportIATACode(String iata);
}
