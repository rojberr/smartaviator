package dev.drzymala.smart4aviation.cargo.application.port;

import dev.drzymala.smart4aviation.cargo.domain.Cargo;
import dev.drzymala.smart4aviation.cargo.domain.Flight;
import lombok.Value;

import java.time.Instant;
import java.util.Optional;

public interface CargoUseCase {

    Optional<?> getWeight(Long flightId, Instant departureDate);

    Optional<Flight> getFlightsAndBaggageAmount(String iata, Instant departureDate);

    Flight addFlight(Flight flight);

    Cargo addCargo(Cargo cargo);

    @Value
    class GetWeightResponse {
        Double baggageWeight;
        Double cargoWeight;
        Double totalWeight;

        public GetWeightResponse(Double baggageWeight, Double cargoWeight) {
            this.totalWeight = baggageWeight + cargoWeight;
            this.baggageWeight = baggageWeight;
            this.cargoWeight = cargoWeight;
        }
    }
}
