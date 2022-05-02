package dev.drzymala.smart4aviation.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Instant;

@Data
@Entity
@RequiredArgsConstructor
public class Flight {

    @Id
    @GeneratedValue
    private Long id;
    private Instant date;
    private Long cargoWeight;
    private Long baggageWeight;
}
