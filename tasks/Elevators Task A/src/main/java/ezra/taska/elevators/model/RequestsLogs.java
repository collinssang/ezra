package ezra.taska.elevators.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Collins K. Sang
 * 11/10/22 10:48 AM
 * Elevators
 * RequestsLogs
 * IntelliJ IDEA
 **/
@Getter
@Setter
@Entity
@Table(name = "request_logs")
public class RequestsLogs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;
    @Column(name = "floor_no")
    private int floor_no;
    private String direction;

    public RequestsLogs(int floorNo, String up) {
        this.direction = up;
        this.floor_no = floorNo;
    }

    public RequestsLogs() {

    }
}
