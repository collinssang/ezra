package ezra.taskb.lending.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

/**
 * Collins K. Sang
 * 11/11/22 9:20 AM
 * Lending Task B
 * DefaultedLoanMetricsRepository
 * IntelliJ IDEA
 **/
@Getter
@Setter
@Entity
@Table(name = "loan_metrics")
public class DefaultedLoanMetrics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;
    @Value("${loan.defaulted.rate}")
    private int min_percentage;
    @Value("${loan.defaulted.period}")
    private int default_duration;
}
