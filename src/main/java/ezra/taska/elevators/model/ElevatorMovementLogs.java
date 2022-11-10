package ezra.taska.elevators.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Collins K. Sang
 * 11/10/22 12:24 PM
 * Elevators
 * ElevatorMovementLogs
 * IntelliJ IDEA
 **/
@Getter
@Setter
@Entity
@Table(name = "elevator_logs")
public class ElevatorMovementLogs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;
    @OneToOne
    private Elevator elevator;
    @OneToOne
    private Floors floors;
    @OneToOne
    private RequestsLogs requests_logs;

    public ElevatorMovementLogs(RequestsLogs requestsLogs, Floors floors, Elevator elevator) {

    }

    public ElevatorMovementLogs() {

    }
}
