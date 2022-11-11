package ezra.taskb.lending.repository;

import ezra.taskb.lending.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Collins K. Sang
 * 11/11/22 8:53 AM
 * Lending Task B
 * UserRepository
 * IntelliJ IDEA
 **/
@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    @Query("SELECT u FROM Users u WHERE u.msisdn = ?1")
    Users findByMsisdn(String phone_no);
}
