package dev.drzymala.smart4aviation.cargo.db;

import dev.drzymala.smart4aviation.cargo.domain.Baggage;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BaggageJpaRepository extends JpaRepository<Baggage, Long> {}
