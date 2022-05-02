package dev.drzymala.smart4aviation.application;

import dev.drzymala.smart4aviation.application.port.CargoUseCase;

import java.time.Instant;

public class CargoService implements CargoUseCase {

    @Override
    public Long getWeight(Long flightId, Instant date) {
        return null;
    }

    @Override
    public String getFlightsAndBaggageAmount(String iata, Instant date) {
        return null;
    }
}
