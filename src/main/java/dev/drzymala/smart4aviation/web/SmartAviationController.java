package dev.drzymala.smart4aviation.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Instant;

@Controller
@AllArgsConstructor
@RequestMapping("/cargo")
public class SmartAviationController {

    @GetMapping()
    public Long getWeight(@RequestParam Long flightId, @RequestParam Instant date) {
        return flightId;
    }

    @GetMapping
    public String getFlightsAndBaggageAmount(@RequestParam String iata, @RequestParam Instant date) {
        return iata;
    }
}
