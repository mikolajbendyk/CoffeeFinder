package pl.bendyk.controllers;

import org.springframework.stereotype.Controller;
import pl.bendyk.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

}
