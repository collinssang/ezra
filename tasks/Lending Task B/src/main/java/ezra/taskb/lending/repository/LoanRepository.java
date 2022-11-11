package ezra.taskb.lending.repository;

import ezra.taskb.lending.model.Loans;
import ezra.taskb.lending.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Collins K. Sang
 * 11/11/22 8:54 AM
 * Lending Task B
 * LoanRepository
 * IntelliJ IDEA
 **/
@Repository
public interface LoanRepository extends JpaRepository<Loans, Integer> {
}
