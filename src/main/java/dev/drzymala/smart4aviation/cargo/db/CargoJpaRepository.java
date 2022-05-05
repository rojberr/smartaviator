package dev.drzymala.smart4aviation.cargo.db;

import dev.drzymala.smart4aviation.cargo.domain.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CargoJpaRepository extends JpaRepository<Cargo, Long> {

    Optional<Cargo> findByFlightId(Long flightId);
}
