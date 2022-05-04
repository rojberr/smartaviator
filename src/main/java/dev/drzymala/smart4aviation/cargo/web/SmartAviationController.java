package dev.drzymala.smart4aviation.cargo.web;

import dev.drzymala.smart4aviation.cargo.application.port.CargoUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/cargo")
@AllArgsConstructor
public class SmartAviationController {

    private final CargoUseCase cargoService;

    @GetMapping(params = {"flightid", "date"})
    public ResponseEntity<?> getWeight(@RequestParam Long flightId, @RequestParam Instant date) {
        return cargoService
                .getWeight(flightId, date)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(params = {"iata", "date"})
    public ResponseEntity<?> getFlightsAndBaggageAmount(@RequestParam String iata, @RequestParam Instant date) {
        return cargoService
                .getFlightsAndBaggageAmount(iata, date)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}


