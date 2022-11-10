package ezra.taska.elevators.controller;

/**
 * Collins K. Sang
 * 11/10/22 8:54 AM
 * Elevators
 * ElevatorController
 * IntelliJ IDEA
 **/

import ezra.taska.elevators.helpers.FloorsHelper;
import ezra.taska.elevators.services.ElevatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Rest Controller in relation to the calls made while inside the elevator
 */
@RestController
@RequestMapping("/elevator")
public class ElevatorController {

    final ElevatorService elevatorService;

    @Autowired
    public ElevatorController(ElevatorService elevatorService) {
        this.elevatorService = elevatorService;
    }

    @RequestMapping(value = "/{elevatorId}/goto/{floorNo}", method = RequestMethod.PUT)
    public void gotoFloor(@PathVariable int elevatorId, @PathVariable int floorNo) {
        System.out.println("FloorNo:" + floorNo + " ElevatorId " + elevatorId);
        elevatorService.gotoFloor(floorNo, elevatorId);
    }

    @RequestMapping(value = "/{elevatorId}/status", method = RequestMethod.GET)
    public
    @ResponseBody
    FloorsHelper status(@PathVariable int elevatorId) {
        return elevatorService.status(elevatorId);
    }

    @RequestMapping(value = "/{elevatorId}/stop", method = RequestMethod.PUT)
    public void stop(@PathVariable int elevatorId) {
        elevatorService.stop(elevatorId);
    }

    @RequestMapping(value = "/elevator", method = RequestMethod.GET)
    public String printWelcome() {
        return "index";
    }
}
