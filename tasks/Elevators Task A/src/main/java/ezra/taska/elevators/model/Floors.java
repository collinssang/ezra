package ezra.taska.elevators.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Collins K. Sang
 * 11/10/22 10:10 AM
 * Elevators
 * FloorsHelper
 * IntelliJ IDEA
 **/
@Getter
@Setter
@Entity
@Table(name = "floors")
public class Floors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;
    private String name;

    public Floors() {
    }
}
