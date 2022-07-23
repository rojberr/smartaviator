package dev.drzymala.smartaviator.cargo.web;

import dev.drzymala.smartaviator.cargo.application.port.CargoUseCase;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@RestController
@RequestMapping("/cargo")
@AllArgsConstructor
public class SmartAviationController {

    private final CargoUseCase cargoService;

    @GetMapping(params = {"flightNumber", "date"})
    public ResponseEntity<?> getWeight(@RequestParam Long flightNumber,
                               @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) {
        return cargoService
                .getWeight(flightNumber, date.toInstant(ZoneOffset.UTC))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(params = {"iata", "date"})
    public ResponseEntity<?> getFlightsAndBaggageAmount(@RequestParam String iata,
                                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) {
        return cargoService
                .getFlightsAndBaggageAmount(iata, date.toInstant(ZoneOffset.UTC))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}