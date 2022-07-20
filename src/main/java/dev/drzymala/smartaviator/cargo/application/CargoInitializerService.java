package dev.drzymala.smartaviator.cargo.application;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import dev.drzymala.smartaviator.cargo.application.port.CargoInitializerUseCase;
import dev.drzymala.smartaviator.cargo.application.port.CargoUseCase;
import dev.drzymala.smartaviator.cargo.domain.Cargo;
import dev.drzymala.smartaviator.cargo.domain.Flight;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
@AllArgsConstructor
public class CargoInitializerService implements CargoInitializerUseCase {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final CargoUseCase cargoService;

    @Override
    public void initialize() {
        initFlightTestData();
        initCargoTestData();
    }

    @SneakyThrows
    private void initFlightTestData() {
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.enable(SerializationFeature.WRITE_DATES_WITH_ZONE_ID);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
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
