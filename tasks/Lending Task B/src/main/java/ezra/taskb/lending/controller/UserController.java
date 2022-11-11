package ezra.taskb.lending.controller;

import ezra.taskb.lending.model.Users;
import ezra.taskb.lending.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Collins K. Sang
 * 11/11/22 8:53 AM
 * Lending Task B
 * UserController
 * IntelliJ IDEA
 **/
@RestController
@RequestMapping(name = "/users")
public class UserController {
    final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public Users createUsers(@RequestBody Users users){
      Users users1 =  userService.save(users);
      return users1;
    }
}
