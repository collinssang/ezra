package ezra.taskb.lending.repository;

import ezra.taskb.lending.model.DefaultedLoanMetrics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Collins K. Sang
 * 11/11/22 9:29 AM
 * Lending Task B
 * DefaultedLoanMetricsRepository
 * IntelliJ IDEA
 **/
@Repository
public interface DefaultedLoanMetricsRepository extends JpaRepository<DefaultedLoanMetrics, Integer> {
}
