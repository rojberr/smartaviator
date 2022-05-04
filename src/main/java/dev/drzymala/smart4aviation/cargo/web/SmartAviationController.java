package dev.drzymala.smart4aviation.cargo.web;

import dev.drzymala.smart4aviation.cargo.application.port.CargoInitializerUseCase;
import dev.drzymala.smart4aviation.cargo.application.port.CargoUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@AllArgsConstructor
public class SmartAviationController {

    private final CargoUseCase cargoService;
    private final CargoInitializerUseCase initializer;

    @GetMapping("/cargo-weight")
    public ResponseEntity<?> getWeight(@RequestParam Long flightId, @RequestParam Instant date) {
        return cargoService
                .getWeight(flightId, date)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/cargo-amount")
    public ResponseEntity<?> getFlightsAndBaggageAmount(@RequestParam String iata, @RequestParam Instant date) {
        return cargoService
                .getFlightsAndBaggageAmount(iata, date)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/init")
    @ResponseStatus(HttpStatus.CREATED)
    public void initialize() {
        initializer.initialize();
    }
}
