package dev.drzymala.smartaviator.cargo.db;

import dev.drzymala.smartaviator.cargo.domain.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CargoJpaRepository extends JpaRepository<Cargo, Long> {

    Optional<Cargo> findByFlightId(Long flightId);
}
