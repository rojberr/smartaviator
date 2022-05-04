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
    private Long flightId;
    private transient Baggage cargo;
    private transient Baggage baggage;
}
