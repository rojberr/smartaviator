package dev.drzymala.smart4aviation.application.port;

import dev.drzymala.smart4aviation.domain.Flight;
import dev.drzymala.smart4aviation.domain.Iata;

import java.time.Instant;
import java.util.Optional;

public interface CargoUseCase {

    Optional<Flight> getWeight(Long flightId, Instant date);

    Optional<Flight> getFlightsAndBaggageAmount(Iata iata, Instant date);
}
