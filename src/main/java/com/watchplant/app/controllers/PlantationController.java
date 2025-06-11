package com.watchplant.app.controllers;

import com.watchplant.app.dtos.plantation.CreatePlantationRequestDto;
import com.watchplant.app.dtos.plantation.CreatePlantationResponseDto;
import com.watchplant.app.services.PlantationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plantation")
class PlantationController {
    private final PlantationService plantationService;

    PlantationController(PlantationService plantationService) {
        this.plantationService = plantationService;
    }

    @PostMapping("/")
    public CreatePlantationResponseDto createPlantation(@Valid @RequestBody CreatePlantationRequestDto createPlantationRequestDto) {
        return this.plantationService.createPlantation(createPlantationRequestDto);
    }
}
