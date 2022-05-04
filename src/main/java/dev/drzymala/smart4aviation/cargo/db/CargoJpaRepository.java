package dev.drzymala.smart4aviation.cargo.db;

import dev.drzymala.smart4aviation.cargo.domain.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoJpaRepository extends JpaRepository<Cargo, Long> {
}
