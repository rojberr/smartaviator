package dev.drzymala.smart4aviation.cargo.application;

import dev.drzymala.smart4aviation.cargo.application.port.CargoUseCase;
import dev.drzymala.smart4aviation.cargo.db.FlightJpaRepository;
import dev.drzymala.smart4aviation.cargo.domain.Flight;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CargoService implements CargoUseCase {

    private final FlightJpaRepository repository;

    @Override
    public Optional<Flight> getWeight(Long flightId, Instant date) {
        return repository.findByFlightIdAndDepartureDate(flightId, date);
    }

    @Override
    public Optional<Flight> getFlightsAndBaggageAmount(String iata, Instant date) {
        return repository.findByDepartureAirportIATACodeAndDepartureDate(iata, date);
    }

    @Override
    public Flight addFlight(Flight flight) {
        return repository.save(flight);
    }
}
