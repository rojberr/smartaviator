package dev.drzymala.smart4aviation.cargo.application;

import dev.drzymala.smart4aviation.cargo.application.port.CargoUseCase;
import dev.drzymala.smart4aviation.cargo.db.FlightJpaRepository;
import dev.drzymala.smart4aviation.cargo.domain.Flight;
import dev.drzymala.smart4aviation.cargo.domain.Iata;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CargoService implements CargoUseCase {

    FlightJpaRepository repository;

    @Override
    public Optional<Flight> getWeight(Long flightId, Instant date) {
        return repository.findByFlightIdAndDepartureDate(flightId, date);
    }

    @Override
    public Optional<Flight> getFlightsAndBaggageAmount(Iata iata, Instant date) {
        return repository.findByIataAndDepartureDate(iata, date);
    }
}
