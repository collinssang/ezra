package ezra.taska.elevators.services.servicesImpl;

import ezra.taska.elevators.interfaces.ElevatorCallBacks;
import ezra.taska.elevators.interfaces.ElevatorDirections;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Collins K. Sang
 * 11/10/22 11:56 AM
 * Elevators
 * ElevatorHardware
 * IntelliJ IDEA
 **/
@Service
public class ElevatorHardware {
    private static Map<Integer, ElevatorDirections> elevatordirs= new HashMap<Integer,ElevatorDirections>();

    public static ElevatorDirections getElevatorDirs(Integer elevatorID, ElevatorCallBacks callback) {
        ElevatorDirections f = elevatordirs.get(elevatorID);
        if (f==null) {
            //TODO: Change this to lookup the class that does the RMI call to hardware.
            f = new ElevatorDirectionsImpl(callback);
            elevatordirs.put(elevatorID, f);
        }
        return f;
    }
}
