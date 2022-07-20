package dev.drzymala.smartaviator.cargo.web;

import dev.drzymala.smartaviator.cargo.application.port.CargoInitializerUseCase;
import dev.drzymala.smartaviator.cargo.application.port.CargoUseCase;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@AllArgsConstructor
@RequestMapping("/init")
public class TestDataInitController {

    private final CargoInitializerUseCase initializer;
    private final CargoUseCase cargoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntityModel initialize() {

        initializer.initialize();
        Link cargoLinkFlightDate = linkTo(SmartAviationController.class)
                .slash(cargoService.getWeight(2741L, Instant.parse("2018-03-31T06:52:28.00Z")))
                .withSelfRel();

        return EntityModel.of(cargoLinkFlightDate);
    }
}