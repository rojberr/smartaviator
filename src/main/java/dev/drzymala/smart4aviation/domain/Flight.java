package dev.drzymala.smart4aviation.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Instant;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Flight {

    @Id
    @GeneratedValue
    private Long id;
    private Iata iata;
    private Long flightId;
    private Long cargoWeight;
    private Long baggageWeight;
    private Instant arrivalDate;
    private Instant departureDate;
}
