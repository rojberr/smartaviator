package dev.drzymala.smart4aviation.application.port;

import java.time.Instant;

public interface CargoUseCase {

    public Long getWeight(Long flightId, Instant date);

    public String getFlightsAndBaggageAmount(String iata, Instant date);
}
