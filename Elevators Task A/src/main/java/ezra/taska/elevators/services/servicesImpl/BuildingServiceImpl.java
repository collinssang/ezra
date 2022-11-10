package ezra.taska.elevators.services.servicesImpl;

import ezra.taska.elevators.model.RequestsLogs;
import ezra.taska.elevators.repository.FloorsRepository;
import ezra.taska.elevators.repository.RequestLogRepository;
import ezra.taska.elevators.services.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Collins K. Sang
 * 11/10/22 9:05 AM
 * Elevators
 * BuildingServiceImpl
 * IntelliJ IDEA
 **/
@Service
public class BuildingServiceImpl implements BuildingService {

    final FloorsRepository floorsRepository;
    final RequestLogRepository requestLogRepository;

    @Autowired
    public BuildingServiceImpl(FloorsRepository floorsRepository, RequestLogRepository requestLogRepository) {
        this.floorsRepository = floorsRepository;
        this.requestLogRepository = requestLogRepository;
    }

    @Override
    public void up(int floorNo) {
        RequestsLogs requestsLogs = new RequestsLogs(floorNo, "up");
        requestLogRepository.save(requestsLogs);
        ezra.taska.elevators.helpers.BuildingService.buildingServiceHelper.up(floorNo);
    }

    @Override
    public void down(int floorNo) {
        RequestsLogs requestsLogs = new RequestsLogs(floorNo, "down");
        requestLogRepository.save(requestsLogs);
        ezra.taska.elevators.helpers.BuildingService.buildingServiceHelper.down(floorNo);
    }
}
