package ezra.taska.elevators.services.servicesImpl;

import ezra.taska.elevators.helpers.BuildingService;
import ezra.taska.elevators.helpers.FloorsHelper;
import ezra.taska.elevators.model.Elevator;
import ezra.taska.elevators.model.ElevatorMovementLogs;
import ezra.taska.elevators.model.Floors;
import ezra.taska.elevators.model.RequestsLogs;
import ezra.taska.elevators.repository.ElevatorMovementRepository;
import ezra.taska.elevators.repository.ElevatorsRepository;
import ezra.taska.elevators.repository.FloorsRepository;
import ezra.taska.elevators.repository.RequestLogRepository;
import ezra.taska.elevators.services.ElevatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Collins K. Sang
 * 11/10/22 12:10 PM
 * Elevators
 * ElevatorServiceImpl
 * IntelliJ IDEA
 **/
@Service
public class ElevatorServiceImpl implements ElevatorService {
    final ElevatorMovementRepository elevatorMovementRepository;
    final RequestLogRepository requestLogRepository;
    final FloorsRepository floorsRepository;
    final ElevatorsRepository elevatorsRepository;

    @Autowired
    public ElevatorServiceImpl(ElevatorMovementRepository elevatorMovementRepository, RequestLogRepository requestLogRepository, FloorsRepository floorsRepository, ElevatorsRepository elevatorsRepository) {
        this.elevatorMovementRepository = elevatorMovementRepository;
        this.requestLogRepository = requestLogRepository;
        this.floorsRepository = floorsRepository;
        this.elevatorsRepository = elevatorsRepository;
    }

    @Override
    public void gotoFloor(int floorNo, int elevatorId) {
        int pressed_from_floor = BuildingService.buildingServiceHelper.getUpdate().getFloorNo();
        RequestsLogs requestsLogs = requestLogRepository.findAllByFloor_no(pressed_from_floor);
        Floors floors = floorsRepository.getById(floorNo);
        Elevator elevator = elevatorsRepository.getById(elevatorId);
        ElevatorMovementLogs elevatorMovementLogs = new ElevatorMovementLogs(requestsLogs, floors, elevator);
        elevatorMovementRepository.save(elevatorMovementLogs);
        BuildingService.buildingServiceHelper.gotoFloor(floorNo, elevatorId);
    }
    @Override
    public void stop(int elevatorId) {
        BuildingService.buildingServiceHelper.stop(elevatorId);
    }

    @Override
    public FloorsHelper status(int elevatorId) {
        return BuildingService.buildingServiceHelper.status(elevatorId);
    }
}
