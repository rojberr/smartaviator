package dev.drzymala.smart4aviation.cargo.application.port;

import dev.drzymala.smart4aviation.cargo.domain.Cargo;
import dev.drzymala.smart4aviation.cargo.domain.Flight;

import java.time.Instant;
import java.util.Optional;

public interface CargoUseCase {

    Optional<Flight> getWeight(Long flightId, Instant departureDate);

    Optional<Flight> findByDepartureDate(Instant departureDate);

    Optional<Flight> findById(Long flightId);

    Optional<Flight> getFlightsAndBaggageAmount(String iata, Instant departureDate);

    Flight addFlight(Flight flight);

    Cargo addCargo(Cargo cargo);
}
