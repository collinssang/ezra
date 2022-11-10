package ezra.taska.elevators.repository;

import ezra.taska.elevators.model.RequestsLogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Collins K. Sang
 * 11/10/22 10:50 AM
 * Elevators
 * RequestLogRepository
 * IntelliJ IDEA
 **/
@Repository
public interface RequestLogRepository extends JpaRepository<RequestsLogs, Integer> {
    @Query("SELECT e FROM Elevator e WHERE e.floorNo.id = ?1 ORDER BY e.id DESC")
    RequestsLogs findAllByFloor_no(int pressed_from_floor);
}
