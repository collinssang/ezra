package ezra.taska.elevators.repository;

import ezra.taska.elevators.model.Elevator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Collins K. Sang
 * 11/10/22 10:29 AM
 * Elevators
 * ElevatorsRepository
 * IntelliJ IDEA
 **/
@Repository
public interface ElevatorsRepository extends JpaRepository<Elevator, Integer> {
}
