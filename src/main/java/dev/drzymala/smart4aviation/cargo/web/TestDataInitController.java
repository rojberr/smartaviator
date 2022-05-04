package dev.drzymala.smart4aviation.cargo.web;

import dev.drzymala.smart4aviation.cargo.application.port.CargoInitializerUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/init")
public class TestDataInitController {

    private final CargoInitializerUseCase initializer;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void initialize() {
        initializer.initialize();
    }
}
