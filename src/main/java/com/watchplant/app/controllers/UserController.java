package com.watchplant.app.controllers;

import com.watchplant.app.dtos.plantation.GetPlantationResponseDto;
import com.watchplant.app.dtos.user.GetUserResponseDTO;
import com.watchplant.app.dtos.user.UpdateUserRequestDTO;
import com.watchplant.app.dtos.user.UpdateUserResponseDTO;
import com.watchplant.app.services.PlantationService;
import com.watchplant.app.services.UserService;
import com.watchplant.app.utils.UserContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
class UserController {
    private final UserService userService;
    private final PlantationService plantationService;

    UserController(UserService userService, PlantationService plantationService) {
        this.userService = userService;
        this.plantationService = plantationService;
    }

    @GetMapping
    public List<GetUserResponseDTO> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{email}")
    public GetUserResponseDTO getByEmail(@PathVariable String email) {
        return userService.getByEmail(email);
    }

    @GetMapping("/me")
    public GetUserResponseDTO getMe() {
        String email = UserContext.getUserEmail();
        return userService.getByEmail(email);
    }

    @PutMapping("/{email}")
    public UpdateUserResponseDTO updateUser(
            @PathVariable String email,
            @RequestBody UpdateUserRequestDTO updateUserRequestDTO
    ) {
        return userService.updateUser(email, updateUserRequestDTO);
    }

    @DeleteMapping("/{email}")
    public void deleteUser(@PathVariable String email) {
        userService.deleteUser(email);
    }

    @GetMapping("/plantations")
    public List<GetPlantationResponseDto> listMyPlantations() {
        return plantationService.listPlantationsByCurrentUser();
    }
}
