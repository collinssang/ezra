package ezra.taska.elevators.services.servicesImpl;

import ezra.taska.elevators.interfaces.ElevatorCallBacks;
import ezra.taska.elevators.interfaces.ElevatorDirections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Collins K. Sang
 * 11/10/22 11:50 AM
 * Elevators
 * ElevatorDirectionsImpl
 * IntelliJ IDEA
 **/
@Service
public class ElevatorDirectionsImpl implements ElevatorDirections {
    private boolean breaksOn = false;
    private int currentFloor = 0;
    private final ElevatorCallBacks callback;

    @Autowired
    public ElevatorDirectionsImpl(ElevatorCallBacks callback) {
        if (callback == null) throw new IllegalArgumentException("callback cannot be null");
        this.callback = callback;
    }


    @Override
    public void moveUpOneFloor() {

    }

    @Override
    public void moveDownOneFloor() {

    }

    @Override
    public void lockBreaks() {

    }

    @Override
    public void unlockBreaks() {

    }
}
