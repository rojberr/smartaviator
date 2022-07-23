package dev.drzymala.smartaviator.cargo.application;

import dev.drzymala.smartaviator.cargo.application.port.CargoUseCase;
import dev.drzymala.smartaviator.cargo.db.BaggageJpaRepository;
import dev.drzymala.smartaviator.cargo.db.CargoJpaRepository;
import dev.drzymala.smartaviator.cargo.db.FlightJpaRepository;
import dev.drzymala.smartaviator.cargo.domain.Baggage;
import dev.drzymala.smartaviator.cargo.domain.Cargo;
import dev.drzymala.smartaviator.cargo.domain.Flight;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CargoService implements CargoUseCase {

    private final FlightJpaRepository flightRepository;
    private final CargoJpaRepository cargoRepository;
    private final BaggageJpaRepository baggageRepository;

    @Override
    public Optional<GetWeightResponse> getWeight(Long flightNumber, Instant departureDate) {

        Optional<Flight> flight = flightRepository.findByFlightNumberAndDepartureDate(flightNumber, departureDate);

        if (flight.isPresent()) {

            Optional<Cargo> cargo = cargoRepository.findByFlightId(flight.get().getFlightId());
            if (cargo.isPresent()) {
                Double baggageWeight = cargo.get().getBaggage().stream().mapToDouble(Baggage::getWeight).sum();
                Double cargoWeight = cargo.get().getCargo().stream().mapToDouble(Baggage::getWeight).sum();
                return Optional.of(new GetWeightResponse(baggageWeight, cargoWeight));
            }
            return Optional.empty();
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<GetFlightsAndBaggageResponse> getFlightsAndBaggageAmount(String iata, Instant departureDate) {

        return Optional.of(
                new GetFlightsAndBaggageResponse(
                        (long) flightRepository.findByDepartureAirportIATACode(iata).size(),
                        (long) flightRepository.findByArrivalAirportIATACode(iata).size(),
                        // TODO: REFACTOR: total number pieces of baggage arriving to this airport
                        baggageRepository.count(),
                        // TODO: REFACTOR: total number pieces of baggage departing from this airport
                        baggageRepository.count()));
    }

    @Override
    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public Cargo addCargo(Cargo cargo) {
        return cargoRepository.save(cargo);
    }
}
