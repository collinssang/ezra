package ezra.taska.elevators.interfaces;

/**
 * Collins K. Sang
 * 11/10/22 11:47 AM
 * Elevators
 * ElevatorDirections
 * IntelliJ IDEA
 **/
public interface ElevatorDirections {
    /**
     *  * Moves an Elevator up one Floor.
    */
    void moveUpOneFloor();

    /**
     * Moves an Elevator down one Floor.
     */
    void moveDownOneFloor();

    /**
     * Locks the elevator breaks, to prevent it from moving.
     */
    void lockBreaks();

    /**
     * Unlocks the elevator breaks allowing it to move again.
     */
    void unlockBreaks();
}
