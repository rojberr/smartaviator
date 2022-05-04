package dev.drzymala.smart4aviation.cargo.application;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.drzymala.smart4aviation.cargo.application.port.CargoInitializerUseCase;
import dev.drzymala.smart4aviation.cargo.application.port.CargoUseCase;
import dev.drzymala.smart4aviation.cargo.domain.Cargo;
import dev.drzymala.smart4aviation.cargo.domain.Flight;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
@AllArgsConstructor
public class CargoInitializerService implements CargoInitializerUseCase {

    private final ObjectMapper objectMapper;
    private final CargoUseCase cargoService;

    @Override
    public void initialize() {
        initFlightTestData();
        initCargoTestData();
    }

    @SneakyThrows
    private void initFlightTestData() {
        File jsonFile = new ClassPathResource("flight-test-data.json").getFile();
        JsonNode rootNode = objectMapper.readTree(jsonFile);

        if (rootNode.isArray()) {
            for (JsonNode arrayItem : rootNode) {
                Flight flight = objectMapper.treeToValue(arrayItem, Flight.class);
                cargoService.addFlight(flight);
            }
        }
    }

    @SneakyThrows
    private void initCargoTestData() {
        File jsonFile = new ClassPathResource("cargo-test-data.json").getFile();
        JsonNode rootNode = objectMapper.readTree(jsonFile);

        if (rootNode.isArray()) {
            for (JsonNode arrayItem : rootNode) {
                Cargo cargo = objectMapper.treeToValue(arrayItem, Cargo.class);
                cargoService.addCargo(cargo);
            }
        }
    }
}
