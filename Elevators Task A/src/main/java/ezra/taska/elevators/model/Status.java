package ezra.taska.elevators.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Collins K. Sang
 * 11/10/22 10:09 AM
 * Elevators
 * Status
 * IntelliJ IDEA
 **/
@Getter
@Setter
@Entity
@Table(name = "status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;
    private String status;

    public Status() {
    }
}
