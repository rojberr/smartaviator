package dev.drzymala.smart4aviation.application.port;

import java.time.Instant;

public interface CargoUseCase {

    Long getWeight(Long flightId, Instant date);

    String getFlightsAndBaggageAmount(String iata, Instant date);
}
