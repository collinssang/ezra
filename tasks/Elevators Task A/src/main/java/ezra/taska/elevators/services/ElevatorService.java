package ezra.taska.elevators.services;

import ezra.taska.elevators.helpers.FloorsHelper;

/**
 * Collins K. Sang
 * 11/10/22 12:05 PM
 * Elevators
 * ElevatorService
 * IntelliJ IDEA
 **/
public interface ElevatorService {
    void gotoFloor(int floorNo, int elevatorId);
    void stop(int elevatorId);

    FloorsHelper status(int elevatorId);
}
