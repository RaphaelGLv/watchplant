package com.watchplant.app.controllers;

import com.watchplant.app.dtos.user.GetUserResponseDTO;
import com.watchplant.app.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
class UserController {
    private final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<GetUserResponseDTO> getAll() {
        return userService.getAll();
    }
}
