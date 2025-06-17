package com.watchplant.app.controllers;

import com.watchplant.app.dtos.user.GetUserResponseDTO;
import com.watchplant.app.dtos.user.UpdateUserRequestDTO;
import com.watchplant.app.dtos.user.UpdateUserResponseDTO;
import com.watchplant.app.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @GetMapping("/{id}")
    public GetUserResponseDTO getById(@PathVariable UUID id) {
        return userService.getById(id);
    }

    @PutMapping("/{id}")
    public UpdateUserResponseDTO updateUser(
            @PathVariable UUID id,
            @RequestBody UpdateUserRequestDTO updateUserRequestDTO
    ) {
        return userService.updateUser(id, updateUserRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);
    }
}
