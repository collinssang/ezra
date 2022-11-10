package ezra.taska.elevators.interfaces;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Collins K. Sang
 * 11/10/22 11:52 AM
 * Elevators
 * ElevatorCallBacks
 * IntelliJ IDEA
 **/
public interface ElevatorCallBacks {
    public void arrived(int floor);
}
