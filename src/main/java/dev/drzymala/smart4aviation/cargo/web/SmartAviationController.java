package dev.drzymala.smart4aviation.cargo.web;

import dev.drzymala.smart4aviation.cargo.application.port.CargoInitializerUseCase;
import dev.drzymala.smart4aviation.cargo.application.port.CargoUseCase;
import dev.drzymala.smart4aviation.cargo.domain.Flight;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Instant;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class SmartAviationController {

    private final CargoUseCase cargoService;
    private final CargoInitializerUseCase initializer;

    @GetMapping("/cargo-weight")
    public Optional<Flight> getWeight(@RequestParam Long flightId, @RequestParam Instant date) {
        return cargoService.getWeight(flightId, date);
    }

    @GetMapping("/cargo-amount")
    public Optional<Flight> getFlightsAndBaggageAmount(@RequestParam String iata, @RequestParam Instant date) {
        return cargoService.getFlightsAndBaggageAmount(iata, date);
    }

    @PostMapping("/init")
    public void initialize() { initializer.initialize(); }
}