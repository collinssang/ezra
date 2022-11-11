package ezra.taska.elevators.api;

import ezra.taska.elevators.interfaces.ElevatorCallBacks;
import ezra.taska.elevators.interfaces.ElevatorDirections;
import ezra.taska.elevators.services.servicesImpl.ElevatorDirectionsImpl;
import ezra.taska.elevators.services.servicesImpl.ElevatorHardware;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * Collins K. Sang
 * 11/10/22 1:56 PM
 * Elevators
 * ElevatorTest
 * IntelliJ IDEA
 **/
public class ElevatorTest {
    @Test
    public void testGetElevatorFacade() {
        ElevatorDirections facade = ElevatorHardware.getElevatorDirs(1, new ElevatorCallBacks() {
            @Override
            public void arrived(int floor) {

            }

        });

        ElevatorDirections facade2 = ElevatorHardware.getElevatorDirs(1, new ElevatorCallBacks() {
            @Override
            public void arrived(int floor) {

            }

        });

        assertSame(facade, facade2);

        ElevatorDirections facade3 = ElevatorHardware.getElevatorDirs(2, new ElevatorCallBacks() {
            @Override
            public void arrived(int floor) {

            }
        });

        assertNotSame(facade, facade3);

    }
}
