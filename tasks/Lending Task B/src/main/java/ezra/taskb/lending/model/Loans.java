package ezra.taskb.lending.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

/**
 * Collins K. Sang
 * 11/10/22 4:47 PM
 * Lending Task B
 * Loans
 * IntelliJ IDEA
 **/
@Getter
@Setter
@Entity
public class Loans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @Value("${loan.limit.amount}")
    private double loan_limit;
    private double loan_amount;
    private double loan_paid_amount = 0;
    @ManyToOne
    private Users user_id;

}
