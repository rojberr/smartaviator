package dev.drzymala.smart4aviation.cargo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Baggage {

    @Id
    private Long id;
    private Double weight;
    private String weightUnit;
    private int pieces;
}
