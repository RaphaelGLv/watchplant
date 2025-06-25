package com.watchplant.app.controllers;

import com.watchplant.app.dtos.plantation.GetPlantationResponseDto;
import com.watchplant.app.dtos.user.GetUserResponseDTO;
import com.watchplant.app.dtos.user.UpdateUserRequestDTO;
import com.watchplant.app.dtos.user.UpdateUserResponseDTO;
import com.watchplant.app.services.PlantationService;
import com.watchplant.app.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @GetMapping("/plantations")
    public List<GetPlantationResponseDto> listMyPlantations() {
        return plantationService.listPlantationsByCurrentUser();
    }
}
