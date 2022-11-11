package ezra.taska.elevators.controller;

/**
 * Collins K. Sang
 * 11/10/22 8:54 AM
 * Elevators
 * BuildingController
 * IntelliJ IDEA
 **/

import ezra.taska.elevators.services.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest api in relation to the call of elevator from any floor
 */
@RestController
@RequestMapping("/building")
public class BuildingController {

    final BuildingService buildingService;

    @Autowired
    public BuildingController(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    @RequestMapping(value = "/up/{floorNo}", method = RequestMethod.PUT)
    public void up(@PathVariable int floorNo) {
        buildingService.up(floorNo);
    }

    @RequestMapping(value = "/down/{floorNo}", method = RequestMethod.PUT)
    public void down(@PathVariable int floorNo) {
        buildingService.down(floorNo);
    }

}
