package ezra.taska.elevators.repository;

import ezra.taska.elevators.model.ElevatorMovementLogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Collins K. Sang
 * 11/10/22 12:27 PM
 * Elevators
 * ElevatorMovementRepository
 * IntelliJ IDEA
 **/
@Repository
public interface ElevatorMovementRepository extends JpaRepository<ElevatorMovementLogs, Integer> {
}
