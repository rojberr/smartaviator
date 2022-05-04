package dev.drzymala.smart4aviation.cargo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Flight {

    @Id
    private Long flightId;
    private Long flightNumber;
    private String departureAirportIATACode;
    private String arrivalAirportIATACode;
    private Instant departureDate;
}
