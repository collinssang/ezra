package ezra.taska.elevators.helpers;

import ezra.taska.elevators.repository.ElevatorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Collins K. Sang
 * 11/10/22 9:39 AM
 * Elevators
 * BuildingService
 * IntelliJ IDEA
 **/
@Component
public class BuildingService {
    static private long elevetorCount;
    final ElevatorsRepository elevatorsRepository;
    public final static BuildingServiceHelper buildingServiceHelper = createBuildingServiceHelper();

    @Autowired
    public BuildingService(ElevatorsRepository elevatorsRepository) {
        this.elevatorsRepository = elevatorsRepository;
        elevetorCount = elevatorsRepository.count();
    }

    public static BuildingServiceHelper createBuildingServiceHelper() {
        BuildingServiceHelper buildingServiceHelper = new BuildingServiceHelper();
        for (int i = 0; i < elevetorCount; i++) {
            System.out.println(" Inti Elevator  " + (i + 1));
            ElevatorSubscriptions elevatorSub = new ElevatorSubscriptions(i + 1, buildingServiceHelper);
            buildingServiceHelper.reg(elevatorSub);
            elevatorSub.start();
        }
        System.out.println("Starting the elevators");
        return buildingServiceHelper;
    }
}
