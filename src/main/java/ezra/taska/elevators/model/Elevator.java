package ezra.taska.elevators.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Collins K. Sang
 * 11/10/22 10:09 AM
 * Elevators
 * Elevator
 * IntelliJ IDEA
 **/
@Getter
@Setter
@Entity
@Table(name = "elevators")
public class Elevator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;
    private String name;
    @ManyToOne
    private Status status;
    @OneToOne
    @JoinColumn(name = "floor_no")
    private Floors floor_no;

    public Elevator() {
    }
}
