package dev.drzymala.smartaviator.cargo.db;

import dev.drzymala.smartaviator.cargo.domain.Baggage;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BaggageJpaRepository extends JpaRepository<Baggage, Long> {}
