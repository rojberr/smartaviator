package dev.drzymala.smartaviator.cargo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Data
@Entity
@Table(name = "flights")
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
