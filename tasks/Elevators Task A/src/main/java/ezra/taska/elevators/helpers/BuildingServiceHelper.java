package ezra.taska.elevators.helpers;


import ezra.taska.elevators.repository.FloorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.InvalidParameterException;
import java.util.*;

/**
 * Collins K. Sang
 * 11/10/22 9:10 AM
 * Elevators
 * BuildingServiceHelper
 * IntelliJ IDEA
 **/
@Component
public class BuildingServiceHelper {
    FloorsRepository floorsRepository;
    long floorsCount;
    private final Object MUTEX = new Object();
    private List<ElevatorSubscriptions> elevatorSubscriptions = new ArrayList<ElevatorSubscriptions>();
    private final Queue<FloorsHelper> pendingFloorCalls = new ArrayDeque<FloorsHelper>();

    public BuildingServiceHelper() {
    }
    @Autowired
    public BuildingServiceHelper(FloorsRepository floorsRepository) {
        this.floorsRepository = floorsRepository;
        this.floorsCount = floorsRepository.count();
    }



    public void reg(ElevatorSubscriptions... elevatorSubscriptions) {
        this.elevatorSubscriptions.addAll(Arrays.asList(elevatorSubscriptions));
    }


    public void up(int floorNo) {
        if (floorNo > 0 && floorNo <= this.floorsCount) {
            FloorsHelper floorsHelper = new FloorsHelper(floorNo, true);
            synchronized (MUTEX) {
                if (!pendingFloorCalls.contains(floorsHelper)) pendingFloorCalls.add(floorsHelper);
            }
        } else throw new InvalidParameterException("Invalid Floor: " + floorNo);
    }

    public void down(int floorNo) {
        if (floorNo > 0 && floorNo <= this.floorsCount) {
            FloorsHelper floorsHelper = new FloorsHelper(floorNo, false);
            synchronized (MUTEX) {
                if (!pendingFloorCalls.contains(floorsHelper)) pendingFloorCalls.add(floorsHelper);
            }
        } else throw new InvalidParameterException("Invalid floor: " + floorNo);
    }

    public void stop(int elevatorId) {
        for (ElevatorSubscriptions elevatorSub : elevatorSubscriptions) {
            if (elevatorId == elevatorSub.getElevatorId()) {
                elevatorSub.terminate();
                break;
            }
        }
    }

    public void gotoFloor(int floorNo, int elevatorId) {
        for (ElevatorSubscriptions elevatorSub : elevatorSubscriptions) {
            if (elevatorId == elevatorSub.getElevatorId()) {
                if (elevatorSub.isUp() && elevatorSub.getCurrentFloor().getFloorNo() < floorNo) {
                    FloorsHelper floorsHelper = new FloorsHelper(floorNo, true);
                    synchronized (MUTEX) {
                        if (!pendingFloorCalls.contains(floorsHelper)) pendingFloorCalls.add(floorsHelper);
                    }
                } else if (!elevatorSub.isUp() && elevatorSub.getCurrentFloor().getFloorNo() > floorNo) {
                    FloorsHelper floorsHelper = new FloorsHelper(floorNo, false);
                    synchronized (MUTEX) {
                        if (!pendingFloorCalls.contains(floorsHelper)) pendingFloorCalls.add(floorsHelper);
                    }
                } else throw new InvalidParameterException("Floor cannot be selected: " + floorNo);
                break;
            }
        }
    }

    public synchronized FloorsHelper getUpdate() {
        synchronized (MUTEX) {
            if (!pendingFloorCalls.isEmpty())
                return pendingFloorCalls.remove();
        }
        return null;
    }

    public FloorsHelper status(int elevatorId) {
        for (ElevatorSubscriptions elevatorSub : elevatorSubscriptions) {
            if (elevatorId == elevatorSub.getElevatorId())
                return elevatorSub.getCurrentFloor();
        }

        throw new InvalidParameterException("Invalid elevator id: " + elevatorId);
    }

}
