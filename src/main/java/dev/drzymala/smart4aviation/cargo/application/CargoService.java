package dev.drzymala.smart4aviation.cargo.application;

import dev.drzymala.smart4aviation.cargo.application.port.CargoUseCase;
import dev.drzymala.smart4aviation.cargo.db.CargoJpaRepository;
import dev.drzymala.smart4aviation.cargo.db.FlightJpaRepository;
import dev.drzymala.smart4aviation.cargo.domain.Baggage;
import dev.drzymala.smart4aviation.cargo.domain.Cargo;
import dev.drzymala.smart4aviation.cargo.domain.Flight;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CargoService implements CargoUseCase {

    private final FlightJpaRepository flightRepository;
    private final CargoJpaRepository cargoRepository;

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

        // total number pieces of bababge arriving to this airport

        // total number pieces of baggage departing from this airport
        return Optional.of(
                new GetFlightsAndBaggageResponse(
                        (long) flightRepository.findByDepartureAirportIATACode(iata).size(),
                        (long) flightRepository.findByArrivalAirportIATACode(iata).size(),
                        0L, 0L));
//        return flightRepository.findByDepartureAirportIATACodeAndDepartureDate(iata, departureDate);
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
