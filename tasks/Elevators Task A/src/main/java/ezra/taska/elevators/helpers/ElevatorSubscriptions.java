package ezra.taska.elevators.helpers;

import ezra.taska.elevators.interfaces.ElevatorCallBacks;
import ezra.taska.elevators.interfaces.ElevatorDirections;
import ezra.taska.elevators.services.servicesImpl.ElevatorHardware;

/**
 * Collins K. Sang
 * 11/10/22 10:56 AM
 * Elevators
 * ElevatorSubscriptions
 * IntelliJ IDEA
 **/
public class ElevatorSubscriptions extends Thread {
    private int elevatorId;
    private boolean up = true;
    private ElevatorDirections elevatorDirections;
    private int currentFloor = 1;
    private boolean running = true;
    private FloorsHelper nextFloorCall;
    private BuildingServiceHelper elevatorPub;

    public ElevatorSubscriptions(final int elevatorId, final BuildingServiceHelper elevatorPub) {
        this.elevatorId = elevatorId;
        this.elevatorPub = elevatorPub;
        this.elevatorDirections = ElevatorHardware.getElevatorDirs(elevatorId, new ElevatorCallBacks() {
            @Override
            public void arrived(int floor) {
                currentFloor = floor;
                if (nextFloorCall != null && floor == nextFloorCall.getFloorNo()) {
                    System.out.println(elevatorId + ": arrived :" + currentFloor + ": up :" + up);
                    elevatorDirections.lockBreaks();
                }
            }
        });
        Thread tElevator = new Thread(this);
        tElevator.start();
    }
    public void terminate() {
        running = false;
        elevatorPub.stop(this.elevatorId);
    }

    public int getElevatorId() {
        return elevatorId;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public FloorsHelper getCurrentFloor() {
        return new FloorsHelper(currentFloor, up);
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public void run() {
        while (running) {
            nextFloorCall = elevatorPub.getUpdate();
            while (nextFloorCall != null) {
                if (this.currentFloor != nextFloorCall.getFloorNo()) {
                    this.elevatorDirections.unlockBreaks();
                    while (this.currentFloor > nextFloorCall.getFloorNo()) {
                        this.elevatorDirections.moveDownOneFloor();
                    }

                    while (this.currentFloor < nextFloorCall.getFloorNo()) {
                        elevatorDirections.moveUpOneFloor();
                    }
                } else {
                    if (nextFloorCall.isUp()) elevatorPub.up(nextFloorCall.getFloorNo());
                    else elevatorPub.down(nextFloorCall.getFloorNo());
                }

                nextFloorCall = elevatorPub.getUpdate();
            }

            try {
                //System.out.println(elevatorId + ": Waiting...");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
