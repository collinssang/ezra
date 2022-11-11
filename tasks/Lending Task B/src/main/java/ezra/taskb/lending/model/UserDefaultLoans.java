package ezra.taskb.lending.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Collins K. Sang
 * 11/11/22 9:22 AM
 * Lending Task B
 * UserDefaultLoans
 * IntelliJ IDEA
 **/
@Getter
@Setter
@Entity
public class UserDefaultLoans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;
    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users users;
    private double defaulted_amount;
    @ManyToOne
    @JoinColumn(name = "metrics_used_id")
    private DefaultedLoanMetrics metrics_used;
}
