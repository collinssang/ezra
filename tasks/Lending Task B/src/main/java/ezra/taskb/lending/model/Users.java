package ezra.taskb.lending.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Collins K. Sang
 * 11/10/22 4:44 PM
 * Lending Task B
 * Users
 * IntelliJ IDEA
 **/
@Getter
@Setter
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;
    private String name;
    private String msisdn;
    private boolean is_eligible = false;
}
