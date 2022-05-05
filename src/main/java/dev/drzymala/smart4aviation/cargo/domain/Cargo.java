package dev.drzymala.smart4aviation.cargo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.ALL;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Cargo {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Long id;

    private Long flightId;

    @OneToMany(cascade = ALL)
    @JoinColumn(name = "cargo")
    private List<Baggage> cargo;

    @OneToMany(cascade = ALL)
    @JoinColumn(name = "baggage")
    private List<Baggage> baggage;
}
