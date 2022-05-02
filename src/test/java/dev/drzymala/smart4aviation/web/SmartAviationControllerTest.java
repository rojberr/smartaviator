package dev.drzymala.smart4aviation.web;

import dev.drzymala.smart4aviation.application.port.CargoUseCase;
import dev.drzymala.smart4aviation.domain.Flight;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest({SmartAviationController.class})
class SmartAviationControllerTest {

    @MockBean
    CargoUseCase cargoUseCase;

    @Autowired
    MockMvc mockMvc;

//    @Test
//    public void shouldGetBaggageAmount() throws Exception {
//        // Given
//        Flight flight1 = Flight.builder().flightId(1L).departureDate(Instant.now()).build();
//        Flight flight2 = Flight.builder().flightId(2L).arrivalDate(Instant.now()).build();
//        Mockito.when(cargoUseCase.getWeight(1L, Instant.now())).thenReturn(Optional.ofNullable(flight1));
//
//        // Assert
//        mockMvc.perform(get("/cargo-weight"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(1)));
//    }
}