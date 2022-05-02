package dev.drzymala.smart4aviation.web;

import dev.drzymala.smart4aviation.application.port.CargoUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Instant;

@Controller
@AllArgsConstructor
public class SmartAviationController {

    private final CargoUseCase cargoService;

    @GetMapping("/cargo-weight")
    public Long getWeight(@RequestParam Long flightId, @RequestParam Instant date) {
        return cargoService.getWeight(flightId, date);
    }

    @GetMapping("/cargo-amount")
    public String getFlightsAndBaggageAmount(@RequestParam String iata, @RequestParam Instant date) {
        return cargoService.getFlightsAndBaggageAmount(iata, date);
    }
}
