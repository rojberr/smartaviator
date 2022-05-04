package dev.drzymala.smart4aviation.cargo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Cargo {

    @Id
    @GeneratedValue
    private Long id;

    private Long flightId;

    @OneToOne
    @JoinColumn(name = "cargo")
    private Baggage cargo;

    @OneToOne
    @JoinColumn(name = "baggage")
    private Baggage baggage;
}
