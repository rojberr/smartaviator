package dev.drzymala.smart4aviation.application;

import dev.drzymala.smart4aviation.application.port.CargoUseCase;
import dev.drzymala.smart4aviation.db.FlightJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@AllArgsConstructor
public class CargoService implements CargoUseCase {

    FlightJpaRepository repository;

    @Override
    public Long getWeight(Long flightId, Instant date) {
        return null;
    }

    @Override
    public String getFlightsAndBaggageAmount(String iata, Instant date) {
        return null;
    }
}
