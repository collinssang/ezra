package ezra.taska.elevators.repository;

import ezra.taska.elevators.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Collins K. Sang
 * 11/10/22 10:26 AM
 * Elevators
 * StatusRepository
 * IntelliJ IDEA
 **/
@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {
}
