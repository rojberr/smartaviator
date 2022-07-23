package dev.drzymala.smartaviator.cargo.application.port;

import dev.drzymala.smartaviator.cargo.domain.Cargo;
import dev.drzymala.smartaviator.cargo.domain.Flight;
import lombok.Value;

import java.time.Instant;
import java.util.Optional;

public interface CargoUseCase {

    Optional<?> getWeight(Long flightId, Instant departureDate);

    Optional<GetFlightsAndBaggageResponse> getFlightsAndBaggageAmount(String iata, Instant departureDate);

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

    record GetFlightsAndBaggageResponse(Long flightsDeparting, Long flightsArriving, Long baggageArriving,
                                        Long baggageDeparting) {}
}
