package dev.drzymala.smart4aviation.cargo.application.port;

import dev.drzymala.smart4aviation.cargo.domain.Flight;

import java.time.Instant;
import java.util.Optional;

public interface CargoUseCase {

    Optional<Flight> getWeight(Long flightId, Instant date);

    Optional<Flight> getFlightsAndBaggageAmount(String iata, Instant date);

    Flight addFlight(Flight flight);
}
