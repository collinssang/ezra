package ezra.taskb.lending.repository;

import ezra.taskb.lending.model.UserDefaultLoans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Collins K. Sang
 * 11/11/22 9:30 AM
 * Lending Task B
 * UserDefaultLoansRepository
 * IntelliJ IDEA
 **/
@Repository
public interface UserDefaultLoansRepository extends JpaRepository<UserDefaultLoans, Integer> {
}
