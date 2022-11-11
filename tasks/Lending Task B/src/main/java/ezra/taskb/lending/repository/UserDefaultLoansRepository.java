package ezra.taskb.lending.repository;

import ezra.taskb.lending.model.UserDefaultLoans;
import ezra.taskb.lending.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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

    @Query("SELECT ud FROM UserDefaultLoans ud WHERE ud.users.id = ?1")
    UserDefaultLoans findByUserId(Users user_id);
}
