package ezra.taska.elevators.repository;

import ezra.taska.elevators.model.Floors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Collins K. Sang
 * 11/10/22 10:28 AM
 * Elevators
 * FloorsRepository
 * IntelliJ IDEA
 **/
@Repository
public interface FloorsRepository extends JpaRepository<Floors, Integer> {
}
