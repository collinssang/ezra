package ezra.taskb.lending.model;

import javax.persistence.*;

/**
 * Collins K. Sang
 * 11/11/22 9:22 AM
 * Lending Task B
 * UserDefaultLoans
 * IntelliJ IDEA
 **/
public class UserDefaultLoans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;
    private Users users;
    private double defaulted_amount;
    private DefaultedLoanMetrics metrics_used;
}
